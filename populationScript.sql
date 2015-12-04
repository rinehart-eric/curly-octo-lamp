#Create tables
create table Game (
	title varchar(255) not null,
    game_release_date date not null,
    franchise_name varchar(255),
    primary key(title, game_release_date),
    foreign key(franchise_name) references Franchise
);

create table Franchise (
	franchise_name varchar(255) not null,
    game_count integer not null,
    first_release_date Date not null
);

create table Game_Platform(
	game_title varchar(255) not null,
    game_release_date date not null,
    platform_name varchar(255) not null,
    release_date_on_platform date not null,
    sales integer not null,
    primary key(game_title, game_release_date, platform_name),
    check (sales > 0),
    foreign key (game_title, game_release_date) references game,
    foreign key (platform_name) references platform
);

create table Platform (
	platform_name varchar(255) not null unique,
    platform_release_date date not null,
    primary key(platform_name)
);

create table Developer_Studio (
	developer_name varchar(255) not null unique,
    date_founded date not null
);

create table developed_by (
	developer_name varchar(255) not null,
    game_title varchar(255) not null,
    game_release_date date not null,
    primary key(developer_name, game_title, game_release_date),
    foreign key(developer_name) references developer_studio,
    foreign key(game_title, game_release_date) references game
);

create table produced_by (
	producer_name varchar(255) not null,
    game_title varchar(255) not null,
    game_release_date date not null,
    primary key (producer_name, game_title, game_release_date),
    foreign key(producer_name) references producer_studio,
    foreign key(game_title,game_release_date) references game
);

create table Producer_Studio (
	producer_name varchar(255) not null unique,
    date_founded date not null,
    primary key(producer_name)
);

#add games
insert into game values ("fallout 4", 2015-11-28, "fallout");
insert into game values ("fallout 3", 2008-10-28, "fallout");
insert into game values ("mass effect", 2007-11-27,"mass effect");
insert into game values ("mass effect 2", 2010-1-26, "mass effect");
insert into game values ("mass effect 3", 2012-3-6, "mass effect");
insert into game values ("call of duty 4", 2007-11-5, "call of duty");
insert into game values ("call of duty: world at war", 2008-11-11, "call of duty");

#add franchises
insert into franchise values("fallout", 2, 2008-10-28);
insert into franchise values("mass effect", 3, 2007-11-27);
insert into franchise values("call of duty", 2, 2007-11-5);

#add platforms
insert into platform values("pc",2000-1-1);
insert into platform values("xbox 360", 2005-11-22);
insert into platform values("xbox one", 2013-11-22);
insert into platform values("playstation 3", 2006-11-11);
insert into platform values("playstation 4", 2013-11-15);

#add developer studios

#add producer studios

#add game platform relations

#add produced by relations

#add developed by relations

