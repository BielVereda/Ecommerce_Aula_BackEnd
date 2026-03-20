# 🛒 E-commerce API

API RESTful desenvolvida com **Spring Boot** para gerenciamento de um sistema de e-commerce.

Este projeto implementa um backend completo com operações CRUD, relacionamentos entre entidades e estrutura organizada seguindo boas práticas de desenvolvimento.

---

## 🚀 Funcionalidades

* 👤 Gerenciamento de usuários
* 📦 Gerenciamento de produtos
* 🏷️ Categorias de produtos
* 🧾 Criação e controle de pedidos
* 💳 Registro de pagamentos
* 🔐 Controle de perfis (ADMIN / USER)
* 🔄 CRUD completo (Create, Read, Update, Delete)

---

## 🧱 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* Lombok
* H2 / PostgreSQL
* Maven
* Postman

---

## 📂 Estrutura do Projeto

```
com.projeto.ecommerce
│
├── controllers
├── services
├── repositories
├── entities
├── dtos
└── enums
```

---

## 🌐 Base URL

**Local**
```
http://localhost:8080/
```

---
**API**
```
https://ecommercevereda.azurewebsites.net/
```
**Teste API:**

<img width="580" height="248" alt="image" src="https://github.com/user-attachments/assets/55a45304-012d-4e87-96e4-96cb5ec168a4" />

---

# 🔎 Endpoints da API (Local)

---

## 👤 Usuários (`/users`)

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
![post_users.png](images/users/post_users.png)

---

### 📌 Listar usuários

**GET** `/users`
![get_users.png](images/users/get_users.png)
---

### 📌 Atualizar usuário

**PUT** `/users/{id}`

```json
{
  "name": "Novo Nome",
  "email": "novo@email.com",
  "phone": "111111111",
  "roles": "ADMIN"
}
```
![put_users_id.png](images/users/put_users_id.png)
---

### 📌 Deletar usuário

**DELETE** `/users/{id}`
![delete_users.png](images/users/delete_users.png)
---

## 📦 Produtos (`/products`)

### 📌 Criar produto

**POST** `/products`

```json
{
  "name": "Notebook Gamer",
  "description": "RTX 4060, 16GB RAM",
  "price": 7500,
  "imgURL": "https://imagem.com/notebook.jpg",
  "categoriesIds": ["uuid-da-categoria"]
}
```
![post_products.png](images/products/post_products.png)
---

### 📌 Listar produtos

**GET** `/products`
![get_products.png](images/products/get_products.png)
---

### 📌 Buscar por ID

**GET** `/products/{id}`
![get_products_id.png](images/products/get_products_id.png)
---

### 📌 Atualizar produto

**PUT** `/products/{id}`

```json
{
  "name": "Produto Atualizado",
  "description": "Nova descrição",
  "price": 999.99,
  "imgURL": "url",
  "categoriesIds": []
}
```
![put_products_id.png](images/products/put_products_id.png)
---

### 📌 Deletar produto

**DELETE** `/products/{id}`
![delete_products.png](images/products/delete_products.png)
---

## 🏷️ Categorias (`/categories`)

### 📌 Criar categoria

**POST** `/categories`

```json
{
  "name": "Eletrônicos"
}
```
![post_categories.png](images/categories/post_categories.png)
---

### 📌 Listar categorias

**GET** `/categories`
![get_categories.png](images/categories/get_categories.png)
---

### 📌 Buscar por ID

**GET** `/categories/{id}`
![get_categories_id.png](images/categories/get_categories_id.png)
---

### 📌 Atualizar categoria

**PUT** `/categories/{id}`

```json
{
  "name": "Nova Categoria"
}
```
![put_categories_id.png](images/categories/put_categories_id.png)
---

### 📌 Deletar categoria

**DELETE** `/categories/{id}`
![delete_categories.png](images/categories/delete_categories.png)
---

## 🧾 Pedidos (`/orders`)

### 📌 Criar pedido

**POST** `/orders`

```json
{
  "status": "AWAITING_PAYMENT",
  "clientId": "uuid-do-usuario"
}
```
![post_orders.png](images/orders/post_orders.png)
---

### 📌 Listar pedidos

**GET** `/orders`
![get_orders.png](images/orders/get_orders.png)
---

### 📌 Buscar por ID

**GET** `/orders/{id}`
![get_orders_id.png](images/orders/get_orders_id.png)
---

### 📌 Atualizar pedido

**PUT** `/orders/{id}`

```json
{
  "status": "PAID",
  "clientId": "uuid-do-usuario"
}
```
![put_orders_id.png](images/orders/put_orders_id.png)
---

### 📌 Deletar pedido

**DELETE** `/orders/{id}`
![delete_orders.png](images/orders/delete_orders.png)
---

## 💳 Pagamentos (`/payments`)

### 📌 Criar pagamento

**POST** `/payments`

```json
{
  "orderId": "uuid-do-pedido"
}
```
![post_payments.png](images/payments/post_payments.png)
---

### 📌 Listar pagamentos

**GET** `/payments`
![get_payments.png](images/payments/get_payments.png)
---

### 📌 Buscar por ID

**GET** `/payments/{id}`
![get_payments_id.png](images/payments/get_payments_id.png)
---

### 📌 Atualizar pagamento

**PUT** `/payments/{id}`

```json
{
  "moment": "2026-03-18"
}
```
![put_payments_id.png](images/payments/put_payments_id.png)
---

### 📌 Deletar pagamento

**DELETE** `/payments/{id}`
![delete_payments.png](images/payments/delete_payments.png)
---

## 🗄️ Modelo de Dados

### Principais relacionamentos:

* Um usuário possui vários pedidos
* Um pedido possui um pagamento
* Um produto pode ter várias categorias
* Relação Many-to-Many entre Produto e Categoria

---

## ▶️ Como Rodar o Projeto

### 📌 Clonar repositório

```
git clone https://github.com/BielVereda/Ecommerce_Aula_BackEnd.git
```

### 📌 Entrar na pasta

```
cd ecommerce
```

### 📌 Executar aplicação

```
./mvnw spring-boot:run
```

---

## 🧪 Testes

Você pode testar os endpoints utilizando:

* Postman
* Insomnia

---

## 🧠 Melhorias Futuras

* 🔐 Autenticação com JWT
* 📦 Implementação de OrderItem (carrinho real)
* 📄 Documentação com Swagger
* ⚠️ Tratamento global de exceções
* 📊 Paginação de dados
* 🌐 Deploy (Render / Railway / AWS)

---

## 👨‍💻 Autor

Desenvolvido por **BielVereda**

---

## ⭐ Considerações Finais

Este projeto foi desenvolvido com foco em aprendizado e boas práticas no desenvolvimento de APIs REST com Spring Boot.

Sinta-se livre para contribuir, melhorar ou utilizar como base para projetos maiores 🚀
