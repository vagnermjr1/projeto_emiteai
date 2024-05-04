DO $$
DECLARE
column_exists INT;
BEGIN

SELECT COUNT(*)
INTO column_exists
FROM information_schema.columns
WHERE table_name = 'pessoa'
  AND column_name = 'endereco_id';


IF column_exists = 0 THEN
ALTER TABLE pessoa
    ADD COLUMN endereco_id INT;


ALTER TABLE pessoa
    ADD CONSTRAINT fk_endereco
        FOREIGN KEY (endereco_id)
            REFERENCES endereco(id);
END IF;
END $$;