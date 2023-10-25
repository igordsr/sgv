CREATE TABLE CarteiraVacina (
                                id UUID PRIMARY KEY,
                                idUsuario UUID,
                                numeroSus INT,
                                idVacina UUID,
                                FOREIGN KEY (idUsuario) REFERENCES Usuario(id),
                                FOREIGN KEY (idVacina) REFERENCES Vacina(id)
);



