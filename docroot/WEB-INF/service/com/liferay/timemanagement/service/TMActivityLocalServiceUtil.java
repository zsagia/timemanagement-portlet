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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for TMActivity. This utility wraps
 * {@link com.liferay.timemanagement.service.impl.TMActivityLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivityLocalService
 * @see com.liferay.timemanagement.service.base.TMActivityLocalServiceBaseImpl
 * @see com.liferay.timemanagement.service.impl.TMActivityLocalServiceImpl
 * @generated
 */
public class TMActivityLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.timemanagement.service.impl.TMActivityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the t m activity to the database. Also notifies the appropriate model listeners.
	*
	* @param tmActivity the t m activity
	* @return the t m activity that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity addTMActivity(
		com.liferay.timemanagement.model.TMActivity tmActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTMActivity(tmActivity);
	}

	/**
	* Creates a new t m activity with the primary key. Does not add the t m activity to the database.
	*
	* @param activityId the primary key for the new t m activity
	* @return the new t m activity
	*/
	public static com.liferay.timemanagement.model.TMActivity createTMActivity(
		long activityId) {
		return getService().createTMActivity(activityId);
	}

	/**
	* Deletes the t m activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityId the primary key of the t m activity
	* @return the t m activity that was removed
	* @throws PortalException if a t m activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity deleteTMActivity(
		long activityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTMActivity(activityId);
	}

	/**
	* Deletes the t m activity from the database. Also notifies the appropriate model listeners.
	*
	* @param tmActivity the t m activity
	* @return the t m activity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity deleteTMActivity(
		com.liferay.timemanagement.model.TMActivity tmActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTMActivity(tmActivity);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.timemanagement.model.TMActivity fetchTMActivity(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTMActivity(activityId);
	}

	/**
	* Returns the t m activity with the primary key.
	*
	* @param activityId the primary key of the t m activity
	* @return the t m activity
	* @throws PortalException if a t m activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity getTMActivity(
		long activityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTMActivity(activityId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.timemanagement.model.TMActivity> getTMActivities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTMActivities(start, end);
	}

	/**
	* Returns the number of t m activities.
	*
	* @return the number of t m activities
	* @throws SystemException if a system exception occurred
	*/
	public static int getTMActivitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTMActivitiesCount();
	}

	/**
	* Updates the t m activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tmActivity the t m activity
	* @return the t m activity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timemanagement.model.TMActivity updateTMActivity(
		com.liferay.timemanagement.model.TMActivity tmActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTMActivity(tmActivity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.timemanagement.model.TMActivity addTMActivity(
		long companyId, long userId, java.lang.String activityName,
		long classNameId, long classPK, java.lang.String classUuid,
		java.lang.String description, java.util.Date endDate, int priority,
		java.util.Date reminderDate, java.util.Date scheduledDate,
		java.util.Date startDate, boolean visible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTMActivity(companyId, userId, activityName, classNameId,
			classPK, classUuid, description, endDate, priority, reminderDate,
			scheduledDate, startDate, visible, serviceContext);
	}

	public static void addTMActivityResources(
		com.liferay.timemanagement.model.TMActivity tmActivity,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTMActivityResources(tmActivity, addGroupPermissions,
			addGuestPermissions);
	}

	public static void addTMActivityResources(
		com.liferay.timemanagement.model.TMActivity tmActivity,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTMActivityResources(tmActivity, groupPermissions,
			guestPermissions);
	}

	public static int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByC_G(companyId, groupId);
	}

	public static java.util.List<com.liferay.timemanagement.model.TMActivity> getTMActivitiesByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTMActivitiesByC_G(companyId, groupId, start, end);
	}

	public static java.util.List<com.liferay.timemanagement.model.TMActivity> getTMActivitiesByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTMActivitiesByC_G(companyId, groupId, start, end,
			orderByComparator);
	}

	public static com.liferay.timemanagement.model.TMActivity updateTMActivity(
		long activityId, java.lang.String activityName, long classNameId,
		long classPK, java.lang.String classUuid, java.lang.String description,
		java.util.Date endDate, int priority, java.util.Date reminderDate,
		java.util.Date scheduledDate, java.util.Date startDate,
		boolean visible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTMActivity(activityId, activityName, classNameId,
			classPK, classUuid, description, endDate, priority, reminderDate,
			scheduledDate, startDate, visible, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TMActivityLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TMActivityLocalService.class.getName());

			if (invokableLocalService instanceof TMActivityLocalService) {
				_service = (TMActivityLocalService)invokableLocalService;
			}
			else {
				_service = new TMActivityLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TMActivityLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TMActivityLocalService service) {
	}

	private static TMActivityLocalService _service;
}