drop user 'etakemon'@'localhost';
create user 'etakemon'@'localhost' identified by 'etakemon';
grant all privileges on etakemondb.* to 'etakemon'@'localhost';
flush privileges;