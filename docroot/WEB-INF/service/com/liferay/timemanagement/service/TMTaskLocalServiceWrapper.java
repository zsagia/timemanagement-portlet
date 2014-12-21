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
 * Provides a wrapper for {@link TMTaskLocalService}.
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMTaskLocalService
 * @generated
 */
public class TMTaskLocalServiceWrapper implements TMTaskLocalService,
	ServiceWrapper<TMTaskLocalService> {
	public TMTaskLocalServiceWrapper(TMTaskLocalService tmTaskLocalService) {
		_tmTaskLocalService = tmTaskLocalService;
	}

	/**
	* Adds the t m task to the database. Also notifies the appropriate model listeners.
	*
	* @param tmTask the t m task
	* @return the t m task that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMTask addTMTask(
		com.liferay.timemanagement.model.TMTask tmTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.addTMTask(tmTask);
	}

	/**
	* Creates a new t m task with the primary key. Does not add the t m task to the database.
	*
	* @param taskId the primary key for the new t m task
	* @return the new t m task
	*/
	@Override
	public com.liferay.timemanagement.model.TMTask createTMTask(long taskId) {
		return _tmTaskLocalService.createTMTask(taskId);
	}

	/**
	* Deletes the t m task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the t m task
	* @return the t m task that was removed
	* @throws PortalException if a t m task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMTask deleteTMTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.deleteTMTask(taskId);
	}

	/**
	* Deletes the t m task from the database. Also notifies the appropriate model listeners.
	*
	* @param tmTask the t m task
	* @return the t m task that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMTask deleteTMTask(
		com.liferay.timemanagement.model.TMTask tmTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.deleteTMTask(tmTask);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tmTaskLocalService.dynamicQuery();
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
		return _tmTaskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tmTaskLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tmTaskLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _tmTaskLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tmTaskLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.timemanagement.model.TMTask fetchTMTask(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.fetchTMTask(taskId);
	}

	/**
	* Returns the t m task with the primary key.
	*
	* @param taskId the primary key of the t m task
	* @return the t m task
	* @throws PortalException if a t m task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMTask getTMTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.getTMTask(taskId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the t m tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t m tasks
	* @param end the upper bound of the range of t m tasks (not inclusive)
	* @return the range of t m tasks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.timemanagement.model.TMTask> getTMTasks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.getTMTasks(start, end);
	}

	/**
	* Returns the number of t m tasks.
	*
	* @return the number of t m tasks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTMTasksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.getTMTasksCount();
	}

	/**
	* Updates the t m task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tmTask the t m task
	* @return the t m task that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMTask updateTMTask(
		com.liferay.timemanagement.model.TMTask tmTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.updateTMTask(tmTask);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tmTaskLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tmTaskLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tmTaskLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.timemanagement.model.TMTask getTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.getTask(taskId);
	}

	@Override
	public java.util.List<com.liferay.timemanagement.model.TMTask> getTaskByC_T(
		long companyId, long taskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.getTaskByC_T(companyId, taskId);
	}

	@Override
	public java.util.List<com.liferay.timemanagement.model.TMTask> getTaskByC_T_F(
		long companyId, long taskId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmTaskLocalService.getTaskByC_T_F(companyId, taskId, folderId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TMTaskLocalService getWrappedTMTaskLocalService() {
		return _tmTaskLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTMTaskLocalService(
		TMTaskLocalService tmTaskLocalService) {
		_tmTaskLocalService = tmTaskLocalService;
	}

	@Override
	public TMTaskLocalService getWrappedService() {
		return _tmTaskLocalService;
	}

	@Override
	public void setWrappedService(TMTaskLocalService tmTaskLocalService) {
		_tmTaskLocalService = tmTaskLocalService;
	}

	private TMTaskLocalService _tmTaskLocalService;
}