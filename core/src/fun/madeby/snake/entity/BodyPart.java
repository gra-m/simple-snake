package fun.madeby.snake.entity;

import fun.madeby.snake.config.GameConfig;

public class BodyPart extends EntityBase{

    public BodyPart() {
        super.setSize(GameConfig.SNAKE_SIZE, GameConfig.SNAKE_SIZE);
    }
}
