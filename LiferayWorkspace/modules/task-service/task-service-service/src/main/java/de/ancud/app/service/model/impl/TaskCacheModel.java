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

package de.ancud.app.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import de.ancud.app.service.model.Task;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Task in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskCacheModel implements CacheModel<Task>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TaskCacheModel)) {
			return false;
		}

		TaskCacheModel taskCacheModel = (TaskCacheModel)object;

		if (taskId == taskCacheModel.taskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{taskId=");
		sb.append(taskId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", toDoTask=");
		sb.append(toDoTask);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", done=");
		sb.append(done);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Task toEntityModel() {
		TaskImpl taskImpl = new TaskImpl();

		taskImpl.setTaskId(taskId);
		taskImpl.setUserId(userId);

		if (toDoTask == null) {
			taskImpl.setToDoTask("");
		}
		else {
			taskImpl.setToDoTask(toDoTask);
		}

		if (dueDate == Long.MIN_VALUE) {
			taskImpl.setDueDate(null);
		}
		else {
			taskImpl.setDueDate(new Date(dueDate));
		}

		taskImpl.setDone(done);

		taskImpl.resetOriginalValues();

		return taskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskId = objectInput.readLong();

		userId = objectInput.readLong();
		toDoTask = objectInput.readUTF();
		dueDate = objectInput.readLong();

		done = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(taskId);

		objectOutput.writeLong(userId);

		if (toDoTask == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(toDoTask);
		}

		objectOutput.writeLong(dueDate);

		objectOutput.writeBoolean(done);
	}

	public long taskId;
	public long userId;
	public String toDoTask;
	public long dueDate;
	public boolean done;

}