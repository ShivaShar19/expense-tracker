💰 Expense Tracker
A full-stack expense tracking web application built with Java Spring Boot, React.js, and PostgreSQL.
🚀 Features

JWT-based user authentication (Register/Login)
Add, categorize and delete expenses
Monthly spending summary report
Interactive dashboard with charts
REST APIs for all operations

🛠️ Tech Stack
Backend

Java 17
Spring Boot
Spring Security (JWT)
Spring Data JPA
PostgreSQL
Maven

Frontend

React.js
Recharts (for graphs)
HTML, CSS, Bootstrap

⚙️ How to Run
Prerequisites

Java 17+
PostgreSQL installed and running
Node.js (for frontend)
Maven

Backend Setup

Clone the repository
Open in Spring Tool Suite (STS)
Create a PostgreSQL database named expense_tracker
Update src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/expense_tracker
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

Run ExpenseTrackerApplication.java
Backend runs on http://localhost:8080

Frontend Setup

Go to frontend folder
Run npm install
Run npm start
Frontend runs on http://localhost:3000

📸 Screenshots
Coming soon
🔗 API Endpoints
MethodEndpointDescriptionPOST/api/auth/registerRegister new userPOST/api/auth/loginLogin userGET/api/expensesGet all expensesPOST/api/expensesAdd new expenseDELETE/api/expenses/{id}Delete expenseGET/api/expenses/summaryMonthly summary
👨‍💻 Author
Shivam Kumar

GitHub: @ShivaShar19
Email: shivam.sharma.9966@gmail.com
LinkedIn: Shivam Kumar
