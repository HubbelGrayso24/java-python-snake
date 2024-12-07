# CSCI 5448 Grad Project: Implementation of Snake and OOP Concepts
This project demonstrates the use of Object-Oriented Programming (OOP) principles and multithreading/multiprocessing techniques in Python. It includes examples of encapsulation, inheritance, and polymorphism, as well as the implementation of the classic Snake game.

---

## **1. Python OOP Examples**
This section showcases key OOP principles: **Encapsulation**, **Inheritance**, and **Polymorphism**.

### **Encapsulation (`encapsulation.py`)**
- Demonstrates controlled access to private attributes using Python's `@property` decorator.
- The `Character` class encapsulates its health attribute, ensuring it cannot drop below zero.
- **Key Features**:
    - Encapsulation via protected attributes.
    - Controlled access through getter and setter methods.
- **Output**:
  Displays initial health, updates after damage, and ensures health remains non-negative.

---

### **Inheritance (`inheritance.py`)**
- Demonstrates inheritance using an `Animal` base class and its `Dog` and `Cat` subclasses.
- The subclasses override the `speak` method to provide specific implementations.
- **Key Features**:
    - Reuse of a base class.
    - Method overriding in child classes to showcase polymorphism.
- **Output**:
  Shows the unique behaviors of `Dog` and `Cat` through overridden methods.

---

### **Polymorphism (`polymorphism.py`)**
- Demonstrates polymorphism with a `Shape` base class and its `Rectangle` and `Circle` subclasses.
- Each subclass implements its own versions of `area` and `perimeter` methods.
- **Key Features**:
    - Use of a common interface (`Shape`) to handle different subclasses.
    - Specific implementations of methods in child classes.
- **Output**:
  Computes and displays the area and perimeter of different shapes.

---

## **2. Multithreading and Multiprocessing Demos**
### **File: `multiprocessingAndmultithreading_demo.py`**
- Demonstrates sequential, multithreading, and multiprocessing execution models.
- **Key Features**:
    - A shared counter is incremented:
        - Sequentially (no threads or processes).
        - Using multithreading (multiple threads).
        - Using multiprocessing (multiple processes).
    - Execution times are measured and compared for all three methods.
- **Output**:
    - Displays the time taken for sequential execution, multithreading, and multiprocessing.
    - Highlights the efficiency gains of parallelism over sequential execution.

---

## **3. Snake Game Implementation**
### **File: `snake_game.py`**
- Implements the classic Snake game using Pygame, showcasing how OOP principles like encapsulation and inheritance are applied in game development.
- **Key Features**:
    - A `Snake` class to manage the player's snake.
    - A `Game` class to handle the game loop, user input, and rendering.
    - Utilizes Pygame for graphical output and event handling.
- **Usage**:
    - Run the script to play the Snake game.
    - Move the snake using arrow keys, and avoid collisions with the screen borders or the snake itself.
- **Output**:
    - Interactive game that ends when the snake collides with itself or the screen borders.

For additional details on the snake game's implementation, see `Snake.md` [here](Snake.md).

---

## **Conclusion**
This project highlights Python's versatility in demonstrating OOP principles, implementing games, and leveraging multithreading/multiprocessing for parallelism. Each file serves as a standalone demonstration and can be run independently to explore these concepts in action.
