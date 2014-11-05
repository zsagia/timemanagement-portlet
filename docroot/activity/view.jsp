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

<%@page import="com.liferay.timemanagement.TMDateTimeException"%>
<%@page import="com.liferay.timemanagement.TMActivityNameException"%>
<%@ include file="/init.jsp" %>

<%
PortletURL portletURL = renderResponse.createRenderURL();

String currentURL = PortalUtil.getCurrentURL(request);

Calendar today = CalendarFactoryUtil.getCalendar(timeZone, locale);

String sortByCol = ParamUtil.getString(request, "orderByCol");
String sortByType = ParamUtil.getString(request, "orderByType");

if (Validator.isNull(sortByType)) {
	sortByType = "asc";
}

OrderByComparator orderByComparator = TMActivityModelUtil.getActivityOrderByComparator(sortByCol, sortByType);

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
%>

<portlet:actionURL name="updateActivity" var="updateActivityURL" />

<aui:form action="<%= updateActivityURL %>" method="post" name="fm1">
	<aui:input name="mvcPath" type="hidden" value="/activity/view.jsp" />

	<liferay-ui:error exception="<%= TMActivityNameException.class %>" message="please-enter-an-activity-name" />
	<liferay-ui:error exception="<%= TMDateTimeException.class %>" message="please-enter-a-start-date-that-comes-before-the-end-date" />

	<liferay-ui:panel-container accordion="<%= true %>" extended="<%= false %>">
		<liferay-ui:panel collapsible="<%= true %>" defaultState="open" extended="<%= true %>" persistState="<%= true %>" title="new-activity">
			<aui:fieldset>
				<aui:input label="name" name="activityName">
					<aui:validator name="required" />
				</aui:input>

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
		</liferay-ui:panel>

		<liferay-ui:panel collapsible="<%= true %>" defaultState="closed" extended="<%= true %>" persistState="<%= true %>" title="activity-list">
			<liferay-ui:search-container
				emptyResultsMessage="no-activities-were-found"
				headerNames="name,startDate,endDate,description,userName"
				iteratorURL="<%= portletURL %>"
				orderByCol="<%= sortByCol %>" orderByType="<%= sortByType %>"
				orderByComparator="<%= orderByComparator %>"
				total= "<%= TMActivityLocalServiceUtil.countByC_G(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId()) %>"
			>

				<liferay-ui:search-container-results
					results="<%= TMActivityLocalServiceUtil.getTMActivitiesByC_G(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), searchContainer.getStart(), searchContainer.getEnd(), orderByComparator) %>"
				/>

				<liferay-ui:search-container-row
					className="com.liferay.timemanagement.model.TMActivity"
					keyProperty="activityId"
					modelVar="activity"
				>

					<liferay-ui:search-container-column-text
						name="Name"
						orderable="<%= true %>"
						orderableProperty="name"
						value="<%= activity.getActivityName() %>"
					/>

					<liferay-ui:search-container-column-text
						name="start-date"
						orderable="<%= true %>"
						orderableProperty="startDate"
						value="<%= dateTimeFormat.format(activity.getTMActivitySession().getStartTime()) %>"
					/>

					<liferay-ui:search-container-column-text
						name="end-date"
						orderable="<%= true %>"
						orderableProperty="endDate"
						value="<%= dateTimeFormat.format(activity.getTMActivitySession().getStartTime()) %>"
					/>

					<liferay-ui:search-container-column-text
						name="description"
						value="<%= activity.getDescription() %>"
					/>

					<liferay-ui:search-container-column-text
						name="author"
						value="<%= activity.getTMActivitySession().getUserName() %>"
					/>

				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
</aui:form>