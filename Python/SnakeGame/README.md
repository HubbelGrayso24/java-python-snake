# Snake

A Python project implementing the classic Snake game using Pygame.

## Project Structure

- `game.py`: Main game logic and event handling.
- `snake.py`: Snake class implementation.
- `food.py`: Food class implementation.
- `game_state.py`: Game state management.
- `play_game.py`: Script to start the game.
- `Tests/`: Unit tests for the game components.
- `Sound/`: Directory containing sound effects.

## Requirements

This project uses [Pygame](https://www.pygame.org/) for game development. Install the required dependencies using:

```sh
pip install -r requirements.txt
```

To run the game:
```sh
python play_game.py
```

## Additional Information

This is a simple snake game made with Python and Pygame. We wanted to
showcase the simplicity of Pygame and how relatively easy it is to develop.
The game is made using Pygame's own structure, and while does use classes, does
not rely on OOP principles. This has pros and cons as we discuss in the paper,
but it does demonstrate how a single developer or small team can create a simple
game without building complex class structures.

To run the game, you will need to have Python and Pygame installed. Pygame is the
only dependency, and is listed in the requirements.txt file. We used PyCharm to develop
and run the game, but so long as you have Pygame it should run.

The game code is divided into the food, game, game_state, and snake files. To run the game
open the Test directory and run the play_game.py file. This will start the interactive game
and you can play snake using the arrow keys. The game will end when the snake runs into itself
or the wall.

There are also additional tests in the Test directory that can demonstrate the game's functionality.
These tests are python unittests, and can be run using the unittest module in Python. Again, we developed
these tests in PyCharm, which is likely the easiest way to run them.