DO $$
BEGIN

    IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'emiteai') THEN
        CREATE DATABASE emiteai
            WITH
            OWNER = postgres
            ENCODING = 'UTF8'
            LC_COLLATE = 'pt_BR.UTF-8'
            LC_CTYPE = 'pt_BR.UTF-8'
            TEMPLATE = template0;
END IF;
END $$;
