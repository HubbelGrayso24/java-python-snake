package io.hubbell.fung.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Game extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private GameLogic gameLogic;

    public static final int WORLD_WIDTH = 640;
    public static final int WORLD_HEIGHT = 480;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        gameLogic = new GameLogic(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

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

    private void drawSnake() {
        gameLogic.getSnake().render(shapeRenderer);
    }
    private void drawFood() {
        gameLogic.getFood().render(shapeRenderer);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
