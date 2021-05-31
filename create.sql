create sequence hibernate_sequence start with 1 increment by 1;
create table usuario (id bigint not null, data_nascimento varchar(255), image varchar(255), nome varchar(255), primary key (id));
