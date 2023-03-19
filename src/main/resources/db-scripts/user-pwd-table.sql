create table PUBLIC.USERS_PWD
(
    USERID   UUID not null
        primary key,
    PASSWORD CHARACTER VARYING(255)
);

