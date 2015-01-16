<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String randomNamespace = PortalUtil.generateRandomKey(request, "portlet_activity_tracking") + StringPool.UNDERLINE;

Calendar today = CalendarFactoryUtil.getCalendar(timeZone, locale);

int endDateAmPm = today.get(Calendar.AM_PM);
int endDateDay = today.get(Calendar.DATE);
int endDateHour = today.get(Calendar.HOUR);
int endDateMinute = today.get(Calendar.MINUTE);
int endDateMonth = today.get(Calendar.MONTH);
int endDateYear = today.get(Calendar.YEAR);
int endDateYearRangeEnd = today.get(Calendar.YEAR);
int endDateYearRangeStart = today.get(Calendar.YEAR) - 50;

int startDateAmPm = today.get(Calendar.AM_PM);
int startDateDay = today.get(Calendar.DATE);
int startDateHour = today.get(Calendar.HOUR);
int startDateMinute = today.get(Calendar.MINUTE);
int startDateMonth = today.get(Calendar.MONTH);
int startDateYear = today.get(Calendar.YEAR);
int startDateYearRangeEnd = today.get(Calendar.YEAR);
int startDateYearRangeStart = today.get(Calendar.YEAR) - 50;

String activityName = ParamUtil.getString(request, "activityName");

long activityId = ParamUtil.getLong(request, "activityId");
%>

<portlet:actionURL name="startActivity" var="startActivityURL" />

<aui:form action="<%= startActivityURL %>" cssClass="start-activity-form" method="post" name='<%= randomNamespace + "fm" %>'>
	<div class="hide lfr-message-response" id="activityMessagesStart"></div>

	<aui:input name="<%= Constants.CMD %>" type="hidden" value="start_activity" />

	<aui:input name="mvcPath" type="hidden" value="/timetracking/start_activity.jsp" />

	<aui:fieldset>
		<aui:input name="activityId" type="hidden" value="<%= activityId %>" />

		<%
			if (activityName != null) {
		%>

				<aui:input name="activityName" type="hidden" value="<%= activityName %>" />

				<span class="activity-name"><%= HtmlUtil.escape(activityName) %></span>

		<%
			}
		%>

		<aui:field-wrapper label="start-date">
			<liferay-ui:input-date
				dayParam='<%= "startDateDay" %>'
				dayValue="<%= startDateDay %>"
				monthParam='<%= "startDateMonth" %>'
				monthValue="<%= startDateMonth %>"
				yearParam='<%= "startDateYear" %>'
				yearValue="<%= startDateYear %>"
			/>

			<liferay-ui:input-time
				amPmParam='<%= "startDateAmPm" %>'
				amPmValue="<%= startDateAmPm %>"
				hourParam='<%= "startDateHour" %>'
				hourValue="<%= startDateHour %>"
				minuteParam='<%= "startDateMinute" %>'
				minuteValue="<%= startDateMinute %>"
			/>
		</aui:field-wrapper>

		<aui:field-wrapper label="end-date">
			<liferay-ui:input-date
				dayParam='<%= "endDateDay" %>'
				dayValue="<%= endDateDay %>"
				monthParam='<%= "endDateMonth" %>'
				monthValue="<%= endDateMonth %>"
				yearParam='<%= "endDateYear" %>'
				yearValue="<%= endDateYear %>"
			/>

			<liferay-ui:input-time
				amPmParam='<%= "endDateAmPm" %>'
				amPmValue="<%= endDateAmPm %>"
				hourParam='<%= "endDateHour" %>'
				hourValue="<%= endDateHour %>"
				minuteParam='<%= "endDateMinute" %>'
				minuteValue="<%= endDateMinute %>"
			/>
		</aui:field-wrapper>

		<aui:field-wrapper>
			<aui:input name="description" type="textarea" />
		</aui:field-wrapper>

		<aui:field-wrapper label="permissions">
			<liferay-ui:input-permissions
				modelName="<%= TMActivity.class.getName() %>"
			/>
		</aui:field-wrapper>

		<aui:button-row cssClass="activity-action">
			<aui:button type="submit" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>