package fun.madeby.snake.config;

public class GameConfig {

    // pixel width and height the world units actually used to reference the world:
    public static final float WIDTH = 800f;
    public static final float HEIGHT = 480f;
    public static final float WORLD_WIDTH = 25f;
    public static final float WORLD_HEIGHT = 15f;

    public static final float WORLD_CENTER_X = WORLD_WIDTH / 2;
    public static final float WORLD_CENTER_Y  = WORLD_HEIGHT / 2;

    //Snake
    public static final float SNAKE_SIZE = 1f;
    public static FloatTuple NORMAL_MOVES_IN = new FloatTuple(1f, 0.2f);
    private GameConfig(){}
}
