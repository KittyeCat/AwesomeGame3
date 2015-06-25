package com.awesomegame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Basil on 25/06/2015.
 */
public class Hero extends Actor {

    public static final int WIDTH = 72;
    public static final int HEIGHT = 72;


    private Vector2 vel;
    private Vector2 accel;

    private TextureRegion region;

    private State state;
    private enum State {alive, dead};

    public Hero() {

        region = new TextureRegion(Assets.hero);
        setWidth(WIDTH);
        setHeight(HEIGHT);

        vel = new Vector2();
        accel = new Vector2();
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
