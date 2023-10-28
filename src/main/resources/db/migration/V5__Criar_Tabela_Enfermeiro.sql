create table enfermeiro (
                            numero_coren integer not null,
                            id uuid primary key not null,
                            FOREIGN KEY (id) REFERENCES usuario(id)
)