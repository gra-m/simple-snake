package fun.madeby;

import com.badlogic.gdx.Game;

import fun.madeby.snake.game.GameScreen;

// As opposed to ApplicationAdapter Game can multiple screens
public class SimpleSnakeGame extends Game {
    @Override
    public void create() {
        //todo if debugger not working
        //Gdx.app.setLogLevel(Application.LOG_DEBUG);
        setScreen(new GameScreen(this));
    }
}
