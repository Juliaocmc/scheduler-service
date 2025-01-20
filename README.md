# Virtual Scheduling - Backend

O **Virtual Scheduling Backend** é a parte responsável pela lógica de negócios e persistência de dados do sistema de agendamento de contatos e compromissos. Ele é desenvolvido em **Java 17** com **Spring 3.4.1**.

## Requisitos

Antes de começar, verifique se você tem os seguintes softwares instalados em sua máquina:

- **Java 17** (JDK)
- **Maven** (para gerenciar o projeto)
- **Docker** (para rodar o banco de dados)

## Como Instalar

### 1. Instalar o Java 17

Para instalar o **Java 17**, siga os passos abaixo:

#### **Windows / macOS**:
- Acesse o site oficial do OpenJDK: [https://jdk.java.net/17/](https://jdk.java.net/17/)
- Baixe a versão correspondente ao seu sistema operacional e siga as instruções de instalação.

#### **Linux (Ubuntu/Debian)**:
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### 2. Instalar o Docker
Caso o Docker não esteja instalado, siga as instruções abaixo:

#### Windows / macOS:
Baixe o Docker Desktop [aqui](https://www.docker.com/products/docker-desktop/).

### Linux (Ubuntu/Debian):
```
sudo apt update
sudo apt install docker.io
sudo systemctl start docker
sudo systemctl enable docker
```

Verifique se o Docker foi instalado corretamente com:
```
docker --version
```

## Como Configurar o Banco de Dados
### 1. Rodar o Banco de Dados PostgreSQL com Docker
Para rodar o banco de dados PostgreSQL necessário para o projeto, execute o comando abaixo:
```
docker run --name postgres_db -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password -e POSTGRES_DB=scheduler-db -p 5432:5432 -d postgres:latest
```
Este comando irá:

 * Baixar a imagem mais recente do PostgreSQL.
 * Criar um contêiner chamado postgres_db com as credenciais e banco de dados configurados.
 * Mapear a porta 5432 do contêiner para a porta 5432 da sua máquina.

## Como Executar o Projeto
### 1. Compilar o Projeto
Com o Java 17 e Maven instalados, compile o projeto com o comando:
```
mvn clean install
```

### 2. Executar o Projeto
Para rodar a aplicação localmente, use o comando:
```
mvn spring-boot:run
```
Isso iniciará o servidor na porta padrão (8080), e você poderá acessar a API no endereço: http://localhost:8080.

### 3. Parâmetros de Banco de Dados
Certifique-se de que o banco de dados PostgreSQL está rodando antes de iniciar o backend. O Spring Boot conectará automaticamente ao banco de dados conforme as configurações no arquivo application.properties.

## Funcionalidades
* Gerenciamento de Contatos: API para adicionar, listar e excluir contatos.
* Agendamento de Reuniões/Eventos: API para criar, listar, editar e excluir compromissos.
* Autenticação e Autorização: Sistema de login utilizando JWT para autenticação segura.

## Tecnologias Utilizadas
* Java 17: Ambiente de execução para a aplicação.
* Spring 3.4.1: Framework para o desenvolvimento do backend.
* PostgreSQL: Banco de dados relacional utilizado para persistência.
* Docker: Utilizado para rodar o banco de dados PostgreSQL.
