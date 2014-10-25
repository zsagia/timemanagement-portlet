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

package com.liferay.timemanagement.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TMActivitySessionLocalService}.
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivitySessionLocalService
 * @generated
 */
public class TMActivitySessionLocalServiceWrapper
	implements TMActivitySessionLocalService,
		ServiceWrapper<TMActivitySessionLocalService> {
	public TMActivitySessionLocalServiceWrapper(
		TMActivitySessionLocalService tmActivitySessionLocalService) {
		_tmActivitySessionLocalService = tmActivitySessionLocalService;
	}

	/**
	* Adds the t m activity session to the database. Also notifies the appropriate model listeners.
	*
	* @param tmActivitySession the t m activity session
	* @return the t m activity session that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivitySession addTMActivitySession(
		com.liferay.timemanagement.model.TMActivitySession tmActivitySession)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.addTMActivitySession(tmActivitySession);
	}

	/**
	* Creates a new t m activity session with the primary key. Does not add the t m activity session to the database.
	*
	* @param activitySessionId the primary key for the new t m activity session
	* @return the new t m activity session
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivitySession createTMActivitySession(
		long activitySessionId) {
		return _tmActivitySessionLocalService.createTMActivitySession(activitySessionId);
	}

	/**
	* Deletes the t m activity session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activitySessionId the primary key of the t m activity session
	* @return the t m activity session that was removed
	* @throws PortalException if a t m activity session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivitySession deleteTMActivitySession(
		long activitySessionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.deleteTMActivitySession(activitySessionId);
	}

	/**
	* Deletes the t m activity session from the database. Also notifies the appropriate model listeners.
	*
	* @param tmActivitySession the t m activity session
	* @return the t m activity session that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivitySession deleteTMActivitySession(
		com.liferay.timemanagement.model.TMActivitySession tmActivitySession)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.deleteTMActivitySession(tmActivitySession);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tmActivitySessionLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.timemanagement.model.TMActivitySession fetchTMActivitySession(
		long activitySessionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.fetchTMActivitySession(activitySessionId);
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
	public com.liferay.timemanagement.model.TMActivitySession getTMActivitySession(
		long activitySessionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.getTMActivitySession(activitySessionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> getTMActivitySessions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.getTMActivitySessions(start, end);
	}

	/**
	* Returns the number of t m activity sessions.
	*
	* @return the number of t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTMActivitySessionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.getTMActivitySessionsCount();
	}

	/**
	* Updates the t m activity session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tmActivitySession the t m activity session
	* @return the t m activity session that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivitySession updateTMActivitySession(
		com.liferay.timemanagement.model.TMActivitySession tmActivitySession)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.updateTMActivitySession(tmActivitySession);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tmActivitySessionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tmActivitySessionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tmActivitySessionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.timemanagement.model.TMActivitySession addActivitySession(
		long userId, java.util.Date startTime, java.util.Date endTime,
		long tmActivityId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.addActivitySession(userId,
			startTime, endTime, tmActivityId, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> getActivitySessionsByU_T(
		long userId, long tmActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.getActivitySessionsByU_T(userId,
			tmActivityId);
	}

	@Override
	public com.liferay.timemanagement.model.TMActivitySession updateTaskSession(
		com.liferay.timemanagement.model.TMActivitySession tmActivitySession)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivitySessionLocalService.updateTaskSession(tmActivitySession);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TMActivitySessionLocalService getWrappedTMActivitySessionLocalService() {
		return _tmActivitySessionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTMActivitySessionLocalService(
		TMActivitySessionLocalService tmActivitySessionLocalService) {
		_tmActivitySessionLocalService = tmActivitySessionLocalService;
	}

	@Override
	public TMActivitySessionLocalService getWrappedService() {
		return _tmActivitySessionLocalService;
	}

	@Override
	public void setWrappedService(
		TMActivitySessionLocalService tmActivitySessionLocalService) {
		_tmActivitySessionLocalService = tmActivitySessionLocalService;
	}

	private TMActivitySessionLocalService _tmActivitySessionLocalService;
}