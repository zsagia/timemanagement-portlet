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
 * This class is used by SOAP remote services, specifically {@link com.liferay.timemanagement.service.http.TMActivityServiceSoap}.
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see com.liferay.timemanagement.service.http.TMActivityServiceSoap
 * @generated
 */
public class TMActivitySoap implements Serializable {
	public static TMActivitySoap toSoapModel(TMActivity model) {
		TMActivitySoap soapModel = new TMActivitySoap();

		soapModel.setActivityId(model.getActivityId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActivityName(model.getActivityName());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setClassUuid(model.getClassUuid());
		soapModel.setDescription(model.getDescription());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setPriority(model.getPriority());
		soapModel.setReminderDate(model.getReminderDate());
		soapModel.setScheduledDate(model.getScheduledDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setVisible(model.getVisible());

		return soapModel;
	}

	public static TMActivitySoap[] toSoapModels(TMActivity[] models) {
		TMActivitySoap[] soapModels = new TMActivitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TMActivitySoap[][] toSoapModels(TMActivity[][] models) {
		TMActivitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TMActivitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TMActivitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TMActivitySoap[] toSoapModels(List<TMActivity> models) {
		List<TMActivitySoap> soapModels = new ArrayList<TMActivitySoap>(models.size());

		for (TMActivity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TMActivitySoap[soapModels.size()]);
	}

	public TMActivitySoap() {
	}

	public long getPrimaryKey() {
		return _activityId;
	}

	public void setPrimaryKey(long pk) {
		setActivityId(pk);
	}

	public long getActivityId() {
		return _activityId;
	}

	public void setActivityId(long activityId) {
		_activityId = activityId;
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

	public String getActivityName() {
		return _activityName;
	}

	public void setActivityName(String activityName) {
		_activityName = activityName;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getClassUuid() {
		return _classUuid;
	}

	public void setClassUuid(String classUuid) {
		_classUuid = classUuid;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	public Date getReminderDate() {
		return _reminderDate;
	}

	public void setReminderDate(Date reminderDate) {
		_reminderDate = reminderDate;
	}

	public Date getScheduledDate() {
		return _scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		_scheduledDate = scheduledDate;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public boolean getVisible() {
		return _visible;
	}

	public boolean isVisible() {
		return _visible;
	}

	public void setVisible(boolean visible) {
		_visible = visible;
	}

	private long _activityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _activityName;
	private long _classNameId;
	private long _classPK;
	private String _classUuid;
	private String _description;
	private Date _endDate;
	private int _priority;
	private Date _reminderDate;
	private Date _scheduledDate;
	private Date _startDate;
	private boolean _visible;
}