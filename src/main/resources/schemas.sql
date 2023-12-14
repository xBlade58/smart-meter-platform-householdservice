CREATE TABLE IF NOT EXISTS HOUSEHOLD (
    id SERIAL not null primary key,
    street char(128) not null,
    street_no char(8) not null,
    door_no char(4),
    city char(64) not null,
    zip_code char(10) not null,
    country char(64) not null,
    household_type char(16),
    residents_no int
);

CREATE TABLE IF NOT EXISTS METER_USER (
    id SERIAL not null primary key,
    firstname char(36),
    lastname char(36)
);

CREATE TABLE IF NOT EXISTS USER_HOUSEHOLD(
    street char(128) not null,
    street_no char(8) not null,
    door_no char(4) not null,
    city char(64) not null,
    zip_code char(10) not null,
    country char(64) not null,
    user_id serial not null,
    foreign key (street, street_no, door_no, city, zip_code, country) references HOUSEHOLD(street, street_no, door_no, city, zip_code, country),
    foreign key (user_id) references METER_USER(id)
);