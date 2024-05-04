DO $$
DECLARE
table_exists INT;
BEGIN

SELECT COUNT(*)
INTO table_exists
FROM information_schema.tables
WHERE table_name = 'pessoa';


IF table_exists = 0 THEN
CREATE TABLE pessoa (
                        id SERIAL PRIMARY KEY,
                        nome VARCHAR(100) NOT NULL,
                        cpf VARCHAR(14) UNIQUE,
                        telefone VARCHAR(15)
);
END IF;
END $$;