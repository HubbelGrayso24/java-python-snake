import pygame
import sys
from snake import Snake
from food import Food

# Sound effects
# pygame.mixer.init()
# pygame.mixer.Sound("Sound\itemPickUp.mp3")

class Game:
    def __init__(self, gameState):
        pygame.init()
        self.window = pygame.display.set_mode((gameState.windowWidth, gameState.windowHeight))
        pygame.display.set_caption("Snake Game (OOP)")
        self.clock = pygame.time.Clock()
        self.snake = Snake(gameState)
        self.food = Food(gameState)
        self.score = 0
        self.gameState = gameState
        self.pickup_sound = pygame.mixer.Sound("Sound/ItemPickup.mp3")  # Initialize the sound


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
            self.pickup_sound.play()  # Play the sound when the snake eats the food
            

        if self.snake.check_collision():
            print(f"Game Over! Your score was: {self.score}")
            pygame.quit()
            sys.exit()

    def draw(self):
        self.window.fill(self.gameState.BLACK)
        # Draw the snake
        for segment in self.snake.body:
            rect = pygame.Rect(segment[0] * self.gameState.gridSize,
                               segment[1] * self.gameState.gridSize,
                               self.gameState.gridSize, self.gameState.gridSize)
            pygame.draw.rect(self.window, self.gameState.GREEN, rect)

        # Draw the food
        food_rect = pygame.Rect(self.food.position[0] * self.gameState.gridSize,
                                self.food.position[1] * self.gameState.gridSize,
                                self.gameState.gridSize, self.gameState.gridSize)
        pygame.draw.rect(self.window, self.gameState.RED, food_rect)

        # Display score
        font = pygame.font.SysFont("Arial", 30)
        score_surface = font.render(f"Score: {self.score}", True, self.gameState.WHITE)
        self.window.blit(score_surface, (10, 10))

        pygame.display.flip()

    def run(self):
        while True:
            self.handle_events()
            self.update()
            self.draw()
            self.clock.tick(self.gameState.FPS)