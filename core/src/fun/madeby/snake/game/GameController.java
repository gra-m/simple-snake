package fun.madeby.snake.game;

import com.badlogic.gdx.utils.Logger;

import fun.madeby.snake.entity.SnakeHead;

public class GameController {

    private static final Logger LOG = new Logger(GameController.class.getName());

    private SnakeHead head;

    public GameController() {
        this.head = new SnakeHead();
    }

    public void update(float delta) {}

    public SnakeHead getHead() {
        return head;
    }
}
