use environment_project;
show databases;
select database();
show tables;
create table Application(
id int not null, 
name varchar(30) not null,
deployment_location varchar(30) not null,
log_type varchar(10) not null,
primary key (id)
);

create table application_type(
id int not null,
application_type varchar(20) not null,
application_id int not null,
foreign key (application_id) references application(id) on update cascade
);

alter table application_type add primary key (id); 

create table environment(
id int not null primary key,
name varchar(30) not null,
location varchar(30)
);

create table server_type(
id int not null primary key,
server_type varchar(30) not null,
operating_system_version varchar(20)
); 

create table network_domain(
id int not null primary key,
domain_name varchar(30) not null 
);

create table server(
id int not null primary key,
name varchar(30) not null,
environment_id int not null,
network_domain_id int not null,
foreign key (environment_id) references application(id) on update cascade,
foreign key (network_domain_id) references network_domain(id) on update cascade
);

create table application_and_server(
id int not null primary key,
application_id int not null,
server_id int not null,
foreign key(application_id) references application(id) on update cascade,
foreign key(server_id) references server(id) on update cascade 
);

create table deployment_step(
id int not null primary key,
application_id int not null,
change_set varchar(20),
version varchar(20) not null, 
foreign key (application_id) references application(id) on update cascade 
);

create table Change_request(
id int not null primary key,
request_date date,
deployment_step_id int not null,
foreign key (deployment_step_id) references deployment_step(id) on update cascade
);

create table application_state(
id int not null primary key,
state varchar(15) not null
);

create table application_deployment_info(
id int not null primary key,
application_id int not null,
server_id int not null,
version varchar(15) not null,
application_state_id int not null,
deployment_date date,
foreign key (application_id) references application(id)on update cascade,
foreign key (server_id) references server(id)on update cascade,
foreign key(application_state_id) references application_state(id)on update cascade
);