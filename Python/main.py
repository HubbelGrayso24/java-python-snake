import pygame
import random
import sys

# Constants
windowWidth = 800
windowHeight = 600
gridSize = 20
gridWidth = windowWidth // gridSize
gridHeight = windowHeight // gridSize
FPS = 10

# Colors
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
GREEN = (0, 255, 0)
RED = (255, 0, 0)

# Snake Class
class Snake:
    # Initialize the snake with a single segment
    def __init__(self):
        self.body = [[gridWidth // 2, gridHeight // 2]]
        self.direction = (0, 0)  # Don't start til keypress
        self.grow = False

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
        if head[0] < 0 or head[0] >= gridWidth or head[1] < 0 or head[1] >= gridHeight:
            return True
        return False

# Food Class
class Food:
    def __init__(self):
        self.position = [random.randint(0, gridWidth - 1), random.randint(0, gridHeight - 1)]

    def randomize_position(self):
        self.position = [random.randint(0, gridWidth - 1), random.randint(0, gridHeight - 1)]

# Game Class
class Game:
    def __init__(self):
        pygame.init()
        self.window = pygame.display.set_mode((windowWidth, windowHeight))
        pygame.display.set_caption("Snake Game (OOP)")
        self.clock = pygame.time.Clock()
        self.snake = Snake()
        self.food = Food()
        self.score = 0

    # Arrow keys to change direction
    def handle_events(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_UP:
                    self.snake.change_direction((0, -1))
                elif event.key == pygame.K_DOWN:
                    self.snake.change_direction((0, 1))
                elif event.key == pygame.K_LEFT:
                    self.snake.change_direction((-1, 0))
                elif event.key == pygame.K_RIGHT:
                    self.snake.change_direction((1, 0))

    # Update the game state, check for collisions, and check for food
    def update(self):
        self.snake.move()
        # Score and grow snake if it eats the food
        if self.snake.body[0] == self.food.position:
            self.snake.grow_snake()
            self.food.randomize_position()
            self.score += 1

        if self.snake.check_collision():
            print(f"Game Over! Your score was: {self.score}")
            pygame.quit()
            sys.exit()

    def draw(self):
        self.window.fill(BLACK)
        # Draw the snake
        for segment in self.snake.body:
            rect = pygame.Rect(segment[0] * gridSize, segment[1] * gridSize, gridSize, gridSize)
            pygame.draw.rect(self.window, GREEN, rect)

        # Draw the food
        food_rect = pygame.Rect(self.food.position[0] * gridSize, self.food.position[1] * gridSize, gridSize, gridSize)
        pygame.draw.rect(self.window, RED, food_rect)

        # Display score
        font = pygame.font.SysFont("Arial", 30)
        score_surface = font.render(f"Score: {self.score}", True, WHITE)
        self.window.blit(score_surface, (10, 10))

        pygame.display.flip()

    def run(self):
        while True:
            self.handle_events()
            self.update()
            self.draw()
            self.clock.tick(FPS)

# Main Execution
if __name__ == "__main__":
    game = Game()
    game.run()
