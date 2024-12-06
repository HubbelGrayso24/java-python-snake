package io.hubbell.fung.snake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SnakeSegment extends GameEntity implements Renderable, Collidable {
    public static final float WIDTH = 20f;
    public static final float HEIGHT = 20f;

    public SnakeSegment(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(ShapeRenderer renderer) {
        renderer.setColor(Color.GREEN);
        renderer.rect(getX(), getY(), WIDTH, HEIGHT);
    }

    @Override
    public boolean collidesWith(SnakeSegment other) {
        boolean xCollision = (this.getX() < other.getX() + WIDTH) && (this.getX() + WIDTH > other.getX());
        boolean yCollision = (this.getY() < other.getY() + HEIGHT) && (this.getY() + HEIGHT > other.getY());
        return xCollision && yCollision;
    }
}
