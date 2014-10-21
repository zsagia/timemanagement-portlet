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
		attributes.put("description", getDescription());
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	* Returns the description of this t m task.
	*
	* @return the description of this t m task
	*/
	@Override
	public java.lang.String getDescription() {
		return _tmTask.getDescription();
	}

	/**
	* Returns the localized description of this t m task in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this t m task
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _tmTask.getDescription(locale);
	}

	/**
	* Returns the localized description of this t m task in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this t m task. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _tmTask.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this t m task in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this t m task
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _tmTask.getDescription(languageId);
	}

	/**
	* Returns the localized description of this t m task in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this t m task
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _tmTask.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _tmTask.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _tmTask.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this t m task.
	*
	* @return the locales and localized descriptions of this t m task
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _tmTask.getDescriptionMap();
	}

	/**
	* Sets the description of this t m task.
	*
	* @param description the description of this t m task
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_tmTask.setDescription(description);
	}

	/**
	* Sets the localized description of this t m task in the language.
	*
	* @param description the localized description of this t m task
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_tmTask.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this t m task in the language, and sets the default locale.
	*
	* @param description the localized description of this t m task
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_tmTask.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_tmTask.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this t m task from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this t m task
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_tmTask.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this t m task from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this t m task
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_tmTask.setDescriptionMap(descriptionMap, defaultLocale);
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
	* Returns the localized task name of this t m task in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized task name of this t m task
	*/
	@Override
	public java.lang.String getTaskName(java.util.Locale locale) {
		return _tmTask.getTaskName(locale);
	}

	/**
	* Returns the localized task name of this t m task in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized task name of this t m task. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTaskName(java.util.Locale locale,
		boolean useDefault) {
		return _tmTask.getTaskName(locale, useDefault);
	}

	/**
	* Returns the localized task name of this t m task in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized task name of this t m task
	*/
	@Override
	public java.lang.String getTaskName(java.lang.String languageId) {
		return _tmTask.getTaskName(languageId);
	}

	/**
	* Returns the localized task name of this t m task in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized task name of this t m task
	*/
	@Override
	public java.lang.String getTaskName(java.lang.String languageId,
		boolean useDefault) {
		return _tmTask.getTaskName(languageId, useDefault);
	}

	@Override
	public java.lang.String getTaskNameCurrentLanguageId() {
		return _tmTask.getTaskNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getTaskNameCurrentValue() {
		return _tmTask.getTaskNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized task names of this t m task.
	*
	* @return the locales and localized task names of this t m task
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTaskNameMap() {
		return _tmTask.getTaskNameMap();
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

	/**
	* Sets the localized task name of this t m task in the language.
	*
	* @param taskName the localized task name of this t m task
	* @param locale the locale of the language
	*/
	@Override
	public void setTaskName(java.lang.String taskName, java.util.Locale locale) {
		_tmTask.setTaskName(taskName, locale);
	}

	/**
	* Sets the localized task name of this t m task in the language, and sets the default locale.
	*
	* @param taskName the localized task name of this t m task
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTaskName(java.lang.String taskName, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_tmTask.setTaskName(taskName, locale, defaultLocale);
	}

	@Override
	public void setTaskNameCurrentLanguageId(java.lang.String languageId) {
		_tmTask.setTaskNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized task names of this t m task from the map of locales and localized task names.
	*
	* @param taskNameMap the locales and localized task names of this t m task
	*/
	@Override
	public void setTaskNameMap(
		java.util.Map<java.util.Locale, java.lang.String> taskNameMap) {
		_tmTask.setTaskNameMap(taskNameMap);
	}

	/**
	* Sets the localized task names of this t m task from the map of locales and localized task names, and sets the default locale.
	*
	* @param taskNameMap the locales and localized task names of this t m task
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTaskNameMap(
		java.util.Map<java.util.Locale, java.lang.String> taskNameMap,
		java.util.Locale defaultLocale) {
		_tmTask.setTaskNameMap(taskNameMap, defaultLocale);
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
	public java.lang.String[] getAvailableLanguageIds() {
		return _tmTask.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _tmTask.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_tmTask.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_tmTask.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new TMTaskWrapper((TMTask)_tmTask.clone());
	}

	@Override
	public int compareTo(TMTask tmTask) {
		return _tmTask.compareTo(tmTask);
	}

	@Override
	public int hashCode() {
		return _tmTask.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<TMTask> toCacheModel() {
		return _tmTask.toCacheModel();
	}

	@Override
	public TMTask toEscapedModel() {
		return new TMTaskWrapper(_tmTask.toEscapedModel());
	}

	@Override
	public TMTask toUnescapedModel() {
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