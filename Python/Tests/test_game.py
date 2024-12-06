import unittest
from game import Game
from game_state import GameState

windowWidth = 800
windowHeight = 600
gridSize = 20
FPS = 10
game_state = GameState(windowWidth, windowHeight, gridSize, FPS)

class TestGame(unittest.TestCase):
    def test_instantiation(self):
        game = Game(game_state)
        self.assertEqual(game.gameState, game_state)
        self.assertEqual(game.score, 0)
        self.assertEqual(game.snake.body, [[game_state.gridWidth // 2, game_state.gridHeight // 2]])
        self.assertEqual(game.snake.direction, (0, 0))

    def test_handle_events(self):
        game = Game(game_state)
        game.handle_events()
        self.assertEqual(game.snake.direction, (0, 0))

    def test_draw(self):
        game = Game(game_state)
        game.draw()
        self.assertEqual(game.window.get_at((0, 0)), game.gameState.BLACK)

    def test_update(self):
        game = Game(game_state)
        game.snake.change_direction((1, 0))
        expected_pos = [game_state.gridWidth // 2 + 1, game_state.gridHeight // 2 + 0]
        game.update()
        self.assertEqual(game.snake.body, [expected_pos])
        self.assertEqual(game.score, 0)

if __name__ == '__main__':
    unittest.main()
