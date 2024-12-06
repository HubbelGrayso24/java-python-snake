package io.hubbell.fung.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

// Primary game logic workflow, follows the game design pattern.
// Manages the connection between LibGDX and the game code. Ensures
// encapsulation and adherence to the single responsibility principle.
public class GameLogic {
    private final Snake snake;
    private Food food;

    private final float worldWidth;
    private final float worldHeight;

    // This is used to temper the game speed using LibGDX
    private float accumulator = 0;
    private final float tick = 0.1f;

    public GameLogic(float worldWidth, float worldHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        snake = new Snake(worldWidth / 2, worldHeight / 2); // Start the snake in the middle of the board
        spawnFood();
    }

    // Update from the game pattern, checks conditions, then iterates the game.
    public void update(float delta) {
        checkExitCondition();
        snake.updateDirection();
        accumulator += delta;

        // Only move and check for collisions every 0.1 ticks.
        if (accumulator >= tick) {
            accumulator -= tick;
            checkSelfCollision();
            checkFoodCollision();
            snake.move();
        }
    }

    // Randomly select a new spot for the food
    private void spawnFood() {
        int x = (int) (Math.random() * (worldWidth - Food.WIDTH));
        int y = (int) (Math.random() * (worldHeight - Food.HEIGHT));
        food = new Food(x, y);
    }

    // Check the food collision with only the head of the snake
    private void checkFoodCollision() {
        if (snake.collidesWith(food)) {
            snake.grow();
            spawnFood();
        }
    }

    // Check if the snake has collided with itself.
    private void checkSelfCollision() {
        if (snake.collidesWithSelf()) {
            resetGame();
        }
    }

    // Reset game function, simplifies repeated code.
    private void resetGame() {
        snake.reset();
        spawnFood();
    }

    // Check if the user would like to end the game.
    private void checkExitCondition() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) ||
            Gdx.input.isKeyPressed(Input.Keys.Q)) {
            Gdx.app.exit();
        }
    }

    // Ensure encapsulation
    public void renderSnake(ShapeRenderer shapeRenderer) { snake.render(shapeRenderer); }
    public void renderFood(ShapeRenderer shapeRenderer) { food.render(shapeRenderer); }
}
