create table TEST.PUBLIC.users
(
    id               UUID        not null,
    "Name"           VARCHAR(50) not null,
    "Location"       VARCHAR(50) not null,
    "Date of Birth"  DATE        not null,
    "Contact Number" VARCHAR(50) not null,
    constraint id
        primary key (id)
);

