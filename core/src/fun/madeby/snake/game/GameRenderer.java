package fun.madeby.snake.game;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fun.madeby.snake.config.GameConfig;
import fun.madeby.snake.entity.BodyPart;
import fun.madeby.snake.entity.Coin;
import fun.madeby.snake.entity.Snake;
import fun.madeby.snake.entity.SnakeHead;
import fun.madeby.snake.util.GdxUtils;
import fun.madeby.snake.util.ViewportUtils;
import fun.madeby.snake.util.debug.DebugCameraController;

// super dispose in game disposes game screen and this dispose

/**
 * A class for everything related to rendering in the game so all textures etc
 */
public class GameRenderer implements Disposable {
    private static final Logger LOG = new Logger(GameRenderer.class.getName(), Logger.DEBUG);
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


        renderDebug();
    }

    private void renderDebug() {

        viewport.apply();
        ViewportUtils.drawGrid(viewport, renderer);


        Color oldColor = renderer.getColor().cpy();

        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);

        drawDebug();

        renderer.end();

        renderer.setColor(oldColor);



    }

    private void drawDebug() {
        Snake snake = controller.getSnake();
        SnakeHead head = snake.getHead();
        Coin coin = controller.getCoin();



        renderer.setColor(Color.RED);
        renderer.rect(head.getX(), head.getY(), head.getWidth(), head.getHeight());
        renderer.rect(coin.getX(), coin.getY(), coin.getWidth(), coin.getHeight());
        // draw bounds position if you see red and green or blue something wrong.
        Rectangle headBounds = head.getBoundsThatAreUsedForCollisionDetection();
        Rectangle coinBounds = coin.getBoundsThatAreUsedForCollisionDetection();
        renderer.setColor(Color.GREEN);
        renderer.rect(headBounds.x, headBounds.y, headBounds.getWidth(), headBounds.getHeight());
        renderer.setColor(Color.BLUE);
        renderer.rect(coinBounds.x, coinBounds.y, coinBounds.getWidth(), coinBounds.getHeight());
        renderer.setColor(Color.PURPLE);

        for (BodyPart bodyPart : snake.getBodyParts()){
            Rectangle bodyPartBounds = bodyPart.getBoundsThatAreUsedForCollisionDetection();
            renderer.rect(bodyPartBounds.x, bodyPartBounds.y, bodyPartBounds.getWidth(), bodyPartBounds.getHeight());
        }
    }

    // called at start of game and for any subsequent resize event.
    public void resize(int width, int height) {
        viewport.update(width, height, true);

        LOG.debug("Getting game Pixels per unit from debugPixelsPerUnit(viewport): ");
        ViewportUtils.debugPixelsPerUnit(viewport);
    }


    @Override
    public void dispose() {
    renderer.dispose();

    }
}
