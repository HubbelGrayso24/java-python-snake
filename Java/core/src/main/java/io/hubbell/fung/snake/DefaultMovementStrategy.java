package io.hubbell.fung.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

// This movement strategy is for user input and uses the arrow keys.
public class DefaultMovementStrategy implements MovementStrategy {
    @Override
    public void updateDirection(Snake snake) {
        // This could also be written using InputProcessor and attach functions to that processor.
        // this method was chosen to simplify the implementation as inputs do not need to be instantaneous
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
