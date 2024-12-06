package io.hubbell.fung.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;

public class Snake implements Movable, Renderable {
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

    public int getXDirection() {
        return switch (direction) {
            case LEFT -> -1;
            case RIGHT -> 1;
            default -> 0;
        };
    }

    public int getYDirection() {
        return switch (direction) {
            case UP -> 1;
            case DOWN -> -1;
            default -> 0;
        };
    }

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

    @Override
    public void render(ShapeRenderer renderer) {
        for (SnakeSegment segment : segments) {
            segment.render(renderer);
        }
    }

    public void grow() {
        SnakeSegment tail = segments.getLast();
        segments.add(new SnakeSegment(tail.getX(), tail.getY()));
    }

    public List<SnakeSegment> getSegments() {
        return segments;
    }

    public SnakeSegment getHead() {
        return segments.getFirst();
    }

    public void reset() {
        segments.clear();
        segments.add(new SnakeSegment(startX, startY));
    }
}
