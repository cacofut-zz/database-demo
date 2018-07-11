/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  cristianoca
 * Created: 10/07/2018
 */

create table person(
    id integer not null, 
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);

INSERT INTO person(id, name, location, birth_date)VALUES(1000, 'Cristiano Carvalho Amaral', 'São Paulo',  sysdate()); 