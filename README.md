# Spring Boot GraphQL Order Management Service 🚀

A Spring Boot based **schema-first GraphQL Order Management Service** that provides APIs for managing Users and Orders with a One-to-Many relationship (User → Orders) using Spring Data JPA and MySQL.

---

## 📌 Overview

This project demonstrates:
- Schema-first GraphQL design using `schema.graphqls`
- Queries and Mutations for Users and Orders  
- Resolver mappings using `@QueryMapping` and `@MutationMapping`
- JPA entity relationships (One-to-Many)
- Clean, modular backend architecture  
- Postman-based API testing with environment variables  

---

## 🛠️ Tech Stack

- Java 17  
- Spring Boot  
- Spring GraphQL  
- Spring Data JPA (Hibernate)  
- MySQL  
- Maven  
- Postman  
- GraphiQL  

---

## 🏗️ High-Level Architecture

```

Client (Postman / GraphiQL)
↓
POST /graphql
↓
Spring GraphQL Dispatcher
↓
schema.graphqls (Schema-first)
↓
@QueryMapping / @MutationMapping (Resolvers)
↓
Spring Data JPA (Repositories)
↓
MySQL Database

````

---

## 📌 GraphQL Schema (Core)

### User
```graphql
type User {
  userId: ID
  name: String
  phone: String
  email: String
  orders: [Order]
}
````

### Order

```graphql
type Order {
  orderId: ID
  orderDetail: String
  address: String
  price: Int
  user: User
}
```

### Queries

```graphql
type Query {
  getUsers: [User]
  getUser(userId: ID!): User
  getOrders: [Order]
  getOrder(orderId: ID!): Order
}
```

### Mutations

```graphql
type Mutation {
  createUser(name: String, phone: String, email: String, password: String): User
  deleteUser(userId: ID!): Boolean

  createOrder(orderDetail: String, address: String, price: Int, userId: ID!): Order
  deleteOrder(orderId: ID!): Boolean
}
```

---

## 🔥 Key Features

* Schema-first GraphQL API
* Full CRUD operations for Users and Orders
* Nested queries (User with Orders, Order with User)
* JPA One-to-Many mapping
* GraphQL variables support
* Organized Postman collection with env variables

---

---

## 📬 Postman Collection

Download and import the ready-made Postman collection:

🔗 **Postman Collection:**
✅ [Download Postman Collection](https://github.com/UrsTrulyDeep/spring-boot-graphql-order-service/blob/main/postman/spring-boot-graphql-order-service-organized-postman-collection.json?raw=true)

**How to import:**

1. Open Postman → Click **Import**
2. Choose **Upload Files**
3. Select the JSON file
4. Click **Import**

---

## 🧪 Sample GraphQL Queries

### Get All Users

```graphql
{
  getUsers {
    userId
    name
    email
    orders {
      orderId
      orderDetail
      price
    }
  }
}
```

### Create User

```graphql
mutation {
  createUser(
    name: "Deep Kushwaha",
    phone: "6386613507",
    email: "21deepkushwaha3@gmail.com",
    password: "deep123"
  ) {
    userId
    name
  }
}
```

### Create Order

```graphql
mutation {
  createOrder(
    orderDetail: "First order of Deep",
    address: "Pune",
    price: 1500,
    userId: 1
  ) {
    orderId
    orderDetail
  }
}
```
