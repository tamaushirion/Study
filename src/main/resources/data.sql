/* ユーザー */
INSERT INTO m_users (
  user_id
, user_name
, email
, password
, role
) VALUES 

('1', 'rion0422', 'rion@co.jp', '$2a$10$tGqok0/yJiJC47V204lOEO9Ii/r.qz0Xh7X5Kw7d8IqKG5ZFV65Ne', '0')
, ('2', 'rion20422', 'rion2@co.jp', '$2a$10$tGqok0/yJiJC47V204lOEO9Ii/r.qz0Xh7X5Kw7d8IqKG5ZFV65Ne', '1')
, ('3', 'rion30422', 'rion3@co.jp', '$2a$10$tGqok0/yJiJC47V204lOEO9Ii/r.qz0Xh7X5Kw7d8IqKG5ZFV65Ne', '1');

/* 勤務情報 */
INSERT INTO t_work_infos (
  work_info_id
, user_id
, work_place_id
, work_day
, start_time
, break_time
, end_time
) VALUES 
('1', '2', '1', '2024-08-01', '10:00', '1:00', '19:00')
, ('2', '2', '1', '2024-08-02', '10:00', '1:00', '19:00')
, ('3', '2', '1', '2024-08-03', '10:00', '1:00', '19:00')
, ('4', '2', '2', '2024-09-01', '10:00', '1:00', '19:00')
, ('5', '2', '2', '2024-09-02', '10:00', '1:00', '19:00')
, ('6', '2', '2', '2024-09-03', '10:00', '1:00', '19:00')
, ('7', '2', '3', '2024-10-01', '10:00', '1:00', '19:00')
, ('8', '2', '3', '2024-10-02', '10:00', '1:00', '19:00')
, ('9', '2', '3', '2024-10-03', '10:00', '1:00', '19:00');

/* 勤務地マスタ */
INSERT INTO m_work_places (
  work_place_id
, work_place
) VALUES 
('1', '飯田橋')
, ('2', '五反田')
, ('3', '新宿');