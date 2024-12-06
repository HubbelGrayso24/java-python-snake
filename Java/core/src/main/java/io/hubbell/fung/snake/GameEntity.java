package io.hubbell.fung.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.hubbell.fung.snake.Game;

// Abstract super class for element on the 2D board.
// Stores position coordinates and provides setters and
// getters for the subclasses. Also provides the default grid
// scale via default width and height.
public abstract class GameEntity {
    private float x;
    private float y;

    public static final float WIDTH = 20f;
    public static final float HEIGHT = 20f;

    GameEntity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
}
