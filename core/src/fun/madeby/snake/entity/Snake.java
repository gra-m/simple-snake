package fun.madeby.snake.entity;

import fun.madeby.snake.config.GameConfig;

/**
 * Represents whole body of the snake
 */
public class Snake extends EntityBase{
    private SnakeHead head;
    private Direction direction = Direction.RIGHT;

    public Snake() {
        this.head = new SnakeHead();
    }


    public void move() {
        if(direction.isLeft()) {
            head.updateX(-GameConfig.NORMAL_MOVES_EVERY.moves);
        } else if (direction.isRight()) {
            head.updateX(GameConfig.NORMAL_MOVES_EVERY.moves);
        }else if (direction.isUp()) {
            head.updateY(GameConfig.NORMAL_MOVES_EVERY.moves);
        } else {
            head.updateY(-GameConfig.NORMAL_MOVES_EVERY.moves);
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public SnakeHead getHead() {
        return head;
    }
}
