package io.hubbell.fung.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;

// This is the primary implementation of the Snake class. It is responsible for
// managing the snake's segments, direction, and movement. It also implements
// the Movable and Renderable interfaces to allow for movement and rendering.
public class Snake implements Movable, Renderable {

    // The list of SnakeSegments that make up the snake. The snake itself is
    // nothing more than a collection of segments.
    private final List<SnakeSegment> segments;

    private Direction direction = Direction.RIGHT;
    private final MovementStrategy movementStrategy;

    private final float startX, startY;

    public Snake(float startX, float startY) {
        segments = new ArrayList<>();
        segments.add(new SnakeSegment(startX, startY));
        movementStrategy = new DefaultMovementStrategy();
        this.startX = startX;
        this.startY = startY;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void updateDirection() {
        movementStrategy.updateDirection(this);
    }

    // The direction is in two parts: the x direction and the y direction. The
    // x direction is -1 for left, 1 for right, and 0 for no movement.
    private int getXDirection() {
        return switch (direction) {
            case LEFT -> -1;
            case RIGHT -> 1;
            default -> 0;
        };
    }

    // The y direction is -1 for down, 1 for up, and 0 for no movement.
    private int getYDirection() {
        return switch (direction) {
            case UP -> 1;
            case DOWN -> -1;
            default -> 0;
        };
    }

    // The move method is responsible for moving the snake. It does this by
    // moving each segment of the snake to the position of the segment in front
    // of it. The head of the snake is then moved in the direction of the snake.
    @Override
    public void move() {
        for (int i = segments.size() - 1; i > 0; i--) {
            segments.get(i).setX(segments.get(i-1).getX());
            segments.get(i).setY(segments.get(i-1).getY());
        }

        SnakeSegment head = segments.getFirst();
        head.setX(head.getX() + getXDirection() * SnakeSegment.WIDTH);
        head.setY(head.getY() + getYDirection() * SnakeSegment.HEIGHT);
        wrap();
    }

    // The wrap method is responsible for wrapping the snake around the screen.
    // If the snake goes off the screen on one side, the head will appear on the
    // opposite side. Thus, the world is continuous.
    private void wrap() {
        SnakeSegment head = segments.getFirst();
        if (head.getX() < 0) {
            head.setX(Game.WORLD_WIDTH - SnakeSegment.WIDTH);
        } else if (head.getX() >= Game.WORLD_WIDTH) {
            head.setX(0);
        }
        if (head.getY() < 0) {
            head.setY(Game.WORLD_HEIGHT - SnakeSegment.HEIGHT);
        } else if (head.getY() >= Game.WORLD_HEIGHT) {
            head.setY(0);
        }
    }

    // The render method is responsible for rendering the snake.
    // The snake is nothing but segments, so render each segment.
    @Override
    public void render(ShapeRenderer renderer) {
        for (SnakeSegment segment : segments) {
            segment.render(renderer);
        }
    }

    // The grow method adds a new segment to the snake.
    public void grow() {
        SnakeSegment tail = segments.getLast();
        segments.add(new SnakeSegment(tail.getX(), tail.getY()));
    }

    // The collidesWithSelf method checks if the snake has collided with itself.
    // Encourages encapsulation by not exposing the list of segments.
    public boolean collidesWithSelf() {
        SnakeSegment head = getHead();
        for (int i = 1; i < segments.size(); i++) {
            if (head.collidesWith(segments.get(i))) {
                return true;
            }
        }
        return false;
    }

    // The collidesWith method checks if the snake has collided with a food object.
    // Encourages encapsulation by not exposing the head.
    public boolean collidesWith(Food food) {
        return food.collidesWith(getHead());
    }

    private SnakeSegment getHead() {
        return segments.getFirst();
    }

    // The reset method resets the snake to its initial state.
    public void reset() {
        segments.clear();
        segments.add(new SnakeSegment(startX, startY));
    }
}
