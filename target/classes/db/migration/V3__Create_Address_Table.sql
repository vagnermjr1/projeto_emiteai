CREATE TABLE IF NOT EXISTS endereco (
                                        id SERIAL PRIMARY KEY,
                                        cep VARCHAR(9) NOT NULL,
    numero VARCHAR(10),
    complemento VARCHAR(100),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(2)
    );
