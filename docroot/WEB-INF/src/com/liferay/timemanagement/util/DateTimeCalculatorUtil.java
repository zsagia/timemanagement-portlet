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

package com.liferay.timemanagement.util;

public class DateTimeCalculatorUtil {

	public static String getStringFromTime(long time) {
		StringBuffer buffer = new StringBuffer();

		long hours = time / (60 * 60 * 1000);
		long minutes = (time % (60 * 60 * 1000)) / (60 * 1000);

		if (hours < 10) {
			buffer.append("0");
		}

		buffer.append(hours);
		buffer.append(":");

		if (minutes < 10) {
			buffer.append("0");
		}

		buffer.append(minutes);

		return buffer.toString();
	}

}