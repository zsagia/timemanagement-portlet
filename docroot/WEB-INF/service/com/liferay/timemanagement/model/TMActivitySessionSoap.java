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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @generated
 */
public class TMActivitySessionSoap implements Serializable {
	public static TMActivitySessionSoap toSoapModel(TMActivitySession model) {
		TMActivitySessionSoap soapModel = new TMActivitySessionSoap();

		soapModel.setActivitySessionId(model.getActivitySessionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActivityId(model.getActivityId());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setStartTime(model.getStartTime());

		return soapModel;
	}

	public static TMActivitySessionSoap[] toSoapModels(
		TMActivitySession[] models) {
		TMActivitySessionSoap[] soapModels = new TMActivitySessionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TMActivitySessionSoap[][] toSoapModels(
		TMActivitySession[][] models) {
		TMActivitySessionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TMActivitySessionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TMActivitySessionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TMActivitySessionSoap[] toSoapModels(
		List<TMActivitySession> models) {
		List<TMActivitySessionSoap> soapModels = new ArrayList<TMActivitySessionSoap>(models.size());

		for (TMActivitySession model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TMActivitySessionSoap[soapModels.size()]);
	}

	public TMActivitySessionSoap() {
	}

	public long getPrimaryKey() {
		return _activitySessionId;
	}

	public void setPrimaryKey(long pk) {
		setActivitySessionId(pk);
	}

	public long getActivitySessionId() {
		return _activitySessionId;
	}

	public void setActivitySessionId(long activitySessionId) {
		_activitySessionId = activitySessionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getActivityId() {
		return _activityId;
	}

	public void setActivityId(long activityId) {
		_activityId = activityId;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	private long _activitySessionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _activityId;
	private Date _endTime;
	private Date _startTime;
}