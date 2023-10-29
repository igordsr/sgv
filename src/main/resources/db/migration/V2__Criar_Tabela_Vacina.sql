CREATE TABLE vacina(
                       id UUID PRIMARY KEY,
                       nome_vacina VARCHAR(255),
                       dose_vacina VARCHAR(255),
                       numero_lote INT,
                       quantidade INT
);



CREATE TABLE vacina_aplicada(
                        id UUID PRIMARY KEY,
                        vacina_id  UUID,
                        nome_vacina VARCHAR(255),
                        dose_vacina VARCHAR(255),
                        data_aplicacao DATE,
                        numero_lote INT,
                        FOREIGN KEY (vacina_id) REFERENCES vacina(id)
);