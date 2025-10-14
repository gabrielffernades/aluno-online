# Aluno Online - API Backend

Sistema de gerenciamento de alunos desenvolvido com Spring Boot para fins acadêmicos.

## 📋 Sobre o Projeto

O **Aluno Online** é uma API REST desenvolvida em Java com Spring Boot que permite o gerenciamento básico de informações de alunos. O sistema oferece operações CRUD (Create, Read, Update, Delete) para manipulação de dados de estudantes.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Maven**

## 🏗️ Arquitetura

O projeto segue a arquitetura em camadas (Layered Architecture):

```
src/main/java/br/com/alunoonline/api/
├── controller/     # Camada de controle (REST endpoints)
├── service/        # Camada de serviço (lógica de negócio)
├── repository/     # Camada de acesso a dados
└── model/          # Entidades do domínio
```

## 📊 Modelo de Dados

### Entidade Aluno
- **ID**: Identificador único (auto-gerado)
- **Nome Completo**: Nome completo do aluno
- **Email**: Endereço de email
- **CPF**: Cadastro de Pessoa Física

## 🔧 Configuração do Ambiente

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+
- PostgreSQL 12+

### Configuração do Banco de Dados

1. Instale e configure o PostgreSQL
2. Crie um banco de dados chamado `aluno_online`
3. Configure as credenciais no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/aluno_online
spring.datasource.username=postgres
spring.datasource.password=postgres
```

### Executando a Aplicação

1. Clone o repositório:
```bash
git clone https://github.com/gabrielffernades/aluno-online.git
cd aluno-online
```

2. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📚 Endpoints da API

### Base URL
```
http://localhost:8080/alunos
```

### Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/alunos` | Criar um novo aluno |
| `GET` | `/alunos` | Listar todos os alunos |
| `GET` | `/alunos/{id}` | Buscar aluno por ID |

### Exemplos de Uso

#### Criar um novo aluno
```bash
curl -X POST http://localhost:8080/alunos \
  -H "Content-Type: application/json" \
  -d '{
    "completName": "João Silva",
    "email": "joao.silva@email.com",
    "cpf": "123.456.789-00"
  }'
```

#### Listar todos os alunos
```bash
curl -X GET http://localhost:8080/alunos
```

#### Buscar aluno por ID
```bash
curl -X GET http://localhost:8080/alunos/1
```



## 🔄 Funcionalidades

- ✅ Cadastro de alunos
- ✅ Listagem de todos os alunos
- ✅ Busca de aluno por ID
- ✅ Persistência de dados no PostgreSQL
- ✅ Validação automática de entidades


## 🎥 Demonstrações da API

Aqui estão alguns exemplos práticos de como usar a API:

- **[Criar Aluno](https://drive.google.com/file/d/1DLCu6atNleSUHkb7kGnIZlXeCb5xeNiq/view?usp=drive_link)** - Demonstração de como criar um novo aluno usando Insomnia
- **[Buscar Aluno por ID](https://drive.google.com/file/d/1fB77bwbIXov3dJm2S7NE9NPJzYq7Izz_/view?usp=drive_link)** - Exemplo de busca de aluno específico por ID
- **[Listar Todos os Alunos](https://drive.google.com/file/d/1F0qHMqOJl-uExMBsyckF6IcpzD83_yh6/view?usp=drive_link)** - Demonstração de listagem completa de alunos
- **[Banco de Dados](https://drive.google.com/file/d/1nxjbZgq9SE2xpiMKfWderdEEYe62-D9C/view?usp=drive_link)** - Visualização do banco PostgreSQL no DBeaver com dados inseridos


## 👨‍💻 Autor

**Gabriel Fernandes**
- GitHub: [@gabrielffernades](https://github.com/gabrielffernades)




