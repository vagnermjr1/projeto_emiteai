CREATE TABLE IF NOT EXISTS pessoa (
                                      id SERIAL PRIMARY KEY,
                                      nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE,
    telefone VARCHAR(15)
    );
