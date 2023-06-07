INSERT INTO アカウント.ユーザー (ログイン名, パスワード)
VALUES ('user1', '$2a$10$2K6q3ryhiwKs4WnDz6mjjOCWq/Tn4uuDhM1kZyGdjTTM9J7UC0GOO'),
       ('user2', '$2a$10$5loWIeiozrv3RLdlFSd3mOCKfLfGLHAwG6hg6te2NVuTQ5M18DyQK'),
       ('manager1', '$2a$10$BZjuFGNAVfY5idQpsFYHVu2em61lJ93yB2GxdYBgIN76QTHyKPdf2'),
       ('manager2', '$2a$10$BZjuFGNAVfY5idQpsFYHVu2em61lJ93yB2GxdYBgIN76QTHyKPdf2'),
       ('manager3', '$2a$10$BZjuFGNAVfY5idQpsFYHVu2em61lJ93yB2GxdYBgIN76QTHyKPdf2');


INSERT INTO アカウント.ユーザー役割 (ユーザーID, 役割)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_USER'),
       (3, 'ROLE_ADMIN'),
       (4, 'ROLE_ADMIN'),
       (5, 'ROLE_ADMIN');


-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('hosoi', '$2a$10$BZjuFGNAVfY5idQpsFYHVu2em61lJ93yB2GxdYBgIN76QTHyKPdf2', true),
--        ('nakahara', '$2a$10$BZjuFGNAVfY5idQpsFYHVu2em61lJ93yB2GxdYBgIN76QTHyKPdf2', true);
--
-- INSERT INTO AUTHORITIES
-- VALUES ('hosoi', 'ROLE_USER'),
--        ('nakahara', 'ROLE_ADMIN'),
--        ('nakahara', 'ROLE_USER');


INSERT INTO ワークフロー.申請書 (申請ID, 金額, 用途)
VALUES ('7f9f874b-5b9b-49ef-b057-49ebb514c067', 320, '飯田橋-日本橋の交通費'),
       ('72aaa581-be2d-4677-aed7-60a1085b9a88', 12640, '品川-大阪の交通費'),
       ('e173d70e-76b8-4332-9bb1-056b07cee12f', 223540, '機材購入費'),
       ('35b4f3fe-f59b-4325-8c3a-7100aba6dfb8', 445620, 'PC購入費')
;


INSERT INTO ワークフロー.ワークフロー履歴 (申請ID, ワークフロー履歴ID, イベント, 作成日時)
VALUES ('7f9f874b-5b9b-49ef-b057-49ebb514c067', 'c5dded9b-82ac-46d6-b90b-1d5489e8fc49', '作成', '2023-05-31 12:19:01'),
       ('7f9f874b-5b9b-49ef-b057-49ebb514c067', 'e150ff46-1ece-49fd-a367-6886dde7ec1a', '申請', '2023-05-31 14:20:11'),
       ('72aaa581-be2d-4677-aed7-60a1085b9a88', 'fc13c613-8445-48e1-aa48-9de06aec0236', '作成', '2023-05-31 14:29:31'),
       ('72aaa581-be2d-4677-aed7-60a1085b9a88', '81abcbee-2db5-4a49-98f3-eae9d6372b41', '申請', '2023-06-01 09:38:02'),
       ('72aaa581-be2d-4677-aed7-60a1085b9a88', '05fc41f4-7cba-45fa-854f-b2ce8dc131f4', '差戻し', '2023-06-01 11:59:01'),
       ('e173d70e-76b8-4332-9bb1-056b07cee12f', 'a561a5a8-4bcf-42eb-89aa-7069ec3ec893', '作成', '2023-05-31 12:19:01'),
       ('e173d70e-76b8-4332-9bb1-056b07cee12f', 'a7dd6fe6-0f05-40b2-a747-d5ba294d86b7', '申請', '2023-06-02 02:19:01'),
       ('e173d70e-76b8-4332-9bb1-056b07cee12f', '9e1364dc-9e94-430f-8353-7dbc9fb5d7a0', '承認', '2023-06-12 05:12:12'),
       ('35b4f3fe-f59b-4325-8c3a-7100aba6dfb8', '9052e21d-217e-4f96-98b9-72ecfd888956', '作成', '2023-05-31 11:12:51'),
       ('35b4f3fe-f59b-4325-8c3a-7100aba6dfb8', '68d47af9-e126-45df-a77d-d1383d9d66f5', '申請', '2023-05-31 12:19:01')
;


INSERT INTO ワークフロー.担当履歴 (申請ID, ワークフロー履歴ID, ユーザーID)
VALUES ('7f9f874b-5b9b-49ef-b057-49ebb514c067', 'c5dded9b-82ac-46d6-b90b-1d5489e8fc49', 1),
       ('7f9f874b-5b9b-49ef-b057-49ebb514c067', 'e150ff46-1ece-49fd-a367-6886dde7ec1a', 3),
       ('72aaa581-be2d-4677-aed7-60a1085b9a88', 'fc13c613-8445-48e1-aa48-9de06aec0236', 1),
       ('72aaa581-be2d-4677-aed7-60a1085b9a88', '81abcbee-2db5-4a49-98f3-eae9d6372b41', 3),
       ('72aaa581-be2d-4677-aed7-60a1085b9a88', '05fc41f4-7cba-45fa-854f-b2ce8dc131f4', 1),
       ('e173d70e-76b8-4332-9bb1-056b07cee12f', 'a561a5a8-4bcf-42eb-89aa-7069ec3ec893', 1),
       ('e173d70e-76b8-4332-9bb1-056b07cee12f', 'a7dd6fe6-0f05-40b2-a747-d5ba294d86b7', 3),
       ('35b4f3fe-f59b-4325-8c3a-7100aba6dfb8', '9052e21d-217e-4f96-98b9-72ecfd888956', 1),
       ('35b4f3fe-f59b-4325-8c3a-7100aba6dfb8', '68d47af9-e126-45df-a77d-d1383d9d66f5', 3)
;


INSERT INTO ワークフロー.申請 (申請ID, 申請者ID, 申請日時)
VALUES ('7f9f874b-5b9b-49ef-b057-49ebb514c067', 1, '2023-05-31 12:19:01'),
       ('72aaa581-be2d-4677-aed7-60a1085b9a88', 1, '2023-05-31 13:29:01'),
       ('e173d70e-76b8-4332-9bb1-056b07cee12f', 2, '2023-05-31 11:45:31'),
       ('35b4f3fe-f59b-4325-8c3a-7100aba6dfb8', 1, '2023-05-31 10:12:51')
;


INSERT INTO ワークフロー._最新履歴 (申請ID, ワークフロー履歴ID, ステータス)
VALUES ('7f9f874b-5b9b-49ef-b057-49ebb514c067', 'e150ff46-1ece-49fd-a367-6886dde7ec1a', '申請中'),
       ('72aaa581-be2d-4677-aed7-60a1085b9a88', '05fc41f4-7cba-45fa-854f-b2ce8dc131f4', '作成中'),
       ('e173d70e-76b8-4332-9bb1-056b07cee12f', '9e1364dc-9e94-430f-8353-7dbc9fb5d7a0', '承認済'),
       ('35b4f3fe-f59b-4325-8c3a-7100aba6dfb8', '68d47af9-e126-45df-a77d-d1383d9d66f5', '申請中')
;

