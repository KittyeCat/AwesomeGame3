package com.awesomegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AwesomeGame extends Game {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	@Override
	public void create () {
		Assets.load();
		setScreen(new GameplayScreen(this));
	}

	@Override
	public void dispose () {

		Assets.dispose();

	}
}
