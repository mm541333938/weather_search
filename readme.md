项目运行说明：
	项目配置的端口是18080
	第一次运行项目时，在项目启动后，需要访问一次127.0.0.1:18080/page/helper.jsp（注意，该页面只能访问一次）
	然后，可以正常访问127.0.0.1:18080/page/index.jsp


	
项目结构：
	index2.jsp为简单版的查询功能
	index.jsp是在index2.jsp基础上进一步完善，美观化的查询页面



建表语句:
	CREATE TABLE `js_city` (
	`id` INT ( 11 ) NOT NULL,
	`pid` INT ( 11 ) DEFAULT NULL,
	`city_code` VARCHAR ( 255 ) DEFAULT NULL,
	`city_name` VARCHAR ( 255 ) DEFAULT NULL 
	) ENGINE = INNODB DEFAULT CHARSET = utf8;



