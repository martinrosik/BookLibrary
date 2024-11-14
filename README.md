# 📚 Java Book Library with CRUD Operations
This is a terminal-based Book Library application in Java, allowing users to manage a collection of books through a simple command-line interface. The application is connected to a MySQL database and supports basic CRUD (Create, Read, Update, Delete) operations.

## 📖 Features
Interactive Command-Line Menu: Provides an easy-to-use numbered menu for navigation.
CRUD Operations:
Add: Insert new books into the library.
Read: View the list of books in the library.
Update: Modify details of an existing book.
Delete: Remove a book from the library.
## 🚀 Getting Started
### 1. Prerequisites
- Java JDK: Ensure you have Java installed on your machine.
- MySQL Database: You'll need a MySQL database to store the book data.
- JDBC Driver: Make sure the JDBC driver for MySQL is added to your project classpath.
### 2. Setting Up the Database
- Create the Database:

Use PHPMyAdmin or your preferred MySQL interface to create a new database.
Name your database (e.g., book_library) and set up a table (e.g., books) with the following columns:
```
id (INT, Primary Key, Auto Increment)
title (VARCHAR)
author (VARCHAR)
publication_year (INT)
```
- Configure Database Connection:

Open the DatabaseConnection.java file in the project.
Replace the placeholder values with your database connection details:
```
private static final String url = "jdbc:mysql://localhost:3306/your_database_name";
private static final String login = "your_username";
private static final String password = "your_password";
```
### 3. Running the Application
- Compile the Code:

```
javac LibrarySystem.java
```
- Run the Application:

```
java LibrarySystem
```
- Using the Application:

Once launched, the application will display a menu in the terminal.
Input the number corresponding to the operation you want to perform (e.g., 1 to add a book).
Follow the prompts to manage your book collection.
## 🛠️ Project Structure
- Main.java: 
  - Main application class with the command-line menu for CRUD operations.
- DatabaseConnection.java: 
    - Manages the database connection settings.
- BookDAO.java:
    - Data Access Object for CRUD operations.
- Book.java:
    - Constructor class for book.
## 📝 Example Usage
Upon running the application, you'll see a menu like this:

```
Book Library
Choose action:
Add - 1
View - 2
Update - 3
Delete - 4
Exit - 5
Enter the number of the operation you want, and follow the prompts!
```
