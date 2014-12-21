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

import com.liferay.timemanagement.model.TMTask;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TMTask in entity cache.
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMTask
 * @generated
 */
public class TMTaskCacheModel implements CacheModel<TMTask>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{taskId=");
		sb.append(taskId);
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
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", status=");
		sb.append(status);
		sb.append(", taskName=");
		sb.append(taskName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TMTask toEntityModel() {
		TMTaskImpl tmTaskImpl = new TMTaskImpl();

		tmTaskImpl.setTaskId(taskId);
		tmTaskImpl.setGroupId(groupId);
		tmTaskImpl.setCompanyId(companyId);
		tmTaskImpl.setUserId(userId);

		if (userName == null) {
			tmTaskImpl.setUserName(StringPool.BLANK);
		}
		else {
			tmTaskImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tmTaskImpl.setCreateDate(null);
		}
		else {
			tmTaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tmTaskImpl.setModifiedDate(null);
		}
		else {
			tmTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (dueDate == Long.MIN_VALUE) {
			tmTaskImpl.setDueDate(null);
		}
		else {
			tmTaskImpl.setDueDate(new Date(dueDate));
		}

		tmTaskImpl.setFolderId(folderId);
		tmTaskImpl.setPriority(priority);
		tmTaskImpl.setStatus(status);

		if (taskName == null) {
			tmTaskImpl.setTaskName(StringPool.BLANK);
		}
		else {
			tmTaskImpl.setTaskName(taskName);
		}

		tmTaskImpl.resetOriginalValues();

		return tmTaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dueDate = objectInput.readLong();
		folderId = objectInput.readLong();
		priority = objectInput.readInt();
		status = objectInput.readInt();
		taskName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(taskId);
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
		objectOutput.writeLong(dueDate);
		objectOutput.writeLong(folderId);
		objectOutput.writeInt(priority);
		objectOutput.writeInt(status);

		if (taskName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taskName);
		}
	}

	public long taskId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dueDate;
	public long folderId;
	public int priority;
	public int status;
	public String taskName;
}