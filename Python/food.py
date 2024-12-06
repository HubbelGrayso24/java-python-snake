import random

class Food:
    def __init__(self, gameState):
        self.position = [random.randint(0, gameState.gridWidth - 1),
                         random.randint(0, gameState.gridHeight - 1)]
        self.gameState = gameState

    def randomize_position(self):
        self.position = [random.randint(0, self.gameState.gridWidth - 1),
                         random.randint(0, self.gameState.gridHeight - 1)]