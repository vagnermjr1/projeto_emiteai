# Use a imagem oficial do Node.js como base
FROM node:14.21.3

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo package.json e package-lock.json para o diretório de trabalho
COPY package.json package-lock.json ./

# Instale as dependências do projeto
RUN npm install

# Copie todos os arquivos do projeto para o diretório de trabalho
COPY . .

# Exponha a porta em que a aplicação será executada
EXPOSE 3000

# Comando padrão para iniciar a aplicação
CMD ["npm", "start"]