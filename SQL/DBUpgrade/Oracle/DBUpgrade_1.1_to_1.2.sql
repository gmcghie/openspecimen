#--  Name: Sachin Lale Bug ID: 3052 Patch ID: 3052_4 See also: 1-4 ---
#--  Description : A comment field at the Specimen Collection Group level.---
alter table CATISSUE_SPECIMEN_COLL_GROUP add column COMMENTS varchar(500);