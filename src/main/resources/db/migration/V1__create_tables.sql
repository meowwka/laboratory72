use `chat72`;

CREATE TABLE `users`
(
    `id`   INT auto_increment NOT NULL,
    `name` varchar (128) NOT NULL ,
    PRIMARY KEY (`id`));
    insert into `users` values (1,'User1'), (2,'User2');
CREATE TABLE `chats`
(
    id   int auto_increment primary key not null,
    name varchar(255) not  null,
    time datetime(6) not null
);
    insert into `chats` values (1,'Chat1', CAST('2020-02-20 15:00' as DateTime)),
     (2,'Chat2', CAST('2020-02-20 15:00' as DateTime));
CREATE TABLE `messages`(
    id      int auto_increment primary key,
    text    varchar(255) not null,
    time    datetime(6)  not null,
    user_id int          not null,
    chat_id int          not null,
    constraint `user_fk`
        foreign key (user_id) references `users` (id),
    constraint `chat_fk`
        foreign key (chat_id) references `chats` (id)

);

    insert into `messages` values (1,'Message Text', CAST('2020-01-13 11:00' as DateTime), 1,1),
     (2,'Message Text2', CAST('2020-02-20 15:00' as DateTime), 2,2);









