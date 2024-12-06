package io.hubbell.fung.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameLogic {
    private final Snake snake;
    private Food food;

    private final float worldWidth;
    private final float worldHeight;

    private float accumulator = 0;
    private final float tick = 0.1f;

    public GameLogic(float worldWidth, float worldHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        snake = new Snake(worldWidth / 2, worldHeight / 2);
        spawnFood();
    }

    public void update(float delta) {
        checkExitCondition();
        snake.updateDirection();
        accumulator += delta;
        if (accumulator >= tick) {
            accumulator -= tick;
            checkSelfCollision();
            checkFoodCollision();
            snake.move();
        }
    }

    private void spawnFood() {
        int x = (int) (Math.random() * (worldWidth - Food.WIDTH));
        int y = (int) (Math.random() * (worldHeight - Food.HEIGHT));
        food = new Food(x, y);
    }

    private void checkFoodCollision() {
        SnakeSegment head = snake.getHead();
        if (food.collidesWith(head)) {
            snake.grow();
            spawnFood();
        }
    }

    private void checkSelfCollision() {
        SnakeSegment head = snake.getHead();
        for (int i = 1; i < snake.getSegments().size(); i++) {
            if (head.collidesWith(snake.getSegments().get(i))) {
                resetGame();
            }
        }
    }

    private void resetGame() {
        snake.reset();
        spawnFood();
    }

    private void checkExitCondition() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) ||
            Gdx.input.isKeyPressed(Input.Keys.Q)) {
            Gdx.app.exit();
        }
    }

    public Snake getSnake() {
        return snake;
    }
    public Food getFood() {
        return food;
    }
}
