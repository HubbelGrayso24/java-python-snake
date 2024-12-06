package io.hubbell.fung.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class DefaultMovementStrategy implements MovementStrategy {
    @Override
    public void updateDirection(Snake snake) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            snake.setDirection(Direction.UP);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            snake.setDirection(Direction.DOWN);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            snake.setDirection(Direction.LEFT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            snake.setDirection(Direction.RIGHT);
        }
    }
}
