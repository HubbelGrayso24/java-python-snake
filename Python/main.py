from game_state import GameState
from game import Game

if __name__ == "__main__":
    windowWidth = 800
    windowHeight = 600
    gridSize = 20
    FPS = 10
    gameState = GameState(windowWidth, windowHeight, gridSize, FPS)
    game = Game(gameState)
    game.run()
