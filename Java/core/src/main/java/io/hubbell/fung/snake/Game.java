package io.hubbell.fung.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

// LibGDX has an abstract class ApplicationAdapter that defines the standard game development pattern
public class Game extends ApplicationAdapter {

    // This is a 2D game only with shapes, so we can use the standard shape renderer
    private ShapeRenderer shapeRenderer;
    private GameLogic gameLogic;

    // Define the standard world size. This is the size of the render window.
    public static final int WORLD_WIDTH = 640;
    public static final int WORLD_HEIGHT = 480;

    // This is the init function run by LibGDX as part of ApplicationAdaptor
    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        gameLogic = new GameLogic(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    // This render function is also called by LibGDX in the game pattern.
    // It is called as the primary update function and sets game state and renders
    // the game using the gameLogic class.
    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameLogic.update(Gdx.graphics.getDeltaTime());

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        drawSnake();
        drawFood();
        shapeRenderer.end();
    }

    // Simplifying code for rendering objects embedded in gameLogic
    private void drawSnake() {
        gameLogic.renderSnake(shapeRenderer);
    }
    private void drawFood() {
        gameLogic.renderFood(shapeRenderer);
    }

    // Clean the board and delete the existing renderer when exiting
    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
