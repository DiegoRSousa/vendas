drop table if exists fornecedores;

create table fornecedores (
 id serial primary key,
 nome varchar(20) not null,
 cnpj varchar(18) not null,
 criado_em timestamp not null
);

insert into fornecedores (nome, cnpj, criado_em) values
('Coca Cola', '73.781.975/0001-78', current_timestamp),
('Monster', '73.781.975/0001-78', current_timestamp);