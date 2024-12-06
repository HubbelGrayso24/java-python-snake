package io.hubbell.fung.snake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

// Food is a game entity as it exists on the game board, and it is renderable and collidable
public class Food extends GameEntity implements Renderable, Collidable {

    public Food(float x, float y) {
        super(x, y);
    }

    // This takes in the system renderer, which is passed in.
    @Override
    public void render(ShapeRenderer renderer) {
        renderer.setColor(Color.RED);
        renderer.rect(getX(), getY(), WIDTH, HEIGHT);
    }

    // Method checks for any collisions with the snake.
    @Override
    public boolean collidesWith(SnakeSegment other) {
        boolean xCollision = (this.getX() < other.getX() + WIDTH) &&
            (this.getX() + WIDTH > other.getX()); // Is it within the x boundary
        boolean yCollision = (this.getY() < other.getY() + HEIGHT) &&
            (this.getY() + HEIGHT > other.getY()); // Is it within the y boundary
        return xCollision && yCollision;
    }
}
