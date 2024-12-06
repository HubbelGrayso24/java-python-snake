package io.hubbell.fung.snake;

public interface Collidable {
    boolean collidesWith(SnakeSegment other);
}
