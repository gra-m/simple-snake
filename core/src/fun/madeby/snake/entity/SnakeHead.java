package fun.madeby.snake.entity;

import fun.madeby.snake.config.GameConfig;

public class SnakeHead extends EntityBase{

    private Direction direction = Direction.RIGHT;

    public SnakeHead(){
        super.setSize(GameConfig.SNAKE_SIZE, GameConfig.SNAKE_SIZE);
    }

    public void updateX(float amount) {
        x += amount;
        updateBoundsForCollisionDetection();
    }
    public void updateY(float amount) {
        y += amount;
        updateBoundsForCollisionDetection();
    }

    public void move() {
        if(direction.isLeft()) {
            updateX(-GameConfig.NORMAL_MOVES_EVERY.moves);
        } else if (direction.isRight()) {
            updateX(GameConfig.NORMAL_MOVES_EVERY.moves);
        }else if (direction.isUp()) {
            updateY(GameConfig.NORMAL_MOVES_EVERY.moves);
        } else {
            updateY(-GameConfig.NORMAL_MOVES_EVERY.moves);
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
