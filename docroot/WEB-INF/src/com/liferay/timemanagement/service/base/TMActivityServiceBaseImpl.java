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

package com.liferay.timemanagement.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.timemanagement.model.TMActivity;
import com.liferay.timemanagement.service.TMActivityService;
import com.liferay.timemanagement.service.persistence.TMActivityPersistence;
import com.liferay.timemanagement.service.persistence.TMActivitySessionPersistence;
import com.liferay.timemanagement.service.persistence.TMTaskPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the t m activity remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.timemanagement.service.impl.TMActivityServiceImpl}.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see com.liferay.timemanagement.service.impl.TMActivityServiceImpl
 * @see com.liferay.timemanagement.service.TMActivityServiceUtil
 * @generated
 */
public abstract class TMActivityServiceBaseImpl extends BaseServiceImpl
	implements TMActivityService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.timemanagement.service.TMActivityServiceUtil} to access the t m activity remote service.
	 */

	/**
	 * Returns the t m activity local service.
	 *
	 * @return the t m activity local service
	 */
	public com.liferay.timemanagement.service.TMActivityLocalService getTMActivityLocalService() {
		return tmActivityLocalService;
	}

	/**
	 * Sets the t m activity local service.
	 *
	 * @param tmActivityLocalService the t m activity local service
	 */
	public void setTMActivityLocalService(
		com.liferay.timemanagement.service.TMActivityLocalService tmActivityLocalService) {
		this.tmActivityLocalService = tmActivityLocalService;
	}

	/**
	 * Returns the t m activity remote service.
	 *
	 * @return the t m activity remote service
	 */
	public com.liferay.timemanagement.service.TMActivityService getTMActivityService() {
		return tmActivityService;
	}

	/**
	 * Sets the t m activity remote service.
	 *
	 * @param tmActivityService the t m activity remote service
	 */
	public void setTMActivityService(
		com.liferay.timemanagement.service.TMActivityService tmActivityService) {
		this.tmActivityService = tmActivityService;
	}

	/**
	 * Returns the t m activity persistence.
	 *
	 * @return the t m activity persistence
	 */
	public TMActivityPersistence getTMActivityPersistence() {
		return tmActivityPersistence;
	}

	/**
	 * Sets the t m activity persistence.
	 *
	 * @param tmActivityPersistence the t m activity persistence
	 */
	public void setTMActivityPersistence(
		TMActivityPersistence tmActivityPersistence) {
		this.tmActivityPersistence = tmActivityPersistence;
	}

	/**
	 * Returns the t m activity session local service.
	 *
	 * @return the t m activity session local service
	 */
	public com.liferay.timemanagement.service.TMActivitySessionLocalService getTMActivitySessionLocalService() {
		return tmActivitySessionLocalService;
	}

	/**
	 * Sets the t m activity session local service.
	 *
	 * @param tmActivitySessionLocalService the t m activity session local service
	 */
	public void setTMActivitySessionLocalService(
		com.liferay.timemanagement.service.TMActivitySessionLocalService tmActivitySessionLocalService) {
		this.tmActivitySessionLocalService = tmActivitySessionLocalService;
	}

	/**
	 * Returns the t m activity session persistence.
	 *
	 * @return the t m activity session persistence
	 */
	public TMActivitySessionPersistence getTMActivitySessionPersistence() {
		return tmActivitySessionPersistence;
	}

	/**
	 * Sets the t m activity session persistence.
	 *
	 * @param tmActivitySessionPersistence the t m activity session persistence
	 */
	public void setTMActivitySessionPersistence(
		TMActivitySessionPersistence tmActivitySessionPersistence) {
		this.tmActivitySessionPersistence = tmActivitySessionPersistence;
	}

	/**
	 * Returns the t m task local service.
	 *
	 * @return the t m task local service
	 */
	public com.liferay.timemanagement.service.TMTaskLocalService getTMTaskLocalService() {
		return tmTaskLocalService;
	}

	/**
	 * Sets the t m task local service.
	 *
	 * @param tmTaskLocalService the t m task local service
	 */
	public void setTMTaskLocalService(
		com.liferay.timemanagement.service.TMTaskLocalService tmTaskLocalService) {
		this.tmTaskLocalService = tmTaskLocalService;
	}

	/**
	 * Returns the t m task persistence.
	 *
	 * @return the t m task persistence
	 */
	public TMTaskPersistence getTMTaskPersistence() {
		return tmTaskPersistence;
	}

	/**
	 * Sets the t m task persistence.
	 *
	 * @param tmTaskPersistence the t m task persistence
	 */
	public void setTMTaskPersistence(TMTaskPersistence tmTaskPersistence) {
		this.tmTaskPersistence = tmTaskPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TMActivity.class;
	}

	protected String getModelClassName() {
		return TMActivity.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tmActivityPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.timemanagement.service.TMActivityLocalService.class)
	protected com.liferay.timemanagement.service.TMActivityLocalService tmActivityLocalService;
	@BeanReference(type = com.liferay.timemanagement.service.TMActivityService.class)
	protected com.liferay.timemanagement.service.TMActivityService tmActivityService;
	@BeanReference(type = TMActivityPersistence.class)
	protected TMActivityPersistence tmActivityPersistence;
	@BeanReference(type = com.liferay.timemanagement.service.TMActivitySessionLocalService.class)
	protected com.liferay.timemanagement.service.TMActivitySessionLocalService tmActivitySessionLocalService;
	@BeanReference(type = TMActivitySessionPersistence.class)
	protected TMActivitySessionPersistence tmActivitySessionPersistence;
	@BeanReference(type = com.liferay.timemanagement.service.TMTaskLocalService.class)
	protected com.liferay.timemanagement.service.TMTaskLocalService tmTaskLocalService;
	@BeanReference(type = TMTaskPersistence.class)
	protected TMTaskPersistence tmTaskPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TMActivityServiceClpInvoker _clpInvoker = new TMActivityServiceClpInvoker();
}