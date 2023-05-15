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

package de.ancud.app.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Task}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Task
 * @generated
 */
public class TaskWrapper
	extends BaseModelWrapper<Task> implements ModelWrapper<Task>, Task {

	public TaskWrapper(Task task) {
		super(task);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("userId", getUserId());
		attributes.put("toDoTask", getToDoTask());
		attributes.put("dueDate", getDueDate());
		attributes.put("done", isDone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String toDoTask = (String)attributes.get("toDoTask");

		if (toDoTask != null) {
			setToDoTask(toDoTask);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Boolean done = (Boolean)attributes.get("done");

		if (done != null) {
			setDone(done);
		}
	}

	@Override
	public Task cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the done of this task.
	 *
	 * @return the done of this task
	 */
	@Override
	public boolean getDone() {
		return model.getDone();
	}

	/**
	 * Returns the due date of this task.
	 *
	 * @return the due date of this task
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the primary key of this task.
	 *
	 * @return the primary key of this task
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the task ID of this task.
	 *
	 * @return the task ID of this task
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the to do task of this task.
	 *
	 * @return the to do task of this task
	 */
	@Override
	public String getToDoTask() {
		return model.getToDoTask();
	}

	/**
	 * Returns the user ID of this task.
	 *
	 * @return the user ID of this task
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this task.
	 *
	 * @return the user uuid of this task
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this task is done.
	 *
	 * @return <code>true</code> if this task is done; <code>false</code> otherwise
	 */
	@Override
	public boolean isDone() {
		return model.isDone();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this task is done.
	 *
	 * @param done the done of this task
	 */
	@Override
	public void setDone(boolean done) {
		model.setDone(done);
	}

	/**
	 * Sets the due date of this task.
	 *
	 * @param dueDate the due date of this task
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the primary key of this task.
	 *
	 * @param primaryKey the primary key of this task
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the task ID of this task.
	 *
	 * @param taskId the task ID of this task
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the to do task of this task.
	 *
	 * @param toDoTask the to do task of this task
	 */
	@Override
	public void setToDoTask(String toDoTask) {
		model.setToDoTask(toDoTask);
	}

	/**
	 * Sets the user ID of this task.
	 *
	 * @param userId the user ID of this task
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this task.
	 *
	 * @param userUuid the user uuid of this task
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TaskWrapper wrap(Task task) {
		return new TaskWrapper(task);
	}

}