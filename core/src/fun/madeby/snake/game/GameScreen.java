package fun.madeby.snake.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;

import fun.madeby.SimpleSnakeGame;

public class GameScreen extends ScreenAdapter {
    private final SimpleSnakeGame game;
    private final AssetManager assetManager;

    private GameRenderer renderer;
    private GameController controller;

    public GameScreen(SimpleSnakeGame simpleSnakeGame) {
        this.game = simpleSnakeGame;
        this.assetManager = game.getAssetManager();
    }


    @Override
    public void show() {
        // only instantiated when screen needs to be shown
        controller = new GameController();
        renderer = new GameRenderer(controller);
    }

    // the nexus, where render called automatically for this screen splits game logic/model (controller)
    // with rendering/view (renderer)
    @Override
    public void render(float delta) {
        controller.update(delta);
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        // propagate resize to renderer:
        renderer.resize(width, height);
    }


    @Override
    public void hide() {
        // screens are not auto disposed so we do this on hide
        dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
