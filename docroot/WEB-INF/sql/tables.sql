create table timemanagement_TMActivity (
	activityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description STRING null,
	activityName STRING null
);