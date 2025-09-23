# Assignment 3: Java Programming

## Q1. Encapsulation with Bank Account

Design a `BankAccount` class to demonstrate encapsulation. The class should store account details (`account number`, `account holder`, `balance`) as **private** data members and provide **getter** and **setter** methods to update and display details. Write a program to **deposit** and **withdraw** money securely.

---

### Q2. Inheritance & Polymorphism with Shapes

Create a base class `Shape` with a method `area()`. Derive `Circle` and `Rectangle` classes from it, each overriding the `area()` method. Demonstrate **runtime polymorphism** by calling `area()` using a `Shape` reference for different objects.

---

### Q3. Constructors and Data Abstraction with Student Details

Implement a `Student` class using **data abstraction** that hides details like `roll number`, `name`, and `marks`. Use **parameterized constructors** to initialize values and a **destructor** (`finalize` method) to print a message when the object is destroyed. Demonstrate object creation and destruction in the `main` method.

---

### Q4. Employee Payroll using Inheritance

Create a base class `Employee` with attributes like `name` and `basic salary`. Derive classes `Manager` and `Programmer` that calculate salary differently using **allowances/deductions**. Demonstrate **inheritance** and **polymorphism** by displaying salaries of different employees.

---

### Q5. Library Management with Encapsulation

Design a `Book` class that encapsulates book details (`title`, `author`, `price`). Implement **getters** and **setters** for updating book information. Create multiple book objects and display their details using a method.

---

### Q6. Vehicle Hierarchy with Method Overriding

Build a class hierarchy where `Vehicle` is the base class, and `Car` and `Bike` are derived classes. Override a method `fuelType()` in each subclass to demonstrate **runtime polymorphism**.

---

    ### Q7. Constructor Overloading for Complex Numbers

    Write a class `Complex` that represents complex numbers. Implement **constructor overloading**: one **default constructor**, one **parameterized constructor**, and one **copy constructor**. Create objects using all three constructors and display their values.

---

### Q8. Abstract Class for Shape Perimeter

Define an **abstract class** `Polygon` with an abstract method `perimeter()`. Implement subclasses `Triangle` and `Square` that provide specific implementations. Demonstrate **data abstraction** and **polymorphism** by calling `perimeter()` through a base class reference.

---

### Q9. Student Result with Encapsulation & Constructors

Create a `Student` class with **private attributes** (`roll number`, `name`, `marks in 3 subjects`). Use a **constructor** to initialize the values, and methods to calculate and display the **total** and **grade**. Demonstrate **encapsulation** by providing only controlled access to marks.

---

### Q10. Destructor Simulation with File Handling

**Problem Statement:** Binary to Decimal Conversion

Design a Java program using **Object-Oriented Programming** principles to convert a given binary number into its decimal equivalent. The program should demonstrate **encapsulation** by storing the binary number as a private data member, provide **constructors** to initialize the value, and use appropriate methods to perform the conversion. The solution must ensure **data abstraction** by exposing only necessary operations to the user, and should **validate the input** to confirm that only binary digits (0 and 1) are accepted.
