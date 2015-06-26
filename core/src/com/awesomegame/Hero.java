package com.awesomegame;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Basil on 25/06/2015. LOL
 */
public class Hero extends Actor {

    public static final int WIDTH = 72;
    public static final int HEIGHT = 72;
    public static final int VEL = 8;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

/*  private Vector2 vel;
    private Vector2 accel;
    private State orientation;
    private enum State {left, right, up, down}; */

    private TextureRegion region;

    private boolean isMoving;
    private int orientation;
    private int movementCtr;

    public Hero() {

        region = new TextureRegion(Assets.hero);
        setWidth(WIDTH);
        setHeight(HEIGHT);

        //vel = new Vector2();
        //accel = new Vector2();
        isMoving = false;
        orientation  = DOWN;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    @Override
    public void act(float delta) {
        if (isMoving && movementCtr < GameplayScreen.TILESIZE){
            if (orientation == LEFT && getX() > 0 ) {
                moveBy(-VEL, 0);
            }
            if (orientation == RIGHT && getX() < GameplayScreen.WORLDWIDTH) {
                moveBy(VEL, 0);
            }
            if (orientation == UP && getY() < GameplayScreen.WORLDHEIGHT) {
                moveBy(0, VEL);
            }
            if (orientation == DOWN && getY() > 0) {
                moveBy(0, -VEL);
            }
            movementCtr += VEL;
        }
        else {
            isMoving = false;
            movementCtr = 0;
        }
    }

    public void move(int orientation){
        if(movementCtr == 0) {
            isMoving = true;
            this.orientation = orientation;
        }
    }
}
