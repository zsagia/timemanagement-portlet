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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.timemanagement.model.TMActivity;
import com.liferay.timemanagement.model.TMActivitySession;
import com.liferay.timemanagement.service.TMActivityLocalServiceUtil;
import com.liferay.timemanagement.service.TMActivitySessionLocalServiceUtil;
import com.liferay.timemanagement.util.PortletKeys;
import com.liferay.timemanagement.util.TMDateTimeUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.Calendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Zsolt Szabo
 */
public class TimeTrackingPortlet extends MVCPortlet {

	public void updateActivity(
			ActionRequest actionRequest, ActionResponse actionResponse)
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

		try {
			if (activityId <= 0) {
				Calendar startTimeCalendar = TMDateTimeUtil.getCalendar(
					actionRequest, "startDate");
				Calendar endTimeCalendar = TMDateTimeUtil.getCalendar(
					actionRequest, "endDate");

				tmActivity = TMActivityLocalServiceUtil.addTMActivity(
					themeDisplay.getCompanyId(), themeDisplay.getUserId(),
					activityName, 0, 0, null, description, null, 0, null, null,
					null, true, startTimeCalendar.getTime(),
					endTimeCalendar.getTime(), serviceContext);
			}
			else {
				tmActivity = TMActivityLocalServiceUtil.getTMActivity(
					activityId);

				tmActivity.setActivityName(activityName);
				tmActivity.setDescription(description);

				tmActivity = TMActivityLocalServiceUtil.updateTMActivity(
					tmActivity);
			}

			Layout layout = themeDisplay.getLayout();

			PortletURL portletURL = PortletURLFactoryUtil.create(
				actionRequest, PortletKeys.TIME_MANAGEMENT_ACTIVITY,
				layout.getPlid(), PortletRequest.RENDER_PHASE);

			portletURL.setParameter("mvcPath", "/timetracking/view.jsp");

			actionResponse.sendRedirect(portletURL.toString());
		}
		catch (Exception e) {
			actionResponse.setRenderParameter(
				"mvcPath", "/timetracking/view.jsp");

			actionResponse.setRenderParameters(actionRequest.getParameterMap());

			SessionErrors.add(actionRequest, e.getClass(), e);
		}
	}

	public void updateActivitySession(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		updateTMActivitySession(actionRequest, 0);
	}

	protected TMActivitySession updateTMActivitySession(
			PortletRequest portletRequest, long tmActivityId)
		throws PortalException, SystemException {

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

}