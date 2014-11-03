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

package com.liferay.timemanagement.model.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.timemanagement.model.TMActivitySession;
import com.liferay.timemanagement.service.TMActivitySessionLocalServiceUtil;

import java.util.List;

/**
 * The extended model implementation for the TMActivity service. Represents a row in the &quot;timemanagement_TMActivity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timemanagement.model.TMActivity} interface.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 */
@SuppressWarnings("serial")
public class TMActivityImpl extends TMActivityBaseImpl {

	public TMActivityImpl() {
	}

	public TMActivitySession getTMActivitySession() throws SystemException {
		List<TMActivitySession> tmActivitySessions =
			TMActivitySessionLocalServiceUtil.getTMActivitySessionsByActivityId(
				getActivityId());

		return tmActivitySessions.get(0);
	}

}