/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.timemanagement.timetracking.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.timemanagement.model.TMActivity;
import com.liferay.timemanagement.model.TMActivitySession;
import com.liferay.timemanagement.service.TMActivityLocalServiceUtil;
import com.liferay.timemanagement.service.TMActivitySessionLocalServiceUtil;
import com.liferay.timemanagement.util.DateTimeUtil;
import com.liferay.timemanagement.util.TMDateTimeUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import java.text.Format;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * @author Zsolt Szabo
 */
public class TimeTrackingPortlet extends MVCPortlet {

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateActivity(actionRequest, actionResponse, jsonObject);
			}
			else if (cmd.equals("start_activity")) {
				startActivity(actionRequest, actionResponse, jsonObject);
			}
		}
		catch (Exception e) {
			jsonObject.putException(e);
		}

		writeJSON(actionRequest, actionResponse, jsonObject);
	}

	@Override
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		try {
			String resourceID = resourceRequest.getResourceID();

			if (resourceID.equals("getActivities")) {
				getActivities(resourceRequest, resourceResponse, jsonObject);
			}
			else if (resourceID.equals("getTodayActivitySessions")) {
				getTodayActivitySessions(
					resourceRequest, resourceResponse, jsonObject);
			}
		}
		catch (Exception e) {
			jsonObject.putException(e);
		}

		writeJSON(resourceRequest, resourceResponse, jsonObject);
	}

	protected void getActivities(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			JSONObject jsonObject)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		int start = ParamUtil.getInteger(resourceRequest, "start");
		int end = ParamUtil.getInteger(resourceRequest, "end");
		int total = TMActivityLocalServiceUtil.countByC_G(
			themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());

		List<TMActivity> activityList =
			TMActivityLocalServiceUtil.getTMActivitiesByC_G(
				themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
				start, end);

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (TMActivity activity : activityList) {
			JSONObject activityJSON = JSONFactoryUtil.createJSONObject();

			activityJSON.put("activityId", activity.getActivityId());
			activityJSON.put("activityName", activity.getActivityName());

			jsonArray.put(activityJSON);
		}

		jsonObject.put("activities", jsonArray);

		jsonObject.put("total", total);
	}

	protected void getTodayActivitySessions(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			JSONObject jsonObject)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Date now = new Date();
		Date startInterval = DateTimeUtil.getDayWithoutTime(now);
		Date endInterval = DateTimeUtil.getIncrementedDay(startInterval);

		List<TMActivitySession> todayActivitySessionList =
			TMActivitySessionLocalServiceUtil.getActivitySessionsByC_G_U_I(
				themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId(), startInterval, endInterval);

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (TMActivitySession activitySession : todayActivitySessionList) {
			JSONObject activitySessionJSON = createActivitySessionJSON(
				activitySession, themeDisplay);

			jsonArray.put(activitySessionJSON);
		}

		jsonObject.put("todayActivitySessionList", jsonArray);

		jsonObject.put("total", todayActivitySessionList.size());
	}

	protected void startActivity(
			ActionRequest actionRequest, ActionResponse actionResponse,
			JSONObject jsonObject)
		throws Exception {

		long activityId = ParamUtil.getLong(actionRequest, "activityId");

		if (activityId <= 0) {
			updateActivity(actionRequest, actionResponse, jsonObject);
		}
		else {
			updateActivitySession(actionRequest, actionResponse, jsonObject);
		}
	}

	protected void updateActivity(
			ActionRequest actionRequest, ActionResponse actionResponse,
			JSONObject jsonObject)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long activityId = ParamUtil.getLong(actionRequest, "activityId");

		String activityName = ParamUtil.getString(
			actionRequest, "activityName");
		String description = ParamUtil.getString(actionRequest, "description");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			TMActivity.class.getName(), actionRequest);

		TMActivity tmActivity = null;

		if (activityId <= 0) {
			Calendar startTimeCalendar = TMDateTimeUtil.getCalendar(
				actionRequest, "startDate");
			Calendar endTimeCalendar = TMDateTimeUtil.getCalendar(
				actionRequest, "endDate");

			tmActivity = TMActivityLocalServiceUtil.addTMActivity(
				themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				activityName, 0, 0, null, description, null, 0, null, null,
				null, true, serviceContext);

			TMActivitySession activitySession =
				TMActivitySessionLocalServiceUtil.addActivitySession(
					themeDisplay.getUserId(), startTimeCalendar.getTime(),
					endTimeCalendar.getTime(), tmActivity.getActivityId(),
					serviceContext);

			jsonObject.put(
				"activitySessionItem", createActivitySessionJSON(
					activitySession, themeDisplay));
		}
		else {
			tmActivity = TMActivityLocalServiceUtil.getTMActivity(activityId);

			tmActivity.setActivityName(activityName);
			tmActivity.setDescription(description);

			tmActivity = TMActivityLocalServiceUtil.updateTMActivity(
				tmActivity);
		}
	}

	protected void updateActivitySession(
			ActionRequest actionRequest, ActionResponse actionResponse,
			JSONObject jsonObject)
		throws Exception {

		updateActivitySession(actionRequest, 0, jsonObject);
	}

	protected TMActivitySession updateActivitySession(
			PortletRequest portletRequest, long tmActivityId,
			JSONObject jsonObject)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		long tmActivitySessionId = ParamUtil.getLong(
			portletRequest, "activitySessionId");

		Calendar startTimeCalendar = TMDateTimeUtil.getCalendar(
			portletRequest, "startDate");
		Calendar endTimeCalendar = TMDateTimeUtil.getCalendar(
			portletRequest, "endDate");

		TMActivitySession tmActivitySession = null;

		if (tmActivitySessionId <= 0) {
			if (tmActivityId <= 0) {
				tmActivityId = ParamUtil.getLong(portletRequest, "activityId");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				TMActivity.class.getName(), portletRequest);

			tmActivitySession =
				TMActivitySessionLocalServiceUtil.addActivitySession(
					themeDisplay.getUserId(), startTimeCalendar.getTime(),
					endTimeCalendar.getTime(), tmActivityId, serviceContext);

			jsonObject.put(
					"activitySessionItem", createActivitySessionJSON(
						tmActivitySession, themeDisplay));
		}
		else {
			tmActivitySession =
				TMActivitySessionLocalServiceUtil.getTMActivitySession(
					tmActivitySessionId);

			tmActivitySession.setStartTime(startTimeCalendar.getTime());
			tmActivitySession.setEndTime(endTimeCalendar.getTime());

			TMActivitySessionLocalServiceUtil.updateTaskSession(
				tmActivitySession);
		}

		return tmActivitySession;
	}

	private JSONObject createActivitySessionJSON(
			TMActivitySession activitySession, ThemeDisplay themeDisplay)
		throws Exception {

		JSONObject activitySessionJSON = JSONFactoryUtil.createJSONObject();

		TMActivity activity = activitySession.getTMActivity();

		Date startTime = activitySession.getStartTime();
		Date endTime = activitySession.getEndTime();

		Format dateTimeFormat =
			FastDateFormatFactoryUtil.getTime(
				themeDisplay.getLocale(), themeDisplay.getTimeZone());

		activitySessionJSON.put(
			"activitySessionId", activitySession.getActivitySessionId());
		activitySessionJSON.put("activityId", activitySession.getActivityId());
		activitySessionJSON.put("activityName", activity.getActivityName());
		activitySessionJSON.put("startDate", startTime.getTime());
		activitySessionJSON.put("endDate", endTime.getTime());
		activitySessionJSON.put(
			"duration", activitySession.getDurationAsString());

		return activitySessionJSON;
	}

}