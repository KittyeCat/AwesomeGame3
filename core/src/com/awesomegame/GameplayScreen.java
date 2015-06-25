package com.awesomegame;

import com.awesomegame.AwesomeGame;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Basil on 25/06/2015.
 */
public class GameplayScreen extends ScreenAdapter {

    protected AwesomeGame game;
    protected OrthographicCamera camera;

    private Stage gameplayStage;
    private Hero hero;
    private Image background;



    public GameplayScreen(AwesomeGame game){
        this.game = game;
        camera = new OrthographicCamera(AwesomeGame.WIDTH, AwesomeGame.HEIGHT);

        gameplayStage = new Stage(new StretchViewport(AwesomeGame.WIDTH, AwesomeGame.HEIGHT));

        hero = new Hero();
        background = new Image(Assets.background);

        gameplayStage.addActor(background);

        gameplayStage.addActor(hero);
        hero.setPosition(AwesomeGame.WIDTH / 2, AwesomeGame.HEIGHT / 2, Align.center);
    }

    @Override
    public void render(float delta) {
        gameplayStage.act();
        gameplayStage.draw();
    }




    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);

    }
}
