# Multiple Choice Question Application

## Description

This project is a Java-based application that manages multiple-choice questions and answers using
JDBC for database interaction. The application allows you answer the question with multiple choices
answers and see the score that you got.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- PostgresSQL
- JDBC driver for postgres
- Maven

### Installation

1. **Clone the repository:**

   ```sh
   git clone https://github.com/Monaseka-ROEUY/multiple-choice-questions-with-jdbc.git

2. **Open this project in your favorite code editor**
    - Intellij
    - Eclipse
3. **Configure the database connection:**
    - Create a database
   ```postgres-sql
   CREATE DATABASE databasename; 
   ```
    - Create 2 tables (questions and answers) in your database
   ```postgres-sql
   CREATE TABLE questions (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL
   );
   ```
   ```postgres-sql
   CREATE TABLE answers (
    id SERIAL PRIMARY KEY,
    answer_text TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL,
    question_id INTEGER REFERENCES questions(id)
   );
   ```
4. **Database Connection**
   - Modify **database name**, **username** and **password** in **DatabaseConnection.class** with yours in package: 
   ```
   package com.kaka.simplified.utils
   ```
5. **Finally run the program in Main class**