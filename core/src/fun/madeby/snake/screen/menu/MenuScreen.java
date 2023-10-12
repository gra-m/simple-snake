package fun.madeby.snake.screen.menu;

import static com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.table;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fun.madeby.SimpleSnakeGame;
import fun.madeby.snake.assets.AssetDescriptors;
import fun.madeby.snake.assets.ButtonStyleNames;
import fun.madeby.snake.assets.RegionNames;
import fun.madeby.snake.config.GameConfig;

public class MenuScreen extends ScreenAdapter {
    private final SimpleSnakeGame game;
    private final AssetManager assetManager;

    private Viewport viewport;
    private Stage stage;
    private Skin skin;
    private TextureAtlas gameplayAtlas;

    public MenuScreen(SimpleSnakeGame simpleSnakeGame) {
        this.game = simpleSnakeGame;
        this.assetManager = game.getAssetManager();
    }

    @Override
    public void show() {
        viewport = new FitViewport(GameConfig.HUD_WIDTH, GameConfig.HUD_HEIGHT); // auto cam
        stage = new Stage(viewport, game.getBatch());
        skin = assetManager.get(AssetDescriptors.UI_SKIN);
        gameplayAtlas = assetManager.get(AssetDescriptors.GAMEPLAY_ATLAS);

        // create stage and get actor for it:
        Gdx.input.setInputProcessor(stage);
        stage.addActor(createUI());
    }

    private Actor createUI() {

        // create and activate elements
        Table menuActorTable = new Table(skin);
        TextureRegion background = assetManager.get(RegionNames.BACKGROUND);
        TextureRegionDrawable tableBackground = new TextureRegionDrawable(background);
        Image titleImage = new Image(skin, RegionNames.TITLE);
        Button playButton = new Button(skin, ButtonStyleNames.PLAY);
        Button quitButton = new Button(skin, ButtonStyleNames.QUIT);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                play();
            }
        });

        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                quit();
            }
        });

        // set table attributes
        menuActorTable.defaults().pad(10);
        menuActorTable.setBackground(tableBackground);
        menuActorTable.center();
        menuActorTable.setFillParent(true);

        // pack table
        menuActorTable.add(titleImage);
        menuActorTable.add(playButton);
        menuActorTable.add(quitButton);
        menuActorTable.pack();

        return menuActorTable;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
