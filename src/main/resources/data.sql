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
, ('3', 'rion30422', 'rion3@co.jp', '$2a$10$tGqok0/yJiJC47V204lOEO9Ii/r.qz0Xh7X5Kw7d8IqKG5ZFV65Ne', '1')
, ('4', 'rion40422', 'rion4@co.jp', '$2a$10$tGqok0/yJiJC47V204lOEO9Ii/r.qz0Xh7X5Kw7d8IqKG5ZFV65Ne', '1')
, ('5', 'rion50422', 'rion5@co.jp', '$2a$10$tGqok0/yJiJC47V204lOEO9Ii/r.qz0Xh7X5Kw7d8IqKG5ZFV65Ne', '1')
, ('6', 'rion60422', 'rion6@co.jp', '$2a$10$tGqok0/yJiJC47V204lOEO9Ii/r.qz0Xh7X5Kw7d8IqKG5ZFV65Ne', '1');

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
('1', '1', '1', '2024-08-01', '10:00', '1:00', '19:00')
, ('2', '1', '1', '2024-08-02', '10:00', '1:00', '19:00');

/* 勤務地マスタ */
INSERT INTO m_work_places (
  work_place_id
, work_place
) VALUES 
('1', '飯田橋')
, ('2', '飯田橋')
, ('3', '飯田橋')
, ('4', '飯田橋')
, ('5', '五反田')
, ('6', '五反田')
, ('7', '五反田')