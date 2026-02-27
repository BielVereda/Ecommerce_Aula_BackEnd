# 🛒 Projeto E-commerce API

API RESTful desenvolvida com **Spring Boot** para gerenciamento de um sistema de e-commerce.

O projeto possui:

- 👤 Usuários
- 📦 Produtos
- 🏷️ Categorias
- 🧾 Pedidos
- 💳 Pagamentos
- 🔐 Controle de perfis (ADMIN / USER)

---

## 🧱 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- H2 / PostgreSQL
- Maven
- Postman (para testes)

---

## 📂 Estrutura do Projeto

```
com.projeto.ecommerce
│
├── entities
├── dtos
├── repositories
├── services
├── controllers
└── enums
```


---

# 🔎 Endpoints da API

## 👤 Usuários

### 📌 Criar usuário

**POST** `/users`

```json
{
  "name": "Gabriel",
  "email": "gabriel@email.com",
  "phone": "19999999999",
  "password": "123456",
  "roles": "USER"
}
```
### 📌 Buscar usuário por ID

**GET** `/users/{id}`

---
## 📦 Produtos
### 📌 Criar produto

**POST** `/products`
```
{
  "name": "Notebook Gamer",
  "description": "RTX 4060, 16GB RAM",
  "price": 7500.00,
  "imgURL": "https://imagem.com/notebook.jpg",
  "categoriesIds": ["uuid-da-categoria"]
}
```
### 📌 Listar produtos

**GET** `/products`

---
## 🏷️ Categorias
### 📌 Criar categoria

**POST** `/categories`
```
{
  "name": "Eletrônicos"
}
```

---
## 🧾 Pedidos
### 📌 Criar pedido

**POST** `/orders`
```
{
  "status": "AWAITING_PAYMENT",
  "clientId": "uuid-do-usuario"
}
```

---
## 💳 Pagamento
### 📌 Registrar pagamento

**POST** `/payments`
```
{
  "orderId": "uuid-do-pedido"
}
```

---
## 🖼️ Prints do Postman
### Criando Usuário:

### Criando Produto:

### Criando Pedido:

---
## 🗄️ Modelo de Banco de Dados
### Principais Relacionamentos:

- Um Usuário pode ter vários Pedidos
- Um Pedido possui um Pagamento
- Um Produto pode ter várias Categorias
- Produto e Categoria possuem relacionamento Many-to-Many

---
# ▶️ Como Rodar o Projeto

## Clone o projeto em um local:
```
git clone https://github.com/seu-usuario/seu-repositorio.git
```

## Entre na pasta:
```
cd ecommerce
```

## Rodar aplicação
```
./mvnw spring-boot:run
```

## A API estará disponível em:
```
http://localhost:8080
```

## 🧠 Melhorias Futuras:

- Implementar autenticação com JWT
- Adicionar OrderItem
- Implementar paginação
- Criar documentação com Swagger
- Implementar validações com Bean Validation
- Deploy em produção (Render / Railway / AWS)

## 👨‍💻 Autor

Projeto desenvolvido por BielVereda.
