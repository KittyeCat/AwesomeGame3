package com.awesomegame;

import com.awesomegame.AwesomeGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
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

    public static final int TILESIZE = 32;
    public static final int WORLDWIDTH = 800;
    public static final int WORLDHEIGHT = 800;

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
        processInput();
        camera.position.set(hero.getX(), hero.getY(), 0);
        camera.update();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameplayStage.act();
        gameplayStage.draw();
    }

    public void processInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            hero.move(hero.LEFT);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            hero.move(hero.RIGHT);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
            hero.move(hero.UP);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
            hero.move(hero.DOWN);
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }
}
