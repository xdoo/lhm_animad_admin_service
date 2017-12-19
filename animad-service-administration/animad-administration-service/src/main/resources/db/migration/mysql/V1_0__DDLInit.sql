	-- This file is for MYSQL

	--**************************
	--Tables
	--**************************
	
	create table Enclosure (
	oid varchar(36),
	name varchar(30) not null, 
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
	
	create table Keeper (
	oid varchar(36),
	firstname varchar(30) not null, 
	lastname varchar(30) not null, 
	employmentdate datetime not null, 
	birthday datetime not null, 
	salary bigint not null, 
	primary key (oid));
	
	--Enclosure_AnimalList Relation Table
	create table Enclosure_AnimalList (
	enclosure_oid varchar(36) not null, 
	animalList_oid varchar(36) not null unique, 
	order_index bigint,
	primary key ( enclosure_oid, animalList_oid));
	
	alter table Enclosure_AnimalList 
	add constraint FK_enclosure_animalList_TO_animalList 
	foreign key (animalList_oid) 
	references Animal(oid);
	
	alter table Enclosure_AnimalList 
	add constraint FK_enclosure_animalList_TO_enclosure 
	foreign key (enclosure_oid) 
	references Enclosure(oid);
	
	
	--Animal_KeeperList Relation Table
	create table Animal_KeeperList (
	animal_oid varchar(36) not null, 
	keeperList_oid varchar(36) not null, 
	order_index bigint,
	primary key ( animal_oid, keeperList_oid));
	
	alter table Animal_KeeperList 
	add constraint FK_animal_keeperList_TO_keeperList 
	foreign key (keeperList_oid) 
	references Keeper(oid);
	
	alter table Animal_KeeperList 
	add constraint FK_animal_keeperList_TO_animal 
	foreign key (animal_oid) 
	references Animal(oid);
	
	
	
