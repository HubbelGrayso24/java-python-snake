package io.hubbell.fung.snake;

// Defines a movement strategy command pattern for the
// snake to follow.
public interface MovementStrategy {
    void updateDirection(Snake snake);
}
