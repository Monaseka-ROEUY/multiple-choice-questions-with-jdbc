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
4. **Sample Data You can add more**
   ```postgres-sql
   -- Insert questions
   INSERT INTO questions (title) VALUES
   ('What is the output of 3 + 2 * 2 in Java?'),
   ('Which data structure uses LIFO?'),
   ('What is the file extension for a Java source file?'),
   ('Which keyword is used to create a subclass in Java?'),
   ('What is the output of 10 % 3 in Java?'),
   ('Which language is known as the language of the web?'),
   ('Which symbol is used to denote a single-line comment in Python?'),
   ('What is the output of print(2 ** 3) in Python?'),
   ('Which function is used to read a line of text in Java?'),
   ('What is the default value of an uninitialized int variable in Java?'),
   ('Which keyword is used to declare a constant in Java?'),
   ('Which method is used to start a thread in Java?'),
   ('What does SQL stand for?'),
   ('Which operator is used to concatenate strings in Java?'),
   ('What is the output of the expression 5 == 5.0 in Java?'),
   ('Which method is used to convert a string to an integer in Java?'),
   ('What is the output of True and False in Python?'),
   ('What does HTML stand for?'),
   ('Which symbol is used to denote a block of code in Python?'),
   ('What is the purpose of the "import" statement in Python?');
   
   -- Insert answers
   INSERT INTO answers (answer_text, is_correct, question_id) VALUES
   -- Question 1
   ('7', false, 1),
   ('10', false, 1),
   ('7', true, 1),
   -- Question 2
   ('Queue', false, 2),
   ('Stack', true, 2),
   ('Array', false, 2),
   -- Question 3
   ('.js', false, 3),
   ('.class', false, 3),
   ('.java', true, 3),
   -- Question 4
   ('extends', true, 4),
   ('implements', false, 4),
   ('inherits', false, 4),
   -- Question 5
   ('3', true, 5),
   ('1', false, 5),
   ('2', false, 5),
   -- Question 6
   ('Python', false, 6),
   ('C++', false, 6),
   ('JavaScript', true, 6),
   -- Question 7
   ('#', true, 7),
   ('//', false, 7),
   ('/*', false, 7),
   -- Question 8
   ('6', false, 8),
   ('8', true, 8),
   ('9', false, 8),
   -- Question 9 (corrected)
   ('readLine()', false, 9),
   ('input()', false, 9),
   ('nextLine()', true, 9),
   -- Question 10
   ('0', true, 10),
   ('null', false, 10),
   ('undefined', false, 10),
   -- Question 11
   ('constant', false, 11),
   ('static', false, 11),
   ('final', true, 11),
   -- Question 12
   ('start()', true, 12),
   ('run()', false, 12),
   ('execute()', false, 12),
   -- Question 13
   ('Structured Query Language', true, 13),
   ('Sequential Query Language', false, 13),
   ('Standard Query Language', false, 13),
   -- Question 14
   ('+', true, 14),
   ('&', false, 14),
   ('*', false, 14),
   -- Question 15
   ('true', true, 15),
   ('false', false, 15),
   ('error', false, 15),
   -- Question 16
   ('toInt()', false, 16),
   ('parseInt()', true, 16),
   ('intValue()', false, 16),
   -- Question 17
   ('True', false, 17),
   ('False', true, 17),
   ('Error', false, 17),
   -- Question 18
   ('Hyper Text Markup Language', true, 18),
   ('High Text Markup Language', false, 18),
   ('Hyperlinks and Text Markup Language', false, 18),
   -- Question 19
   ('Indentation', true, 19),
   ('Brackets', false, 19),
   ('Parentheses', false, 19),
   -- Question 20
   ('Include external libraries', false, 20),
   ('Import code from other files', true, 20),
   ('Define a module', false, 20);
   ```
5. **Database Connection**
   - Modify **database name**, **username** and **password** in **DatabaseConnection.class** with yours in package: 
   ```
   package com.kaka.simplified.utils
   ```
6. **Finally run the program in Main class**