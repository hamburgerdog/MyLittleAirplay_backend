# 项目简介
`My little airplay`的项目后台，主要用于提供歌曲搜索的服务



## 运行方法

数据库DDL

   ```mysql
   # ---- Album ----
   create table Album
   (
   	albumId int auto_increment
   		primary key,
   	albumName varchar(1000) not null,
   	albumCoverUrl varchar(1000) null
   );
   
   # ---- AlbumCollection ----
   create table AlbumCollection
   (
   	userId varchar(200) not null,
   	albumId int not null
   );
   
   # ---- Song ----
   create table Song
   (
   	songId int auto_increment
   		primary key,
   	songName varchar(500) not null,
   	albumId int not null,
   	url varchar(1000) not null,
   	songCoverUrl varchar(1000) null
   );
   
   # ---- SongCollection ----
   create table SongCollection
   (
   	userId varchar(200) not null,
   	songId int not null
   );
   
   create index SongCollection_userId_index
   	on SongCollection (userId);
   
   # ---- User ----
   create table User
   (
   	userKey varchar(10) not null,
   	uuid varchar(100) not null,
   	constraint User_key_uindex
   		unique (userKey),
   	constraint User_uuid_uindex
   		unique (uuid)
   );
   
   alter table User
   	add primary key (userKey);
   
   
   ```