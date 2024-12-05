# CSCI 5448 Grad Project Implementation of Snake
## Object-Oriented Programming in Java vs Python

### Overview
This project demonstrates the implementation of the classic Snake game using Object-Oriented Programming (OOP) principles in both Java and Python. Below, we discuss the differences in OOP concepts and code implementation between these two languages.

### OOP Concepts in Java and Python
- **Class Definitions**: Both Java and Python use classes to define objects. However, Java requires explicit declaration of class members and methods, while Python allows more flexibility with dynamic typing.
- **Inheritance**: Both languages support inheritance, but Java uses explicit interfaces and abstract classes, whereas Python uses a more straightforward approach with base classes.
- **Encapsulation**: Java enforces encapsulation with access modifiers (public, private, protected), while Python relies on naming conventions (single or double underscores) to indicate private members.
- **Polymorphism**: Both languages support polymorphism, but Java requires method signatures to match exactly, while Python uses duck typing.

### Code Implementation

#### Python Implementation
In Python, the Snake game is implemented with concise and readable code. 
Key components include:
- **Game Loop**: Managed using the `pygame` library.
- **Graphics**: Rendered using `pygame` surfaces and blitting.
- **Event Handling**: Implemented with `pygame.event.get()` for user input.

Example snippet:
```python
import pygame
import random
import sys

# Constants
windowWidth = 800
windowHeight = 600
gridSize = 20
gridWidth = windowWidth // gridSize
gridHeight = windowHeight // gridSize
FPS = 10

# Colors
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
GREEN = (0, 255, 0)
RED = (255, 0, 0)

# Snake Class
class Snake:
    # Initialize the snake with a single segment
    def __init__(self):
        self.body = [[gridWidth // 2, gridHeight // 2]]
        self.direction = (0, 0)  # Don't start til keypress
        self.grow = False

    # Move the snake
    def move(self):
        # Get the current head position
        head_x, head_y = self.body[0]
        # Calculate the new head position
        delta_x, delta_y = self.direction
        new_head = [head_x + delta_x, head_y + delta_y]
        
        if not self.grow:
            self.body.pop()  # Remove the tail unless growing
        else:
            self.grow = False
        self.body.insert(0, new_head)  # Add the new head position

    # Change the direction of the snake
    def change_direction(self, new_direction):
        opposite = (-self.direction[0], -self.direction[1])
        if new_direction != opposite:  # Prevent moving directly backward
            self.direction = new_direction

    # Grow the snake
    def grow_snake(self):
        self.grow = True

    def check_collision(self):
        head = self.body[0]
        # Check if the snake collides with itself
        if head in self.body[1:]:
            return True
        # Check if the snake hits the walls
        if head[0] < 0 or head[0] >= gridWidth or head[1] < 0 or head[1] >= gridHeight:
            return True
        return False
```

### Conclusion
While both Java and Python offer robust support for OOP, their approaches to implementing a game like Snake differ significantly. Java's strict type system and explicit class structures provide clarity and robustness, while Python's dynamic typing and concise syntax offer flexibility and ease of use. This project highlights the strengths and trade-offs of each language in the context of game development.