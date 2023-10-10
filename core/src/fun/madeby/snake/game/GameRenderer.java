package fun.madeby.snake.game;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fun.madeby.snake.config.GameConfig;
import fun.madeby.snake.util.GdxUtils;
import fun.madeby.snake.util.ViewportUtils;
import fun.madeby.snake.util.debug.DebugCameraController;

// super dispose in game disposes game screen and this dispose

/**
 * A class for everything related to rendering in the game so all textures etc
 */
public class GameRenderer implements Disposable {
    private final GameController controller;

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;
    private DebugCameraController debugCameraController;

    public GameRenderer(GameController gameController) {
        this.controller = gameController;
        init();
    }

    private void init() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
        renderer = new ShapeRenderer();

        debugCameraController = new DebugCameraController();
        debugCameraController.setStartPosition(GameConfig.WORLD_CENTER_X, GameConfig.WORLD_CENTER_Y);
    }

    public void render(float delta) {
        debugCameraController.handleDebugInput(delta);
        debugCameraController.applyTo(camera);

        GdxUtils.clearScreen();

        // test code
        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);

        renderer.circle(GameConfig.WORLD_CENTER_X, GameConfig.WORLD_CENTER_Y, 4, 30);

        renderer.end();

        renderDebug();
    }

    private void renderDebug() {
        ViewportUtils.drawGrid(viewport, renderer);
    }

    // called at start of game and for any subsequent resize event.
    public void resize(int width, int height) {
        viewport.update(width, height, true);

        // tell us ppu
        ViewportUtils.debugPixelsPerUnit(viewport);
    }


    @Override
    public void dispose() {
    renderer.dispose();

    }
}
