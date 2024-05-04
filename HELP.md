# Cadastro App - Guia de Ajuda

## Tecnologias Utilizadas

### Backend:
- **Spring Boot:** Framework para desenvolvimento rápido de aplicativos Java.
- **Spring Data JPA:** Facilita o acesso e a manipulação de dados em bancos de dados relacionais.
- **Hibernate:** Framework ORM para mapeamento objeto-relacional.
- **Flyway:** Gerenciamento de migrações de banco de dados.
- **JUnity:** Framework de teste unitário para garantir a qualidade do código.
- **Logs:** Todos os registros para auditorias posteriores são armazenados na pasta /logs/log.log.

### Frontend:
- **React:** Biblioteca JavaScript para construção de interfaces de usuário.
- **React Router:** Gerenciamento de rotas na aplicação React para uma navegação suave.
- **Material-UI:** Framework de design de interface de usuário para React, fornecendo componentes estilizados prontos para uso.
- **Axios:** Biblioteca JavaScript usada para fazer solicitações HTTP para interagir com o backend de forma eficiente.
- **CSV:** CSV (Comma-Separated Values) é um formato de arquivo simples usado para armazenar dados tabulares de forma estruturada.

### Infraestrutura:
- **Docker:** Plataforma para desenvolvimento, envio e execução de aplicativos em contêineres, facilitando a padronização e a portabilidade.

---

### Instruções para Subir o Container:
1. Certifique-se de ter o Docker instalado e em execução.
2. Clone o repositório do projeto.
3. Navegue até o diretório raiz do projeto.
4. Execute `docker-compose up postgres` para iniciar o banco de dados PostgreSQL (essa ação é necessária para poder construir o backend).
5. Na pasta ./back, execute o comando `mvn clean install` para compilar e instalar as dependências do projeto Maven.
6. Navegue até o diretório raiz do projeto e execute o comando `docker-compose up --build` para criar e iniciar os contêineres Docker.

---

Este guia deve ajudar você a entender as tecnologias utilizadas na aplicação e como iniciar os servidores backend e frontend, além de como subir o container Docker. Certifique-se de seguir os passos corretamente para garantir o funcionamento adequado da aplicação.
