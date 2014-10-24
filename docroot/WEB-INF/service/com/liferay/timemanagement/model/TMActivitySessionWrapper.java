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
 * This class is a wrapper for {@link TMActivitySession}.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivitySession
 * @generated
 */
public class TMActivitySessionWrapper implements TMActivitySession,
	ModelWrapper<TMActivitySession> {
	public TMActivitySessionWrapper(TMActivitySession tmActivitySession) {
		_tmActivitySession = tmActivitySession;
	}

	@Override
	public Class<?> getModelClass() {
		return TMActivitySession.class;
	}

	@Override
	public String getModelClassName() {
		return TMActivitySession.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activitySessionId", getActivitySessionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("activityId", getActivityId());
		attributes.put("endTime", getEndTime());
		attributes.put("startTime", getStartTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long activitySessionId = (Long)attributes.get("activitySessionId");

		if (activitySessionId != null) {
			setActivitySessionId(activitySessionId);
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

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}
	}

	/**
	* Returns the primary key of this t m activity session.
	*
	* @return the primary key of this t m activity session
	*/
	@Override
	public long getPrimaryKey() {
		return _tmActivitySession.getPrimaryKey();
	}

	/**
	* Sets the primary key of this t m activity session.
	*
	* @param primaryKey the primary key of this t m activity session
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tmActivitySession.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the activity session ID of this t m activity session.
	*
	* @return the activity session ID of this t m activity session
	*/
	@Override
	public long getActivitySessionId() {
		return _tmActivitySession.getActivitySessionId();
	}

	/**
	* Sets the activity session ID of this t m activity session.
	*
	* @param activitySessionId the activity session ID of this t m activity session
	*/
	@Override
	public void setActivitySessionId(long activitySessionId) {
		_tmActivitySession.setActivitySessionId(activitySessionId);
	}

	/**
	* Returns the group ID of this t m activity session.
	*
	* @return the group ID of this t m activity session
	*/
	@Override
	public long getGroupId() {
		return _tmActivitySession.getGroupId();
	}

	/**
	* Sets the group ID of this t m activity session.
	*
	* @param groupId the group ID of this t m activity session
	*/
	@Override
	public void setGroupId(long groupId) {
		_tmActivitySession.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this t m activity session.
	*
	* @return the company ID of this t m activity session
	*/
	@Override
	public long getCompanyId() {
		return _tmActivitySession.getCompanyId();
	}

	/**
	* Sets the company ID of this t m activity session.
	*
	* @param companyId the company ID of this t m activity session
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tmActivitySession.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this t m activity session.
	*
	* @return the user ID of this t m activity session
	*/
	@Override
	public long getUserId() {
		return _tmActivitySession.getUserId();
	}

	/**
	* Sets the user ID of this t m activity session.
	*
	* @param userId the user ID of this t m activity session
	*/
	@Override
	public void setUserId(long userId) {
		_tmActivitySession.setUserId(userId);
	}

	/**
	* Returns the user uuid of this t m activity session.
	*
	* @return the user uuid of this t m activity session
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySession.getUserUuid();
	}

	/**
	* Sets the user uuid of this t m activity session.
	*
	* @param userUuid the user uuid of this t m activity session
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tmActivitySession.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this t m activity session.
	*
	* @return the user name of this t m activity session
	*/
	@Override
	public java.lang.String getUserName() {
		return _tmActivitySession.getUserName();
	}

	/**
	* Sets the user name of this t m activity session.
	*
	* @param userName the user name of this t m activity session
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tmActivitySession.setUserName(userName);
	}

	/**
	* Returns the create date of this t m activity session.
	*
	* @return the create date of this t m activity session
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tmActivitySession.getCreateDate();
	}

	/**
	* Sets the create date of this t m activity session.
	*
	* @param createDate the create date of this t m activity session
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tmActivitySession.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this t m activity session.
	*
	* @return the modified date of this t m activity session
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tmActivitySession.getModifiedDate();
	}

	/**
	* Sets the modified date of this t m activity session.
	*
	* @param modifiedDate the modified date of this t m activity session
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tmActivitySession.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the activity ID of this t m activity session.
	*
	* @return the activity ID of this t m activity session
	*/
	@Override
	public long getActivityId() {
		return _tmActivitySession.getActivityId();
	}

	/**
	* Sets the activity ID of this t m activity session.
	*
	* @param activityId the activity ID of this t m activity session
	*/
	@Override
	public void setActivityId(long activityId) {
		_tmActivitySession.setActivityId(activityId);
	}

	/**
	* Returns the end time of this t m activity session.
	*
	* @return the end time of this t m activity session
	*/
	@Override
	public java.util.Date getEndTime() {
		return _tmActivitySession.getEndTime();
	}

	/**
	* Sets the end time of this t m activity session.
	*
	* @param endTime the end time of this t m activity session
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_tmActivitySession.setEndTime(endTime);
	}

	/**
	* Returns the start time of this t m activity session.
	*
	* @return the start time of this t m activity session
	*/
	@Override
	public java.util.Date getStartTime() {
		return _tmActivitySession.getStartTime();
	}

	/**
	* Sets the start time of this t m activity session.
	*
	* @param startTime the start time of this t m activity session
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_tmActivitySession.setStartTime(startTime);
	}

	@Override
	public boolean isNew() {
		return _tmActivitySession.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tmActivitySession.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tmActivitySession.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tmActivitySession.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tmActivitySession.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tmActivitySession.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tmActivitySession.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tmActivitySession.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tmActivitySession.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tmActivitySession.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tmActivitySession.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TMActivitySessionWrapper((TMActivitySession)_tmActivitySession.clone());
	}

	@Override
	public int compareTo(TMActivitySession tmActivitySession) {
		return _tmActivitySession.compareTo(tmActivitySession);
	}

	@Override
	public int hashCode() {
		return _tmActivitySession.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<TMActivitySession> toCacheModel() {
		return _tmActivitySession.toCacheModel();
	}

	@Override
	public TMActivitySession toEscapedModel() {
		return new TMActivitySessionWrapper(_tmActivitySession.toEscapedModel());
	}

	@Override
	public TMActivitySession toUnescapedModel() {
		return new TMActivitySessionWrapper(_tmActivitySession.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tmActivitySession.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tmActivitySession.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tmActivitySession.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TMActivitySessionWrapper)) {
			return false;
		}

		TMActivitySessionWrapper tmActivitySessionWrapper = (TMActivitySessionWrapper)obj;

		if (Validator.equals(_tmActivitySession,
					tmActivitySessionWrapper._tmActivitySession)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TMActivitySession getWrappedTMActivitySession() {
		return _tmActivitySession;
	}

	@Override
	public TMActivitySession getWrappedModel() {
		return _tmActivitySession;
	}

	@Override
	public void resetOriginalValues() {
		_tmActivitySession.resetOriginalValues();
	}

	private TMActivitySession _tmActivitySession;
}