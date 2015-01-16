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

<aui:form cssClass="activity-portlet-content" method="post" name="fm1">
	<aui:layout>
		<aui:column columnWidth="50">
			<aui:row cssClass="activity-start-content">
				<h3 class="activity-start-header"><%= LanguageUtil.get(pageContext, "start-activity") %></h3>

				<aui:input autoFocus="<%= true %>" autoSize="<%= true %>" cssClass="activity-name" id="activityNameField" inlineField="<%= true %>" label="name" name="activityName" />

				<aui:button cssClass="start-activity-btn" id="startActivityButton" value="start" />
			</aui:row>

			<aui:row cssClass="activity-list-content">
				<h3 class="activity-list-header"><%= LanguageUtil.get(pageContext, "activities") %></h3>

				<div class="unstyled activity-list"></div>

				<div class="activity-list-pagination"></div>
			</aui:row>
		</aui:column>

		<aui:column columnWidth="50">
			<h3 class="today-activities-header"><%= LanguageUtil.get(pageContext, "today-activities") %></h3>

			<div class="unstyled today-activity-session-list" id="today-activity-session-list"></div>
		</aui:column>
	</aui:layout>
</aui:form>

<aui:script use="liferay-timetracking">
	new Liferay.Portlet.TimeTracking(
		{
			baseActionURL: '<%= PortletURLFactoryUtil.create(request, portletDisplay.getId(), themeDisplay.getPlid(), PortletRequest.ACTION_PHASE) %>',
			baseRenderURL: '<%= PortletURLFactoryUtil.create(request, portletDisplay.getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE) %>',
			baseResourceURL: '<%= PortletURLFactoryUtil.create(request, portletDisplay.getId(), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE) %>',
			itemsPerPage: <%= 15 %>,
			portletId: '<%= portletDisplay.getId() %>'
		}
	);
</aui:script>