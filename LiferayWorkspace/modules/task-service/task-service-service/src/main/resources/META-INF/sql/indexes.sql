create index IX_B3AFD8F0 on codingchallenge_Task (toDoTask[$COLUMN_LENGTH:75$]);
create index IX_E43504E1 on codingchallenge_Task (userId, done);
create index IX_13F25CA7 on codingchallenge_Task (userId, dueDate);
create index IX_9CC76FAA on codingchallenge_Task (userId, toDoTask[$COLUMN_LENGTH:75$]);