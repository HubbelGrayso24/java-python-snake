package io.hubbell.fung.snake;

public class RandomMovementStrategy implements MovementStrategy {
    @Override
    public void updateDirection(Snake snake) {
        int random = (int) (Math.random() * 4);
        switch (random) {
            case 0 -> snake.setDirection(Direction.UP);
            case 1 -> snake.setDirection(Direction.DOWN);
            case 2 -> snake.setDirection(Direction.LEFT);
            case 3 -> snake.setDirection(Direction.RIGHT);
        }
    }
}
