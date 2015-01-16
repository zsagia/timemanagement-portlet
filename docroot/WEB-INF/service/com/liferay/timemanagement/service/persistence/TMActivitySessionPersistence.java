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

import com.liferay.timemanagement.model.TMActivitySession;

/**
 * The persistence interface for the t m activity session service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivitySessionPersistenceImpl
 * @see TMActivitySessionUtil
 * @generated
 */
public interface TMActivitySessionPersistence extends BasePersistence<TMActivitySession> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TMActivitySessionUtil} to access the t m activity session persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the t m activity sessions where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByactivityId(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t m activity sessions where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of t m activity sessions
	* @param end the upper bound of the range of t m activity sessions (not inclusive)
	* @return the range of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByactivityId(
		long activityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t m activity sessions where activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activityId the activity ID
	* @param start the lower bound of the range of t m activity sessions
	* @param end the upper bound of the range of t m activity sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByactivityId(
		long activityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t m activity session in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession findByactivityId_First(
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	/**
	* Returns the first t m activity session in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity session, or <code>null</code> if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession fetchByactivityId_First(
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t m activity session in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession findByactivityId_Last(
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	/**
	* Returns the last t m activity session in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity session, or <code>null</code> if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession fetchByactivityId_Last(
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t m activity sessions before and after the current t m activity session in the ordered set where activityId = &#63;.
	*
	* @param activitySessionId the primary key of the current t m activity session
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession[] findByactivityId_PrevAndNext(
		long activitySessionId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	/**
	* Removes all the t m activity sessions where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByactivityId(long activityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t m activity sessions where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public int countByactivityId(long activityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t m activity sessions where userId = &#63; and activityId = &#63;.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @return the matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByU_T(
		long userId, long activityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t m activity sessions where userId = &#63; and activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @param start the lower bound of the range of t m activity sessions
	* @param end the upper bound of the range of t m activity sessions (not inclusive)
	* @return the range of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByU_T(
		long userId, long activityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t m activity sessions where userId = &#63; and activityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @param start the lower bound of the range of t m activity sessions
	* @param end the upper bound of the range of t m activity sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByU_T(
		long userId, long activityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t m activity session in the ordered set where userId = &#63; and activityId = &#63;.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession findByU_T_First(
		long userId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	/**
	* Returns the first t m activity session in the ordered set where userId = &#63; and activityId = &#63;.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity session, or <code>null</code> if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession fetchByU_T_First(
		long userId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t m activity session in the ordered set where userId = &#63; and activityId = &#63;.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession findByU_T_Last(
		long userId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	/**
	* Returns the last t m activity session in the ordered set where userId = &#63; and activityId = &#63;.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity session, or <code>null</code> if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession fetchByU_T_Last(
		long userId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t m activity sessions before and after the current t m activity session in the ordered set where userId = &#63; and activityId = &#63;.
	*
	* @param activitySessionId the primary key of the current t m activity session
	* @param userId the user ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession[] findByU_T_PrevAndNext(
		long activitySessionId, long userId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	/**
	* Removes all the t m activity sessions where userId = &#63; and activityId = &#63; from the database.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_T(long userId, long activityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t m activity sessions where userId = &#63; and activityId = &#63;.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @return the number of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_T(long userId, long activityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t m activity sessions where companyId = &#63; and groupId = &#63; and userId = &#63; and startTime &gt; &#63; and endTime &lt; &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param startTime the start time
	* @param endTime the end time
	* @return the matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByC_G_U_I(
		long companyId, long groupId, long userId, java.util.Date startTime,
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t m activity sessions where companyId = &#63; and groupId = &#63; and userId = &#63; and startTime &gt; &#63; and endTime &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param startTime the start time
	* @param endTime the end time
	* @param start the lower bound of the range of t m activity sessions
	* @param end the upper bound of the range of t m activity sessions (not inclusive)
	* @return the range of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByC_G_U_I(
		long companyId, long groupId, long userId, java.util.Date startTime,
		java.util.Date endTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t m activity sessions where companyId = &#63; and groupId = &#63; and userId = &#63; and startTime &gt; &#63; and endTime &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param startTime the start time
	* @param endTime the end time
	* @param start the lower bound of the range of t m activity sessions
	* @param end the upper bound of the range of t m activity sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByC_G_U_I(
		long companyId, long groupId, long userId, java.util.Date startTime,
		java.util.Date endTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t m activity session in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and startTime &gt; &#63; and endTime &lt; &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param startTime the start time
	* @param endTime the end time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession findByC_G_U_I_First(
		long companyId, long groupId, long userId, java.util.Date startTime,
		java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	/**
	* Returns the first t m activity session in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and startTime &gt; &#63; and endTime &lt; &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param startTime the start time
	* @param endTime the end time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity session, or <code>null</code> if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession fetchByC_G_U_I_First(
		long companyId, long groupId, long userId, java.util.Date startTime,
		java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t m activity session in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and startTime &gt; &#63; and endTime &lt; &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param startTime the start time
	* @param endTime the end time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession findByC_G_U_I_Last(
		long companyId, long groupId, long userId, java.util.Date startTime,
		java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	/**
	* Returns the last t m activity session in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and startTime &gt; &#63; and endTime &lt; &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param startTime the start time
	* @param endTime the end time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity session, or <code>null</code> if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession fetchByC_G_U_I_Last(
		long companyId, long groupId, long userId, java.util.Date startTime,
		java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t m activity sessions before and after the current t m activity session in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and startTime &gt; &#63; and endTime &lt; &#63;.
	*
	* @param activitySessionId the primary key of the current t m activity session
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param startTime the start time
	* @param endTime the end time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession[] findByC_G_U_I_PrevAndNext(
		long activitySessionId, long companyId, long groupId, long userId,
		java.util.Date startTime, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	/**
	* Removes all the t m activity sessions where companyId = &#63; and groupId = &#63; and userId = &#63; and startTime &gt; &#63; and endTime &lt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param startTime the start time
	* @param endTime the end time
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_U_I(long companyId, long groupId, long userId,
		java.util.Date startTime, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t m activity sessions where companyId = &#63; and groupId = &#63; and userId = &#63; and startTime &gt; &#63; and endTime &lt; &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param startTime the start time
	* @param endTime the end time
	* @return the number of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_U_I(long companyId, long groupId, long userId,
		java.util.Date startTime, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the t m activity session in the entity cache if it is enabled.
	*
	* @param tmActivitySession the t m activity session
	*/
	public void cacheResult(
		com.liferay.timemanagement.model.TMActivitySession tmActivitySession);

	/**
	* Caches the t m activity sessions in the entity cache if it is enabled.
	*
	* @param tmActivitySessions the t m activity sessions
	*/
	public void cacheResult(
		java.util.List<com.liferay.timemanagement.model.TMActivitySession> tmActivitySessions);

	/**
	* Creates a new t m activity session with the primary key. Does not add the t m activity session to the database.
	*
	* @param activitySessionId the primary key for the new t m activity session
	* @return the new t m activity session
	*/
	public com.liferay.timemanagement.model.TMActivitySession create(
		long activitySessionId);

	/**
	* Removes the t m activity session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activitySessionId the primary key of the t m activity session
	* @return the t m activity session that was removed
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession remove(
		long activitySessionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	public com.liferay.timemanagement.model.TMActivitySession updateImpl(
		com.liferay.timemanagement.model.TMActivitySession tmActivitySession)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t m activity session with the primary key or throws a {@link com.liferay.timemanagement.NoSuchTMActivitySessionException} if it could not be found.
	*
	* @param activitySessionId the primary key of the t m activity session
	* @return the t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession findByPrimaryKey(
		long activitySessionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException;

	/**
	* Returns the t m activity session with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activitySessionId the primary key of the t m activity session
	* @return the t m activity session, or <code>null</code> if a t m activity session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timemanagement.model.TMActivitySession fetchByPrimaryKey(
		long activitySessionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t m activity sessions.
	*
	* @return the t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t m activity sessions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t m activity sessions
	* @param end the upper bound of the range of t m activity sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timemanagement.model.TMActivitySession> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t m activity sessions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t m activity sessions.
	*
	* @return the number of t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}