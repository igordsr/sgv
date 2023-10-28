create table usuario (
                         data_nascimento date not null,
                         id uuid PRIMARY KEY not null,
                         email varchar(255) not null,
                         nome varchar(255) not null,
                         rg varchar(255) not null,
                         senha varchar(255) not null,
                         primary key (id)
)