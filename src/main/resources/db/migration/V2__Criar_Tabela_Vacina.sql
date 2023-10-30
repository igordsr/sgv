CREATE TABLE vacina
(
    id          UUID PRIMARY KEY,
    nome_vacina VARCHAR(255) NOT NULL,
    numero_lote INT          NOT NULL,
    quantidade  INT          NOT NULL
);



CREATE TABLE vacina_aplicada
(
    id                 UUID PRIMARY KEY,
    vacina_id          UUID         NOT NULL,
    carteira_vacina_id UUID         NOT NULL,
    dose_vacina        VARCHAR(255) NOT NULL,
    data_aplicacao     DATE         NOT NULL,
    numero_lote        INT,
    FOREIGN KEY (vacina_id) REFERENCES vacina (id),
    FOREIGN KEY (carteira_vacina_id) REFERENCES carteira_vacina (id)

);