

class Snake:
    # Initialize the snake with a single segment
    def __init__(self, gameState):
        self.body = [[gameState.gridWidth // 2, gameState.gridHeight // 2]]
        self.direction = (0, 0)  # Don't start til keypress
        self.grow = False
        self.gameState = gameState

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
        if head[0] < 0 or head[0] >= self.gameState.gridWidth or head[1] < 0 or head[1] >= self.gameState.gridHeight:
            return True
        return False