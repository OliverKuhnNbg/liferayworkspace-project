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

package de.ancud.app.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.ancud.app.service.model.Task;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the task service. This utility wraps <code>de.ancud.app.service.service.persistence.impl.TaskPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskPersistence
 * @generated
 */
public class TaskUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Task task) {
		getPersistence().clearCache(task);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Task> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Task> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Task> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Task> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Task update(Task task) {
		return getPersistence().update(task);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Task update(Task task, ServiceContext serviceContext) {
		return getPersistence().update(task, serviceContext);
	}

	/**
	 * Returns all the tasks where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @return the matching tasks
	 */
	public static List<Task> findByallTasks(String toDoTask) {
		return getPersistence().findByallTasks(toDoTask);
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
	public static List<Task> findByallTasks(
		String toDoTask, int start, int end) {

		return getPersistence().findByallTasks(toDoTask, start, end);
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
	public static List<Task> findByallTasks(
		String toDoTask, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findByallTasks(
			toDoTask, start, end, orderByComparator);
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
	public static List<Task> findByallTasks(
		String toDoTask, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByallTasks(
			toDoTask, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task in the ordered set where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByallTasks_First(
			String toDoTask, OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByallTasks_First(
			toDoTask, orderByComparator);
	}

	/**
	 * Returns the first task in the ordered set where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByallTasks_First(
		String toDoTask, OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByallTasks_First(
			toDoTask, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByallTasks_Last(
			String toDoTask, OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByallTasks_Last(
			toDoTask, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByallTasks_Last(
		String toDoTask, OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByallTasks_Last(
			toDoTask, orderByComparator);
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
	public static Task[] findByallTasks_PrevAndNext(
			long taskId, String toDoTask,
			OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByallTasks_PrevAndNext(
			taskId, toDoTask, orderByComparator);
	}

	/**
	 * Removes all the tasks where toDoTask = &#63; from the database.
	 *
	 * @param toDoTask the to do task
	 */
	public static void removeByallTasks(String toDoTask) {
		getPersistence().removeByallTasks(toDoTask);
	}

	/**
	 * Returns the number of tasks where toDoTask = &#63;.
	 *
	 * @param toDoTask the to do task
	 * @return the number of matching tasks
	 */
	public static int countByallTasks(String toDoTask) {
		return getPersistence().countByallTasks(toDoTask);
	}

	/**
	 * Returns all the tasks where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @return the matching tasks
	 */
	public static List<Task> findByuserTasks(long userId, String toDoTask) {
		return getPersistence().findByuserTasks(userId, toDoTask);
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
	public static List<Task> findByuserTasks(
		long userId, String toDoTask, int start, int end) {

		return getPersistence().findByuserTasks(userId, toDoTask, start, end);
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
	public static List<Task> findByuserTasks(
		long userId, String toDoTask, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findByuserTasks(
			userId, toDoTask, start, end, orderByComparator);
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
	public static List<Task> findByuserTasks(
		long userId, String toDoTask, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserTasks(
			userId, toDoTask, start, end, orderByComparator, useFinderCache);
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
	public static Task findByuserTasks_First(
			long userId, String toDoTask,
			OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByuserTasks_First(
			userId, toDoTask, orderByComparator);
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByuserTasks_First(
		long userId, String toDoTask,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByuserTasks_First(
			userId, toDoTask, orderByComparator);
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
	public static Task findByuserTasks_Last(
			long userId, String toDoTask,
			OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByuserTasks_Last(
			userId, toDoTask, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByuserTasks_Last(
		long userId, String toDoTask,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByuserTasks_Last(
			userId, toDoTask, orderByComparator);
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
	public static Task[] findByuserTasks_PrevAndNext(
			long taskId, long userId, String toDoTask,
			OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByuserTasks_PrevAndNext(
			taskId, userId, toDoTask, orderByComparator);
	}

	/**
	 * Removes all the tasks where userId = &#63; and toDoTask = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 */
	public static void removeByuserTasks(long userId, String toDoTask) {
		getPersistence().removeByuserTasks(userId, toDoTask);
	}

	/**
	 * Returns the number of tasks where userId = &#63; and toDoTask = &#63;.
	 *
	 * @param userId the user ID
	 * @param toDoTask the to do task
	 * @return the number of matching tasks
	 */
	public static int countByuserTasks(long userId, String toDoTask) {
		return getPersistence().countByuserTasks(userId, toDoTask);
	}

	/**
	 * Returns all the tasks where userId = &#63; and done = &#63;.
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @return the matching tasks
	 */
	public static List<Task> findByuserTasksDone(long userId, boolean done) {
		return getPersistence().findByuserTasksDone(userId, done);
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
	public static List<Task> findByuserTasksDone(
		long userId, boolean done, int start, int end) {

		return getPersistence().findByuserTasksDone(userId, done, start, end);
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
	public static List<Task> findByuserTasksDone(
		long userId, boolean done, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findByuserTasksDone(
			userId, done, start, end, orderByComparator);
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
	public static List<Task> findByuserTasksDone(
		long userId, boolean done, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserTasksDone(
			userId, done, start, end, orderByComparator, useFinderCache);
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
	public static Task findByuserTasksDone_First(
			long userId, boolean done,
			OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByuserTasksDone_First(
			userId, done, orderByComparator);
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and done = &#63;.
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByuserTasksDone_First(
		long userId, boolean done, OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByuserTasksDone_First(
			userId, done, orderByComparator);
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
	public static Task findByuserTasksDone_Last(
			long userId, boolean done,
			OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByuserTasksDone_Last(
			userId, done, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and done = &#63;.
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByuserTasksDone_Last(
		long userId, boolean done, OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByuserTasksDone_Last(
			userId, done, orderByComparator);
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
	public static Task[] findByuserTasksDone_PrevAndNext(
			long taskId, long userId, boolean done,
			OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByuserTasksDone_PrevAndNext(
			taskId, userId, done, orderByComparator);
	}

	/**
	 * Removes all the tasks where userId = &#63; and done = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param done the done
	 */
	public static void removeByuserTasksDone(long userId, boolean done) {
		getPersistence().removeByuserTasksDone(userId, done);
	}

	/**
	 * Returns the number of tasks where userId = &#63; and done = &#63;.
	 *
	 * @param userId the user ID
	 * @param done the done
	 * @return the number of matching tasks
	 */
	public static int countByuserTasksDone(long userId, boolean done) {
		return getPersistence().countByuserTasksDone(userId, done);
	}

	/**
	 * Returns all the tasks where userId = &#63; and dueDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @return the matching tasks
	 */
	public static List<Task> findByuserTasksByDueDate(
		long userId, Date dueDate) {

		return getPersistence().findByuserTasksByDueDate(userId, dueDate);
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
	public static List<Task> findByuserTasksByDueDate(
		long userId, Date dueDate, int start, int end) {

		return getPersistence().findByuserTasksByDueDate(
			userId, dueDate, start, end);
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
	public static List<Task> findByuserTasksByDueDate(
		long userId, Date dueDate, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findByuserTasksByDueDate(
			userId, dueDate, start, end, orderByComparator);
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
	public static List<Task> findByuserTasksByDueDate(
		long userId, Date dueDate, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserTasksByDueDate(
			userId, dueDate, start, end, orderByComparator, useFinderCache);
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
	public static Task findByuserTasksByDueDate_First(
			long userId, Date dueDate,
			OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByuserTasksByDueDate_First(
			userId, dueDate, orderByComparator);
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and dueDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByuserTasksByDueDate_First(
		long userId, Date dueDate, OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByuserTasksByDueDate_First(
			userId, dueDate, orderByComparator);
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
	public static Task findByuserTasksByDueDate_Last(
			long userId, Date dueDate,
			OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByuserTasksByDueDate_Last(
			userId, dueDate, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and dueDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByuserTasksByDueDate_Last(
		long userId, Date dueDate, OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByuserTasksByDueDate_Last(
			userId, dueDate, orderByComparator);
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
	public static Task[] findByuserTasksByDueDate_PrevAndNext(
			long taskId, long userId, Date dueDate,
			OrderByComparator<Task> orderByComparator)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByuserTasksByDueDate_PrevAndNext(
			taskId, userId, dueDate, orderByComparator);
	}

	/**
	 * Removes all the tasks where userId = &#63; and dueDate = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 */
	public static void removeByuserTasksByDueDate(long userId, Date dueDate) {
		getPersistence().removeByuserTasksByDueDate(userId, dueDate);
	}

	/**
	 * Returns the number of tasks where userId = &#63; and dueDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param dueDate the due date
	 * @return the number of matching tasks
	 */
	public static int countByuserTasksByDueDate(long userId, Date dueDate) {
		return getPersistence().countByuserTasksByDueDate(userId, dueDate);
	}

	/**
	 * Caches the task in the entity cache if it is enabled.
	 *
	 * @param task the task
	 */
	public static void cacheResult(Task task) {
		getPersistence().cacheResult(task);
	}

	/**
	 * Caches the tasks in the entity cache if it is enabled.
	 *
	 * @param tasks the tasks
	 */
	public static void cacheResult(List<Task> tasks) {
		getPersistence().cacheResult(tasks);
	}

	/**
	 * Creates a new task with the primary key. Does not add the task to the database.
	 *
	 * @param taskId the primary key for the new task
	 * @return the new task
	 */
	public static Task create(long taskId) {
		return getPersistence().create(taskId);
	}

	/**
	 * Removes the task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the task
	 * @return the task that was removed
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public static Task remove(long taskId)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().remove(taskId);
	}

	public static Task updateImpl(Task task) {
		return getPersistence().updateImpl(task);
	}

	/**
	 * Returns the task with the primary key or throws a <code>NoSuchTaskException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task
	 * @return the task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public static Task findByPrimaryKey(long taskId)
		throws de.ancud.app.service.exception.NoSuchTaskException {

		return getPersistence().findByPrimaryKey(taskId);
	}

	/**
	 * Returns the task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task
	 * @return the task, or <code>null</code> if a task with the primary key could not be found
	 */
	public static Task fetchByPrimaryKey(long taskId) {
		return getPersistence().fetchByPrimaryKey(taskId);
	}

	/**
	 * Returns all the tasks.
	 *
	 * @return the tasks
	 */
	public static List<Task> findAll() {
		return getPersistence().findAll();
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
	public static List<Task> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Task> findAll(
		int start, int end, OrderByComparator<Task> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Task> findAll(
		int start, int end, OrderByComparator<Task> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the tasks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tasks.
	 *
	 * @return the number of tasks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaskPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TaskPersistence _persistence;

}