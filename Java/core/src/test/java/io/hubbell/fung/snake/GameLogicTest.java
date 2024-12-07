package io.hubbell.fung.snake;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {
    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        gameLogic = new GameLogic(100, 100);
    }

    @Test
    void testInit() {
        assertNotNull(gameLogic);
        assertEquals(1, gameLogic.getSnakeLength());
        assertEquals(50, gameLogic.getSnakeX());
        assertEquals(50, gameLogic.getSnakeY());
    }
}
