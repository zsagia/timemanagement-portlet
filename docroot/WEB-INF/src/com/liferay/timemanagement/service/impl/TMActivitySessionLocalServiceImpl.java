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
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.timemanagement.TMDateTimeException;
import com.liferay.timemanagement.model.TMActivitySession;
import com.liferay.timemanagement.service.base.TMActivitySessionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the t m activity session local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timemanagement.service.TMActivitySessionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see com.liferay.timemanagement.service.base.TMActivitySessionLocalServiceBaseImpl
 * @see com.liferay.timemanagement.service.TMActivitySessionLocalServiceUtil
 */
public class TMActivitySessionLocalServiceImpl
	extends TMActivitySessionLocalServiceBaseImpl {

	public TMActivitySession addActivitySession(
			long userId, Date startTime, Date endTime, long tmActivityId,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();

		validate(startTime, endTime);

		long activitySessionId = counterLocalService.increment();

		TMActivitySession tmActivitySession =
			tmActivitySessionPersistence.create(activitySessionId);

		Date now = new Date();

		tmActivitySession.setCompanyId(user.getCompanyId());
		tmActivitySession.setCreateDate(now);
		tmActivitySession.setEndTime(endTime);
		tmActivitySession.setGroupId(groupId);
		tmActivitySession.setModifiedDate(now);
		tmActivitySession.setStartTime(startTime);
		tmActivitySession.setActivityId(tmActivityId);
		tmActivitySession.setUserId(user.getUserId());
		tmActivitySession.setUserName(user.getFullName());

		tmActivitySessionPersistence.update(tmActivitySession);

		return tmActivitySession;
	}

	public List<TMActivitySession> getActivitySessionsByU_T(
			long userId, long tmActivityId)
		throws SystemException {

		List<TMActivitySession> tmActivitySessions =
			tmActivitySessionPersistence.findByU_T(userId, tmActivityId);

		return tmActivitySessions;
	}

	public List<TMActivitySession> getTMActivitySessionsByActivityId(
			long activityId)
		throws SystemException {

		return tmActivitySessionPersistence.findByactivityId(activityId);
	}

	public TMActivitySession updateTaskSession(
			TMActivitySession tmActivitySession)
		throws SystemException {

		Date now = new Date();

		tmActivitySession.setModifiedDate(now);

		tmActivitySessionPersistence.update(tmActivitySession);

		return tmActivitySession;
	}

	protected void validate(Date startTime, Date endTime)
		throws PortalException {

		if (!startTime.before(endTime)) {
			throw new TMDateTimeException();
		}
	}

}