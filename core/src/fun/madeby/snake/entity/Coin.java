package fun.madeby.snake.entity;

import fun.madeby.snake.config.GameConfig;

public class Coin extends EntityBase{
    private boolean available;

    public Coin() {
        super.setSize(GameConfig.COIN_SIZE, GameConfig.COIN_SIZE);
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean isAvailable) {
        this.available = isAvailable;
    }
}
