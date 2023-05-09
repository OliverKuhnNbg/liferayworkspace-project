create index IX_EEB3C023 on FOO_Task (toDoTask[$COLUMN_LENGTH:75$]);
create index IX_9FBC1A94 on FOO_Task (userId, done);
create index IX_E0E88614 on FOO_Task (userId, dueDate);
create index IX_6E9673DD on FOO_Task (userId, toDoTask[$COLUMN_LENGTH:75$]);