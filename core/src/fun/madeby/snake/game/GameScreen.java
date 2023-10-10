package fun.madeby.snake.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;

import fun.madeby.SimpleSnakeGame;

public class GameScreen extends ScreenAdapter {
    private final SimpleSnakeGame game;
    private final AssetManager assetManager;

    public GameScreen(SimpleSnakeGame simpleSnakeGame) {
        this.game = simpleSnakeGame;
        this.assetManager = game.getAssetManager();
    }




}
