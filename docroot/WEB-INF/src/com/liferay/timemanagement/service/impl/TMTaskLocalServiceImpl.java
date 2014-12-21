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
import com.liferay.timemanagement.model.TMTask;
import com.liferay.timemanagement.service.base.TMTaskLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the t m task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timemanagement.service.TMTaskLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Zsolt Szabo
 * @see com.liferay.timemanagement.service.base.TMTaskLocalServiceBaseImpl
 * @see com.liferay.timemanagement.service.TMTaskLocalServiceUtil
 */
public class TMTaskLocalServiceImpl extends TMTaskLocalServiceBaseImpl {

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

}