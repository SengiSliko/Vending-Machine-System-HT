# Vending Machine Application

A full-stack vending machine simulation system built with Spring Boot and Angular. This application simulates a real vending machine with product management, payment processing, and change calculation capabilities.

## Features

- Product management with real-time stock tracking
- Dynamic shopping cart functionality
- Payment processing with denomination handling
- Automatic change calculation and validation
- Transaction history tracking
- Admin interface for inventory management
- Exception handling for various scenarios
- RESTful API architecture

## Tech Stack

### Backend
- Java 23
- Spring Boot
- Hibernate
- postgresql database
- JUnit 5
- Maven

### Frontend
- Angular 6+
- TypeScript
- Tailwind CSS
- RxJS
- Angular CLI

## Project Structure

```
vending-machine/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/VendingApi/
│   │   │   │       ├── config/
│   │   │   │       ├── controller/
│   │   │   │       ├── dto/
│   │   │   │       ├── entity/
│   │   │   │       ├── exception/
│   │   │   │       ├── mapper/
│   │   │   │       ├── repository/
│   │   │   │       └── service/
│   │   │   └── resources/
│   │   └── test/
│   └── pom.xml
└── frontend/
    ├── src/
    │   ├── app/
    │   │   ├── components/
    │   │   ├── services/
    │   │   ├── models/
    │   │   └── shared/
    │   ├── assets/
    │   └── environments/
    ├── package.json
    └── angular.json
```

## Setup Instructions

### Backend Setup

1. Clone the repository:
```bash
git clone https://github.com/yourusername/vending-machine.git
```

2. Navigate to backend directory:
```bash
cd vending-machine/backend
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The backend server will start on `http://localhost:8080`

### Frontend Setup

1. Navigate to frontend directory:
```bash
cd vending-machine/frontend
```

2. Install dependencies:
```bash
npm install
```

3. Run the application:
```bash
ng serve
```

The frontend application will start on `http://localhost:4200`

## API Endpoints

### Products
- GET `/api/products` - Get all products
- GET `/api/products/{id}` - Get product by ID
- POST `/api/products` - Create new product
- PUT `/api/products/{id}` - Update product
- DELETE `/api/products/{id}` - Delete product

### Transactions
- POST `/api/transactions/process` - Process new transaction
- GET `/api/transactions` - Get transaction history
- GET `/api/transactions/{id}` - Get transaction by ID

## Database Schema

### Product Table
```sql
CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock_quantity INTEGER NOT NULL,
    color VARCHAR(50),
    image VARCHAR(255)
);
```

### Transaction Table
```sql
CREATE TABLE transaction (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    total_amount DECIMAL(10,2) NOT NULL,
    amount_paid DECIMAL(10,2) NOT NULL,
    change_amount DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    timestamp DATETIME NOT NULL
);
```

### Cash_Inventory Table
```sql
CREATE TABLE cash_inventory (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    denomination VARCHAR(20) NOT NULL,
    quantity INTEGER NOT NULL
);
```

## Assumptions

1. Currency is in South African Rand (R)
2. Available denominations: R5, R10, R20, R50, R100
3. Products must have stock quantity ≥ 0
4. Prices must be positive values
5. System maintains sufficient change for transactions

## Error Handling

The system handles various exceptions including:
- Insufficient stock
- Insufficient payment
- Unable to provide change
- Invalid denominations
- Product not found
- System errors

## Testing

Run backend tests:
```bash
mvn test
```

Run frontend tests:
```bash
ng test
```

## Security Considerations

1. CORS configuration is implemented
2. Input validation on both frontend and backend
3. Transaction atomicity using @Transactional
4. Error messages don't expose system details
5. Proper exception handling and logging


## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



## Acknowledgments

- Spring Boot documentation
- Angular documentation
- Postgressql database
- Tailwind CSS

## Contact

Your Name - sonosengi@gmail.com



## UML Diagrams: 


#Transaction flow: 

![image](https://github.com/user-attachments/assets/7e2aaef9-8947-4f0b-92dd-d5a1c70c534f)

#Backend System UML Diagram: 
![image](https://github.com/user-attachments/assets/dbdb951d-313a-4da7-a789-4f0177d65597)

#frontend System UML Diagram: 
![image](https://github.com/user-attachments/assets/e17806d0-c38b-49a3-b451-0eb1f8c1adcf)






