create table unidade (
                         registro_unidade integer not null,
                         id uuid not null,
                         nome varchar(255) not null,
                         situacao varchar(255) not null,
                         vacinas varchar(255) not null,
                         primary key (id)
)