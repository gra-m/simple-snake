package fun.madeby.snake.entity;

import fun.madeby.snake.config.GameConfig;

public class SnakeHead extends EntityBase{

    public SnakeHead(){
        super.setSize(GameConfig.SNAKE_SIZE, GameConfig.SNAKE_SIZE);
    }

}
