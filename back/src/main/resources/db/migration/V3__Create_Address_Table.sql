DO $$
DECLARE
table_exists INT;
BEGIN

SELECT COUNT(*)
INTO table_exists
FROM information_schema.tables
WHERE table_name = 'endereco';


IF table_exists = 0 THEN
CREATE TABLE endereco (
                          id SERIAL PRIMARY KEY,
                          cep VARCHAR(9) NOT NULL,
                          numero VARCHAR(10),
                          complemento VARCHAR(100),
                          bairro VARCHAR(100),
                          cidade VARCHAR(100),
                          estado VARCHAR(2)
);
END IF;
END $$;
