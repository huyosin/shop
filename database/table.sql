--create user 'liuliang'@'%' identified by '0310';
--grant all on liuliang.* to liuliang@'%';

--drop database if exists liuliang;
--create database liuliang DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

drop table if exists user;
create table user(
	id bigint not null auto_increment comment '主键id',
	loginname varchar(64) not null unique comment '登录名',
	name varchar(64) not null comment '用户名',
	password varchar(64) not null comment '密码',
	salt varchar(64) not null comment 'salt值',
	sex tinyint(2) not null default 0 comment '性别 0未公开 1 男 2女',
	age tinyint(2) default 0 comment '年龄',
	phone varchar(20) default null comment '手机号',
	status tinyint(2) not null default 0 comment '状态 0正常 1锁定 9删除',
	type tinyint(2) not null default 0 comment '类型',
	createtime datetime not null default now() comment '创建时间',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户';

drop table if exists role;
create table role(
	id bigint not null auto_increment comment '主键id',
	name varchar(64) not null comment '角色名',
	orderno tinyint not null default 0 comment '排序号',
	status tinyint(2) not null default 0 comment '状态 0正常 1锁定 9删除',	
	createtime datetime not null default now() comment '创建时间',
    description varchar(255) DEFAULT NULL comment '简介',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色';

drop table if exists user_role;
create table user_role(
	userid bigint not null comment '用户id',
	roleid bigint not null comment '角色id',
	createtime datetime not null default now() comment '创建时间'
)ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='用户角色关系';

drop table if exists permission;
create table permission(
	id bigint not null auto_increment comment '主键id',
	name varchar(64) not null comment '权限名',
	status tinyint(2) not null default 0 comment '状态 0正常 1锁定 9删除',
	type tinyint(2) not null default 0 comment '类型',
	createtime datetime not null default now() comment '创建时间',
    description varchar(255) DEFAULT NULL comment '简介',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='权限';

drop table if exists role_permission;
create table role_permission(
	roleid bigint not null comment '角色id',
	permissionid bigint not null comment '权限id',
	createtime datetime not null default now() comment '创建时间'
)ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='角色权限关系';

drop table if exists operation;
create table operation(
	id bigint not null auto_increment comment '主键id',
	name varchar(64) not null comment '操作名',
	url varchar(255) default null comment '操作路径',
	pid bigint default 0 not null comment '父节点id',
	status tinyint(2) not null default 0 comment '状态 0正常 1锁定 9删除',
	type tinyint(2) not null default 0 comment '类型',
	createtime datetime not null default now() comment '创建时间',
    description varchar(255) DEFAULT NULL comment '简介',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='操作';

drop table if exists permission_operation;
create table permission_operation(
	permissionid bigint not null comment '权限id',
	operationid bigint not null comment '操作id',
	createtime datetime not null default now() comment '创建时间'
)ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='权限操作关系';

drop table if exists menu;
create table menu(
	id bigint not null auto_increment comment '主键id',
	name varchar(64) not null comment '菜单名',
	url varchar(255) default null comment '操作路径',
	pid bigint default 0 not null comment '父节点id',
	status tinyint(2) not null default 0 comment '状态 0正常 1锁定 9删除',
	type tinyint(2) not null default 0 comment '类型',
	createtime datetime not null default now() comment '创建时间',
    description varchar(255) DEFAULT NULL comment '简介',
    orderno int comment '排序号',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='菜单';

drop table if exists permission_menu;
create table permission_menu(
	permissionid bigint not null comment '权限id',
	menuid bigint not null comment '菜单id',
	createtime datetime not null default now() comment '创建时间'
)ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='权限菜单关系';
