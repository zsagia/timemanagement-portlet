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

package com.liferay.timemanagement.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.timemanagement.model.TMTask;

/**
 * The persistence interface for the t m task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMTaskPersistenceImpl
 * @see TMTaskUtil
 * @generated
 */
public interface TMTaskPersistence extends BasePersistence<TMTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TMTaskUtil} to access the t m task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the t m tasks where companyId = &#63; and taskId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @return the matching t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMTask> findByC_T(
		long companyId, long taskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t m tasks where companyId = &#63; and taskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param start the lower bound of the range of t m tasks
	* @param end the upper bound of the range of t m tasks (not inclusive)
	* @return the range of matching t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMTask> findByC_T(
		long companyId, long taskId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t m tasks where companyId = &#63; and taskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param start the lower bound of the range of t m tasks
	* @param end the upper bound of the range of t m tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMTask> findByC_T(
		long companyId, long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t m task in the ordered set where companyId = &#63; and taskId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m task
	* @throws com.liferay.timemanagement.NoSuchTMTaskException if a matching t m task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask findByC_T_First(
		long companyId, long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMTaskException;

	/**
	* Returns the first t m task in the ordered set where companyId = &#63; and taskId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m task, or <code>null</code> if a matching t m task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask fetchByC_T_First(
		long companyId, long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t m task in the ordered set where companyId = &#63; and taskId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m task
	* @throws com.liferay.timemanagement.NoSuchTMTaskException if a matching t m task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask findByC_T_Last(
		long companyId, long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMTaskException;

	/**
	* Returns the last t m task in the ordered set where companyId = &#63; and taskId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m task, or <code>null</code> if a matching t m task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask fetchByC_T_Last(
		long companyId, long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t m tasks where companyId = &#63; and taskId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_T(long companyId, long taskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t m tasks where companyId = &#63; and taskId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @return the number of matching t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_T(long companyId, long taskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t m tasks where companyId = &#63; and taskId = &#63; and folderId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param folderId the folder ID
	* @return the matching t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMTask> findByC_T_F(
		long companyId, long taskId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t m tasks where companyId = &#63; and taskId = &#63; and folderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param folderId the folder ID
	* @param start the lower bound of the range of t m tasks
	* @param end the upper bound of the range of t m tasks (not inclusive)
	* @return the range of matching t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMTask> findByC_T_F(
		long companyId, long taskId, long folderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t m tasks where companyId = &#63; and taskId = &#63; and folderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param folderId the folder ID
	* @param start the lower bound of the range of t m tasks
	* @param end the upper bound of the range of t m tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMTask> findByC_T_F(
		long companyId, long taskId, long folderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t m task in the ordered set where companyId = &#63; and taskId = &#63; and folderId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param folderId the folder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m task
	* @throws com.liferay.timemanagement.NoSuchTMTaskException if a matching t m task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask findByC_T_F_First(
		long companyId, long taskId, long folderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMTaskException;

	/**
	* Returns the first t m task in the ordered set where companyId = &#63; and taskId = &#63; and folderId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param folderId the folder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m task, or <code>null</code> if a matching t m task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask fetchByC_T_F_First(
		long companyId, long taskId, long folderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t m task in the ordered set where companyId = &#63; and taskId = &#63; and folderId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param folderId the folder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m task
	* @throws com.liferay.timemanagement.NoSuchTMTaskException if a matching t m task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask findByC_T_F_Last(
		long companyId, long taskId, long folderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMTaskException;

	/**
	* Returns the last t m task in the ordered set where companyId = &#63; and taskId = &#63; and folderId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param folderId the folder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m task, or <code>null</code> if a matching t m task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask fetchByC_T_F_Last(
		long companyId, long taskId, long folderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t m tasks where companyId = &#63; and taskId = &#63; and folderId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param folderId the folder ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_T_F(long companyId, long taskId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t m tasks where companyId = &#63; and taskId = &#63; and folderId = &#63;.
	*
	* @param companyId the company ID
	* @param taskId the task ID
	* @param folderId the folder ID
	* @return the number of matching t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_T_F(long companyId, long taskId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the t m task in the entity cache if it is enabled.
	*
	* @param tmTask the t m task
	*/
	public void cacheResult(com.liferay.timemanagement.model.TMTask tmTask);

	/**
	* Caches the t m tasks in the entity cache if it is enabled.
	*
	* @param tmTasks the t m tasks
	*/
	public void cacheResult(
		java.util.List<com.liferay.timemanagement.model.TMTask> tmTasks);

	/**
	* Creates a new t m task with the primary key. Does not add the t m task to the database.
	*
	* @param taskId the primary key for the new t m task
	* @return the new t m task
	*/
	public com.liferay.timemanagement.model.TMTask create(long taskId);

	/**
	* Removes the t m task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the t m task
	* @return the t m task that was removed
	* @throws com.liferay.timemanagement.NoSuchTMTaskException if a t m task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask remove(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMTaskException;

	public com.liferay.timemanagement.model.TMTask updateImpl(
		com.liferay.timemanagement.model.TMTask tmTask)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t m task with the primary key or throws a {@link com.liferay.timemanagement.NoSuchTMTaskException} if it could not be found.
	*
	* @param taskId the primary key of the t m task
	* @return the t m task
	* @throws com.liferay.timemanagement.NoSuchTMTaskException if a t m task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask findByPrimaryKey(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMTaskException;

	/**
	* Returns the t m task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskId the primary key of the t m task
	* @return the t m task, or <code>null</code> if a t m task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMTask fetchByPrimaryKey(
		long taskId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t m tasks.
	*
	* @return the t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMTask> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timemanagement.model.TMTask> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t m tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t m tasks
	* @param end the upper bound of the range of t m tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t m tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t m tasks.
	*
	* @return the number of t m tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}