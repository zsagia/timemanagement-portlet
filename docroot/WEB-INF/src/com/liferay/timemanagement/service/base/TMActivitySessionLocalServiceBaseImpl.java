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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.timemanagement.model.TMActivitySession;
import com.liferay.timemanagement.service.TMActivitySessionLocalService;
import com.liferay.timemanagement.service.persistence.TMActivityPersistence;
import com.liferay.timemanagement.service.persistence.TMActivitySessionPersistence;
import com.liferay.timemanagement.service.persistence.TMTaskPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the t m activity session local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.timemanagement.service.impl.TMActivitySessionLocalServiceImpl}.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see com.liferay.timemanagement.service.impl.TMActivitySessionLocalServiceImpl
 * @see com.liferay.timemanagement.service.TMActivitySessionLocalServiceUtil
 * @generated
 */
public abstract class TMActivitySessionLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements TMActivitySessionLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.timemanagement.service.TMActivitySessionLocalServiceUtil} to access the t m activity session local service.
	 */

	/**
	 * Adds the t m activity session to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tmActivitySession the t m activity session
	 * @return the t m activity session that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TMActivitySession addTMActivitySession(
		TMActivitySession tmActivitySession) throws SystemException {
		tmActivitySession.setNew(true);

		return tmActivitySessionPersistence.update(tmActivitySession);
	}

	/**
	 * Creates a new t m activity session with the primary key. Does not add the t m activity session to the database.
	 *
	 * @param activitySessionId the primary key for the new t m activity session
	 * @return the new t m activity session
	 */
	@Override
	public TMActivitySession createTMActivitySession(long activitySessionId) {
		return tmActivitySessionPersistence.create(activitySessionId);
	}

	/**
	 * Deletes the t m activity session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activitySessionId the primary key of the t m activity session
	 * @return the t m activity session that was removed
	 * @throws PortalException if a t m activity session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TMActivitySession deleteTMActivitySession(long activitySessionId)
		throws PortalException, SystemException {
		return tmActivitySessionPersistence.remove(activitySessionId);
	}

	/**
	 * Deletes the t m activity session from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tmActivitySession the t m activity session
	 * @return the t m activity session that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TMActivitySession deleteTMActivitySession(
		TMActivitySession tmActivitySession) throws SystemException {
		return tmActivitySessionPersistence.remove(tmActivitySession);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TMActivitySession.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return tmActivitySessionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return tmActivitySessionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return tmActivitySessionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return tmActivitySessionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return tmActivitySessionPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public TMActivitySession fetchTMActivitySession(long activitySessionId)
		throws SystemException {
		return tmActivitySessionPersistence.fetchByPrimaryKey(activitySessionId);
	}

	/**
	 * Returns the t m activity session with the primary key.
	 *
	 * @param activitySessionId the primary key of the t m activity session
	 * @return the t m activity session
	 * @throws PortalException if a t m activity session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivitySession getTMActivitySession(long activitySessionId)
		throws PortalException, SystemException {
		return tmActivitySessionPersistence.findByPrimaryKey(activitySessionId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return tmActivitySessionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the t m activity sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of t m activity sessions
	 * @param end the upper bound of the range of t m activity sessions (not inclusive)
	 * @return the range of t m activity sessions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMActivitySession> getTMActivitySessions(int start, int end)
		throws SystemException {
		return tmActivitySessionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of t m activity sessions.
	 *
	 * @return the number of t m activity sessions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getTMActivitySessionsCount() throws SystemException {
		return tmActivitySessionPersistence.countAll();
	}

	/**
	 * Updates the t m activity session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tmActivitySession the t m activity session
	 * @return the t m activity session that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TMActivitySession updateTMActivitySession(
		TMActivitySession tmActivitySession) throws SystemException {
		return tmActivitySessionPersistence.update(tmActivitySession);
	}

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

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.timemanagement.model.TMActivitySession",
			tmActivitySessionLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.timemanagement.model.TMActivitySession");
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
		return TMActivitySession.class;
	}

	protected String getModelClassName() {
		return TMActivitySession.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tmActivitySessionPersistence.getDataSource();

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
	private TMActivitySessionLocalServiceClpInvoker _clpInvoker = new TMActivitySessionLocalServiceClpInvoker();
}