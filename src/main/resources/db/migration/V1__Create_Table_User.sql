create table usuario (
    data_nascimento date not null,
    numero_coren integer not null,
    id uuid not null,
    id_carteira_vacina uuid unique,
    tipo_usuario varchar(31) not null,
    email varchar(255) not null,
    nome varchar(255) not null,
    rg varchar(255) not null,
    senha varchar(255) not null,
    primary key (id)
)