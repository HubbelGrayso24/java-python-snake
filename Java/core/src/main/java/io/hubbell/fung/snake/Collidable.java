package io.hubbell.fung.snake;


// This allows any surface or type to check if it will collide with the snake
// No other objects can collide with eachother in this game, so the SnakeSegment is
// the relevant object.
public interface Collidable {
    boolean collidesWith(SnakeSegment other);
}
