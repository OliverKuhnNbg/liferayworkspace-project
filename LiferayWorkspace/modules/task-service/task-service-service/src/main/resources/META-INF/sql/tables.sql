create table codingchallenge_Task (
	taskId LONG not null primary key,
	userId LONG,
	toDoTask VARCHAR(75) null,
	dueDate DATE null,
	done BOOLEAN
);