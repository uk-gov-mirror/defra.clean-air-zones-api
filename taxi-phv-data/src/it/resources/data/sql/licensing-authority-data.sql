-- uploader-ids from `RegisterLicencesAbstractTest`: first, second, third and fourth respectively:
-- 6314d1d6-706a-40ce-b392-a0e618ab45b8
-- 07447271-df3d-4217-9092-41f1252864b8
-- 5cd737db-8c77-4016-9999-bcbf455a65b8
-- 36295725-b369-4819-8ee1-e19a43e737ef
-- 614a4d5e-1571-4172-af38-24a553e7def3
INSERT INTO T_MD_LICENSING_AUTHORITY(LICENCE_AUTHORITY_NAME, AUTHORISED_UPLOADER_IDS) values ('la-1', '{"6314d1d6-706a-40ce-b392-a0e618ab45b8", "07447271-df3d-4217-9092-41f1252864b8", "614a4d5e-1571-4172-af38-24a553e7def3"}');
INSERT INTO T_MD_LICENSING_AUTHORITY(LICENCE_AUTHORITY_NAME, AUTHORISED_UPLOADER_IDS) values ('la-2', '{"6314d1d6-706a-40ce-b392-a0e618ab45b8", "07447271-df3d-4217-9092-41f1252864b8", "614a4d5e-1571-4172-af38-24a553e7def3"}');
INSERT INTO T_MD_LICENSING_AUTHORITY(LICENCE_AUTHORITY_NAME, AUTHORISED_UPLOADER_IDS) values ('la-3', '{"6314d1d6-706a-40ce-b392-a0e618ab45b8", "07447271-df3d-4217-9092-41f1252864b8", "5cd737db-8c77-4016-9999-bcbf455a65b8", "36295725-b369-4819-8ee1-e19a43e737ef", "614a4d5e-1571-4172-af38-24a553e7def3"}');
INSERT INTO T_MD_LICENSING_AUTHORITY(LICENCE_AUTHORITY_NAME, AUTHORISED_UPLOADER_IDS) values ('la-4', '{"36295725-b369-4819-8ee1-e19a43e737ef"}');
INSERT INTO T_MD_LICENSING_AUTHORITY(LICENCE_AUTHORITY_NAME, AUTHORISED_UPLOADER_IDS) values ('la-5', '{"0d7ab5c4-5fff-4935-8c4e-56267c0c9491", "0d7ab5c4-5fff-4935-8c4e-56267c0c9492", "0d7ab5c4-5fff-4935-8c4e-56267c0c9494"}');
INSERT INTO T_MD_LICENSING_AUTHORITY(LICENCE_AUTHORITY_NAME, AUTHORISED_UPLOADER_IDS) values ('la-6', '{"0d7ab5c4-5fff-4935-8c4e-56267c0c9471", "0d7ab5c4-5fff-4935-8c4e-56267c0c9472", "0d7ab5c4-5fff-4935-8c4e-56267c0c9474"}');
INSERT INTO T_MD_LICENSING_AUTHORITY(LICENCE_AUTHORITY_NAME, AUTHORISED_UPLOADER_IDS) values ('la-7', '{"0d7ab5c4-5fff-4935-8c4e-56267c0c9481", "0d7ab5c4-5fff-4935-8c4e-56267c0c9472", "0d7ab5c4-5fff-4935-8c4e-56267c0c9484"}');
INSERT INTO T_MD_LICENSING_AUTHORITY(LICENCE_AUTHORITY_NAME, AUTHORISED_UPLOADER_IDS) values ('la-8', '{"0d7ab5c4-5fff-4935-8c4e-56267c0c9493"}');

UPDATE T_MD_LICENSING_AUTHORITY
SET AUTHORISED_UPLOADER_IDS = array_append(AUTHORISED_UPLOADER_IDS,'6314d1d6-706a-40ce-b392-a0e618ab45b8')
WHERE LICENCE_AUTHORITY_NAME = 'Leeds';

UPDATE T_MD_LICENSING_AUTHORITY
SET AUTHORISED_UPLOADER_IDS = array_append(AUTHORISED_UPLOADER_IDS,'6314d1d6-706a-40ce-b392-a0e618ab45b8')
WHERE LICENCE_AUTHORITY_NAME = 'Birmingham';

