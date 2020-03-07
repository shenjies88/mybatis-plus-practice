create schema if not exists mybatis_plus collate utf8mb4_unicode_ci;

create table if not exists mybatis_plus.user
(
	id bigint auto_increment comment '主键ID'
		primary key,
	name varchar(30) default '' null comment '姓名',
	age int null comment '年龄',
	email varchar(50) default '' null comment '邮箱',
	status int default 0 not null comment '0正常，1删除',
	create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间'
);



