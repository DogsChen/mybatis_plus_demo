create table permission
(
    id             int auto_increment comment '主键ID'
        primary key,
    permissionName varchar(255) not null comment '权限名称',
    permissionType varchar(255) not null comment '权限类型',
    description    varchar(500) null comment '描述',
    status         varchar(255) not null comment '状态',
    createById     int          null comment '创建者ID',
    updateById     int          null comment '更新者ID',
    createBy       varchar(255) null comment '创建者',
    updateBy       varchar(255) null comment '更新者',
    createTime     datetime     null comment '创建时间',
    updateTime     datetime     null comment '更新时间'
)
    charset = utf8;

create table plususer
(
    id    bigint auto_increment comment '主键ID'
        primary key,
    name  varchar(30) null comment '姓名',
    age   int         null comment '年龄',
    email varchar(50) null comment '邮箱'
);

create table role
(
    id           int auto_increment comment '主键ID'
        primary key,
    roleName     varchar(255) null comment '角色名称',
    roleType     varchar(255) null comment '角色类型',
    description  varchar(255) null comment '角色描述',
    status       varchar(255) null comment '角色状态（如：启用、禁用）',
    parentRole   varchar(255) null comment '父角色，关联到角色表',
    departmentId int          null comment '部门ID，关联到部门表',
    createById   int          null comment '创建者ID',
    updateById   int          null comment '更新者ID',
    createBy     varchar(255) null comment '创建者',
    updateBy     varchar(255) null comment '更新者',
    createTime   datetime     null comment '创建时间',
    updateTime   datetime     null comment '更新时间'
);

create table rolePermission
(
    id           int auto_increment comment '主键ID'
        primary key,
    roleId       int          not null comment '角色ID',
    permissionId int          not null comment '权限ID',
    createById   int          null comment '创建者ID',
    updateById   int          null comment '更新者ID',
    createBy     varchar(255) null comment '创建者',
    updateBy     varchar(255) null comment '更新者',
    createTime   datetime     null comment '创建时间',
    updateTime   datetime     null comment '更新时间'
);

create table user
(
    id               int auto_increment comment '主键ID'
        primary key,
    userName         varchar(255) not null comment '用户名',
    number           varchar(255) null comment '编号',
    password         varchar(255) not null comment '密码',
    email            varchar(255) null comment '邮箱',
    phone            varchar(255) null comment '电话',
    status           varchar(255) null comment '状态',
    intro            varchar(255) null comment '简介',
    registerTime     datetime     not null comment '注册时间',
    lastLoginTime    datetime     null comment '最后登录时间',
    lastLoginIp      varchar(255) null comment '最后登录IP',
    lastLoginAddress varchar(255) null comment '最后登录地址',
    createById       int          null comment '创建者ID',
    updateById       int          null comment '更新者ID',
    createBy         varchar(255) null comment '创建者',
    updateBy         varchar(255) null comment '更新者',
    createTime       datetime     null comment '创建时间',
    updateTime       datetime     null comment '更新时间'
)
    charset = utf8;

create table userRole
(
    id         int auto_increment comment '主键ID'
        primary key,
    userId     int          not null comment '用��ID',
    roleId     int          not null comment '角色ID',
    createById int          null comment '创建者ID',
    updateById int          null comment '更新者ID',
    createBy   varchar(255) null comment '创建者',
    updateBy   varchar(255) null comment '更新者',
    createTime datetime     null comment '创建时间',
    updateTime datetime     null comment '更新时间'
);



INSERT INTO `plususer` (id, name, age, email)
VALUES (1, 'Jone', 18, 'test1@baomidou.com'),
       (2, 'Jack', 20, 'test2@baomidou.com'),
       (3, 'Tom', 28, 'test3@baomidou.com'),
       (4, 'Sandy', 21, 'test4@baomidou.com'),
       (5, 'Billie', 24, 'test5@baomidou.com');