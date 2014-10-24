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

package com.liferay.timemanagement.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.timemanagement.model.TMActivity;
import com.liferay.timemanagement.service.TMActivityLocalServiceUtil;

/**
* @author Zsolt Szabo
*/

public class TMActivityPermission {

	public static void check(
			PermissionChecker permissionChecker, long taskId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, taskId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, TMActivity tmActivity,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, tmActivity, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long tmActivityId,
			String actionId)
		throws PortalException, SystemException {

		TMActivity tmActivity = TMActivityLocalServiceUtil.getTMActivity(
			tmActivityId);

		return contains(permissionChecker, tmActivity, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, TMActivity tmActivity,
		String actionId) {

		if (permissionChecker.hasOwnerPermission(
				tmActivity.getGroupId(), TMActivity.class.getName(),
			tmActivity.getActivityId(), tmActivity.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			tmActivity.getGroupId(), TMActivity.class.getName(),
			tmActivity.getActivityId(), actionId);
	}

}