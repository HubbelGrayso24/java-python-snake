package io.hubbell.fung.snake;

import org.junit.jupiter.api.Test;

public class SnakeSegmentTest {
    @Test
    public void testSnakeSegmentInit() {
        SnakeSegment segment = new SnakeSegment(0, 0);
        assert segment.getX() == 0;
        assert segment.getY() == 0;
    }

    @Test
    public void testCollision() {
        SnakeSegment segment1 = new SnakeSegment(0, 0);
        SnakeSegment segment2 = new SnakeSegment(0, 0);
        assert segment1.collidesWith(segment2);
    }
}
