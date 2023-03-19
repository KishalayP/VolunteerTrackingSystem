create table PUBLIC.USERS_PWD
(
    USERID   UUID not null
        primary key,
    PASSWORD CHARACTER VARYING(255)
);

create table PUBLIC.USERS
(
    "EMAIL"          CHARACTER VARYING(250) not null,
    constraint "USERS_pk"
        primary key ("EMAIL"),
    ID               UUID                   not null,
    "NAME"           CHARACTER VARYING(50)  not null,
    "LOCATION"       CHARACTER VARYING(50)  not null,
    "DATE_OF_BIRTH"  DATE                   not null,
    "CONTACT_NUMBER" CHARACTER VARYING(50)  not null,

    constraint "USERS_USERS_PWD_USERID_fk"
        foreign key (ID) references PUBLIC.USERS_PWD
);

INSERT INTO PUBLIC.USERS_PWD (USERID, PASSWORD)
VALUES ('3fa85f64-5717-4562-b3fc-2c963f66afa7', 'aaa');
INSERT INTO PUBLIC.USERS ("EMAIL", ID, "NAME", "LOCATION", "DATE_OF_BIRTH", "CONTACT_NUMBER")
VALUES ('kp@gmail.com', '3fa85f64-5717-4562-b3fc-2c963f66afa7', 'Kishalay', 'Bangalore', '1998-04-28', '8310786412');

