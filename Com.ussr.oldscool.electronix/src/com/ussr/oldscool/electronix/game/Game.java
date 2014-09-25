package com.ussr.oldscool.electronix.game;


import ñom.ussr.oldscool.electronix.logic.BaseScreen;
import ñom.ussr.oldscool.electronix.logic.MainScreen;
import ñom.ussr.oldscool.electronix.logic.ScreenManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;


public class Game implements ApplicationListener {

	private PerspectiveCamera cam;

	private BaseScreen stage;

	private static Game instance;
	
	private Screen screen;
	
	/*public void setScreen(Screen screen) {
		
		this.screen = screen;
		
	}*/
	
	
	
	@Override
	public void create() {

		/*
    	this.cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	this.cam.position.set(0, 0, 10f);
    	this.cam.lookAt(0,0,0);
    	this.cam.near = 0.1f;
    	this.cam.far = 300f;
    	this.cam.update();
		 
        //stage = new Stage();
        //stage.clear();
        Gdx.input.setInputProcessor(stage);
        
        Game.instance = this;*/
        
        ScreenManager.getInstance().initialize(this);
        ScreenManager.getInstance().show(ScreenManager.Screen.MAIN_MENU);
        
	}

	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	    
	    //if (this.currentScreen != null) this.currentScreen.Act();
	    
        this.stage.act();
       
        //batch.setProjectionMatrix(camera.combined);
        //batch.begin();
        
        this.stage.draw();
        
        //batch.end();
	
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}


	public void setStage(BaseScreen baseScreen) {
		// TODO Auto-generated method stub
		
		this.stage = baseScreen;
		
		Gdx.input.setInputProcessor(this.stage);
		
	}

}
