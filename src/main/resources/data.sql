INSERT INTO アカウント.ユーザー (ログイン名, パスワード)
VALUES ('user1', '$2a$10$2K6q3ryhiwKs4WnDz6mjjOCWq/Tn4uuDhM1kZyGdjTTM9J7UC0GOO'),
       ('user2', '$2a$10$5loWIeiozrv3RLdlFSd3mOCKfLfGLHAwG6hg6te2NVuTQ5M18DyQK'),
       ('manager1', '$2a$10$BZjuFGNAVfY5idQpsFYHVu2em61lJ93yB2GxdYBgIN76QTHyKPdf2');


INSERT INTO アカウント.ユーザー役割 (ユーザーID, 役割)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_USER'),
       (3, 'ROLE_ADMIN');

-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('hosoi', '$2a$10$BZjuFGNAVfY5idQpsFYHVu2em61lJ93yB2GxdYBgIN76QTHyKPdf2', true),
--        ('nakahara', '$2a$10$BZjuFGNAVfY5idQpsFYHVu2em61lJ93yB2GxdYBgIN76QTHyKPdf2', true);
--
-- INSERT INTO AUTHORITIES
-- VALUES ('hosoi', 'ROLE_USER'),
--        ('nakahara', 'ROLE_ADMIN'),
--        ('nakahara', 'ROLE_USER');