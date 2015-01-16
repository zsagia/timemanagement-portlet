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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.timemanagement.model.TMActivity;
import com.liferay.timemanagement.service.TMActivityLocalServiceUtil;
import com.liferay.timemanagement.util.DateTimeCalculatorUtil;

import java.util.Date;

/**
 * The extended model implementation for the TMActivitySession service. Represents a row in the &quot;timemanagement_TMActivitySession&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timemanagement.model.TMActivitySession} interface.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 */
public class TMActivitySessionImpl extends TMActivitySessionBaseImpl {

	public TMActivitySessionImpl() {
	}

	public long getDuration() throws Exception {
		Date endTime = getEndTime();
		Date startTime = getStartTime();

		if (startTime == null) {
			throw new Exception();
		}

		if (endTime == null) {
			throw new Exception();
		}

		long endTimeValue = endTime.getTime();
		long startTimeValue = startTime.getTime();

		if (startTimeValue > endTimeValue) {
			throw new Exception();
		}

		return endTimeValue - startTimeValue;
	}

	public String getDurationAsString() throws Exception {
		return DateTimeCalculatorUtil.getStringFromTime(getDuration());
	}

	public TMActivity getTMActivity() throws PortalException, SystemException {
		return TMActivityLocalServiceUtil.getTMActivity(getActivityId());
	}

}