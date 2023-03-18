create schema VTDB;
create table VTDB.users
(
    id               UUID        not null,
    "Name"           VARCHAR(50) not null,
    "Location"       VARCHAR(50) not null,
    "Date of Birth"  DATE        not null,
    "Contact Number" VARCHAR(50) not null,
    constraint id
        primary key (id)
);

comment on table VTDB.users is 'Registered Users';
