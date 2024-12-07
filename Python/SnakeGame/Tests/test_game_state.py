import unittest
from game_state import GameState


class GameStateTests(unittest.TestCase):
    def test_game_state(self):
        windowWidth = 800
        windowHeight = 600
        gridSize = 20
        FPS = 10
        game_state = GameState(windowWidth, windowHeight, gridSize, FPS)
        self.assertEqual(game_state.windowWidth, windowWidth)
        self.assertEqual(game_state.windowHeight, windowHeight)
        self.assertEqual(game_state.gridSize, gridSize)
        self.assertEqual(game_state.gridWidth, windowWidth // gridSize)
        self.assertEqual(game_state.gridHeight, windowHeight // gridSize)
        self.assertEqual(game_state.FPS, FPS)
        self.assertEqual(game_state.BLACK, (0, 0, 0))
        self.assertEqual(game_state.WHITE, (255, 255, 255))
        self.assertEqual(game_state.GREEN, (0, 255, 0))
        self.assertEqual(game_state.RED, (255, 0, 0))


if __name__ == '__main__':
    unittest.main()
