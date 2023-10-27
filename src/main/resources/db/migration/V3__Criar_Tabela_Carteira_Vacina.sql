CREATE TABLE carteira_vacina (
                                numero_sus integer not null,
                                id uuid primary key not null,
                                usuario_id uuid unique,
                                vacina_aplicada_id uuid not null,
                                FOREIGN KEY (usuario_id) REFERENCES usuario(id),
                                FOREIGN KEY (vacina_aplicada_id) REFERENCES vacina(id)
);