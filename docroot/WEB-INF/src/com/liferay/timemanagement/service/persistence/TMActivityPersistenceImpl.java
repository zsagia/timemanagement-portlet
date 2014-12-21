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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.timemanagement.NoSuchTMActivityException;
import com.liferay.timemanagement.model.TMActivity;
import com.liferay.timemanagement.model.impl.TMActivityImpl;
import com.liferay.timemanagement.model.impl.TMActivityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the t m activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivityPersistence
 * @see TMActivityUtil
 * @generated
 */
public class TMActivityPersistenceImpl extends BasePersistenceImpl<TMActivity>
	implements TMActivityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TMActivityUtil} to access the t m activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TMActivityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
			TMActivityModelImpl.FINDER_CACHE_ENABLED, TMActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
			TMActivityModelImpl.FINDER_CACHE_ENABLED, TMActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
			TMActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
			TMActivityModelImpl.FINDER_CACHE_ENABLED, TMActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
			TMActivityModelImpl.FINDER_CACHE_ENABLED, TMActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			TMActivityModelImpl.COMPANYID_COLUMN_BITMASK |
			TMActivityModelImpl.GROUPID_COLUMN_BITMASK |
			TMActivityModelImpl.ACTIVITYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
			TMActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the t m activities where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching t m activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMActivity> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TMActivity> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
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
	@Override
	public List<TMActivity> findByC_G(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<TMActivity> list = (List<TMActivity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TMActivity tmActivity : list) {
				if ((companyId != tmActivity.getCompanyId()) ||
						(groupId != tmActivity.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TMACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TMActivityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<TMActivity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TMActivity>(list);
				}
				else {
					list = (List<TMActivity>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TMActivity findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTMActivityException, SystemException {
		TMActivity tmActivity = fetchByC_G_First(companyId, groupId,
				orderByComparator);

		if (tmActivity != null) {
			return tmActivity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTMActivityException(msg.toString());
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
	@Override
	public TMActivity fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TMActivity> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TMActivity findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTMActivityException, SystemException {
		TMActivity tmActivity = fetchByC_G_Last(companyId, groupId,
				orderByComparator);

		if (tmActivity != null) {
			return tmActivity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTMActivityException(msg.toString());
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
	@Override
	public TMActivity fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<TMActivity> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TMActivity[] findByC_G_PrevAndNext(long activityId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTMActivityException, SystemException {
		TMActivity tmActivity = findByPrimaryKey(activityId);

		Session session = null;

		try {
			session = openSession();

			TMActivity[] array = new TMActivityImpl[3];

			array[0] = getByC_G_PrevAndNext(session, tmActivity, companyId,
					groupId, orderByComparator, true);

			array[1] = tmActivity;

			array[2] = getByC_G_PrevAndNext(session, tmActivity, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TMActivity getByC_G_PrevAndNext(Session session,
		TMActivity tmActivity, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TMACTIVITY_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TMActivityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tmActivity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TMActivity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t m activities that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching t m activities that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMActivity> filterFindByC_G(long companyId, long groupId)
		throws SystemException {
		return filterFindByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t m activities that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t m activities
	 * @param end the upper bound of the range of t m activities (not inclusive)
	 * @return the range of matching t m activities that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMActivity> filterFindByC_G(long companyId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t m activities that the user has permissions to view where companyId = &#63; and groupId = &#63;.
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
	 * @return the ordered range of matching t m activities that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMActivity> filterFindByC_G(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G(companyId, groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TMACTIVITY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TMACTIVITY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TMACTIVITY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TMActivityModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TMActivityModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TMActivity.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TMActivityImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TMActivityImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<TMActivity>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t m activities before and after the current t m activity in the ordered set of t m activities that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param activityId the primary key of the current t m activity
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t m activity
	 * @throws com.liferay.timemanagement.NoSuchTMActivityException if a t m activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivity[] filterFindByC_G_PrevAndNext(long activityId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTMActivityException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_PrevAndNext(activityId, companyId, groupId,
				orderByComparator);
		}

		TMActivity tmActivity = findByPrimaryKey(activityId);

		Session session = null;

		try {
			session = openSession();

			TMActivity[] array = new TMActivityImpl[3];

			array[0] = filterGetByC_G_PrevAndNext(session, tmActivity,
					companyId, groupId, orderByComparator, true);

			array[1] = tmActivity;

			array[2] = filterGetByC_G_PrevAndNext(session, tmActivity,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TMActivity filterGetByC_G_PrevAndNext(Session session,
		TMActivity tmActivity, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TMACTIVITY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TMACTIVITY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TMACTIVITY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TMActivityModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TMActivityModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TMActivity.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TMActivityImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TMActivityImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tmActivity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TMActivity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the t m activities where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (TMActivity tmActivity : findByC_G(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tmActivity);
		}
	}

	/**
	 * Returns the number of t m activities where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching t m activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TMACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t m activities that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching t m activities that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByC_G(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TMACTIVITY_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TMActivity.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "tmActivity.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "tmActivity.groupId = ?";

	public TMActivityPersistenceImpl() {
		setModelClass(TMActivity.class);
	}

	/**
	 * Caches the t m activity in the entity cache if it is enabled.
	 *
	 * @param tmActivity the t m activity
	 */
	@Override
	public void cacheResult(TMActivity tmActivity) {
		EntityCacheUtil.putResult(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
			TMActivityImpl.class, tmActivity.getPrimaryKey(), tmActivity);

		tmActivity.resetOriginalValues();
	}

	/**
	 * Caches the t m activities in the entity cache if it is enabled.
	 *
	 * @param tmActivities the t m activities
	 */
	@Override
	public void cacheResult(List<TMActivity> tmActivities) {
		for (TMActivity tmActivity : tmActivities) {
			if (EntityCacheUtil.getResult(
						TMActivityModelImpl.ENTITY_CACHE_ENABLED,
						TMActivityImpl.class, tmActivity.getPrimaryKey()) == null) {
				cacheResult(tmActivity);
			}
			else {
				tmActivity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t m activities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TMActivityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TMActivityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t m activity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TMActivity tmActivity) {
		EntityCacheUtil.removeResult(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
			TMActivityImpl.class, tmActivity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TMActivity> tmActivities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TMActivity tmActivity : tmActivities) {
			EntityCacheUtil.removeResult(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
				TMActivityImpl.class, tmActivity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new t m activity with the primary key. Does not add the t m activity to the database.
	 *
	 * @param activityId the primary key for the new t m activity
	 * @return the new t m activity
	 */
	@Override
	public TMActivity create(long activityId) {
		TMActivity tmActivity = new TMActivityImpl();

		tmActivity.setNew(true);
		tmActivity.setPrimaryKey(activityId);

		return tmActivity;
	}

	/**
	 * Removes the t m activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityId the primary key of the t m activity
	 * @return the t m activity that was removed
	 * @throws com.liferay.timemanagement.NoSuchTMActivityException if a t m activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivity remove(long activityId)
		throws NoSuchTMActivityException, SystemException {
		return remove((Serializable)activityId);
	}

	/**
	 * Removes the t m activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t m activity
	 * @return the t m activity that was removed
	 * @throws com.liferay.timemanagement.NoSuchTMActivityException if a t m activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivity remove(Serializable primaryKey)
		throws NoSuchTMActivityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TMActivity tmActivity = (TMActivity)session.get(TMActivityImpl.class,
					primaryKey);

			if (tmActivity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTMActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tmActivity);
		}
		catch (NoSuchTMActivityException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TMActivity removeImpl(TMActivity tmActivity)
		throws SystemException {
		tmActivity = toUnwrappedModel(tmActivity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tmActivity)) {
				tmActivity = (TMActivity)session.get(TMActivityImpl.class,
						tmActivity.getPrimaryKeyObj());
			}

			if (tmActivity != null) {
				session.delete(tmActivity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tmActivity != null) {
			clearCache(tmActivity);
		}

		return tmActivity;
	}

	@Override
	public TMActivity updateImpl(
		com.liferay.timemanagement.model.TMActivity tmActivity)
		throws SystemException {
		tmActivity = toUnwrappedModel(tmActivity);

		boolean isNew = tmActivity.isNew();

		TMActivityModelImpl tmActivityModelImpl = (TMActivityModelImpl)tmActivity;

		Session session = null;

		try {
			session = openSession();

			if (tmActivity.isNew()) {
				session.save(tmActivity);

				tmActivity.setNew(false);
			}
			else {
				session.merge(tmActivity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TMActivityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tmActivityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tmActivityModelImpl.getOriginalCompanyId(),
						tmActivityModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						tmActivityModelImpl.getCompanyId(),
						tmActivityModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}
		}

		EntityCacheUtil.putResult(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
			TMActivityImpl.class, tmActivity.getPrimaryKey(), tmActivity);

		return tmActivity;
	}

	protected TMActivity toUnwrappedModel(TMActivity tmActivity) {
		if (tmActivity instanceof TMActivityImpl) {
			return tmActivity;
		}

		TMActivityImpl tmActivityImpl = new TMActivityImpl();

		tmActivityImpl.setNew(tmActivity.isNew());
		tmActivityImpl.setPrimaryKey(tmActivity.getPrimaryKey());

		tmActivityImpl.setActivityId(tmActivity.getActivityId());
		tmActivityImpl.setGroupId(tmActivity.getGroupId());
		tmActivityImpl.setCompanyId(tmActivity.getCompanyId());
		tmActivityImpl.setUserId(tmActivity.getUserId());
		tmActivityImpl.setUserName(tmActivity.getUserName());
		tmActivityImpl.setCreateDate(tmActivity.getCreateDate());
		tmActivityImpl.setModifiedDate(tmActivity.getModifiedDate());
		tmActivityImpl.setActivityName(tmActivity.getActivityName());
		tmActivityImpl.setClassNameId(tmActivity.getClassNameId());
		tmActivityImpl.setClassPK(tmActivity.getClassPK());
		tmActivityImpl.setClassUuid(tmActivity.getClassUuid());
		tmActivityImpl.setDescription(tmActivity.getDescription());
		tmActivityImpl.setEndDate(tmActivity.getEndDate());
		tmActivityImpl.setPriority(tmActivity.getPriority());
		tmActivityImpl.setReminderDate(tmActivity.getReminderDate());
		tmActivityImpl.setScheduledDate(tmActivity.getScheduledDate());
		tmActivityImpl.setStartDate(tmActivity.getStartDate());
		tmActivityImpl.setVisible(tmActivity.isVisible());

		return tmActivityImpl;
	}

	/**
	 * Returns the t m activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t m activity
	 * @return the t m activity
	 * @throws com.liferay.timemanagement.NoSuchTMActivityException if a t m activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTMActivityException, SystemException {
		TMActivity tmActivity = fetchByPrimaryKey(primaryKey);

		if (tmActivity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTMActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tmActivity;
	}

	/**
	 * Returns the t m activity with the primary key or throws a {@link com.liferay.timemanagement.NoSuchTMActivityException} if it could not be found.
	 *
	 * @param activityId the primary key of the t m activity
	 * @return the t m activity
	 * @throws com.liferay.timemanagement.NoSuchTMActivityException if a t m activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivity findByPrimaryKey(long activityId)
		throws NoSuchTMActivityException, SystemException {
		return findByPrimaryKey((Serializable)activityId);
	}

	/**
	 * Returns the t m activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t m activity
	 * @return the t m activity, or <code>null</code> if a t m activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TMActivity tmActivity = (TMActivity)EntityCacheUtil.getResult(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
				TMActivityImpl.class, primaryKey);

		if (tmActivity == _nullTMActivity) {
			return null;
		}

		if (tmActivity == null) {
			Session session = null;

			try {
				session = openSession();

				tmActivity = (TMActivity)session.get(TMActivityImpl.class,
						primaryKey);

				if (tmActivity != null) {
					cacheResult(tmActivity);
				}
				else {
					EntityCacheUtil.putResult(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
						TMActivityImpl.class, primaryKey, _nullTMActivity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TMActivityModelImpl.ENTITY_CACHE_ENABLED,
					TMActivityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tmActivity;
	}

	/**
	 * Returns the t m activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityId the primary key of the t m activity
	 * @return the t m activity, or <code>null</code> if a t m activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivity fetchByPrimaryKey(long activityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)activityId);
	}

	/**
	 * Returns all the t m activities.
	 *
	 * @return the t m activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMActivity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TMActivity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<TMActivity> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TMActivity> list = (List<TMActivity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TMACTIVITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TMACTIVITY;

				if (pagination) {
					sql = sql.concat(TMActivityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TMActivity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TMActivity>(list);
				}
				else {
					list = (List<TMActivity>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the t m activities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TMActivity tmActivity : findAll()) {
			remove(tmActivity);
		}
	}

	/**
	 * Returns the number of t m activities.
	 *
	 * @return the number of t m activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TMACTIVITY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the t m activity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timemanagement.model.TMActivity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TMActivity>> listenersList = new ArrayList<ModelListener<TMActivity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TMActivity>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TMActivityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TMACTIVITY = "SELECT tmActivity FROM TMActivity tmActivity";
	private static final String _SQL_SELECT_TMACTIVITY_WHERE = "SELECT tmActivity FROM TMActivity tmActivity WHERE ";
	private static final String _SQL_COUNT_TMACTIVITY = "SELECT COUNT(tmActivity) FROM TMActivity tmActivity";
	private static final String _SQL_COUNT_TMACTIVITY_WHERE = "SELECT COUNT(tmActivity) FROM TMActivity tmActivity WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "tmActivity.activityId";
	private static final String _FILTER_SQL_SELECT_TMACTIVITY_WHERE = "SELECT DISTINCT {tmActivity.*} FROM timemanagement_TMActivity tmActivity WHERE ";
	private static final String _FILTER_SQL_SELECT_TMACTIVITY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {timemanagement_TMActivity.*} FROM (SELECT DISTINCT tmActivity.activityId FROM timemanagement_TMActivity tmActivity WHERE ";
	private static final String _FILTER_SQL_SELECT_TMACTIVITY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN timemanagement_TMActivity ON TEMP_TABLE.activityId = timemanagement_TMActivity.activityId";
	private static final String _FILTER_SQL_COUNT_TMACTIVITY_WHERE = "SELECT COUNT(DISTINCT tmActivity.activityId) AS COUNT_VALUE FROM timemanagement_TMActivity tmActivity WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "tmActivity";
	private static final String _FILTER_ENTITY_TABLE = "timemanagement_TMActivity";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tmActivity.";
	private static final String _ORDER_BY_ENTITY_TABLE = "timemanagement_TMActivity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TMActivity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TMActivity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TMActivityPersistenceImpl.class);
	private static TMActivity _nullTMActivity = new TMActivityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TMActivity> toCacheModel() {
				return _nullTMActivityCacheModel;
			}
		};

	private static CacheModel<TMActivity> _nullTMActivityCacheModel = new CacheModel<TMActivity>() {
			@Override
			public TMActivity toEntityModel() {
				return _nullTMActivity;
			}
		};
}