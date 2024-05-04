DO $$
DECLARE
column_exists INT;
BEGIN
    -- Verifica se a coluna endereco_id já existe na tabela pessoa
SELECT COUNT(*)
INTO column_exists
FROM information_schema.columns
WHERE table_name = 'pessoa'
  AND column_name = 'endereco_id';

-- Se a coluna não existir, adiciona a coluna endereco_id à tabela pessoa
IF column_exists = 0 THEN
ALTER TABLE pessoa
    ADD COLUMN endereco_id INT;

-- Adiciona a restrição de chave estrangeira fk_endereco
ALTER TABLE pessoa
    ADD CONSTRAINT fk_endereco
        FOREIGN KEY (endereco_id)
            REFERENCES endereco(id);
END IF;
END $$;