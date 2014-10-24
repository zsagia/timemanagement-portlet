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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.timemanagement.model.TMActivitySession;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TMActivitySession in entity cache.
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivitySession
 * @generated
 */
public class TMActivitySessionCacheModel implements CacheModel<TMActivitySession>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{activitySessionId=");
		sb.append(activitySessionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", activityId=");
		sb.append(activityId);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TMActivitySession toEntityModel() {
		TMActivitySessionImpl tmActivitySessionImpl = new TMActivitySessionImpl();

		tmActivitySessionImpl.setActivitySessionId(activitySessionId);
		tmActivitySessionImpl.setGroupId(groupId);
		tmActivitySessionImpl.setCompanyId(companyId);
		tmActivitySessionImpl.setUserId(userId);

		if (userName == null) {
			tmActivitySessionImpl.setUserName(StringPool.BLANK);
		}
		else {
			tmActivitySessionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tmActivitySessionImpl.setCreateDate(null);
		}
		else {
			tmActivitySessionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tmActivitySessionImpl.setModifiedDate(null);
		}
		else {
			tmActivitySessionImpl.setModifiedDate(new Date(modifiedDate));
		}

		tmActivitySessionImpl.setActivityId(activityId);

		if (endTime == Long.MIN_VALUE) {
			tmActivitySessionImpl.setEndTime(null);
		}
		else {
			tmActivitySessionImpl.setEndTime(new Date(endTime));
		}

		if (startTime == Long.MIN_VALUE) {
			tmActivitySessionImpl.setStartTime(null);
		}
		else {
			tmActivitySessionImpl.setStartTime(new Date(startTime));
		}

		tmActivitySessionImpl.resetOriginalValues();

		return tmActivitySessionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		activitySessionId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		activityId = objectInput.readLong();
		endTime = objectInput.readLong();
		startTime = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(activitySessionId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(activityId);
		objectOutput.writeLong(endTime);
		objectOutput.writeLong(startTime);
	}

	public long activitySessionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long activityId;
	public long endTime;
	public long startTime;
}