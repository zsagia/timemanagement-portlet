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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.timemanagement.TMTaskNameException;
import com.liferay.timemanagement.model.TMTask;
import com.liferay.timemanagement.service.base.TMTaskLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the t m task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.timemanagement.service.TMTaskLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Zsolt Szabo
 * @see com.liferay.timemanagement.service.base.TMTaskLocalServiceBaseImpl
 * @see com.liferay.timemanagement.service.TMTaskLocalServiceUtil
 */
public class TMTaskLocalServiceImpl extends TMTaskLocalServiceBaseImpl {

	public TMTask addTMTask(
			long companyId, long userId, Date dueDate, long folderId,
			int priority, int status, String tmTaskName,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		TMTask tmTask = createTMTask(
			companyId, userId, dueDate, folderId, priority, status, tmTaskName,
			serviceContext);

		return tmTask;
	}

	public void addTMTaskResources(
			TMTask tmTask, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			tmTask.getCompanyId(), tmTask.getGroupId(), tmTask.getUserId(),
			TMTask.class.getName(), tmTask.getTaskId(), false,
			addGroupPermissions, addGuestPermissions);
	}

	public void addTMTaskResources(
			TMTask tmTask, String[] groupPermissions, String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			tmTask.getCompanyId(), tmTask.getGroupId(), tmTask.getUserId(),
			TMTask.class.getName(), tmTask.getTaskId(), groupPermissions,
			guestPermissions);
	}

	public TMTask deleteTMTask(long tmTaskId)
		throws PortalException, SystemException {

		TMTask tmTask = tmTaskPersistence.findByPrimaryKey(tmTaskId);

		resourceLocalService.deleteResource(
			tmTask.getCompanyId(), TMTask.class.getName(),
			ResourceConstants.SCOPE_COMPANY, tmTask.getTaskId());

		return deleteTMTask(tmTaskId);
	}

	public TMTask getTask(long taskId) throws PortalException, SystemException {
		return tmTaskPersistence.findByPrimaryKey(taskId);
	}

	public List<TMTask> getTaskByC_T(long companyId, long taskId)
		throws SystemException {

		return tmTaskPersistence.findByC_T(companyId, taskId);
	}

	public List<TMTask> getTaskByC_T_F(
			long companyId, long taskId, long folderId)
		throws SystemException {

		return tmTaskPersistence.findByC_T_F(companyId, taskId, folderId);
	}

	public TMTask updateTMTask(
			long taskId, long folderId, ServiceContext serviceContext)
		throws SystemException {

		TMTask tmTask = tmTaskPersistence.fetchByPrimaryKey(taskId);

		tmTask.setFolderId(folderId);

		tmTaskPersistence.update(tmTask);

		return tmTask;
	}

	public TMTask updateTMTask(
			long taskId, String taskName, ServiceContext serviceContext)
		throws SystemException {

		TMTask tmTask = tmTaskPersistence.fetchByPrimaryKey(taskId);

		tmTask.setTaskName(taskName);

		tmTaskPersistence.update(tmTask);

		return tmTask;
	}

	protected TMTask createTMTask(
			long companyId, long userId, Date dueDate, long folderId,
			int priority, int status, String tmTaskName,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();

		validate(tmTaskName);

		long tmTaskId = counterLocalService.increment();

		TMTask tmTask = tmTaskPersistence.create(tmTaskId);

		Date now = new Date();

		tmTask.setCompanyId(user.getCompanyId());
		tmTask.setCreateDate(now);
		tmTask.setGroupId(groupId);
		tmTask.setModifiedDate(now);
		tmTask.setDueDate(dueDate);
		tmTask.setFolderId(folderId);
		tmTask.setPriority(priority);
		tmTask.setStatus(status);
		tmTask.setTaskName(tmTaskName);
		tmTask.setUserId(userId);
		tmTask.setUserName(user.getFullName());

		tmTaskPersistence.update(tmTask);

		addTMTaskResources(
			tmTask, serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		return tmTask;
	}

	protected void validate(String taskName) throws TMTaskNameException {
		if (Validator.isNull(taskName)) {
			throw new TMTaskNameException();
		}
	}

}