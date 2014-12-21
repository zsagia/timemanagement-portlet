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
 * This class is a wrapper for {@link TMActivity}.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivity
 * @generated
 */
public class TMActivityWrapper implements TMActivity, ModelWrapper<TMActivity> {
	public TMActivityWrapper(TMActivity tmActivity) {
		_tmActivity = tmActivity;
	}

	@Override
	public Class<?> getModelClass() {
		return TMActivity.class;
	}

	@Override
	public String getModelClassName() {
		return TMActivity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activityId", getActivityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("activityName", getActivityName());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("classUuid", getClassUuid());
		attributes.put("description", getDescription());
		attributes.put("endDate", getEndDate());
		attributes.put("priority", getPriority());
		attributes.put("reminderDate", getReminderDate());
		attributes.put("scheduledDate", getScheduledDate());
		attributes.put("startDate", getStartDate());
		attributes.put("visible", getVisible());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
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

		String activityName = (String)attributes.get("activityName");

		if (activityName != null) {
			setActivityName(activityName);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String classUuid = (String)attributes.get("classUuid");

		if (classUuid != null) {
			setClassUuid(classUuid);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Date reminderDate = (Date)attributes.get("reminderDate");

		if (reminderDate != null) {
			setReminderDate(reminderDate);
		}

		Date scheduledDate = (Date)attributes.get("scheduledDate");

		if (scheduledDate != null) {
			setScheduledDate(scheduledDate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Boolean visible = (Boolean)attributes.get("visible");

		if (visible != null) {
			setVisible(visible);
		}
	}

	/**
	* Returns the primary key of this t m activity.
	*
	* @return the primary key of this t m activity
	*/
	@Override
	public long getPrimaryKey() {
		return _tmActivity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this t m activity.
	*
	* @param primaryKey the primary key of this t m activity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tmActivity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the activity ID of this t m activity.
	*
	* @return the activity ID of this t m activity
	*/
	@Override
	public long getActivityId() {
		return _tmActivity.getActivityId();
	}

	/**
	* Sets the activity ID of this t m activity.
	*
	* @param activityId the activity ID of this t m activity
	*/
	@Override
	public void setActivityId(long activityId) {
		_tmActivity.setActivityId(activityId);
	}

	/**
	* Returns the group ID of this t m activity.
	*
	* @return the group ID of this t m activity
	*/
	@Override
	public long getGroupId() {
		return _tmActivity.getGroupId();
	}

	/**
	* Sets the group ID of this t m activity.
	*
	* @param groupId the group ID of this t m activity
	*/
	@Override
	public void setGroupId(long groupId) {
		_tmActivity.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this t m activity.
	*
	* @return the company ID of this t m activity
	*/
	@Override
	public long getCompanyId() {
		return _tmActivity.getCompanyId();
	}

	/**
	* Sets the company ID of this t m activity.
	*
	* @param companyId the company ID of this t m activity
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tmActivity.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this t m activity.
	*
	* @return the user ID of this t m activity
	*/
	@Override
	public long getUserId() {
		return _tmActivity.getUserId();
	}

	/**
	* Sets the user ID of this t m activity.
	*
	* @param userId the user ID of this t m activity
	*/
	@Override
	public void setUserId(long userId) {
		_tmActivity.setUserId(userId);
	}

	/**
	* Returns the user uuid of this t m activity.
	*
	* @return the user uuid of this t m activity
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivity.getUserUuid();
	}

	/**
	* Sets the user uuid of this t m activity.
	*
	* @param userUuid the user uuid of this t m activity
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tmActivity.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this t m activity.
	*
	* @return the user name of this t m activity
	*/
	@Override
	public java.lang.String getUserName() {
		return _tmActivity.getUserName();
	}

	/**
	* Sets the user name of this t m activity.
	*
	* @param userName the user name of this t m activity
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tmActivity.setUserName(userName);
	}

	/**
	* Returns the create date of this t m activity.
	*
	* @return the create date of this t m activity
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tmActivity.getCreateDate();
	}

	/**
	* Sets the create date of this t m activity.
	*
	* @param createDate the create date of this t m activity
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tmActivity.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this t m activity.
	*
	* @return the modified date of this t m activity
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tmActivity.getModifiedDate();
	}

	/**
	* Sets the modified date of this t m activity.
	*
	* @param modifiedDate the modified date of this t m activity
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tmActivity.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the activity name of this t m activity.
	*
	* @return the activity name of this t m activity
	*/
	@Override
	public java.lang.String getActivityName() {
		return _tmActivity.getActivityName();
	}

	/**
	* Returns the localized activity name of this t m activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized activity name of this t m activity
	*/
	@Override
	public java.lang.String getActivityName(java.util.Locale locale) {
		return _tmActivity.getActivityName(locale);
	}

	/**
	* Returns the localized activity name of this t m activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized activity name of this t m activity. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getActivityName(java.util.Locale locale,
		boolean useDefault) {
		return _tmActivity.getActivityName(locale, useDefault);
	}

	/**
	* Returns the localized activity name of this t m activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized activity name of this t m activity
	*/
	@Override
	public java.lang.String getActivityName(java.lang.String languageId) {
		return _tmActivity.getActivityName(languageId);
	}

	/**
	* Returns the localized activity name of this t m activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized activity name of this t m activity
	*/
	@Override
	public java.lang.String getActivityName(java.lang.String languageId,
		boolean useDefault) {
		return _tmActivity.getActivityName(languageId, useDefault);
	}

	@Override
	public java.lang.String getActivityNameCurrentLanguageId() {
		return _tmActivity.getActivityNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getActivityNameCurrentValue() {
		return _tmActivity.getActivityNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized activity names of this t m activity.
	*
	* @return the locales and localized activity names of this t m activity
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getActivityNameMap() {
		return _tmActivity.getActivityNameMap();
	}

	/**
	* Sets the activity name of this t m activity.
	*
	* @param activityName the activity name of this t m activity
	*/
	@Override
	public void setActivityName(java.lang.String activityName) {
		_tmActivity.setActivityName(activityName);
	}

	/**
	* Sets the localized activity name of this t m activity in the language.
	*
	* @param activityName the localized activity name of this t m activity
	* @param locale the locale of the language
	*/
	@Override
	public void setActivityName(java.lang.String activityName,
		java.util.Locale locale) {
		_tmActivity.setActivityName(activityName, locale);
	}

	/**
	* Sets the localized activity name of this t m activity in the language, and sets the default locale.
	*
	* @param activityName the localized activity name of this t m activity
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setActivityName(java.lang.String activityName,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_tmActivity.setActivityName(activityName, locale, defaultLocale);
	}

	@Override
	public void setActivityNameCurrentLanguageId(java.lang.String languageId) {
		_tmActivity.setActivityNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized activity names of this t m activity from the map of locales and localized activity names.
	*
	* @param activityNameMap the locales and localized activity names of this t m activity
	*/
	@Override
	public void setActivityNameMap(
		java.util.Map<java.util.Locale, java.lang.String> activityNameMap) {
		_tmActivity.setActivityNameMap(activityNameMap);
	}

	/**
	* Sets the localized activity names of this t m activity from the map of locales and localized activity names, and sets the default locale.
	*
	* @param activityNameMap the locales and localized activity names of this t m activity
	* @param defaultLocale the default locale
	*/
	@Override
	public void setActivityNameMap(
		java.util.Map<java.util.Locale, java.lang.String> activityNameMap,
		java.util.Locale defaultLocale) {
		_tmActivity.setActivityNameMap(activityNameMap, defaultLocale);
	}

	/**
	* Returns the fully qualified class name of this t m activity.
	*
	* @return the fully qualified class name of this t m activity
	*/
	@Override
	public java.lang.String getClassName() {
		return _tmActivity.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_tmActivity.setClassName(className);
	}

	/**
	* Returns the class name ID of this t m activity.
	*
	* @return the class name ID of this t m activity
	*/
	@Override
	public long getClassNameId() {
		return _tmActivity.getClassNameId();
	}

	/**
	* Sets the class name ID of this t m activity.
	*
	* @param classNameId the class name ID of this t m activity
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_tmActivity.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this t m activity.
	*
	* @return the class p k of this t m activity
	*/
	@Override
	public long getClassPK() {
		return _tmActivity.getClassPK();
	}

	/**
	* Sets the class p k of this t m activity.
	*
	* @param classPK the class p k of this t m activity
	*/
	@Override
	public void setClassPK(long classPK) {
		_tmActivity.setClassPK(classPK);
	}

	/**
	* Returns the class uuid of this t m activity.
	*
	* @return the class uuid of this t m activity
	*/
	@Override
	public java.lang.String getClassUuid() {
		return _tmActivity.getClassUuid();
	}

	/**
	* Sets the class uuid of this t m activity.
	*
	* @param classUuid the class uuid of this t m activity
	*/
	@Override
	public void setClassUuid(java.lang.String classUuid) {
		_tmActivity.setClassUuid(classUuid);
	}

	/**
	* Returns the description of this t m activity.
	*
	* @return the description of this t m activity
	*/
	@Override
	public java.lang.String getDescription() {
		return _tmActivity.getDescription();
	}

	/**
	* Returns the localized description of this t m activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this t m activity
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _tmActivity.getDescription(locale);
	}

	/**
	* Returns the localized description of this t m activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this t m activity. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _tmActivity.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this t m activity in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this t m activity
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _tmActivity.getDescription(languageId);
	}

	/**
	* Returns the localized description of this t m activity in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this t m activity
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _tmActivity.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _tmActivity.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _tmActivity.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this t m activity.
	*
	* @return the locales and localized descriptions of this t m activity
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _tmActivity.getDescriptionMap();
	}

	/**
	* Sets the description of this t m activity.
	*
	* @param description the description of this t m activity
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_tmActivity.setDescription(description);
	}

	/**
	* Sets the localized description of this t m activity in the language.
	*
	* @param description the localized description of this t m activity
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_tmActivity.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this t m activity in the language, and sets the default locale.
	*
	* @param description the localized description of this t m activity
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_tmActivity.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_tmActivity.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this t m activity from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this t m activity
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_tmActivity.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this t m activity from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this t m activity
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_tmActivity.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Returns the end date of this t m activity.
	*
	* @return the end date of this t m activity
	*/
	@Override
	public java.util.Date getEndDate() {
		return _tmActivity.getEndDate();
	}

	/**
	* Sets the end date of this t m activity.
	*
	* @param endDate the end date of this t m activity
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_tmActivity.setEndDate(endDate);
	}

	/**
	* Returns the priority of this t m activity.
	*
	* @return the priority of this t m activity
	*/
	@Override
	public int getPriority() {
		return _tmActivity.getPriority();
	}

	/**
	* Sets the priority of this t m activity.
	*
	* @param priority the priority of this t m activity
	*/
	@Override
	public void setPriority(int priority) {
		_tmActivity.setPriority(priority);
	}

	/**
	* Returns the reminder date of this t m activity.
	*
	* @return the reminder date of this t m activity
	*/
	@Override
	public java.util.Date getReminderDate() {
		return _tmActivity.getReminderDate();
	}

	/**
	* Sets the reminder date of this t m activity.
	*
	* @param reminderDate the reminder date of this t m activity
	*/
	@Override
	public void setReminderDate(java.util.Date reminderDate) {
		_tmActivity.setReminderDate(reminderDate);
	}

	/**
	* Returns the scheduled date of this t m activity.
	*
	* @return the scheduled date of this t m activity
	*/
	@Override
	public java.util.Date getScheduledDate() {
		return _tmActivity.getScheduledDate();
	}

	/**
	* Sets the scheduled date of this t m activity.
	*
	* @param scheduledDate the scheduled date of this t m activity
	*/
	@Override
	public void setScheduledDate(java.util.Date scheduledDate) {
		_tmActivity.setScheduledDate(scheduledDate);
	}

	/**
	* Returns the start date of this t m activity.
	*
	* @return the start date of this t m activity
	*/
	@Override
	public java.util.Date getStartDate() {
		return _tmActivity.getStartDate();
	}

	/**
	* Sets the start date of this t m activity.
	*
	* @param startDate the start date of this t m activity
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_tmActivity.setStartDate(startDate);
	}

	/**
	* Returns the visible of this t m activity.
	*
	* @return the visible of this t m activity
	*/
	@Override
	public boolean getVisible() {
		return _tmActivity.getVisible();
	}

	/**
	* Returns <code>true</code> if this t m activity is visible.
	*
	* @return <code>true</code> if this t m activity is visible; <code>false</code> otherwise
	*/
	@Override
	public boolean isVisible() {
		return _tmActivity.isVisible();
	}

	/**
	* Sets whether this t m activity is visible.
	*
	* @param visible the visible of this t m activity
	*/
	@Override
	public void setVisible(boolean visible) {
		_tmActivity.setVisible(visible);
	}

	@Override
	public boolean isNew() {
		return _tmActivity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tmActivity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tmActivity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tmActivity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tmActivity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tmActivity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tmActivity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tmActivity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tmActivity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tmActivity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tmActivity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _tmActivity.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _tmActivity.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_tmActivity.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_tmActivity.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new TMActivityWrapper((TMActivity)_tmActivity.clone());
	}

	@Override
	public int compareTo(com.liferay.timemanagement.model.TMActivity tmActivity) {
		return _tmActivity.compareTo(tmActivity);
	}

	@Override
	public int hashCode() {
		return _tmActivity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.timemanagement.model.TMActivity> toCacheModel() {
		return _tmActivity.toCacheModel();
	}

	@Override
	public com.liferay.timemanagement.model.TMActivity toEscapedModel() {
		return new TMActivityWrapper(_tmActivity.toEscapedModel());
	}

	@Override
	public com.liferay.timemanagement.model.TMActivity toUnescapedModel() {
		return new TMActivityWrapper(_tmActivity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tmActivity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tmActivity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tmActivity.persist();
	}

	@Override
	public com.liferay.timemanagement.model.TMActivitySession getTMActivitySession()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivity.getTMActivitySession();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TMActivityWrapper)) {
			return false;
		}

		TMActivityWrapper tmActivityWrapper = (TMActivityWrapper)obj;

		if (Validator.equals(_tmActivity, tmActivityWrapper._tmActivity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TMActivity getWrappedTMActivity() {
		return _tmActivity;
	}

	@Override
	public TMActivity getWrappedModel() {
		return _tmActivity;
	}

	@Override
	public void resetOriginalValues() {
		_tmActivity.resetOriginalValues();
	}

	private TMActivity _tmActivity;
}