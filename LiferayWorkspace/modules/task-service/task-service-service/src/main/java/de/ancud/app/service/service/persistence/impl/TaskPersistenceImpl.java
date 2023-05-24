/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package de.ancud.app.service.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import de.ancud.app.service.exception.NoSuchTaskException;
import de.ancud.app.service.model.Task;
import de.ancud.app.service.model.TaskTable;
import de.ancud.app.service.model.impl.TaskImpl;
import de.ancud.app.service.model.impl.TaskModelImpl;
import de.ancud.app.service.service.persistence.TaskPersistence;
import de.ancud.app.service.service.persistence.TaskUtil;
import de.ancud.app.service.service.persistence.impl.constants.codingchallengePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TaskPersistence.class)
public class TaskPersistenceImpl
	extends BasePersistenceImpl<Task> implements TaskPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TaskUtil</code> to access the task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TaskImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByallTasks;
	private FinderPath _finderPathWithoutPaginationFindByallTasks;
	private FinderPath _finderPathCountByallTasks;

	/**
	 * Returns all the tasks where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @return the matching tasks
	 */
	@Override
	public List<Task> findByallTasks(String toDoTask) {
		return findByallTasks(
			toDoTask, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tasks where toDoTask = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param toDoTask the to do task
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	@Override
	public List<Task> findByallTasks(String toDoTask, int start, int end) {
		return findByallTasks(toDoTask, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tasks where toDoTask = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param toDoTask the to do task
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	@Override
	public List<Task> findByallTasks(
		String toDoTask, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return findByallTasks(toDoTask, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tasks where toDoTask = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param toDoTask the to do task
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	@Override
	public List<Task> findByallTasks(
		String toDoTask, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		toDoTask = Objects.toString(toDoTask, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByallTasks;
				finderArgs = new Object[] {toDoTask};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByallTasks;
			finderArgs = new Object[] {toDoTask, start, end, orderByComparator};
		}

		List<Task> list = null;

		if (useFinderCache) {
			list = (List<Task>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Task task : list) {
					if (!toDoTask.equals(task.getToDoTask())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TASK_WHERE);

			boolean bindToDoTask = false;

			if (toDoTask.isEmpty()) {
				sb.append(_FINDER_COLUMN_ALLTASKS_TODOTASK_3);
			}
			else {
				bindToDoTask = true;

				sb.append(_FINDER_COLUMN_ALLTASKS_TODOTASK_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToDoTask) {
					queryPos.add(toDoTask);
				}

				list = (List<Task>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first task in the ordered set where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	@Override
	public Task findByallTasks_First(
			String toDoTask, OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		Task task = fetchByallTasks_First(toDoTask, orderByComparator);

		if (task != null) {
			return task;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toDoTask=");
		sb.append(toDoTask);

		sb.append("}");

		throw new NoSuchTaskException(sb.toString());
	}

	/**
	 * Returns the first task in the ordered set where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	@Override
	public Task fetchByallTasks_First(
		String toDoTask, OrderByComparator<Task> orderByComparator) {

		List<Task> list = findByallTasks(toDoTask, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task in the ordered set where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	@Override
	public Task findByallTasks_Last(
			String toDoTask, OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		Task task = fetchByallTasks_Last(toDoTask, orderByComparator);

		if (task != null) {
			return task;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toDoTask=");
		sb.append(toDoTask);

		sb.append("}");

		throw new NoSuchTaskException(sb.toString());
	}

	/**
	 * Returns the last task in the ordered set where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	@Override
	public Task fetchByallTasks_Last(
		String toDoTask, OrderByComparator<Task> orderByComparator) {

		int count = countByallTasks(toDoTask);

		if (count == 0) {
			return null;
		}

		List<Task> list = findByallTasks(
			toDoTask, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tasks before and after the current task in the ordered set where toDoTask = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	@Override
	public Task[] findByallTasks_PrevAndNext(
			long taskId, String toDoTask,
			OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		toDoTask = Objects.toString(toDoTask, "");

		Task task = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			Task[] array = new TaskImpl[3];

			array[0] = getByallTasks_PrevAndNext(
				session, task, toDoTask, orderByComparator, true);

			array[1] = task;

			array[2] = getByallTasks_PrevAndNext(
				session, task, toDoTask, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Task getByallTasks_PrevAndNext(
		Session session, Task task, String toDoTask,
		OrderByComparator<Task> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TASK_WHERE);

		boolean bindToDoTask = false;

		if (toDoTask.isEmpty()) {
			sb.append(_FINDER_COLUMN_ALLTASKS_TODOTASK_3);
		}
		else {
			bindToDoTask = true;

			sb.append(_FINDER_COLUMN_ALLTASKS_TODOTASK_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindToDoTask) {
			queryPos.add(toDoTask);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(task)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Task> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tasks where toDoTask = &#63; from the database.
	 *
	 * @param toDoTask the to do task
	 */
	@Override
	public void removeByallTasks(String toDoTask) {
		for (Task task :
				findByallTasks(
					toDoTask, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(task);
		}
	}

	/**
	 * Returns the number of tasks where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @return the number of matching tasks
	 */
	@Override
	public int countByallTasks(String toDoTask) {
		toDoTask = Objects.toString(toDoTask, "");

		FinderPath finderPath = _finderPathCountByallTasks;

		Object[] finderArgs = new Object[] {toDoTask};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TASK_WHERE);

			boolean bindToDoTask = false;

			if (toDoTask.isEmpty()) {
				sb.append(_FINDER_COLUMN_ALLTASKS_TODOTASK_3);
			}
			else {
				bindToDoTask = true;

				sb.append(_FINDER_COLUMN_ALLTASKS_TODOTASK_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToDoTask) {
					queryPos.add(toDoTask);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ALLTASKS_TODOTASK_2 =
		"task.toDoTask = ?";

	private static final String _FINDER_COLUMN_ALLTASKS_TODOTASK_3 =
		"(task.toDoTask IS NULL OR task.toDoTask = '')";

	private FinderPath _finderPathWithPaginationFindByuserTasks;
	private FinderPath _finderPathWithoutPaginationFindByuserTasks;
	private FinderPath _finderPathCountByuserTasks;

	/**
	 * Returns all the tasks where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @return the matching tasks
	 */
	@Override
	public List<Task> findByuserTasks(long userId, String toDoTask) {
		return findByuserTasks(
			userId, toDoTask, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tasks where userId = &#63; and toDoTask = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	@Override
	public List<Task> findByuserTasks(
		long userId, String toDoTask, int start, int end) {

		return findByuserTasks(userId, toDoTask, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and toDoTask = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	@Override
	public List<Task> findByuserTasks(
		long userId, String toDoTask, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return findByuserTasks(
			userId, toDoTask, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and toDoTask = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	@Override
	public List<Task> findByuserTasks(
		long userId, String toDoTask, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		toDoTask = Objects.toString(toDoTask, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserTasks;
				finderArgs = new Object[] {userId, toDoTask};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserTasks;
			finderArgs = new Object[] {
				userId, toDoTask, start, end, orderByComparator
			};
		}

		List<Task> list = null;

		if (useFinderCache) {
			list = (List<Task>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Task task : list) {
					if ((userId != task.getUserId()) ||
						!toDoTask.equals(task.getToDoTask())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TASK_WHERE);

			sb.append(_FINDER_COLUMN_USERTASKS_USERID_2);

			boolean bindToDoTask = false;

			if (toDoTask.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERTASKS_TODOTASK_3);
			}
			else {
				bindToDoTask = true;

				sb.append(_FINDER_COLUMN_USERTASKS_TODOTASK_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindToDoTask) {
					queryPos.add(toDoTask);
				}

				list = (List<Task>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	@Override
	public Task findByuserTasks_First(
			long userId, String toDoTask,
			OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		Task task = fetchByuserTasks_First(userId, toDoTask, orderByComparator);

		if (task != null) {
			return task;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", toDoTask=");
		sb.append(toDoTask);

		sb.append("}");

		throw new NoSuchTaskException(sb.toString());
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	@Override
	public Task fetchByuserTasks_First(
		long userId, String toDoTask,
		OrderByComparator<Task> orderByComparator) {

		List<Task> list = findByuserTasks(
			userId, toDoTask, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	@Override
	public Task findByuserTasks_Last(
			long userId, String toDoTask,
			OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		Task task = fetchByuserTasks_Last(userId, toDoTask, orderByComparator);

		if (task != null) {
			return task;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", toDoTask=");
		sb.append(toDoTask);

		sb.append("}");

		throw new NoSuchTaskException(sb.toString());
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	@Override
	public Task fetchByuserTasks_Last(
		long userId, String toDoTask,
		OrderByComparator<Task> orderByComparator) {

		int count = countByuserTasks(userId, toDoTask);

		if (count == 0) {
			return null;
		}

		List<Task> list = findByuserTasks(
			userId, toDoTask, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tasks before and after the current task in the ordered set where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	@Override
	public Task[] findByuserTasks_PrevAndNext(
			long taskId, long userId, String toDoTask,
			OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		toDoTask = Objects.toString(toDoTask, "");

		Task task = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			Task[] array = new TaskImpl[3];

			array[0] = getByuserTasks_PrevAndNext(
				session, task, userId, toDoTask, orderByComparator, true);

			array[1] = task;

			array[2] = getByuserTasks_PrevAndNext(
				session, task, userId, toDoTask, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Task getByuserTasks_PrevAndNext(
		Session session, Task task, long userId, String toDoTask,
		OrderByComparator<Task> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TASK_WHERE);

		sb.append(_FINDER_COLUMN_USERTASKS_USERID_2);

		boolean bindToDoTask = false;

		if (toDoTask.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERTASKS_TODOTASK_3);
		}
		else {
			bindToDoTask = true;

			sb.append(_FINDER_COLUMN_USERTASKS_TODOTASK_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (bindToDoTask) {
			queryPos.add(toDoTask);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(task)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Task> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tasks where userId = &#63; and toDoTask = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 */
	@Override
	public void removeByuserTasks(long userId, String toDoTask) {
		for (Task task :
				findByuserTasks(
					userId, toDoTask, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(task);
		}
	}

	/**
	 * Returns the number of tasks where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @return the number of matching tasks
	 */
	@Override
	public int countByuserTasks(long userId, String toDoTask) {
		toDoTask = Objects.toString(toDoTask, "");

		FinderPath finderPath = _finderPathCountByuserTasks;

		Object[] finderArgs = new Object[] {userId, toDoTask};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TASK_WHERE);

			sb.append(_FINDER_COLUMN_USERTASKS_USERID_2);

			boolean bindToDoTask = false;

			if (toDoTask.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERTASKS_TODOTASK_3);
			}
			else {
				bindToDoTask = true;

				sb.append(_FINDER_COLUMN_USERTASKS_TODOTASK_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindToDoTask) {
					queryPos.add(toDoTask);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERTASKS_USERID_2 =
		"task.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERTASKS_TODOTASK_2 =
		"task.toDoTask = ?";

	private static final String _FINDER_COLUMN_USERTASKS_TODOTASK_3 =
		"(task.toDoTask IS NULL OR task.toDoTask = '')";

	private FinderPath _finderPathWithPaginationFindByuserTasksDone;
	private FinderPath _finderPathWithoutPaginationFindByuserTasksDone;
	private FinderPath _finderPathCountByuserTasksDone;

	/**
	 * Returns all the tasks where userId = &#63; and done = &#63;.
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @return the matching tasks
	 */
	@Override
	public List<Task> findByuserTasksDone(long userId, boolean done) {
		return findByuserTasksDone(
			userId, done, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tasks where userId = &#63; and done = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	@Override
	public List<Task> findByuserTasksDone(
		long userId, boolean done, int start, int end) {

		return findByuserTasksDone(userId, done, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and done = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	@Override
	public List<Task> findByuserTasksDone(
		long userId, boolean done, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return findByuserTasksDone(
			userId, done, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and done = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	@Override
	public List<Task> findByuserTasksDone(
		long userId, boolean done, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserTasksDone;
				finderArgs = new Object[] {userId, done};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserTasksDone;
			finderArgs = new Object[] {
				userId, done, start, end, orderByComparator
			};
		}

		List<Task> list = null;

		if (useFinderCache) {
			list = (List<Task>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Task task : list) {
					if ((userId != task.getUserId()) ||
						(done != task.isDone())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TASK_WHERE);

			sb.append(_FINDER_COLUMN_USERTASKSDONE_USERID_2);

			sb.append(_FINDER_COLUMN_USERTASKSDONE_DONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(done);

				list = (List<Task>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and done = &#63;.
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	@Override
	public Task findByuserTasksDone_First(
			long userId, boolean done,
			OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		Task task = fetchByuserTasksDone_First(userId, done, orderByComparator);

		if (task != null) {
			return task;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", done=");
		sb.append(done);

		sb.append("}");

		throw new NoSuchTaskException(sb.toString());
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and done = &#63;.
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	@Override
	public Task fetchByuserTasksDone_First(
		long userId, boolean done, OrderByComparator<Task> orderByComparator) {

		List<Task> list = findByuserTasksDone(
			userId, done, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and done = &#63;.
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	@Override
	public Task findByuserTasksDone_Last(
			long userId, boolean done,
			OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		Task task = fetchByuserTasksDone_Last(userId, done, orderByComparator);

		if (task != null) {
			return task;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", done=");
		sb.append(done);

		sb.append("}");

		throw new NoSuchTaskException(sb.toString());
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and done = &#63;.
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	@Override
	public Task fetchByuserTasksDone_Last(
		long userId, boolean done, OrderByComparator<Task> orderByComparator) {

		int count = countByuserTasksDone(userId, done);

		if (count == 0) {
			return null;
		}

		List<Task> list = findByuserTasksDone(
			userId, done, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tasks before and after the current task in the ordered set where userId = &#63; and done = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param userId the user ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	@Override
	public Task[] findByuserTasksDone_PrevAndNext(
			long taskId, long userId, boolean done,
			OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		Task task = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			Task[] array = new TaskImpl[3];

			array[0] = getByuserTasksDone_PrevAndNext(
				session, task, userId, done, orderByComparator, true);

			array[1] = task;

			array[2] = getByuserTasksDone_PrevAndNext(
				session, task, userId, done, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Task getByuserTasksDone_PrevAndNext(
		Session session, Task task, long userId, boolean done,
		OrderByComparator<Task> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TASK_WHERE);

		sb.append(_FINDER_COLUMN_USERTASKSDONE_USERID_2);

		sb.append(_FINDER_COLUMN_USERTASKSDONE_DONE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(done);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(task)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Task> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tasks where userId = &#63; and done = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param done the done
	 */
	@Override
	public void removeByuserTasksDone(long userId, boolean done) {
		for (Task task :
				findByuserTasksDone(
					userId, done, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(task);
		}
	}

	/**
	 * Returns the number of tasks where userId = &#63; and done = &#63;.
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @return the number of matching tasks
	 */
	@Override
	public int countByuserTasksDone(long userId, boolean done) {
		FinderPath finderPath = _finderPathCountByuserTasksDone;

		Object[] finderArgs = new Object[] {userId, done};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TASK_WHERE);

			sb.append(_FINDER_COLUMN_USERTASKSDONE_USERID_2);

			sb.append(_FINDER_COLUMN_USERTASKSDONE_DONE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(done);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERTASKSDONE_USERID_2 =
		"task.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERTASKSDONE_DONE_2 =
		"task.done = ?";

	private FinderPath _finderPathWithPaginationFindByuserTasksByDueDate;
	private FinderPath _finderPathWithoutPaginationFindByuserTasksByDueDate;
	private FinderPath _finderPathCountByuserTasksByDueDate;

	/**
	 * Returns all the tasks where userId = &#63; and dueDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @return the matching tasks
	 */
	@Override
	public List<Task> findByuserTasksByDueDate(long userId, Date dueDate) {
		return findByuserTasksByDueDate(
			userId, dueDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tasks where userId = &#63; and dueDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	@Override
	public List<Task> findByuserTasksByDueDate(
		long userId, Date dueDate, int start, int end) {

		return findByuserTasksByDueDate(userId, dueDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and dueDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	@Override
	public List<Task> findByuserTasksByDueDate(
		long userId, Date dueDate, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return findByuserTasksByDueDate(
			userId, dueDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and dueDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	@Override
	public List<Task> findByuserTasksByDueDate(
		long userId, Date dueDate, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByuserTasksByDueDate;
				finderArgs = new Object[] {userId, _getTime(dueDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserTasksByDueDate;
			finderArgs = new Object[] {
				userId, _getTime(dueDate), start, end, orderByComparator
			};
		}

		List<Task> list = null;

		if (useFinderCache) {
			list = (List<Task>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Task task : list) {
					if ((userId != task.getUserId()) ||
						!Objects.equals(dueDate, task.getDueDate())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TASK_WHERE);

			sb.append(_FINDER_COLUMN_USERTASKSBYDUEDATE_USERID_2);

			boolean bindDueDate = false;

			if (dueDate == null) {
				sb.append(_FINDER_COLUMN_USERTASKSBYDUEDATE_DUEDATE_1);
			}
			else {
				bindDueDate = true;

				sb.append(_FINDER_COLUMN_USERTASKSBYDUEDATE_DUEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindDueDate) {
					queryPos.add(new Timestamp(dueDate.getTime()));
				}

				list = (List<Task>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and dueDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	@Override
	public Task findByuserTasksByDueDate_First(
			long userId, Date dueDate,
			OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		Task task = fetchByuserTasksByDueDate_First(
			userId, dueDate, orderByComparator);

		if (task != null) {
			return task;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", dueDate=");
		sb.append(dueDate);

		sb.append("}");

		throw new NoSuchTaskException(sb.toString());
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and dueDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	@Override
	public Task fetchByuserTasksByDueDate_First(
		long userId, Date dueDate, OrderByComparator<Task> orderByComparator) {

		List<Task> list = findByuserTasksByDueDate(
			userId, dueDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and dueDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	@Override
	public Task findByuserTasksByDueDate_Last(
			long userId, Date dueDate,
			OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		Task task = fetchByuserTasksByDueDate_Last(
			userId, dueDate, orderByComparator);

		if (task != null) {
			return task;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", dueDate=");
		sb.append(dueDate);

		sb.append("}");

		throw new NoSuchTaskException(sb.toString());
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and dueDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	@Override
	public Task fetchByuserTasksByDueDate_Last(
		long userId, Date dueDate, OrderByComparator<Task> orderByComparator) {

		int count = countByuserTasksByDueDate(userId, dueDate);

		if (count == 0) {
			return null;
		}

		List<Task> list = findByuserTasksByDueDate(
			userId, dueDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tasks before and after the current task in the ordered set where userId = &#63; and dueDate = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	@Override
	public Task[] findByuserTasksByDueDate_PrevAndNext(
			long taskId, long userId, Date dueDate,
			OrderByComparator<Task> orderByComparator)
		throws NoSuchTaskException {

		Task task = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			Task[] array = new TaskImpl[3];

			array[0] = getByuserTasksByDueDate_PrevAndNext(
				session, task, userId, dueDate, orderByComparator, true);

			array[1] = task;

			array[2] = getByuserTasksByDueDate_PrevAndNext(
				session, task, userId, dueDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Task getByuserTasksByDueDate_PrevAndNext(
		Session session, Task task, long userId, Date dueDate,
		OrderByComparator<Task> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TASK_WHERE);

		sb.append(_FINDER_COLUMN_USERTASKSBYDUEDATE_USERID_2);

		boolean bindDueDate = false;

		if (dueDate == null) {
			sb.append(_FINDER_COLUMN_USERTASKSBYDUEDATE_DUEDATE_1);
		}
		else {
			bindDueDate = true;

			sb.append(_FINDER_COLUMN_USERTASKSBYDUEDATE_DUEDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (bindDueDate) {
			queryPos.add(new Timestamp(dueDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(task)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Task> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tasks where userId = &#63; and dueDate = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 */
	@Override
	public void removeByuserTasksByDueDate(long userId, Date dueDate) {
		for (Task task :
				findByuserTasksByDueDate(
					userId, dueDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(task);
		}
	}

	/**
	 * Returns the number of tasks where userId = &#63; and dueDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @return the number of matching tasks
	 */
	@Override
	public int countByuserTasksByDueDate(long userId, Date dueDate) {
		FinderPath finderPath = _finderPathCountByuserTasksByDueDate;

		Object[] finderArgs = new Object[] {userId, _getTime(dueDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TASK_WHERE);

			sb.append(_FINDER_COLUMN_USERTASKSBYDUEDATE_USERID_2);

			boolean bindDueDate = false;

			if (dueDate == null) {
				sb.append(_FINDER_COLUMN_USERTASKSBYDUEDATE_DUEDATE_1);
			}
			else {
				bindDueDate = true;

				sb.append(_FINDER_COLUMN_USERTASKSBYDUEDATE_DUEDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindDueDate) {
					queryPos.add(new Timestamp(dueDate.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERTASKSBYDUEDATE_USERID_2 =
		"task.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERTASKSBYDUEDATE_DUEDATE_1 =
		"task.dueDate IS NULL";

	private static final String _FINDER_COLUMN_USERTASKSBYDUEDATE_DUEDATE_2 =
		"task.dueDate = ?";

	public TaskPersistenceImpl() {
		setModelClass(Task.class);

		setModelImplClass(TaskImpl.class);
		setModelPKClass(long.class);

		setTable(TaskTable.INSTANCE);
	}

	/**
	 * Caches the task in the entity cache if it is enabled.
	 *
	 * @param task the task
	 */
	@Override
	public void cacheResult(Task task) {
		entityCache.putResult(TaskImpl.class, task.getPrimaryKey(), task);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the tasks in the entity cache if it is enabled.
	 *
	 * @param tasks the tasks
	 */
	@Override
	public void cacheResult(List<Task> tasks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tasks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Task task : tasks) {
			if (entityCache.getResult(TaskImpl.class, task.getPrimaryKey()) ==
					null) {

				cacheResult(task);
			}
		}
	}

	/**
	 * Clears the cache for all tasks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaskImpl.class);

		finderCache.clearCache(TaskImpl.class);
	}

	/**
	 * Clears the cache for the task.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Task task) {
		entityCache.removeResult(TaskImpl.class, task);
	}

	@Override
	public void clearCache(List<Task> tasks) {
		for (Task task : tasks) {
			entityCache.removeResult(TaskImpl.class, task);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TaskImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TaskImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new task with the primary key. Does not add the task to the database.
	 *
	 * @param taskId the primary key for the new task
	 * @return the new task
	 */
	@Override
	public Task create(long taskId) {
		Task task = new TaskImpl();

		task.setNew(true);
		task.setPrimaryKey(taskId);

		return task;
	}

	/**
	 * Removes the task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the task
	 * @return the task that was removed
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	@Override
	public Task remove(long taskId) throws NoSuchTaskException {
		return remove((Serializable)taskId);
	}

	/**
	 * Removes the task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task
	 * @return the task that was removed
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	@Override
	public Task remove(Serializable primaryKey) throws NoSuchTaskException {
		Session session = null;

		try {
			session = openSession();

			Task task = (Task)session.get(TaskImpl.class, primaryKey);

			if (task == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(task);
		}
		catch (NoSuchTaskException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Task removeImpl(Task task) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(task)) {
				task = (Task)session.get(
					TaskImpl.class, task.getPrimaryKeyObj());
			}

			if (task != null) {
				session.delete(task);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (task != null) {
			clearCache(task);
		}

		return task;
	}

	@Override
	public Task updateImpl(Task task) {
		boolean isNew = task.isNew();

		if (!(task instanceof TaskModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(task.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(task);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in task proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Task implementation " +
					task.getClass());
		}

		TaskModelImpl taskModelImpl = (TaskModelImpl)task;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(task);
			}
			else {
				task = (Task)session.merge(task);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(TaskImpl.class, taskModelImpl, false, true);

		if (isNew) {
			task.setNew(false);
		}

		task.resetOriginalValues();

		return task;
	}

	/**
	 * Returns the task with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task
	 * @return the task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	@Override
	public Task findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskException {

		Task task = fetchByPrimaryKey(primaryKey);

		if (task == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return task;
	}

	/**
	 * Returns the task with the primary key or throws a <code>NoSuchTaskException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task
	 * @return the task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	@Override
	public Task findByPrimaryKey(long taskId) throws NoSuchTaskException {
		return findByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns the task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task
	 * @return the task, or <code>null</code> if a task with the primary key could not be found
	 */
	@Override
	public Task fetchByPrimaryKey(long taskId) {
		return fetchByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns all the tasks.
	 *
	 * @return the tasks
	 */
	@Override
	public List<Task> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of tasks
	 */
	@Override
	public List<Task> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tasks
	 */
	@Override
	public List<Task> findAll(
		int start, int end, OrderByComparator<Task> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tasks
	 */
	@Override
	public List<Task> findAll(
		int start, int end, OrderByComparator<Task> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Task> list = null;

		if (useFinderCache) {
			list = (List<Task>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TASK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TASK;

				sql = sql.concat(TaskModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Task>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tasks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Task task : findAll()) {
			remove(task);
		}
	}

	/**
	 * Returns the number of tasks.
	 *
	 * @return the number of tasks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TASK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "taskId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TASK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TaskModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the task persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByallTasks = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByallTasks",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"toDoTask"}, true);

		_finderPathWithoutPaginationFindByallTasks = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByallTasks",
			new String[] {String.class.getName()}, new String[] {"toDoTask"},
			true);

		_finderPathCountByallTasks = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByallTasks",
			new String[] {String.class.getName()}, new String[] {"toDoTask"},
			false);

		_finderPathWithPaginationFindByuserTasks = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserTasks",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "toDoTask"}, true);

		_finderPathWithoutPaginationFindByuserTasks = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserTasks",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"userId", "toDoTask"}, true);

		_finderPathCountByuserTasks = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserTasks",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"userId", "toDoTask"}, false);

		_finderPathWithPaginationFindByuserTasksDone = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserTasksDone",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "done"}, true);

		_finderPathWithoutPaginationFindByuserTasksDone = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserTasksDone",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"userId", "done"}, true);

		_finderPathCountByuserTasksDone = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserTasksDone",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"userId", "done"}, false);

		_finderPathWithPaginationFindByuserTasksByDueDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserTasksByDueDate",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "dueDate"}, true);

		_finderPathWithoutPaginationFindByuserTasksByDueDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByuserTasksByDueDate",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"userId", "dueDate"}, true);

		_finderPathCountByuserTasksByDueDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByuserTasksByDueDate",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"userId", "dueDate"}, false);

		_setTaskUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTaskUtilPersistence(null);

		entityCache.removeCache(TaskImpl.class.getName());
	}

	private void _setTaskUtilPersistence(TaskPersistence taskPersistence) {
		try {
			Field field = TaskUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, taskPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = codingchallengePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = codingchallengePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = codingchallengePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_TASK = "SELECT task FROM Task task";

	private static final String _SQL_SELECT_TASK_WHERE =
		"SELECT task FROM Task task WHERE ";

	private static final String _SQL_COUNT_TASK =
		"SELECT COUNT(task) FROM Task task";

	private static final String _SQL_COUNT_TASK_WHERE =
		"SELECT COUNT(task) FROM Task task WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "task.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Task exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Task exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TaskPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}