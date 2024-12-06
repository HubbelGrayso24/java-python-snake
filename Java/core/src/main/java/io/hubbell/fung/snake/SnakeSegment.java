package io.hubbell.fung.snake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

// Represents a segment of the snake. The snake is made up of multiple segments
// connected together. This allows the construction of the snake to be independent,
// enforces the SRP and encapsulation, and allows for easy rendering and collision
public class SnakeSegment extends GameEntity implements Renderable, Collidable {
    public SnakeSegment(float x, float y) {
        super(x, y);
    }

    // Render the snake segment as a green rectangle
    @Override
    public void render(ShapeRenderer renderer) {
        renderer.setColor(Color.GREEN);
        renderer.rect(getX(), getY(), WIDTH, HEIGHT);
    }

    // Check if this segment collides with another segment
    @Override
    public boolean collidesWith(SnakeSegment other) {
        boolean xCollision = (this.getX() < other.getX() + WIDTH) && (this.getX() + WIDTH > other.getX());
        boolean yCollision = (this.getY() < other.getY() + HEIGHT) && (this.getY() + HEIGHT > other.getY());
        return xCollision && yCollision;
    }
}
