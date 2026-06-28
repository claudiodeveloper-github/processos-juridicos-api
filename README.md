# API de Processos Jurídicos

Projeto desenvolvido como parte de estudos de back-end com Java e Spring Boot, focando em boas práticas de arquitetura, segurança e persistência de dados.

##  Tecnologias Utilizadas
- **Java 25**
- **Spring Boot 4.1.0**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL**
- **Spring Validation**

##  Arquitetura do Projeto

O projeto está estruturado em camadas para garantir alta coesão e baixo acoplamento:

| Camada | Responsabilidade |
| :--- | :--- |
| **Controller** | Recebe as requisições HTTP, valida os dados e define o formato da resposta. |
| **Service** | Centraliza as regras de negócio e validações complexas. |
| **Repository** | Camada de abstração que fala diretamente com o Banco de Dados (JPA). |
| **Model** | Define a estrutura dos dados (Entidades) que representam o domínio do negócio. |

**Fluxo da Requisição:**
`Client (Postman)` -> `Controller` -> `Service` -> `Repository` -> `PostgreSQL`

##  Como executar localmente
1. Tenha o Java 21+ e o PostgreSQL instalados.
2. Crie um banco de dados chamado `processos_db`.
3. Configure as variáveis de ambiente na sua IDE:
   - `DB_USERNAME`: (seu usuário do postgres)
   - `DB_PASSWORD`: (sua senha do postgres)
4. Execute a classe `ProcessosJuridicosApplication`.

##  Documentação
A API expõe os seguintes endpoints:
- `POST /api/processos`: Cria um novo processo.
- `GET /api/processos`: Lista todos os processos.
- `GET /api/processos/{id}`: Busca um processo por ID.
- `PUT /api/processos/{id}`: Atualiza um processo existente.
- `DELETE /api/processos/{id}`: Remove um processo.

---
Desenvolvido por **Cláudio G. S. Castro**
