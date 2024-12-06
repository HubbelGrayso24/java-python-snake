

class GameState:
    def __init__(self, windowWidth, windowHeight, gridSize, FPS):
        self.windowWidth = windowWidth
        self.windowHeight = windowHeight
        self.gridSize = gridSize
        self.gridWidth = windowWidth // gridSize
        self.gridHeight = windowHeight // gridSize
        self.FPS = FPS
        self.BLACK = (0, 0, 0)
        self.WHITE = (255, 255, 255)
        self.GREEN = (0, 255, 0)
        self.RED = (255, 0, 0)