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
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.timemanagement.NoSuchTMActivitySessionException;
import com.liferay.timemanagement.model.TMActivitySession;
import com.liferay.timemanagement.model.impl.TMActivitySessionImpl;
import com.liferay.timemanagement.model.impl.TMActivitySessionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the t m activity session service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivitySessionPersistence
 * @see TMActivitySessionUtil
 * @generated
 */
public class TMActivitySessionPersistenceImpl extends BasePersistenceImpl<TMActivitySession>
	implements TMActivitySessionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TMActivitySessionUtil} to access the t m activity session persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TMActivitySessionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
			TMActivitySessionModelImpl.FINDER_CACHE_ENABLED,
			TMActivitySessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
			TMActivitySessionModelImpl.FINDER_CACHE_ENABLED,
			TMActivitySessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
			TMActivitySessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_T = new FinderPath(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
			TMActivitySessionModelImpl.FINDER_CACHE_ENABLED,
			TMActivitySessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T = new FinderPath(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
			TMActivitySessionModelImpl.FINDER_CACHE_ENABLED,
			TMActivitySessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_T",
			new String[] { Long.class.getName(), Long.class.getName() },
			TMActivitySessionModelImpl.USERID_COLUMN_BITMASK |
			TMActivitySessionModelImpl.ACTIVITYID_COLUMN_BITMASK |
			TMActivitySessionModelImpl.STARTTIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_T = new FinderPath(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
			TMActivitySessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_T",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the t m activity sessions where userId = &#63; and activityId = &#63;.
	 *
	 * @param userId the user ID
	 * @param activityId the activity ID
	 * @return the matching t m activity sessions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMActivitySession> findByU_T(long userId, long activityId)
		throws SystemException {
		return findByU_T(userId, activityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TMActivitySession> findByU_T(long userId, long activityId,
		int start, int end) throws SystemException {
		return findByU_T(userId, activityId, start, end, null);
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
	@Override
	public List<TMActivitySession> findByU_T(long userId, long activityId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T;
			finderArgs = new Object[] { userId, activityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_T;
			finderArgs = new Object[] {
					userId, activityId,
					
					start, end, orderByComparator
				};
		}

		List<TMActivitySession> list = (List<TMActivitySession>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TMActivitySession tmActivitySession : list) {
				if ((userId != tmActivitySession.getUserId()) ||
						(activityId != tmActivitySession.getActivityId())) {
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

			query.append(_SQL_SELECT_TMACTIVITYSESSION_WHERE);

			query.append(_FINDER_COLUMN_U_T_USERID_2);

			query.append(_FINDER_COLUMN_U_T_ACTIVITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TMActivitySessionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(activityId);

				if (!pagination) {
					list = (List<TMActivitySession>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TMActivitySession>(list);
				}
				else {
					list = (List<TMActivitySession>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first t m activity session in the ordered set where userId = &#63; and activityId = &#63;.
	 *
	 * @param userId the user ID
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t m activity session
	 * @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a matching t m activity session could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivitySession findByU_T_First(long userId, long activityId,
		OrderByComparator orderByComparator)
		throws NoSuchTMActivitySessionException, SystemException {
		TMActivitySession tmActivitySession = fetchByU_T_First(userId,
				activityId, orderByComparator);

		if (tmActivitySession != null) {
			return tmActivitySession;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", activityId=");
		msg.append(activityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTMActivitySessionException(msg.toString());
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
	@Override
	public TMActivitySession fetchByU_T_First(long userId, long activityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TMActivitySession> list = findByU_T(userId, activityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TMActivitySession findByU_T_Last(long userId, long activityId,
		OrderByComparator orderByComparator)
		throws NoSuchTMActivitySessionException, SystemException {
		TMActivitySession tmActivitySession = fetchByU_T_Last(userId,
				activityId, orderByComparator);

		if (tmActivitySession != null) {
			return tmActivitySession;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", activityId=");
		msg.append(activityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTMActivitySessionException(msg.toString());
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
	@Override
	public TMActivitySession fetchByU_T_Last(long userId, long activityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByU_T(userId, activityId);

		if (count == 0) {
			return null;
		}

		List<TMActivitySession> list = findByU_T(userId, activityId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TMActivitySession[] findByU_T_PrevAndNext(long activitySessionId,
		long userId, long activityId, OrderByComparator orderByComparator)
		throws NoSuchTMActivitySessionException, SystemException {
		TMActivitySession tmActivitySession = findByPrimaryKey(activitySessionId);

		Session session = null;

		try {
			session = openSession();

			TMActivitySession[] array = new TMActivitySessionImpl[3];

			array[0] = getByU_T_PrevAndNext(session, tmActivitySession, userId,
					activityId, orderByComparator, true);

			array[1] = tmActivitySession;

			array[2] = getByU_T_PrevAndNext(session, tmActivitySession, userId,
					activityId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TMActivitySession getByU_T_PrevAndNext(Session session,
		TMActivitySession tmActivitySession, long userId, long activityId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TMACTIVITYSESSION_WHERE);

		query.append(_FINDER_COLUMN_U_T_USERID_2);

		query.append(_FINDER_COLUMN_U_T_ACTIVITYID_2);

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
			query.append(TMActivitySessionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(activityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tmActivitySession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TMActivitySession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the t m activity sessions where userId = &#63; and activityId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param activityId the activity ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByU_T(long userId, long activityId)
		throws SystemException {
		for (TMActivitySession tmActivitySession : findByU_T(userId,
				activityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tmActivitySession);
		}
	}

	/**
	 * Returns the number of t m activity sessions where userId = &#63; and activityId = &#63;.
	 *
	 * @param userId the user ID
	 * @param activityId the activity ID
	 * @return the number of matching t m activity sessions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByU_T(long userId, long activityId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_T;

		Object[] finderArgs = new Object[] { userId, activityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TMACTIVITYSESSION_WHERE);

			query.append(_FINDER_COLUMN_U_T_USERID_2);

			query.append(_FINDER_COLUMN_U_T_ACTIVITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(activityId);

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

	private static final String _FINDER_COLUMN_U_T_USERID_2 = "tmActivitySession.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_T_ACTIVITYID_2 = "tmActivitySession.activityId = ?";

	public TMActivitySessionPersistenceImpl() {
		setModelClass(TMActivitySession.class);
	}

	/**
	 * Caches the t m activity session in the entity cache if it is enabled.
	 *
	 * @param tmActivitySession the t m activity session
	 */
	@Override
	public void cacheResult(TMActivitySession tmActivitySession) {
		EntityCacheUtil.putResult(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
			TMActivitySessionImpl.class, tmActivitySession.getPrimaryKey(),
			tmActivitySession);

		tmActivitySession.resetOriginalValues();
	}

	/**
	 * Caches the t m activity sessions in the entity cache if it is enabled.
	 *
	 * @param tmActivitySessions the t m activity sessions
	 */
	@Override
	public void cacheResult(List<TMActivitySession> tmActivitySessions) {
		for (TMActivitySession tmActivitySession : tmActivitySessions) {
			if (EntityCacheUtil.getResult(
						TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
						TMActivitySessionImpl.class,
						tmActivitySession.getPrimaryKey()) == null) {
				cacheResult(tmActivitySession);
			}
			else {
				tmActivitySession.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t m activity sessions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TMActivitySessionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TMActivitySessionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t m activity session.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TMActivitySession tmActivitySession) {
		EntityCacheUtil.removeResult(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
			TMActivitySessionImpl.class, tmActivitySession.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TMActivitySession> tmActivitySessions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TMActivitySession tmActivitySession : tmActivitySessions) {
			EntityCacheUtil.removeResult(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
				TMActivitySessionImpl.class, tmActivitySession.getPrimaryKey());
		}
	}

	/**
	 * Creates a new t m activity session with the primary key. Does not add the t m activity session to the database.
	 *
	 * @param activitySessionId the primary key for the new t m activity session
	 * @return the new t m activity session
	 */
	@Override
	public TMActivitySession create(long activitySessionId) {
		TMActivitySession tmActivitySession = new TMActivitySessionImpl();

		tmActivitySession.setNew(true);
		tmActivitySession.setPrimaryKey(activitySessionId);

		return tmActivitySession;
	}

	/**
	 * Removes the t m activity session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activitySessionId the primary key of the t m activity session
	 * @return the t m activity session that was removed
	 * @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivitySession remove(long activitySessionId)
		throws NoSuchTMActivitySessionException, SystemException {
		return remove((Serializable)activitySessionId);
	}

	/**
	 * Removes the t m activity session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t m activity session
	 * @return the t m activity session that was removed
	 * @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivitySession remove(Serializable primaryKey)
		throws NoSuchTMActivitySessionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TMActivitySession tmActivitySession = (TMActivitySession)session.get(TMActivitySessionImpl.class,
					primaryKey);

			if (tmActivitySession == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTMActivitySessionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tmActivitySession);
		}
		catch (NoSuchTMActivitySessionException nsee) {
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
	protected TMActivitySession removeImpl(TMActivitySession tmActivitySession)
		throws SystemException {
		tmActivitySession = toUnwrappedModel(tmActivitySession);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tmActivitySession)) {
				tmActivitySession = (TMActivitySession)session.get(TMActivitySessionImpl.class,
						tmActivitySession.getPrimaryKeyObj());
			}

			if (tmActivitySession != null) {
				session.delete(tmActivitySession);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tmActivitySession != null) {
			clearCache(tmActivitySession);
		}

		return tmActivitySession;
	}

	@Override
	public TMActivitySession updateImpl(
		com.liferay.timemanagement.model.TMActivitySession tmActivitySession)
		throws SystemException {
		tmActivitySession = toUnwrappedModel(tmActivitySession);

		boolean isNew = tmActivitySession.isNew();

		TMActivitySessionModelImpl tmActivitySessionModelImpl = (TMActivitySessionModelImpl)tmActivitySession;

		Session session = null;

		try {
			session = openSession();

			if (tmActivitySession.isNew()) {
				session.save(tmActivitySession);

				tmActivitySession.setNew(false);
			}
			else {
				session.merge(tmActivitySession);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TMActivitySessionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tmActivitySessionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tmActivitySessionModelImpl.getOriginalUserId(),
						tmActivitySessionModelImpl.getOriginalActivityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T,
					args);

				args = new Object[] {
						tmActivitySessionModelImpl.getUserId(),
						tmActivitySessionModelImpl.getActivityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T,
					args);
			}
		}

		EntityCacheUtil.putResult(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
			TMActivitySessionImpl.class, tmActivitySession.getPrimaryKey(),
			tmActivitySession);

		return tmActivitySession;
	}

	protected TMActivitySession toUnwrappedModel(
		TMActivitySession tmActivitySession) {
		if (tmActivitySession instanceof TMActivitySessionImpl) {
			return tmActivitySession;
		}

		TMActivitySessionImpl tmActivitySessionImpl = new TMActivitySessionImpl();

		tmActivitySessionImpl.setNew(tmActivitySession.isNew());
		tmActivitySessionImpl.setPrimaryKey(tmActivitySession.getPrimaryKey());

		tmActivitySessionImpl.setActivitySessionId(tmActivitySession.getActivitySessionId());
		tmActivitySessionImpl.setGroupId(tmActivitySession.getGroupId());
		tmActivitySessionImpl.setCompanyId(tmActivitySession.getCompanyId());
		tmActivitySessionImpl.setUserId(tmActivitySession.getUserId());
		tmActivitySessionImpl.setUserName(tmActivitySession.getUserName());
		tmActivitySessionImpl.setCreateDate(tmActivitySession.getCreateDate());
		tmActivitySessionImpl.setModifiedDate(tmActivitySession.getModifiedDate());
		tmActivitySessionImpl.setActivityId(tmActivitySession.getActivityId());
		tmActivitySessionImpl.setEndTime(tmActivitySession.getEndTime());
		tmActivitySessionImpl.setStartTime(tmActivitySession.getStartTime());

		return tmActivitySessionImpl;
	}

	/**
	 * Returns the t m activity session with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t m activity session
	 * @return the t m activity session
	 * @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivitySession findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTMActivitySessionException, SystemException {
		TMActivitySession tmActivitySession = fetchByPrimaryKey(primaryKey);

		if (tmActivitySession == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTMActivitySessionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tmActivitySession;
	}

	/**
	 * Returns the t m activity session with the primary key or throws a {@link com.liferay.timemanagement.NoSuchTMActivitySessionException} if it could not be found.
	 *
	 * @param activitySessionId the primary key of the t m activity session
	 * @return the t m activity session
	 * @throws com.liferay.timemanagement.NoSuchTMActivitySessionException if a t m activity session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivitySession findByPrimaryKey(long activitySessionId)
		throws NoSuchTMActivitySessionException, SystemException {
		return findByPrimaryKey((Serializable)activitySessionId);
	}

	/**
	 * Returns the t m activity session with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t m activity session
	 * @return the t m activity session, or <code>null</code> if a t m activity session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivitySession fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TMActivitySession tmActivitySession = (TMActivitySession)EntityCacheUtil.getResult(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
				TMActivitySessionImpl.class, primaryKey);

		if (tmActivitySession == _nullTMActivitySession) {
			return null;
		}

		if (tmActivitySession == null) {
			Session session = null;

			try {
				session = openSession();

				tmActivitySession = (TMActivitySession)session.get(TMActivitySessionImpl.class,
						primaryKey);

				if (tmActivitySession != null) {
					cacheResult(tmActivitySession);
				}
				else {
					EntityCacheUtil.putResult(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
						TMActivitySessionImpl.class, primaryKey,
						_nullTMActivitySession);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TMActivitySessionModelImpl.ENTITY_CACHE_ENABLED,
					TMActivitySessionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tmActivitySession;
	}

	/**
	 * Returns the t m activity session with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activitySessionId the primary key of the t m activity session
	 * @return the t m activity session, or <code>null</code> if a t m activity session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMActivitySession fetchByPrimaryKey(long activitySessionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)activitySessionId);
	}

	/**
	 * Returns all the t m activity sessions.
	 *
	 * @return the t m activity sessions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMActivitySession> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TMActivitySession> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<TMActivitySession> findAll(int start, int end,
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

		List<TMActivitySession> list = (List<TMActivitySession>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TMACTIVITYSESSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TMACTIVITYSESSION;

				if (pagination) {
					sql = sql.concat(TMActivitySessionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TMActivitySession>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TMActivitySession>(list);
				}
				else {
					list = (List<TMActivitySession>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the t m activity sessions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TMActivitySession tmActivitySession : findAll()) {
			remove(tmActivitySession);
		}
	}

	/**
	 * Returns the number of t m activity sessions.
	 *
	 * @return the number of t m activity sessions
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

				Query q = session.createQuery(_SQL_COUNT_TMACTIVITYSESSION);

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
	 * Initializes the t m activity session persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timemanagement.model.TMActivitySession")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TMActivitySession>> listenersList = new ArrayList<ModelListener<TMActivitySession>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TMActivitySession>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TMActivitySessionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TMACTIVITYSESSION = "SELECT tmActivitySession FROM TMActivitySession tmActivitySession";
	private static final String _SQL_SELECT_TMACTIVITYSESSION_WHERE = "SELECT tmActivitySession FROM TMActivitySession tmActivitySession WHERE ";
	private static final String _SQL_COUNT_TMACTIVITYSESSION = "SELECT COUNT(tmActivitySession) FROM TMActivitySession tmActivitySession";
	private static final String _SQL_COUNT_TMACTIVITYSESSION_WHERE = "SELECT COUNT(tmActivitySession) FROM TMActivitySession tmActivitySession WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tmActivitySession.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TMActivitySession exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TMActivitySession exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TMActivitySessionPersistenceImpl.class);
	private static TMActivitySession _nullTMActivitySession = new TMActivitySessionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TMActivitySession> toCacheModel() {
				return _nullTMActivitySessionCacheModel;
			}
		};

	private static CacheModel<TMActivitySession> _nullTMActivitySessionCacheModel =
		new CacheModel<TMActivitySession>() {
			@Override
			public TMActivitySession toEntityModel() {
				return _nullTMActivitySession;
			}
		};
}