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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.timemanagement.model.TMActivitySession;
import com.liferay.timemanagement.model.TMActivitySessionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TMActivitySession service. Represents a row in the &quot;timemanagement_TMActivitySession&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.timemanagement.model.TMActivitySessionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TMActivitySessionImpl}.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivitySessionImpl
 * @see com.liferay.timemanagement.model.TMActivitySession
 * @see com.liferay.timemanagement.model.TMActivitySessionModel
 * @generated
 */
public class TMActivitySessionModelImpl extends BaseModelImpl<TMActivitySession>
	implements TMActivitySessionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a t m activity session model instance should use the {@link com.liferay.timemanagement.model.TMActivitySession} interface instead.
	 */
	public static final String TABLE_NAME = "timemanagement_TMActivitySession";
	public static final Object[][] TABLE_COLUMNS = {
			{ "activitySessionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "activityId", Types.BIGINT },
			{ "endTime", Types.TIMESTAMP },
			{ "startTime", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table timemanagement_TMActivitySession (activitySessionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,activityId LONG,endTime DATE null,startTime DATE null)";
	public static final String TABLE_SQL_DROP = "drop table timemanagement_TMActivitySession";
	public static final String ORDER_BY_JPQL = " ORDER BY tmActivitySession.startTime DESC";
	public static final String ORDER_BY_SQL = " ORDER BY timemanagement_TMActivitySession.startTime DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.timemanagement.model.TMActivitySession"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.timemanagement.model.TMActivitySession"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.timemanagement.model.TMActivitySession"),
			true);
	public static long ACTIVITYID_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static long STARTTIME_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.timemanagement.model.TMActivitySession"));

	public TMActivitySessionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _activitySessionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setActivitySessionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _activitySessionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getActivitySessionId() {
		return _activitySessionId;
	}

	@Override
	public void setActivitySessionId(long activitySessionId) {
		_activitySessionId = activitySessionId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getActivityId() {
		return _activityId;
	}

	@Override
	public void setActivityId(long activityId) {
		_columnBitmask |= ACTIVITYID_COLUMN_BITMASK;

		if (!_setOriginalActivityId) {
			_setOriginalActivityId = true;

			_originalActivityId = _activityId;
		}

		_activityId = activityId;
	}

	public long getOriginalActivityId() {
		return _originalActivityId;
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_columnBitmask = -1L;

		_startTime = startTime;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TMActivitySession.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TMActivitySession toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TMActivitySession)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TMActivitySessionImpl tmActivitySessionImpl = new TMActivitySessionImpl();

		tmActivitySessionImpl.setActivitySessionId(getActivitySessionId());
		tmActivitySessionImpl.setGroupId(getGroupId());
		tmActivitySessionImpl.setCompanyId(getCompanyId());
		tmActivitySessionImpl.setUserId(getUserId());
		tmActivitySessionImpl.setUserName(getUserName());
		tmActivitySessionImpl.setCreateDate(getCreateDate());
		tmActivitySessionImpl.setModifiedDate(getModifiedDate());
		tmActivitySessionImpl.setActivityId(getActivityId());
		tmActivitySessionImpl.setEndTime(getEndTime());
		tmActivitySessionImpl.setStartTime(getStartTime());

		tmActivitySessionImpl.resetOriginalValues();

		return tmActivitySessionImpl;
	}

	@Override
	public int compareTo(TMActivitySession tmActivitySession) {
		int value = 0;

		value = DateUtil.compareTo(getStartTime(),
				tmActivitySession.getStartTime());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TMActivitySession)) {
			return false;
		}

		TMActivitySession tmActivitySession = (TMActivitySession)obj;

		long primaryKey = tmActivitySession.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		TMActivitySessionModelImpl tmActivitySessionModelImpl = this;

		tmActivitySessionModelImpl._originalUserId = tmActivitySessionModelImpl._userId;

		tmActivitySessionModelImpl._setOriginalUserId = false;

		tmActivitySessionModelImpl._originalActivityId = tmActivitySessionModelImpl._activityId;

		tmActivitySessionModelImpl._setOriginalActivityId = false;

		tmActivitySessionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TMActivitySession> toCacheModel() {
		TMActivitySessionCacheModel tmActivitySessionCacheModel = new TMActivitySessionCacheModel();

		tmActivitySessionCacheModel.activitySessionId = getActivitySessionId();

		tmActivitySessionCacheModel.groupId = getGroupId();

		tmActivitySessionCacheModel.companyId = getCompanyId();

		tmActivitySessionCacheModel.userId = getUserId();

		tmActivitySessionCacheModel.userName = getUserName();

		String userName = tmActivitySessionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			tmActivitySessionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			tmActivitySessionCacheModel.createDate = createDate.getTime();
		}
		else {
			tmActivitySessionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			tmActivitySessionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			tmActivitySessionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		tmActivitySessionCacheModel.activityId = getActivityId();

		Date endTime = getEndTime();

		if (endTime != null) {
			tmActivitySessionCacheModel.endTime = endTime.getTime();
		}
		else {
			tmActivitySessionCacheModel.endTime = Long.MIN_VALUE;
		}

		Date startTime = getStartTime();

		if (startTime != null) {
			tmActivitySessionCacheModel.startTime = startTime.getTime();
		}
		else {
			tmActivitySessionCacheModel.startTime = Long.MIN_VALUE;
		}

		return tmActivitySessionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{activitySessionId=");
		sb.append(getActivitySessionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", activityId=");
		sb.append(getActivityId());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.timemanagement.model.TMActivitySession");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>activitySessionId</column-name><column-value><![CDATA[");
		sb.append(getActivitySessionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityId</column-name><column-value><![CDATA[");
		sb.append(getActivityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TMActivitySession.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TMActivitySession.class
		};
	private long _activitySessionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _activityId;
	private long _originalActivityId;
	private boolean _setOriginalActivityId;
	private Date _endTime;
	private Date _startTime;
	private long _columnBitmask;
	private TMActivitySession _escapedModel;
}