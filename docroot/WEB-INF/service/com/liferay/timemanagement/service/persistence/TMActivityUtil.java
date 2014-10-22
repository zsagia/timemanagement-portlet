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

import com.liferay.timemanagement.model.TMActivity;

import java.util.List;

/**
 * The persistence utility for the t m activity service. This utility wraps {@link TMActivityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivityPersistence
 * @see TMActivityPersistenceImpl
 * @generated
 */
public class TMActivityUtil {
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
	public static void clearCache(TMActivity tmActivity) {
		getPersistence().clearCache(tmActivity);
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
	public static List<TMActivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TMActivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TMActivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TMActivity update(TMActivity tmActivity)
		throws SystemException {
		return getPersistence().update(tmActivity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TMActivity update(TMActivity tmActivity,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tmActivity, serviceContext);
	}

	/**
	* Returns all the t m activities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching t m activities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timemanagement.model.TMActivity> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId);
	}

	/**
	* Returns a range of all the t m activities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t m activities
	* @param end the upper bound of the range of t m activities (not inclusive)
	* @return the range of matching t m activities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timemanagement.model.TMActivity> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t m activities where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t m activities
	* @param end the upper bound of the range of t m activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t m activities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timemanagement.model.TMActivity> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G(companyId, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first t m activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity
	* @throws com.liferay.timemanagement.NoSuchTMActivityException if a matching t m activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity findByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivityException {
		return getPersistence()
				   .findByC_G_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first t m activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t m activity, or <code>null</code> if a matching t m activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity fetchByC_G_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last t m activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity
	* @throws com.liferay.timemanagement.NoSuchTMActivityException if a matching t m activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity findByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivityException {
		return getPersistence()
				   .findByC_G_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last t m activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t m activity, or <code>null</code> if a matching t m activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity fetchByC_G_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the t m activities before and after the current t m activity in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param activityId the primary key of the current t m activity
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t m activity
	* @throws com.liferay.timemanagement.NoSuchTMActivityException if a t m activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity[] findByC_G_PrevAndNext(
		long activityId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivityException {
		return getPersistence()
				   .findByC_G_PrevAndNext(activityId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the t m activities where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G(companyId, groupId);
	}

	/**
	* Returns the number of t m activities where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching t m activities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G(companyId, groupId);
	}

	/**
	* Caches the t m activity in the entity cache if it is enabled.
	*
	* @param tmActivity the t m activity
	*/
	public static void cacheResult(
		com.liferay.timemanagement.model.TMActivity tmActivity) {
		getPersistence().cacheResult(tmActivity);
	}

	/**
	* Caches the t m activities in the entity cache if it is enabled.
	*
	* @param tmActivities the t m activities
	*/
	public static void cacheResult(
		java.util.List<com.liferay.timemanagement.model.TMActivity> tmActivities) {
		getPersistence().cacheResult(tmActivities);
	}

	/**
	* Creates a new t m activity with the primary key. Does not add the t m activity to the database.
	*
	* @param activityId the primary key for the new t m activity
	* @return the new t m activity
	*/
	public static com.liferay.timemanagement.model.TMActivity create(
		long activityId) {
		return getPersistence().create(activityId);
	}

	/**
	* Removes the t m activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityId the primary key of the t m activity
	* @return the t m activity that was removed
	* @throws com.liferay.timemanagement.NoSuchTMActivityException if a t m activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity remove(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivityException {
		return getPersistence().remove(activityId);
	}

	public static com.liferay.timemanagement.model.TMActivity updateImpl(
		com.liferay.timemanagement.model.TMActivity tmActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tmActivity);
	}

	/**
	* Returns the t m activity with the primary key or throws a {@link com.liferay.timemanagement.NoSuchTMActivityException} if it could not be found.
	*
	* @param activityId the primary key of the t m activity
	* @return the t m activity
	* @throws com.liferay.timemanagement.NoSuchTMActivityException if a t m activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity findByPrimaryKey(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timemanagement.NoSuchTMActivityException {
		return getPersistence().findByPrimaryKey(activityId);
	}

	/**
	* Returns the t m activity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activityId the primary key of the t m activity
	* @return the t m activity, or <code>null</code> if a t m activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity fetchByPrimaryKey(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(activityId);
	}

	/**
	* Returns all the t m activities.
	*
	* @return the t m activities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timemanagement.model.TMActivity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the t m activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t m activities
	* @param end the upper bound of the range of t m activities (not inclusive)
	* @return the range of t m activities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timemanagement.model.TMActivity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the t m activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t m activities
	* @param end the upper bound of the range of t m activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t m activities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timemanagement.model.TMActivity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the t m activities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of t m activities.
	*
	* @return the number of t m activities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TMActivityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TMActivityPersistence)PortletBeanLocatorUtil.locate(com.liferay.timemanagement.service.ClpSerializer.getServletContextName(),
					TMActivityPersistence.class.getName());

			ReferenceRegistry.registerReference(TMActivityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TMActivityPersistence persistence) {
	}

	private static TMActivityPersistence _persistence;
}