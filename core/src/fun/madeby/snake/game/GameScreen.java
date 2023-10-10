package fun.madeby.snake.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;

import fun.madeby.SimpleSnakeGame;

public class GameScreen extends ScreenAdapter {
    private final SimpleSnakeGame simpleSnakeGame;
    
    public GameScreen(SimpleSnakeGame game) {
        this.simpleSnakeGame = game;
    }
    
}
