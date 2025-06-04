# API complète Produits & Commandes

## 📝 Description

Ce projet consiste en la création d'une API REST modulaire permettant de gérer un catalogue de produits ainsi que les commandes associées.  
Il comprend les entités principales suivantes :
- **Client**
- **Produit**
- **Commande**

Chaque commande peut contenir plusieurs produits, et un client peut passer plusieurs commandes. L'API permet également de calculer dynamiquement le prix total d'une commande.

---

## ⚙️ Technologies utilisées

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- JWT (Json Web Token) *(génération simple par client)*
- Swagger (OpenAPI) pour la documentation
- Maven

---

## 🚀 Instructions pour exécuter le projet

### 🔧 Pré-requis

- JDK 21 ou version compatible
- Maven
- PostgreSQL installé et configuré
- Un IDE (IntelliJ, VS Code, NetBeans, etc.)

### 📂 Étapes

1. **Cloner le projet** :
   ```bash
   git clone https://github.com/PascaJuile/Stock-management-backend.git
   cd backend

2. **Configurer la base de données dans application.properties** :
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/cosmetic_bd
   spring.datasource.username=ton_utilisateur
   spring.datasource.password=ton_mot_de_passe
  
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

3. **Lancer l'application** :
    ```bash
    ./mvnw spring-boot:run

4. **Accéder à la documentation Swagger** :
  http://localhost:8080/swagger-ui/index.html

## ⚠️ Remarques / Blocages :

- Le projet ne gère pas encore le paiement des commandes.
- Le système JWT est utilisé de façon simple, sans authentification : un token est généré à la création d’un client mais n'est pas encore utilisé pour restreindre l'accès aux endpoints.
- Les quantités de produits par commande ne sont pas encore prises en charge (chaque produit est ajouté une seule fois par commande).
- Swagger a été configuré pour faciliter les tests de l'API.
