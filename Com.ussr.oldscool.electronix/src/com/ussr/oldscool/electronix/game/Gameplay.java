package com.ussr.oldscool.electronix.game;



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


public class Gameplay implements ApplicationListener {

	private PerspectiveCamera cam;
	private ShapeRenderer shapeRenderer;
	
	/*private ImageTextButton buttonA;
	private ImageTextButton buttonB;
	private ImageTextButton buttonS;
	
	private ImageTextButton button1;
	private ImageTextButton button2;
	private ImageTextButton button3;
	private ImageTextButton button4;*/
	
	private int sX = 0;
	private int sY = 0;
	
	//private static InputController ic = new InputController();
	
	private Stage stage;
	
	@Override
	public void create() {

    	this.cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	this.cam.position.set(0, 0, 10f);
    	this.cam.lookAt(0,0,0);
    	this.cam.near = 0.1f;
    	this.cam.far = 300f;
    	this.cam.update();
                
        shapeRenderer = new ShapeRenderer();


        stage = new Stage();
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        BitmapFont font = new BitmapFont();
        Skin skin = new Skin();
        
        TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("test.pack"));
        skin.addRegions(buttonAtlas);
        
        ImageTextButton.ImageTextButtonStyle textButtonStyle = new ImageTextButton.ImageTextButtonStyle();
       
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("up");
        textButtonStyle.down = skin.getDrawable("down");
        textButtonStyle.checked = skin.getDrawable("checked");
        
        this.AddButton(stage, textButtonStyle, "buttonA", new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                Log.d("GAME", "buttonA Pressed");
            }
        }, 50f, 225f, 100f, 100f, 1f);
        
        this.AddButton(stage, textButtonStyle, "buttonB", new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                Log.d("GAME", "ButtonB Pressed");
            }
        }, 50f, 75f, 100f, 100f, 1f);
        
        float w = Gdx.graphics.getWidth();
        //float h = Gdx.graphics.getHeight();
        
        this.AddButton(stage, textButtonStyle, "buttonC", new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                Log.d("GAME", "buttonC Pressed");
            }
        }, w - 50f - 100f, 225f, 100f, 100f, 1f);
        
        this.AddButton(stage, textButtonStyle, "buttonD", new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                Log.d("GAME", "ButtonD Pressed");
            }
        }, w - 50f - 100f, 75f, 100f, 100f, 1f);
        
	}

	private void AddButton(Stage stage, ImageTextButton.ImageTextButtonStyle style, String text, ChangeListener listener, float x, float y, float width, float height, float scale) {
		
		ImageTextButton button = new ImageTextButton(text, style);
		button.setX(x);
		button.setY(y);
		button.setWidth(width);
		button.setHeight(height);
		button.scale(scale);
		button.addListener(listener);
		
		stage.addActor(button);
		
	}
	
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		//нужно ли здесь отписываться от событий ic?
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
	       
        stage.act();
       
        //batch.setProjectionMatrix(camera.combined);
        //batch.begin();
        
        stage.draw();
        
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

}
