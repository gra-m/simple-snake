package fun.madeby.snake.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Logger;

import fun.madeby.snake.config.GameConfig;
import fun.madeby.snake.entity.Direction;
import fun.madeby.snake.entity.SnakeHead;

public class GameController {

    private static final Logger LOG = new Logger(GameController.class.getName());

    private SnakeHead head;
    private float timer;

    public GameController() {
        this.head = new SnakeHead();
    }

    public void update(float delta) {
        getDirectionAtThisTickFromInput();
        timer += delta;
       if (timer >= GameConfig.NORMAL_MOVES_EVERY.every)  {
           timer = 0;
           // GameControl moving head on every timer threshold pass
           head.move();
       }
    }

    private void getDirectionAtThisTickFromInput() {
        boolean leftPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean rightPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean upPressed = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean downPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN);

        if (leftPressed)
            head.setDirection(Direction.LEFT);
        else if (rightPressed)
            head.setDirection(Direction.RIGHT);
        else if (upPressed)
            head.setDirection(Direction.UP);
        else if (downPressed)
            head.setDirection(Direction.DOWN);



    }

    public SnakeHead getHead() {
        return head;
    }
}
