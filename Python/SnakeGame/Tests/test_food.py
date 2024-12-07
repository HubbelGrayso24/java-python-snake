import unittest
from food import Food
from game_state import GameState

windowWidth = 800
windowHeight = 600
gridSize = 20
FPS = 10
game_state = GameState(windowWidth, windowHeight, gridSize, FPS)

class TestFood(unittest.TestCase):
    def test_food(self):
        food = Food(game_state)
        self.assertTrue(food.position[0] >= 0)
        self.assertTrue(food.position[1] >= 0)
        self.assertTrue(food.position[0] < game_state.gridWidth)
        self.assertTrue(food.position[1] < game_state.gridHeight)

    def test_random_change(self):
        food = Food(game_state)
        init_position = food.position.copy()
        food.randomize_position()
        self.assertNotEqual(init_position, food.position)

    def test_random_change_range(self):
        food = Food(game_state)
        for _ in range(10):
            food.randomize_position()
            self.assertTrue(food.position[0] >= 0)
            self.assertTrue(food.position[1] >= 0)
            self.assertTrue(food.position[0] < game_state.gridWidth)
            self.assertTrue(food.position[1] < game_state.gridHeight)


if __name__ == '__main__':
    unittest.main()
