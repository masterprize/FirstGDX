package ñom.ussr.oldscool.electronix.logic;

import android.R.string;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class BaseScreen extends Stage {
	
	protected Stage stage;
	protected PerspectiveCamera cam;
	
	public BaseScreen() {
		
		/*this.stage = new Stage();
		this.stage.clear();*/
		this.clear();
		
	}
	
	protected void AddButton(/*Stage stage,*/ ImageTextButton.ImageTextButtonStyle style, String text, ChangeListener listener, float x, float y, float height, float width, float scale) {
		
		ImageTextButton button = new ImageTextButton(text, style);
		
		button.setX(x);
		button.setY(y);
		button.setHeight(height);
		button.setWidth(width);
		button.setScale(scale);
		button.addListener(listener);
		
		this.addActor(button);
		//stage.addActor(button);
		
	}

	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		
		//Gdx.gl.glClearColor(1, 1, 1, 1);
	    //Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//this.stage.act();
		//this.stage.draw();
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}*/

}
