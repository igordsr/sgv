CREATE TABLE carteira_vacina (
                                numero_sus integer not null,
                                id uuid primary key not null,
                                usuario_id uuid unique,
                                FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);