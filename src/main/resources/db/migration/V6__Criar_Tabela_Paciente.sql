create table paciente (
                          id uuid primary key not null,
                          id_carteira_vacina uuid unique,
                          FOREIGN KEY (id) REFERENCES usuario(id),
                          FOREIGN KEY (id_carteira_vacina) REFERENCES carteira_vacina(id)
)