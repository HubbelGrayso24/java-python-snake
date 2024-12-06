package io.hubbell.fung.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


// Implements a renderable interface for objects to render themselves
// on the LibGDX ShapeRenderer passed in.
public interface Renderable {
    void render(ShapeRenderer renderer);
}
