create table PUBLIC.USERS_PWD
(
    "UserID" UUID,
    PASSWORD CHARACTER VARYING(256),
    constraint "USERS_PWD_USERS_ID_fk"
        foreign key ("UserID") references PUBLIC.USERS
);

