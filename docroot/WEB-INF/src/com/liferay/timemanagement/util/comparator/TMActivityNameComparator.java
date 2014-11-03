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

package com.liferay.timemanagement.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.timemanagement.model.TMActivity;

/**
 * @author Zsolt Szabo
 */
@SuppressWarnings("serial")
public class TMActivityNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "activityName ASC";

	public static final String ORDER_BY_DESC = "activityName DESC";

	public static final String[] ORDER_BY_FIELDS = {"activityName"};

	public TMActivityNameComparator() {
		this(false);
	}

	public TMActivityNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object activity1, Object activity2) {
		String name1 = ((TMActivity)activity1).getActivityName();
		String name2 = ((TMActivity)activity2).getActivityName();

		int value = name1.compareToIgnoreCase(name2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}