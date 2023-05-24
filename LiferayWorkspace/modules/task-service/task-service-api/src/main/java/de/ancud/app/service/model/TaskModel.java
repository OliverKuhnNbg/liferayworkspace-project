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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Task service. Represents a row in the &quot;codingchallenge_Task&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>de.ancud.app.service.model.impl.TaskModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>de.ancud.app.service.model.impl.TaskImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Task
 * @generated
 */
@ProviderType
public interface TaskModel extends BaseModel<Task> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a task model instance should use the {@link Task} interface instead.
	 */

	/**
	 * Returns the primary key of this task.
	 *
	 * @return the primary key of this task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this task.
	 *
	 * @param primaryKey the primary key of this task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the task ID of this task.
	 *
	 * @return the task ID of this task
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this task.
	 *
	 * @param taskId the task ID of this task
	 */
	public void setTaskId(long taskId);

	/**
	 * Returns the user ID of this task.
	 *
	 * @return the user ID of this task
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this task.
	 *
	 * @param userId the user ID of this task
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this task.
	 *
	 * @return the user uuid of this task
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this task.
	 *
	 * @param userUuid the user uuid of this task
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the to do task of this task.
	 *
	 * @return the to do task of this task
	 */
	@AutoEscape
	public String getToDoTask();

	/**
	 * Sets the to do task of this task.
	 *
	 * @param toDoTask the to do task of this task
	 */
	public void setToDoTask(String toDoTask);

	/**
	 * Returns the due date of this task.
	 *
	 * @return the due date of this task
	 */
	public Date getDueDate();

	/**
	 * Sets the due date of this task.
	 *
	 * @param dueDate the due date of this task
	 */
	public void setDueDate(Date dueDate);

	/**
	 * Returns the done of this task.
	 *
	 * @return the done of this task
	 */
	public boolean getDone();

	/**
	 * Returns <code>true</code> if this task is done.
	 *
	 * @return <code>true</code> if this task is done; <code>false</code> otherwise
	 */
	public boolean isDone();

	/**
	 * Sets whether this task is done.
	 *
	 * @param done the done of this task
	 */
	public void setDone(boolean done);

	@Override
	public Task cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}