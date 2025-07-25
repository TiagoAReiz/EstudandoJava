# EstudandoJava

Projeto fullstack com backend em Java (Spring Boot) e frontend em Angular.

## Descrição

Este projeto tem como objetivo o estudo e implementação de autenticação JWT, cadastro e login de usuários, utilizando boas práticas de arquitetura em Java com Spring Boot no backend e Angular no frontend.

## Funcionalidades

- Cadastro de usuário com validação de e-mail e senha
- Login de usuário com autenticação JWT
- Proteção de rotas utilizando filtro JWT
- Integração com banco de dados via JPA
- Hash de senha com BCrypt

## Estrutura do Projeto

```
Project/
 ├── src/
 │   ├── main/
 │   │   ├── java/group/Reiz/Project/
 │   │   │   ├── Adapters/         # Interfaces e DTOs
 │   │   │   ├── Application/      # Casos de uso
 │   │   │   ├── Controllers/      # Controllers REST
 │   │   │   ├── Core/             # Entidades e interfaces de domínio
 │   │   │   ├── Infra/            # Implementações de infraestrutura (DB, Security)
 │   │   │   └── ProjectApplication.java
 │   └── test/
 ├── pom.xml
 └── README.md

frontend/
 ├── src/
 ├── angular.json
 ├── package.json
 └── README.md
```

## Como rodar o backend

1. Certifique-se de ter o Java 17+ e o Maven instalados.
2. No diretório `Project`, execute:
   ```sh
   ./mvnw spring-boot:run
   ```
3. O backend estará disponível em `http://localhost:8080`.

## Como rodar o frontend

1. Certifique-se de ter o Node.js e o Angular CLI instalados.
2. No diretório `frontend`, execute:
   ```sh
   npm install
   ng serve
   ```
3. O frontend estará disponível em `http://localhost:4200`.

## Endpoints principais

- `POST /user/create` — Criação de usuário
- `POST /user/login` — Login e obtenção do token JWT

## Autores

- [Tiago Reiz](https://github.com/TiagoAReiz)

---

Projeto para estudo e prática de desenvolvimento fullstack utilizando Java (Spring Boot) e Angular.
