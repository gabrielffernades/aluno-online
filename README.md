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

### Entidade Professor
- **ID**: Identificador único (auto-gerado)
- **Nome**: Nome do professor
- **Email**: Endereço de email
- **CPF**: Cadastro de Pessoa Física

### Entidade Disciplina
- **ID**: Identificador único (auto-gerado)
- **Nome**: Nome da disciplina
- **Professor**: Relacionamento com a entidade Professor (Many-to-One)

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

### Endpoints de Aluno

#### Base URL
```
http://localhost:8080/alunos
```

#### Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/alunos` | Criar um novo aluno |
| `GET` | `/alunos` | Listar todos os alunos |
| `GET` | `/alunos/{id}` | Buscar aluno por ID |

### Endpoints de Professor

#### Base URL
```
http://localhost:8080/professores
```

#### Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/professores` | Criar um novo professor |
| `GET` | `/professores` | Listar todos os professores |
| `GET` | `/professores/{id}` | Buscar professor por ID |
| `PUT` | `/professores/{id}` | Atualizar professor por ID |
| `DELETE` | `/professores/{id}` | Deletar professor por ID |

### Endpoints de Disciplina

#### Base URL
```
http://localhost:8080/disciplinas
```

#### Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/disciplinas` | Criar uma nova disciplina |
| `GET` | `/disciplinas` | Listar todas as disciplinas |
| `GET` | `/disciplinas/{id}` | Buscar disciplina por ID |
| `PUT` | `/disciplinas/{id}` | Atualizar disciplina por ID |
| `DELETE` | `/disciplinas/{id}` | Deletar disciplina por ID |

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

### Exemplos de Uso - Professor

#### Criar um novo professor
```bash
curl -X POST http://localhost:8080/professores \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria Santos",
    "email": "maria.santos@email.com",
    "cpf": "987.654.321-00"
  }'
```

#### Listar todos os professores
```bash
curl -X GET http://localhost:8080/professores
```

#### Buscar professor por ID
```bash
curl -X GET http://localhost:8080/professores/1
```

#### Atualizar professor por ID
```bash
curl -X PUT http://localhost:8080/professores/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria Santos Silva",
    "email": "maria.silva@email.com",
    "cpf": "987.654.321-00"
  }'
```

#### Deletar professor por ID
```bash
curl -X DELETE http://localhost:8080/professores/1
```

### Exemplos de Uso - Disciplina

#### Criar uma nova disciplina
```bash
curl -X POST http://localhost:8080/disciplinas \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Programação Java",
    "professor": {
      "id": 1
    }
  }'
```

#### Listar todas as disciplinas
```bash
curl -X GET http://localhost:8080/disciplinas
```

#### Buscar disciplina por ID
```bash
curl -X GET http://localhost:8080/disciplinas/1
```

#### Atualizar disciplina por ID
```bash
curl -X PUT http://localhost:8080/disciplinas/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Programação Java Avançada",
    "professor": {
      "id": 1
    }
  }'
```

#### Deletar disciplina por ID
```bash
curl -X DELETE http://localhost:8080/disciplinas/1
```

## 🔄 Funcionalidades

### Aluno
- ✅ Cadastro de alunos
- ✅ Listagem de todos os alunos
- ✅ Busca de aluno por ID
- ✅ Persistência de dados no PostgreSQL
- ✅ Validação automática de entidades

### Professor
- ✅ Cadastro de professores
- ✅ Listagem de todos os professores
- ✅ Busca de professor por ID
- ✅ Atualização de professor por ID
- ✅ Deleção de professor por ID
- ✅ Persistência de dados no PostgreSQL
- ✅ Validação automática de entidades

### Disciplina
- ✅ Cadastro de disciplinas
- ✅ Listagem de todas as disciplinas
- ✅ Busca de disciplina por ID
- ✅ Atualização de disciplina por ID
- ✅ Deleção de disciplina por ID
- ✅ Relacionamento com Professor (Many-to-One)
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




