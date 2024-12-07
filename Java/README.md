# Java Snake Game

A LibGDX Java implementation of the classic Snake game.

## Project Structure

- `core` - The main project module containing the game logic and rendering.
  - `Snake` - The snake object itself.
  - `SnakeSegment` - The individual renderable segments of the snake.
  - `Food` - The food object that the snake eats.
  - `DefaultMovementStrategy` - The player interactable movement strategy. 
  - `RandomMovementStrategy` - The random movement strategy for the snake.
  - `Game` - The main game class that initializes the game and interacts with LibGDX.
  - `GameEntity` - The base class for all game entities.
  - `GameLogic` - The main game logic class containing the primary update loop.
  - `EatFoodSound` - The sound effect for when the snake eats food.
- `desktop` - The desktop launcher for the game.
  - `Lwjgl3Launcher` - The configuration class for desktop, LibGDX's naming scheme.
  - `PlayGame` - The main class for launching the user interactable game on desktop.
  - `PlayRandomGame` - The main class for launching the random movement snake on desktop.
  - `StartupHelper` - A helper class for launching the game.

## Requirements

This project uses Java 21 and Gradle. There are several maven dependencies that are included in the
build.gradle file. The project is built using LibGDX. It was built using IntelliJ.

## Running the Game

To run the game, execute the main class `PlayGame` in the `lwjgl3` module, LibGDX's naming scheme. This will launch the game
in a window. The game can be played using the arrow keys. There is no border collision detection, and
the snake will wrap around the screen. The game will reset if the snake collides with itself. To quit,
close the window, press ESC or press q.

To observe the games functions in an amusing way, run the `PlayRandomGame` class in the `lwjgl3` module, LibGDX's naming scheme.
This will launch a snake that moves randomly around the screen. It will continue until the game is exited.

There are also additional test files that demonstrate the functionality of specifc components. These can be run
from the io.hubbell.yuri.snake test package.

There is also a demonstration of multithreading using a subpackage in the `core` module. This can be run from the
`MultithreadedCounter` class in the `core` module under the Demos directory.

## Game Description

This is a simple snake game implemented in Java. The game is implemented using LibGDX.
We wanted to highlight the additional flexibility and understandability that OOP provides
when compared to linear programming. This game uses SOLID principles and is built using 
LibGDX's design patterns. The game design pattern relies on an update, render loop which is
a part of every piece of the codebase. The game is also designed to be highly adaptable and
could grow into a more complex game with additional features with relative ease.




