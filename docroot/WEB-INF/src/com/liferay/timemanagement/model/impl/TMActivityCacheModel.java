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

import com.liferay.timemanagement.model.TMActivity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TMActivity in entity cache.
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivity
 * @generated
 */
public class TMActivityCacheModel implements CacheModel<TMActivity>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{activityId=");
		sb.append(activityId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", activityName=");
		sb.append(activityName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TMActivity toEntityModel() {
		TMActivityImpl tmActivityImpl = new TMActivityImpl();

		tmActivityImpl.setActivityId(activityId);
		tmActivityImpl.setGroupId(groupId);
		tmActivityImpl.setCompanyId(companyId);
		tmActivityImpl.setUserId(userId);

		if (userName == null) {
			tmActivityImpl.setUserName(StringPool.BLANK);
		}
		else {
			tmActivityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tmActivityImpl.setCreateDate(null);
		}
		else {
			tmActivityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tmActivityImpl.setModifiedDate(null);
		}
		else {
			tmActivityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			tmActivityImpl.setDescription(StringPool.BLANK);
		}
		else {
			tmActivityImpl.setDescription(description);
		}

		if (activityName == null) {
			tmActivityImpl.setActivityName(StringPool.BLANK);
		}
		else {
			tmActivityImpl.setActivityName(activityName);
		}

		tmActivityImpl.resetOriginalValues();

		return tmActivityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		activityId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		activityName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(activityId);
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

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (activityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityName);
		}
	}

	public long activityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String activityName;
}