# Aluno Online - API Backend

Sistema de gerenciamento de alunos desenvolvido com Spring Boot para fins acadêmicos.

## 📋 Sobre o Projeto

O **Aluno Online** é uma API REST desenvolvida em Java com Spring Boot que permite o gerenciamento de informações acadêmicas. O sistema oferece operações CRUD (Create, Read, Update, Delete) completas para manipulação de dados de alunos, professores e disciplinas, com relacionamentos entre as entidades.

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
| `PUT` | `/alunos/{id}` | Atualizar aluno por ID |
| `DELETE` | `/alunos/{id}` | Deletar aluno por ID |

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

#### Atualizar aluno por ID
```bash
curl -X PUT http://localhost:8080/alunos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "completName": "João Silva Santos",
    "email": "joao.santos@email.com",
    "cpf": "123.456.789-00"
  }'
```

#### Deletar aluno por ID
```bash
curl -X DELETE http://localhost:8080/alunos/1
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

## 🔍 API de Pesquisa Interativa

A API de Pesquisa Interativa permite realizar consultas dinâmicas e seguras nas tabelas do sistema, com suporte a filtros e exportação para CSV.

### Base URL
```
http://localhost:8080/interactive-search
```

### Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/interactive-search/tables` | Lista todas as tabelas permitidas |
| `GET` | `/interactive-search/{table}/columns` | Lista as colunas permitidas de uma tabela |
| `POST` | `/interactive-search/query` | Executa uma query com filtros e retorna JSON |
| `POST` | `/interactive-search/export-csv` | Executa uma query e retorna os resultados em CSV |

### Tabelas e Colunas Permitidas

#### Tabela: `aluno`
Colunas: `id`, `completName`, `email`, `cpf`

#### Tabela: `professor`
Colunas: `id`, `nome`, `email`, `cpf`

#### Tabela: `disciplina`
Colunas: `id`, `name`, `professor_id`

### Operações de Filtro

As seguintes operações são suportadas:
- `contains`: Busca parcial (case-insensitive) - usa ILIKE
- `equals`: Igualdade exata
- `gte`: Maior ou igual (>=)
- `lte`: Menor ou igual (<=)

### Limites

- **Limite padrão**: 200 registros
- **Limite máximo**: 1000 registros

### Exemplos de Uso

#### 1. Listar Tabelas Disponíveis

**Insomnia:**
```
GET http://localhost:8080/interactive-search/tables
```

**cURL:**
```bash
curl -X GET http://localhost:8080/interactive-search/tables
```

**Resposta:**
```json
["aluno", "professor", "disciplina"]
```

#### 2. Listar Colunas de uma Tabela

**Insomnia:**
```
GET http://localhost:8080/interactive-search/aluno/columns
```

**cURL:**
```bash
curl -X GET http://localhost:8080/interactive-search/aluno/columns
```

**Resposta:**
```json
["id", "completName", "email", "cpf"]
```

#### 3. Executar Query Simples

**Insomnia:**
```
POST http://localhost:8080/interactive-search/query
Content-Type: application/json

{
  "table": "aluno",
  "columns": ["id", "completName", "email"],
  "filters": [
    {
      "field": "completName",
      "op": "contains",
      "value": "joao"
    }
  ],
  "limit": 100
}
```

**cURL:**
```bash
curl -X POST http://localhost:8080/interactive-search/query \
  -H "Content-Type: application/json" \
  -d '{
    "table": "aluno",
    "columns": ["id", "completName", "email"],
    "filters": [
      {
        "field": "completName",
        "op": "contains",
        "value": "joao"
      }
    ],
    "limit": 100
  }'
```

**Resposta:**
```json
{
  "rows": [
    {
      "id": 1,
      "completName": "João Silva",
      "email": "joao.silva@email.com"
    }
  ]
}
```

#### 4. Query com Múltiplos Filtros

**Insomnia:**
```
POST http://localhost:8080/interactive-search/query
Content-Type: application/json

{
  "table": "aluno",
  "columns": ["id", "completName", "email", "cpf"],
  "filters": [
    {
      "field": "completName",
      "op": "contains",
      "value": "silva"
    },
    {
      "field": "cpf",
      "op": "equals",
      "value": "123.456.789-00"
    }
  ],
  "limit": 200
}
```

**cURL:**
```bash
curl -X POST http://localhost:8080/interactive-search/query \
  -H "Content-Type: application/json" \
  -d '{
    "table": "aluno",
    "columns": ["id", "completName", "email", "cpf"],
    "filters": [
      {
        "field": "completName",
        "op": "contains",
        "value": "silva"
      },
      {
        "field": "cpf",
        "op": "equals",
        "value": "123.456.789-00"
      }
    ],
    "limit": 200
  }'
```

#### 5. Query em Professores

