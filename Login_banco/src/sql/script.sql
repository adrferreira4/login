-- URL JDBC para acessar o banco de dados.
-- jdbc:derby:db;create=true

create table login ( usuario varchar(255), nome varchar(255), senha varchar(255))

select usuario, nome, senha from login

insert into login (usuario, nome, senha) values ('Test', 'Adriel', '0123012')


select
    count(*) as usuario
from
    login