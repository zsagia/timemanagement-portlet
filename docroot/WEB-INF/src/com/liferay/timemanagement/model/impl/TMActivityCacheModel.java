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
		StringBundler sb = new StringBundler(37);

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
		sb.append(", activityName=");
		sb.append(activityName);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", classUuid=");
		sb.append(classUuid);
		sb.append(", description=");
		sb.append(description);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", reminderDate=");
		sb.append(reminderDate);
		sb.append(", scheduledDate=");
		sb.append(scheduledDate);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", visible=");
		sb.append(visible);
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

		if (activityName == null) {
			tmActivityImpl.setActivityName(StringPool.BLANK);
		}
		else {
			tmActivityImpl.setActivityName(activityName);
		}

		tmActivityImpl.setClassNameId(classNameId);
		tmActivityImpl.setClassPK(classPK);

		if (classUuid == null) {
			tmActivityImpl.setClassUuid(StringPool.BLANK);
		}
		else {
			tmActivityImpl.setClassUuid(classUuid);
		}

		if (description == null) {
			tmActivityImpl.setDescription(StringPool.BLANK);
		}
		else {
			tmActivityImpl.setDescription(description);
		}

		if (endDate == Long.MIN_VALUE) {
			tmActivityImpl.setEndDate(null);
		}
		else {
			tmActivityImpl.setEndDate(new Date(endDate));
		}

		tmActivityImpl.setPriority(priority);

		if (reminderDate == Long.MIN_VALUE) {
			tmActivityImpl.setReminderDate(null);
		}
		else {
			tmActivityImpl.setReminderDate(new Date(reminderDate));
		}

		if (scheduledDate == Long.MIN_VALUE) {
			tmActivityImpl.setScheduledDate(null);
		}
		else {
			tmActivityImpl.setScheduledDate(new Date(scheduledDate));
		}

		if (startDate == Long.MIN_VALUE) {
			tmActivityImpl.setStartDate(null);
		}
		else {
			tmActivityImpl.setStartDate(new Date(startDate));
		}

		tmActivityImpl.setVisible(visible);

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
		activityName = objectInput.readUTF();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		classUuid = objectInput.readUTF();
		description = objectInput.readUTF();
		endDate = objectInput.readLong();
		priority = objectInput.readInt();
		reminderDate = objectInput.readLong();
		scheduledDate = objectInput.readLong();
		startDate = objectInput.readLong();
		visible = objectInput.readBoolean();
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

		if (activityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityName);
		}

		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);

		if (classUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classUuid);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(endDate);
		objectOutput.writeInt(priority);
		objectOutput.writeLong(reminderDate);
		objectOutput.writeLong(scheduledDate);
		objectOutput.writeLong(startDate);
		objectOutput.writeBoolean(visible);
	}

	public long activityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String activityName;
	public long classNameId;
	public long classPK;
	public String classUuid;
	public String description;
	public long endDate;
	public int priority;
	public long reminderDate;
	public long scheduledDate;
	public long startDate;
	public boolean visible;
}