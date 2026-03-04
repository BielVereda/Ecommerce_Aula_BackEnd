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

- Java 25
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
<img width="1494" height="587" alt="image" src="https://github.com/user-attachments/assets/fc634616-2460-4fd7-a4cb-6fb853df74ce" />

### 📌 Buscar usuário por ID

**GET** `/users/{id}`
<img width="1475" height="497" alt="image" src="https://github.com/user-attachments/assets/219f0641-0c1d-4092-8888-8687e4729699" />

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
<img width="1494" height="587" alt="image" src="https://github.com/user-attachments/assets/5de7dead-4144-44d1-80a7-0cd1f68a3f90" />

### 📌 Listar produtos

**GET** `/products`
<img width="1475" height="497" alt="image" src="https://github.com/user-attachments/assets/d2aad5f2-c760-4099-aa45-6b527e0fbbaf" />

---
## 🏷️ Categorias
### 📌 Criar categoria

**POST** `/categories`
```
{
  "name": "Eletrônicos"
}
```
<img width="1494" height="406" alt="image" src="https://github.com/user-attachments/assets/6c3b9a77-b2e6-4d69-af2b-654e5df1ad65" />

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
<img width="1494" height="500" alt="image" src="https://github.com/user-attachments/assets/5ae9347f-13ce-472b-b1ae-3e5e74a6de9e" />

---
## 💳 Pagamento
### 📌 Registrar pagamento

**POST** `/payments`
```
{
  "orderId": "uuid-do-pedido"5cc4b4ee-69f0-460e-898c-46a79fb58d68
}
```
<img width="1475" height="423" alt="image" src="https://github.com/user-attachments/assets/95c70be4-c3e1-4534-9bb9-8515774485cc" />

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
