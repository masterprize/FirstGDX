package ñom.ussr.oldscool.electronix.logic;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

public class GamePlayScreen extends BaseScreen {

	public GamePlayScreen() {
		Log.d("MAIN", "MAIN_CREATE");
		//this.stage = new Stage();
		//this.stage.clear();
		
		this.SetButtons();
	}
	
	//TODO: settings
	private void SetButtons() {
	
		BitmapFont font = new BitmapFont();
	    Skin skin = new Skin();
	    
	    TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("test.pack"));
	    skin.addRegions(buttonAtlas);
	    
	    ImageTextButton.ImageTextButtonStyle textButtonStyle = new ImageTextButton.ImageTextButtonStyle();
	   
	    textButtonStyle.font = font;
	    textButtonStyle.up = skin.getDrawable("up");
	    textButtonStyle.down = skin.getDrawable("down");
	    textButtonStyle.checked = skin.getDrawable("checked");
	    
	    this.AddButton(/*this.stage,*/ textButtonStyle, "buttonA", new ChangeListener() {
	        public void changed (ChangeEvent event, Actor actor) {
	            Log.d("GAME", "buttonA Pressed");
	            ScreenManager.getInstance().show(ScreenManager.Screen.MAIN_MENU);
	            
	        }
	    }, 50f, 225f, 100f, 100f, 1f);
	    
	    this.AddButton(/*this.stage,*/ textButtonStyle, "buttonB", new ChangeListener() {
	        public void changed (ChangeEvent event, Actor actor) {
	            Log.d("GAME", "ButtonB Pressed");
	        }
	    }, 50f, 75f, 100f, 100f, 1f);
	    
	    
	}

	
}
