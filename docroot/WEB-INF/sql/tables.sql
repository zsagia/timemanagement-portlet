create table timemanagement_TMActivity (
	activityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	activityName STRING null,
	classNameId LONG,
	classPK LONG,
	classUuid VARCHAR(75) null,
	description STRING null,
	endDate DATE null,
	priority INTEGER,
	reminderDate DATE null,
	scheduledDate DATE null,
	startDate DATE null,
	visible BOOLEAN
);

create table timemanagement_TMActivitySession (
	activitySessionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	activityId LONG,
	endTime DATE null,
	startTime DATE null
);

create table timemanagement_TMTask (
	taskId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dueDate DATE null,
	folderId LONG,
	priority INTEGER,
	status INTEGER,
	taskName VARCHAR(75) null
);