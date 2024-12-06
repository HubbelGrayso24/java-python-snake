package io.hubbell.fung.snake;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {
    Food food;

    @BeforeEach
    void setup() {
        food = new Food(25, 25);
    }

    @Test
    void testFoodInstantiation() {
        assertEquals(25, food.getX());
        assertEquals(25, food.getY());
    }

    @Test
    void testSnakeCollision() {
        SnakeSegment segment = new SnakeSegment(15, 15);
        assertTrue(food.collidesWith(segment));
    }

    @Test
    void testSnakeDoesNotCollide() {
        SnakeSegment segment = new SnakeSegment(50, 50);
        assertFalse(food.collidesWith(segment));
    }
}
