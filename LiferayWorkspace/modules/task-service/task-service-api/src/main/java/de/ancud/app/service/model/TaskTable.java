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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;codingchallenge_Task&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Task
 * @generated
 */
public class TaskTable extends BaseTable<TaskTable> {

	public static final TaskTable INSTANCE = new TaskTable();

	public final Column<TaskTable, Long> taskId = createColumn(
		"taskId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TaskTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskTable, String> toDoTask = createColumn(
		"toDoTask", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Date> dueDate = createColumn(
		"dueDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Boolean> done = createColumn(
		"done", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private TaskTable() {
		super("codingchallenge_Task", TaskTable::new);
	}

}