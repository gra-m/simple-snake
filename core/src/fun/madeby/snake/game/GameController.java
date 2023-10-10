package fun.madeby.snake.game;

import com.badlogic.gdx.utils.Logger;

import fun.madeby.snake.config.GameConfig;
import fun.madeby.snake.entity.SnakeHead;

public class GameController {

    private static final Logger LOG = new Logger(GameController.class.getName());

    private SnakeHead head;
    private float timer;

    public GameController() {
        this.head = new SnakeHead();
    }

    public void update(float delta) {
        timer += delta;
       if (timer >= GameConfig.NORMAL_MOVES_EVERY.every)  {
           timer = 0;
           head.updateX(GameConfig.NORMAL_MOVES_EVERY.moves);
       }
    }

    public SnakeHead getHead() {
        return head;
    }
}
