package com.awesomegame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Basil on 25/06/2015.
 */
public class Assets {

    public static TextureAtlas atlas;
    public static SpriteBatch batch;


    public static TextureRegion hero;
    public static TextureRegion background;

    public static void load() {

        atlas = new TextureAtlas("assets/pack.atlas");
        batch = new SpriteBatch();

        hero = atlas.findRegion("hero");
        background = atlas.findRegion("map");


    }

    public static void dispose() {
        if (atlas != null) {
            atlas.dispose();

        }
        if (batch != null) {
            batch.dispose();
        }
    }
}