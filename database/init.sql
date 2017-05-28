truncate table user;
insert into user(id, login_name, name, password, salt) values(1,"sunxin","sunxin","1","1");
insert into user(id, login_name, name, password, salt) values(2,"liuliang","liuliang","1","1");

truncate table role;
insert into role(id, name, orderno) values(1,"admin",1);
insert into role(id, name, orderno) values(2,"user",2);

truncate table user_role;
insert into user_role(userid, roleid) values(1,1);
insert into user_role(userid, roleid) values(2,2);

truncate table permission;
insert into permission(id, name) values(1,"访问test");
insert into permission(id, name) values(2,"permission2");
insert into permission(id, name) values(3,"permission3");

truncate table role_permission;
insert into role_permission(roleid, permissionid) values(1,1);
insert into role_permission(roleid, permissionid) values(1,2);
insert into role_permission(roleid, permissionid) values(2,2);

truncate table menu;
insert into menu(id, name) values(1,"menu1");
insert into menu(id, name) values(2,"menu2");
insert into menu(id, name) values(3,"menu3");
insert into menu(id, pid, name) values(4,1,"menu4");

truncate table permission_menu;
insert into permission_menu(permissionid, menuid) values(1,1);
insert into permission_menu(permissionid, menuid) values(1,2);
insert into permission_menu(permissionid, menuid) values(2,1);
insert into permission_menu(permissionid, menuid) values(2,2);
insert into permission_menu(permissionid, menuid) values(2,3);
insert into permission_menu(permissionid, menuid) values(3,4);

truncate table operation;
insert into operation(id, name, url) values(1,"operation1","url1");
insert into operation(id, name, url) values(2,"operation2","url2");
insert into operation(id, name, url) values(3,"operation3","url3");
insert into operation(id, name, url) values(4,"operation4","url4");

truncate table permission_operation;
insert into permission_operation(permissionid, operationid) values(1,1);
insert into permission_operation(permissionid, operationid) values(2,2);
insert into permission_operation(permissionid, operationid) values(3,3);