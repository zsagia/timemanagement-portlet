create index IX_38D9DC7F on timemanagement_TMActivity (companyId, groupId);
create index IX_F846B1CD on timemanagement_TMActivity (groupId);

create index IX_30A7CE23 on timemanagement_TMActivitySession (activityId);
create index IX_15BB2A5D on timemanagement_TMActivitySession (userId, activityId);

create index IX_A540DC9 on timemanagement_TMTask (companyId, taskId);
create index IX_E78E1D66 on timemanagement_TMTask (companyId, taskId, folderId);