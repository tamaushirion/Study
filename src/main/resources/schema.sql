/* ユーザー */
CREATE TABLE IF NOT EXISTS m_users (
user_id INT(3) AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(100),
email VARCHAR(50),
password VARCHAR(100),
role INT(1)
);

/* 勤務情報 */
CREATE TABLE IF NOT EXISTS t_work_infos (
work_info_id INT(3) AUTO_INCREMENT PRIMARY KEY,
user_id INT(3),
work_place_id INT(3),
work_day DATE(10),
start_time TIME(8),
break_time TIME(8),
end_time TIME(8)
);

/* 勤務地マスタ */
CREATE TABLE IF NOT EXISTS m_work_places (
work_place_id INT(3) AUTO_INCREMENT PRIMARY KEY,
work_place VARCHAR(50)
);