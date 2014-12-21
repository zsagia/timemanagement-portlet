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

package com.liferay.timemanagement.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TMTask}.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMTask
 * @generated
 */
public class TMTaskWrapper implements TMTask, ModelWrapper<TMTask> {
	public TMTaskWrapper(TMTask tmTask) {
		_tmTask = tmTask;
	}

	@Override
	public Class<?> getModelClass() {
		return TMTask.class;
	}

	@Override
	public String getModelClassName() {
		return TMTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("folderId", getFolderId());
		attributes.put("priority", getPriority());
		attributes.put("status", getStatus());
		attributes.put("taskName", getTaskName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String taskName = (String)attributes.get("taskName");

		if (taskName != null) {
			setTaskName(taskName);
		}
	}

	/**
	* Returns the primary key of this t m task.
	*
	* @return the primary key of this t m task
	*/
	@Override
	public long getPrimaryKey() {
		return _tmTask.getPrimaryKey();
	}

	/**
	* Sets the primary key of this t m task.
	*
	* @param primaryKey the primary key of this t m task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tmTask.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the task ID of this t m task.
	*
	* @return the task ID of this t m task
	*/
	@Override
	public long getTaskId() {
		return _tmTask.getTaskId();
	}

	/**
	* Sets the task ID of this t m task.
	*
	* @param taskId the task ID of this t m task
	*/
	@Override
	public void setTaskId(long taskId) {
		_tmTask.setTaskId(taskId);
	}

	/**
	* Returns the group ID of this t m task.
	*
	* @return the group ID of this t m task
	*/
	@Override
	public long getGroupId() {
		return _tmTask.getGroupId();
	}

	/**
	* Sets the group ID of this t m task.
	*
	* @param groupId the group ID of this t m task
	*/
	@Override
	public void setGroupId(long groupId) {
		_tmTask.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this t m task.
	*
	* @return the company ID of this t m task
	*/
	@Override
	public long getCompanyId() {
		return _tmTask.getCompanyId();
	}

	/**
	* Sets the company ID of this t m task.
	*
	* @param companyId the company ID of this t m task
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tmTask.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this t m task.
	*
	* @return the user ID of this t m task
	*/
	@Override
	public long getUserId() {
		return _tmTask.getUserId();
	}

	/**
	* Sets the user ID of this t m task.
	*
	* @param userId the user ID of this t m task
	*/
	@Override
	public void setUserId(long userId) {
		_tmTask.setUserId(userId);
	}

	/**
	* Returns the user uuid of this t m task.
	*
	* @return the user uuid of this t m task
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmTask.getUserUuid();
	}

	/**
	* Sets the user uuid of this t m task.
	*
	* @param userUuid the user uuid of this t m task
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tmTask.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this t m task.
	*
	* @return the user name of this t m task
	*/
	@Override
	public java.lang.String getUserName() {
		return _tmTask.getUserName();
	}

	/**
	* Sets the user name of this t m task.
	*
	* @param userName the user name of this t m task
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tmTask.setUserName(userName);
	}

	/**
	* Returns the create date of this t m task.
	*
	* @return the create date of this t m task
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tmTask.getCreateDate();
	}

	/**
	* Sets the create date of this t m task.
	*
	* @param createDate the create date of this t m task
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tmTask.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this t m task.
	*
	* @return the modified date of this t m task
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tmTask.getModifiedDate();
	}

	/**
	* Sets the modified date of this t m task.
	*
	* @param modifiedDate the modified date of this t m task
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tmTask.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the due date of this t m task.
	*
	* @return the due date of this t m task
	*/
	@Override
	public java.util.Date getDueDate() {
		return _tmTask.getDueDate();
	}

	/**
	* Sets the due date of this t m task.
	*
	* @param dueDate the due date of this t m task
	*/
	@Override
	public void setDueDate(java.util.Date dueDate) {
		_tmTask.setDueDate(dueDate);
	}

	/**
	* Returns the folder ID of this t m task.
	*
	* @return the folder ID of this t m task
	*/
	@Override
	public long getFolderId() {
		return _tmTask.getFolderId();
	}

	/**
	* Sets the folder ID of this t m task.
	*
	* @param folderId the folder ID of this t m task
	*/
	@Override
	public void setFolderId(long folderId) {
		_tmTask.setFolderId(folderId);
	}

	/**
	* Returns the priority of this t m task.
	*
	* @return the priority of this t m task
	*/
	@Override
	public int getPriority() {
		return _tmTask.getPriority();
	}

	/**
	* Sets the priority of this t m task.
	*
	* @param priority the priority of this t m task
	*/
	@Override
	public void setPriority(int priority) {
		_tmTask.setPriority(priority);
	}

	/**
	* Returns the status of this t m task.
	*
	* @return the status of this t m task
	*/
	@Override
	public int getStatus() {
		return _tmTask.getStatus();
	}

	/**
	* Sets the status of this t m task.
	*
	* @param status the status of this t m task
	*/
	@Override
	public void setStatus(int status) {
		_tmTask.setStatus(status);
	}

	/**
	* Returns the task name of this t m task.
	*
	* @return the task name of this t m task
	*/
	@Override
	public java.lang.String getTaskName() {
		return _tmTask.getTaskName();
	}

	/**
	* Sets the task name of this t m task.
	*
	* @param taskName the task name of this t m task
	*/
	@Override
	public void setTaskName(java.lang.String taskName) {
		_tmTask.setTaskName(taskName);
	}

	@Override
	public boolean isNew() {
		return _tmTask.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tmTask.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tmTask.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tmTask.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tmTask.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tmTask.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tmTask.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tmTask.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tmTask.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tmTask.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tmTask.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TMTaskWrapper((TMTask)_tmTask.clone());
	}

	@Override
	public int compareTo(com.liferay.timemanagement.model.TMTask tmTask) {
		return _tmTask.compareTo(tmTask);
	}

	@Override
	public int hashCode() {
		return _tmTask.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.timemanagement.model.TMTask> toCacheModel() {
		return _tmTask.toCacheModel();
	}

	@Override
	public com.liferay.timemanagement.model.TMTask toEscapedModel() {
		return new TMTaskWrapper(_tmTask.toEscapedModel());
	}

	@Override
	public com.liferay.timemanagement.model.TMTask toUnescapedModel() {
		return new TMTaskWrapper(_tmTask.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tmTask.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tmTask.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tmTask.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TMTaskWrapper)) {
			return false;
		}

		TMTaskWrapper tmTaskWrapper = (TMTaskWrapper)obj;

		if (Validator.equals(_tmTask, tmTaskWrapper._tmTask)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TMTask getWrappedTMTask() {
		return _tmTask;
	}

	@Override
	public TMTask getWrappedModel() {
		return _tmTask;
	}

	@Override
	public void resetOriginalValues() {
		_tmTask.resetOriginalValues();
	}

	private TMTask _tmTask;
}