**Insomnia:**
```
POST http://localhost:8080/interactive-search/query
Content-Type: application/json

{
  "table": "professor",
  "columns": ["id", "nome", "email"],
  "filters": [
    {
      "field": "nome",
      "op": "contains",
      "value": "maria"
    }
  ],
  "limit": 50
}
```

#### 6. Query em Disciplinas

**Insomnia:**
```
POST http://localhost:8080/interactive-search/query
Content-Type: application/json

{
  "table": "disciplina",
  "columns": ["id", "name", "professor_id"],
  "filters": [],
  "limit": 100
}
```

#### 7. Exportar Resultados para CSV

**Insomnia:**
```
POST http://localhost:8080/interactive-search/export-csv
Content-Type: application/json

{
  "table": "aluno",
  "columns": ["id", "completName", "email", "cpf"],
  "filters": [
    {
      "field": "completName",
      "op": "contains",
      "value": "joao"
    }
  ],
  "limit": 500
}
```

**cURL:**
```bash
curl -X POST http://localhost:8080/interactive-search/export-csv \
  -H "Content-Type: application/json" \
  -d '{
    "table": "aluno",
    "columns": ["id", "completName", "email", "cpf"],
    "filters": [
      {
        "field": "completName",
        "op": "contains",
        "value": "joao"
      }
    ],
    "limit": 500
  }' \
  --output alunos_export.csv
```

**Resposta:** Arquivo CSV será baixado automaticamente com o nome `export_aluno_[timestamp].csv`

### Tratamento de Erros

A API retorna erros em formato JSON:

**Erro 400 - Bad Request:**
```json
{
  "error": "Tabela inválida ou não permitida: tabela_inexistente"
}
```

**Exemplos de erros comuns:**
- Tabela não permitida
- Coluna não permitida
- Operação de filtro inválida
- Limite excedido (máximo 1000)

**Erro 500 - Internal Server Error:**
```json
{
  "error": "Erro ao executar query: [detalhes do erro]"
}
```

### Notas Importantes

1. **Segurança**: A API utiliza whitelist para tabelas e colunas, garantindo que apenas dados permitidos sejam consultados.

2. **Nomes de Colunas**: Os nomes das colunas devem corresponder exatamente aos nomes no banco de dados. Com a configuração atual (`PhysicalNamingStrategyStandardImpl`), as colunas mantêm o nome exato do Java (camelCase). Se você alterar a estratégia de naming, ajuste o mapa `ALLOWED_COLUMNS` no arquivo `InteractiveSearchService.java`.

3. **Localização do Whitelist**: O mapa de colunas permitidas está definido em:
   ```
   src/main/java/br/com/alunoonline/api/service/InteractiveSearchService.java
   ```
   Linha ~30: `ALLOWED_COLUMNS`

4. **Performance**: Para grandes volumes de dados, sempre defina um `limit` apropriado. O limite padrão é 200 registros.

5. **Filtro `contains`**: Utiliza `ILIKE` do PostgreSQL, que é case-insensitive. O valor é automaticamente envolvido com `%` (ex: "joao" vira "%joao%").

## 🔄 Funcionalidades

### Aluno
- ✅ Cadastro de alunos
- ✅ Listagem de todos os alunos
- ✅ Busca de aluno por ID
- ✅ Atualização de aluno por ID
- ✅ Deleção de aluno por ID
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

### Pesquisa Interativa
- ✅ Listagem de tabelas permitidas
- ✅ Listagem de colunas por tabela
- ✅ Query dinâmica com filtros (contains, equals, gte, lte)
- ✅ Exportação de resultados para CSV
- ✅ Validação de segurança com whitelist
- ✅ Limite de registros configurável (máx. 1000)

## 🎥 Demonstrações da API

Aqui estão alguns exemplos práticos de como usar a API:

- **[Criar Aluno](https://drive.google.com/file/d/1DLCu6atNleSUHkb7kGnIZlXeCb5xeNiq/view?usp=drive_link)** - Demonstração de como criar um novo aluno usando Insomnia
- **[Buscar Aluno por ID](https://drive.google.com/file/d/1fB77bwbIXov3dJm2S7NE9NPJzYq7Izz_/view?usp=drive_link)** - Exemplo de busca de aluno específico por ID
- **[Listar Todos os Alunos](https://drive.google.com/file/d/1F0qHMqOJl-uExMBsyckF6IcpzD83_yh6/view?usp=drive_link)** - Demonstração de listagem completa de alunos
- **[Banco de Dados](https://drive.google.com/file/d/1nxjbZgq9SE2xpiMKfWderdEEYe62-D9C/view?usp=drive_link)** - Visualização do banco PostgreSQL no DBeaver com dados inseridos


## 👨‍💻 Autor

**Gabriel Fernandes**
- GitHub: [@gabrielffernades](https://github.com/gabrielffernades)




