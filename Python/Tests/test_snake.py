import unittest
from snake import Snake
from game_state import GameState


windowWidth = 800
windowHeight = 600
gridSize = 20
FPS = 10
game_state = GameState(windowWidth, windowHeight, gridSize, FPS)

class SnakeTests(unittest.TestCase):
    def test_snake_init(self):
        snake = Snake(game_state)
        self.assertEqual(len(snake.body), 1)
        self.assertEqual(snake.body[0], [game_state.gridWidth // 2, game_state.gridHeight // 2])
        self.assertEqual(snake.direction, (0, 0))

    def test_snake_move(self):
        move_states = [(1,0), (0,1), (-1,0), (0,-1)]
        for dx, dy in move_states:
            snake = Snake(game_state)
            snake.change_direction((dx, dy))
            snake.move()
            self.assertEqual(snake.body[0], [game_state.gridWidth // 2 + dx, game_state.gridHeight // 2 + dy])

    def test_snake_growth(self):
        snake = Snake(game_state)
        snake.grow_snake()
        snake.move()
        self.assertEqual(len(snake.body), 2)
        snake.move()
        self.assertEqual(len(snake.body), 2)

    def test_snake_collision(self):
        snake = Snake(game_state)
        self.assertFalse(snake.check_collision())
        snake.body = [[0, 0], [0, 1], [1, 1], [1, 0], [0, 0]]
        self.assertTrue(snake.check_collision())

if __name__ == '__main__':
    unittest.main()
