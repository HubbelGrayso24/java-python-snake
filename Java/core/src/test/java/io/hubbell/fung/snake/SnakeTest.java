package io.hubbell.fung.snake;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {
    Snake snake;

    @BeforeEach
    void setUp() {
        snake = new Snake(100, 100);
    }

    @Test
    void testCollidesWithSelf() {
        assertFalse(snake.collidesWithSelf());
        snake.grow();
        snake.move();
        snake.setDirection(Direction.UP);
        snake.grow();
        snake.move();
        snake.setDirection(Direction.LEFT);
        snake.grow();
        snake.move();
        snake.setDirection(Direction.DOWN);
        snake.grow();
        snake.move();
        assertTrue(snake.collidesWithSelf());
    }

    @Test
    void testCollidesWithFood() {
        Food food = new Food(110, 110);
        assertTrue(snake.collidesWith(food));
    }

    @Test
    void testSetDirectionUp() {
        snake.setDirection(Direction.UP);
        assertEquals(Direction.UP, snake.getDirection());
    }

    @Test
    void testMoveUp() {
        testSetDirectionUp();
        snake.move();
        assertEquals(100 + GameEntity.HEIGHT , snake.getY());
    }

    @Test
    void testGrow() {
        snake.grow();
        snake.move();
        assertEquals(2, snake.getLength());
        snake.move();
        snake.grow();
        assertEquals(3, snake.getLength());
    }

    @Test
    void testYWrapping() {
        snake.setDirection(Direction.UP);
        for (int i=100; i < Game.WORLD_HEIGHT; i += (int) GameEntity.HEIGHT) {
            snake.move();
        }
        assertTrue(snake.getY() < Game.WORLD_HEIGHT);
        assertEquals(0, snake.getY());

        snake.setDirection(Direction.DOWN);
        snake.move();
        assertTrue(snake.getY() > 0);
        assertEquals(Game.WORLD_HEIGHT - GameEntity.HEIGHT, snake.getY());
    }

    @Test
    void testXWrapping() {
        snake.setDirection(Direction.RIGHT);
        for (int i=100; i < Game.WORLD_WIDTH; i += (int) GameEntity.WIDTH) {
            snake.move();
        }
        assertTrue(snake.getX() < Game.WORLD_WIDTH);
        assertEquals(0, snake.getX());

        snake.setDirection(Direction.LEFT);
        snake.move();
        assertTrue(snake.getX() > 0);
        assertEquals(Game.WORLD_WIDTH - GameEntity.WIDTH, snake.getX());
    }

    @Test
    void testReset() {
        snake.move();
        snake.grow();
        snake.move();
        snake.reset();
        assertEquals(1, snake.getLength());
        assertEquals(100, snake.getX());
        assertEquals(100, snake.getY());
    }
}
