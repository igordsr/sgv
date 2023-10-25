CREATE TABLE vacina(
                       id UUID PRIMARY KEY,
                       NomeVacina VARCHAR(255),
                       doseVacina VARCHAR(255),
                       numeroLote INT,
                       quantidade INT
);



CREATE TABLE vacina_aplicada(
                        id UUID PRIMARY KEY,
                        idVacina  UUID,
                        NomeVacina VARCHAR(255),
                        doseVacina VARCHAR(255),
                        data_aplicacao DATE,
                        numeroLote INT,
                        FOREIGN KEY (idVacina) REFERENCES vacina(id)
);