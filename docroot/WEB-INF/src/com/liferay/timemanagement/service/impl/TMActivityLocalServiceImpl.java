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

package com.liferay.timemanagement.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.timemanagement.TMActivityNameException;
import com.liferay.timemanagement.model.TMActivity;
import com.liferay.timemanagement.service.base.TMActivityLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the t m activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timemanagement.service.TMActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see com.liferay.timemanagement.service.base.TMActivityLocalServiceBaseImpl
 * @see com.liferay.timemanagement.service.TMActivityLocalServiceUtil
 */
public class TMActivityLocalServiceImpl extends TMActivityLocalServiceBaseImpl {

	public TMActivity addTMActivity(
			long companyId, long userId, String taskName, String description,
			Date startTime, Date endTime, ServiceContext serviceContext)
		throws PortalException, SystemException {

		TMActivity tmActivity = addTMActivity(
			companyId, userId, taskName, description, serviceContext);

		tmActivitySessionLocalService.addActivitySession(
			userId, startTime, endTime, tmActivity.getActivityId(),
			serviceContext);

		return tmActivity;
	}

	public TMActivity addTMActivity(
			long companyId, long userId, String taskName, String description,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		TMActivity tmActivity = createTMActivity(
			companyId, userId, taskName, description, serviceContext);

		return tmActivity;
	}

	public void addTMActivityResources(
			TMActivity tmActivity, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			tmActivity.getCompanyId(), tmActivity.getGroupId(),
			tmActivity.getUserId(), TMActivity.class.getName(),
			tmActivity.getActivityId(), false, addGroupPermissions,
			addGuestPermissions);
	}

	public void addTMActivityResources(
			TMActivity tmActivity, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			tmActivity.getCompanyId(), tmActivity.getGroupId(),
			tmActivity.getUserId(), TMActivity.class.getName(),
			tmActivity.getActivityId(), groupPermissions, guestPermissions);
	}

	public int countByC_G(long companyId, long groupId) throws SystemException {
		return tmActivityPersistence.countByC_G(companyId, groupId);
	}

	public TMActivity deleteTMActivity(long tmActivityId)
		throws PortalException, SystemException {

		TMActivity tmActivity = tmActivityPersistence.findByPrimaryKey(
			tmActivityId);

		resourceLocalService.deleteResource(
			tmActivity.getCompanyId(), TMActivity.class.getName(),
			ResourceConstants.SCOPE_COMPANY, tmActivity.getActivityId());

		return deleteTMActivity(tmActivityId);
	}

	public List<TMActivity> getTMActivitiesByC_G(
			long companyId, long groupId, int start, int end)
		throws SystemException {

		return tmActivityPersistence.findByC_G(companyId, groupId, start, end);
	}

	public List<TMActivity> getTMActivitiesByC_G(
			long companyId, long groupId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return tmActivityPersistence.filterFindByC_G(
			companyId, groupId, start, end, orderByComparator);
	}

	public TMActivity updateTMActivity(
			long activityId, String activityName, String description,
			ServiceContext serviceContext)
		throws SystemException {

		TMActivity tmActivity = tmActivityPersistence.fetchByPrimaryKey(
			activityId);

		tmActivity.setActivityName(activityName);
		tmActivity.setDescription(description);

		tmActivityPersistence.update(tmActivity);

		return tmActivity;
	}

	public TMActivity updateTMActivity(TMActivity tmActivity)
		throws SystemException {

		tmActivityPersistence.update(tmActivity);

		return tmActivity;
	}

	protected TMActivity createTMActivity(
			long companyId, long userId, String tmActivityName,
			String description, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();

		validate(tmActivityName);

		long tmActivityId = counterLocalService.increment();

		TMActivity tmActivity = tmActivityPersistence.create(tmActivityId);

		Date now = new Date();

		tmActivity.setCompanyId(user.getCompanyId());
		tmActivity.setCreateDate(now);
		tmActivity.setGroupId(groupId);
		tmActivity.setModifiedDate(now);
		tmActivity.setActivityName(tmActivityName);
		tmActivity.setDescription(description);
		tmActivity.setUserId(userId);
		tmActivity.setUserName(user.getFullName());

		tmActivityPersistence.update(tmActivity);

		addTMActivityResources(
			tmActivity, serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		return tmActivity;
	}

	protected void validate(String activityName)
		throws TMActivityNameException {

		if (Validator.isNull(activityName)) {
			throw new TMActivityNameException();
		}
	}

}