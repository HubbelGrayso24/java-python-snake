package io.hubbell.fung.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.hubbell.fung.snake.Game;

public abstract class GameEntity {
    private float x;
    private float y;

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

    public void setPosition(float x, float y) {
        setX(x);
        setY(y);
    }
}
