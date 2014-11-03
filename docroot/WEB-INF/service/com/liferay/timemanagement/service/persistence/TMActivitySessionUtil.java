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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.timemanagement.model.TMActivitySession;

import java.util.List;

/**
 * The persistence utility for the t m activity session service. This utility wraps {@link TMActivitySessionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivitySessionPersistence
 * @see TMActivitySessionPersistenceImpl
 * @generated
 */
public class TMActivitySessionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TMActivitySession tmActivitySession) {
		getPersistence().clearCache(tmActivitySession);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TMActivitySession> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TMActivitySession> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TMActivitySession> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TMActivitySession update(TMActivitySession tmActivitySession)
		throws SystemException {
		return getPersistence().update(tmActivitySession);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TMActivitySession update(
		TMActivitySession tmActivitySession, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tmActivitySession, serviceContext);
	}

	/**
	* Returns all the t m activity sessions where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByactivityId(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByactivityId(activityId);
	}

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
	public static java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByactivityId(
		long activityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByactivityId(activityId, start, end);
	}

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
	public static java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByactivityId(
		long activityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByactivityId(activityId, start, end, orderByComparator);
	}

	/**
	* Returns the first t m activity session in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivitySession findByactivityId_First(
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException {
		return getPersistence()
				   .findByactivityId_First(activityId, orderByComparator);
	}

	/**
	* Returns the first t m activity session in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity session, or <code>null</code> if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivitySession fetchByactivityId_First(
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByactivityId_First(activityId, orderByComparator);
	}

	/**
	* Returns the last t m activity session in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivitySession findByactivityId_Last(
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException {
		return getPersistence()
				   .findByactivityId_Last(activityId, orderByComparator);
	}

	/**
	* Returns the last t m activity session in the ordered set where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity session, or <code>null</code> if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivitySession fetchByactivityId_Last(
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByactivityId_Last(activityId, orderByComparator);
	}

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
	public static com.liferay.timemanagement.model.TMActivitySession[] findByactivityId_PrevAndNext(
		long activitySessionId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException {
		return getPersistence()
				   .findByactivityId_PrevAndNext(activitySessionId, activityId,
			orderByComparator);
	}

	/**
	* Removes all the t m activity sessions where activityId = &#63; from the database.
	*
	* @param activityId the activity ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByactivityId(long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByactivityId(activityId);
	}

	/**
	* Returns the number of t m activity sessions where activityId = &#63;.
	*
	* @param activityId the activity ID
	* @return the number of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByactivityId(long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByactivityId(activityId);
	}

	/**
	* Returns all the t m activity sessions where userId = &#63; and activityId = &#63;.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @return the matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByU_T(
		long userId, long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_T(userId, activityId);
	}

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
	public static java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByU_T(
		long userId, long activityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_T(userId, activityId, start, end);
	}

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
	public static java.util.List<com.liferay.timemanagement.model.TMActivitySession> findByU_T(
		long userId, long activityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_T(userId, activityId, start, end, orderByComparator);
	}

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
	public static com.liferay.timemanagement.model.TMActivitySession findByU_T_First(
		long userId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException {
		return getPersistence()
				   .findByU_T_First(userId, activityId, orderByComparator);
	}

	/**
	* Returns the first t m activity session in the ordered set where userId = &#63; and activityId = &#63;.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity session, or <code>null</code> if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivitySession fetchByU_T_First(
		long userId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_T_First(userId, activityId, orderByComparator);
	}

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
	public static com.liferay.timemanagement.model.TMActivitySession findByU_T_Last(
		long userId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException {
		return getPersistence()
				   .findByU_T_Last(userId, activityId, orderByComparator);
	}

	/**
	* Returns the last t m activity session in the ordered set where userId = &#63; and activityId = &#63;.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity session, or <code>null</code> if a matching t m activity session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivitySession fetchByU_T_Last(
		long userId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_T_Last(userId, activityId, orderByComparator);
	}

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
	public static com.liferay.timemanagement.model.TMActivitySession[] findByU_T_PrevAndNext(
		long activitySessionId, long userId, long activityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException {
		return getPersistence()
				   .findByU_T_PrevAndNext(activitySessionId, userId,
			activityId, orderByComparator);
	}

	/**
	* Removes all the t m activity sessions where userId = &#63; and activityId = &#63; from the database.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_T(long userId, long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_T(userId, activityId);
	}

	/**
	* Returns the number of t m activity sessions where userId = &#63; and activityId = &#63;.
	*
	* @param userId the user ID
	* @param activityId the activity ID
	* @return the number of matching t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_T(long userId, long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_T(userId, activityId);
	}

	/**
	* Caches the t m activity session in the entity cache if it is enabled.
	*
	* @param tmActivitySession the t m activity session
	*/
	public static void cacheResult(
		com.liferay.timemanagement.model.TMActivitySession tmActivitySession) {
		getPersistence().cacheResult(tmActivitySession);
	}

	/**
	* Caches the t m activity sessions in the entity cache if it is enabled.
	*
	* @param tmActivitySessions the t m activity sessions
	*/
	public static void cacheResult(
		java.util.List<com.liferay.timemanagement.model.TMActivitySession> tmActivitySessions) {
		getPersistence().cacheResult(tmActivitySessions);
	}

	/**
	* Creates a new t m activity session with the primary key. Does not add the t m activity session to the database.
	*
	* @param activitySessionId the primary key for the new t m activity session
	* @return the new t m activity session
	*/
	public static com.liferay.timemanagement.model.TMActivitySession create(
		long activitySessionId) {
		return getPersistence().create(activitySessionId);
	}

	/**
	* Removes the t m activity session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activitySessionId the primary key of the t m activity session
	* @return the t m activity session that was removed
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivitySession remove(
		long activitySessionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException {
		return getPersistence().remove(activitySessionId);
	}

	public static com.liferay.timemanagement.model.TMActivitySession updateImpl(
		com.liferay.timemanagement.model.TMActivitySession tmActivitySession)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tmActivitySession);
	}

	/**
	* Returns the t m activity session with the primary key or throws a {@link com.liferay.timemanagement.NoSuchTMActivitySessionException} if it could not be found.
	*
	* @param activitySessionId the primary key of the t m activity session
	* @return the t m activity session
	* @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivitySession findByPrimaryKey(
		long activitySessionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivitySessionException {
		return getPersistence().findByPrimaryKey(activitySessionId);
	}

	/**
	* Returns the t m activity session with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activitySessionId the primary key of the t m activity session
	* @return the t m activity session, or <code>null</code> if a t m activity session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivitySession fetchByPrimaryKey(
		long activitySessionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(activitySessionId);
	}

	/**
	* Returns all the t m activity sessions.
	*
	* @return the t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timemanagement.model.TMActivitySession> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.timemanagement.model.TMActivitySession> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.timemanagement.model.TMActivitySession> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the t m activity sessions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of t m activity sessions.
	*
	* @return the number of t m activity sessions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TMActivitySessionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TMActivitySessionPersistence)PortletBeanLocatorUtil.locate(com.liferay.timemanagement.service.ClpSerializer.getServletContextName(),
					TMActivitySessionPersistence.class.getName());

			ReferenceRegistry.registerReference(TMActivitySessionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TMActivitySessionPersistence persistence) {
	}

	private static TMActivitySessionPersistence _persistence;
}