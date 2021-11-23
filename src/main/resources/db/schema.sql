--drop table education;
--drop table work;
--drop table address;
--drop table profile;

create table profile(
	id serial,
	first_name varchar(50) not null,
	middle_name varchar(50),
	last_name varchar(50) not null,
	birth_date date not null,
	primary key(id)
);

create table address(
	id serial,
	profile_id int not null,
	address varchar(200) not null,
	city varchar(200),
	state varchar(100),
	zip varchar(50),
	country varchar(50),
	constraint fk_address_profile_id foreign key(profile_id) references profile(id)
);

create table work(
	id serial,
	profile_id int not null,
	company varchar(100) not null,
	job_title varchar(50) not null,
	start_date date,
	end_date date,
	constraint fk_work_profile_id foreign key(profile_id) references profile(id)
);

create table education(
	id serial,
	profile_id int not null,
	school_name varchar(100) not null,
	course varchar(50) not null,
	start_date date,
	end_date date,
	constraint fk_education_profile_id foreign key(profile_id) references profile(id)
);