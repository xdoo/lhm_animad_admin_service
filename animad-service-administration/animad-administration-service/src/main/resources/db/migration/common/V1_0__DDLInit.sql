	-- This file is for H2

	--**************************
	--Tables
	--**************************
	
	create table Enclosure (
	oid varchar(36),
	enclosureid varchar(30) not null, 
	cleaningtime datetime not null, 
	primary key (oid));
	
	create table Animal (
	oid varchar(36),
	name varchar(30) not null, 
	species varchar(255) not null, 
	birthday datetime not null, 
	gender varchar(255) not null, 
	weight decimal not null, 
	alive boolean not null, 
	primary key (oid));
	
	create table Zookeeper (
	oid varchar(36),
	name varchar(30) not null, 
	employmentdate datetime not null, 
	birthday datetime not null, 
	salary bigint not null, 
	primary key (oid));
	
	--Enclosure_Animals Relation Table
	create table Enclosure_Animals (
	enclosure_oid varchar(36) not null, 
	animals_oid varchar(36) not null unique, 
	order_index bigint,
	primary key ( enclosure_oid, animals_oid));
	
	alter table Enclosure_Animals 
	add constraint FK_enclosure_animals_TO_animals 
	foreign key (animals_oid) 
	references Animal;
	
	alter table Enclosure_Animals 
	add constraint FK_enclosure_animals_TO_enclosure 
	foreign key (enclosure_oid) 
	references Enclosure;
	
	
	--Animal_Keeper Relation Table
	create table Animal_Keeper (
	animal_oid varchar(36) not null, 
	keeper_oid varchar(36) not null, 
	order_index bigint,
	primary key ( animal_oid, keeper_oid));
	
	alter table Animal_Keeper 
	add constraint FK_animal_keeper_TO_keeper 
	foreign key (keeper_oid) 
	references Zookeeper;
	
	alter table Animal_Keeper 
	add constraint FK_animal_keeper_TO_animal 
	foreign key (animal_oid) 
	references Animal;
	
	
	
