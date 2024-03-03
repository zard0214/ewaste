create table t_user
(
    id                  bigint auto_increment comment 'ID'
        primary key,
    version             int          default 0                 null comment 'version',

    gender              int          default 0                 null comment 'gender',
    login_name          varchar(50)  default ''                null comment 'login_name',
    password            varchar(300) default ''                null comment 'password',
    provider_id         varchar(300) default ''                null comment 'provider_id',
    provider            varchar(300) default ''                null comment 'provider',
    user_code           varchar(32)  default ''                null comment 'user_code',
    user_name           varchar(50)  default ''                null comment 'user_name',
    image_url           varchar(500)  default ''                null comment 'image_url',
    phone               varchar(15)  default ''                null comment 'phone',
    email               varchar(50)  default ''                null comment 'email',
    status              varchar(20)  default ''                null comment 'status',
    remark              varchar(300) default ''                null comment 'remark',

    creator             varchar(20)  default ''                null comment 'creator',
    creator_id          bigint                                 null comment 'creator_id',
    gmt_created         datetime     default CURRENT_TIMESTAMP null comment 'gmt_created',
    last_operator       varchar(20)  default ''                null comment 'last_operator',
    last_operator_id    bigint                                 null comment 'last_operator_id',
    gmt_modified        datetime     default CURRENT_TIMESTAMP null comment 'gmt_modified',
    is_deleted          int          default 0                 null comment 'is_deleted'
);

create table t_user_token
(
    id                  bigint auto_increment comment 'ID'
        primary key,
    version             int          default 0                 null comment 'version',

    login_name             varchar(50)   default ''                null comment 'login_name',
    user_name              varchar(50)   default ''                null comment 'user_name',
    user_id                bigint                                               null comment 'user_id',
    login_ip               varchar(20)   default ''                null comment 'login_ip',
    login_location         varchar(50)   default ''                null comment 'login_location',
    login_time             datetime                   default CURRENT_TIMESTAMP null comment 'login_time',
    access_token           varchar(2000) default ''                null comment 'access_token',
    refresh_token          varchar(2000) default ''                null comment 'refresh_token',
    token_type             varchar(20)   default ''                null comment 'token_type',
    access_token_validity  int                                                  null comment 'access_token_validity',
    refresh_token_validity int                                                  null comment 'refresh_token_validity',
    status                 int                        default 0                 null comment '0 online 10refresh 20 offline',

    creator             varchar(20)  default ''                null comment 'creator',
    creator_id          bigint                                 null comment 'creator_id',
    gmt_created         datetime     default CURRENT_TIMESTAMP null comment 'gmt_created',
    last_operator       varchar(20)  default ''                null comment 'last_operator',
    last_operator_id    bigint                                 null comment 'last_operator_id',
    gmt_modified        datetime     default CURRENT_TIMESTAMP null comment 'gmt_modified',
    is_deleted          int          default 0                 null comment 'is_deleted'
);

create table t_role
(
    id               bigint auto_increment comment 'ID'
        primary key,
    version          int          default 0                 null comment 'version',

    role_name        varchar(100) default ''                null comment 'role_name',
    role_code        varchar(100) default ''                null comment 'role_code',
    data_scope       varchar(100) default '1'               null comment 'data_scope',
    status           varchar(20)  default ''                null comment 'status',
    remark           varchar(300) default ''                null comment 'remark',

    creator             varchar(20)  default ''                null comment 'creator',
    creator_id          bigint                                 null comment 'creator_id',
    gmt_created         datetime     default CURRENT_TIMESTAMP null comment 'gmt_created',
    last_operator       varchar(20)  default ''                null comment 'last_operator',
    last_operator_id    bigint                                 null comment 'last_operator_id',
    gmt_modified        datetime     default CURRENT_TIMESTAMP null comment 'gmt_modified',
    is_deleted          int          default 0                 null comment 'is_deleted'
);

create table t_user_role
(
    id               bigint auto_increment comment 'ID'
        primary key,

    user_id          bigint      default 0                 null comment 'user id',
    role_id          bigint      default 0                 null comment 'role id',

    creator             varchar(20)  default ''                null comment 'creator',
    creator_id          bigint                                 null comment 'creator_id',
    gmt_created         datetime     default CURRENT_TIMESTAMP null comment 'gmt_created',
    last_operator       varchar(20)  default ''                null comment 'last_operator',
    last_operator_id    bigint                                 null comment 'last_operator_id',
    gmt_modified        datetime     default CURRENT_TIMESTAMP null comment 'gmt_modified',
    is_deleted          int          default 0                 null comment 'is_deleted'
);