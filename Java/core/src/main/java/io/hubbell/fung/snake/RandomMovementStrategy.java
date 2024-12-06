package io.hubbell.fung.snake;

import java.util.Random;

// Movement strategy that randomly selects directionality
// removing user input and focusing on just the implementation
public class RandomMovementStrategy implements MovementStrategy {
    private final Random rand = new Random();

    @Override
    public void updateDirection(Snake snake) {
        int random = rand.nextInt(4);
        switch (random) {
            case 0 -> snake.setDirection(Direction.UP);
            case 1 -> snake.setDirection(Direction.DOWN);
            case 2 -> snake.setDirection(Direction.LEFT);
            case 3 -> snake.setDirection(Direction.RIGHT);
        }
    }
}
