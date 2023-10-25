CREATE TABLE carteira_vacina (
                                id UUID PRIMARY KEY,
                                idUsuario UUID,
                                numeroSus INT,
                                idVacina UUID,
                                FOREIGN KEY (idUsuario) REFERENCES Usuario(id),
                                FOREIGN KEY (idVacina) REFERENCES vacina_aplicada(id)
);



