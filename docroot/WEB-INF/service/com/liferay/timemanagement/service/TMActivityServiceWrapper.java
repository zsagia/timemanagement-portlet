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
 * Provides a wrapper for {@link TMActivityService}.
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivityService
 * @generated
 */
public class TMActivityServiceWrapper implements TMActivityService,
	ServiceWrapper<TMActivityService> {
	public TMActivityServiceWrapper(TMActivityService tmActivityService) {
		_tmActivityService = tmActivityService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tmActivityService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tmActivityService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tmActivityService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TMActivityService getWrappedTMActivityService() {
		return _tmActivityService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTMActivityService(TMActivityService tmActivityService) {
		_tmActivityService = tmActivityService;
	}

	@Override
	public TMActivityService getWrappedService() {
		return _tmActivityService;
	}

	@Override
	public void setWrappedService(TMActivityService tmActivityService) {
		_tmActivityService = tmActivityService;
	}

	private TMActivityService _tmActivityService;
}