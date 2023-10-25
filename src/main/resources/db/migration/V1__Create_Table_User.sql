CREATE TABLE Usuario (
                         id UUID PRIMARY KEY,
                         nome VARCHAR(255),
                         email VARCHAR(255),
                         senha VARCHAR(255),
                         tipoUsuario VARCHAR(255),
                         rg VARCHAR(255),
                         dataNascimento DATE
);
