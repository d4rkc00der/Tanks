package com.soho.evgeny;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.soho.evgeny.Factory.UnitsFactory;
import com.soho.evgeny.Model.Enemy;
import com.soho.evgeny.Model.Player;

import java.util.Random;

/**
 * Created by shumakove on 05.12.16.
 */

public class GameScreen implements Screen {

    Array<Enemy> enemies;
    Player player;
    private Batch batch;
    Texture joystick_texture;
    TextureRegion button_image;

    @Override
    public void show() {
        batch = new SpriteBatch();
        enemies = new Array<Enemy>();

            loadController();
            loadPlayer();
            createEnemy();


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for (Enemy enemy : enemies) {
            enemy.draw(batch);
        }
        player.draw(batch);
        loadController();

    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


    //
    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        UnitsFactory.tanks_texture.dispose();
    }

    public void loadController(){
        batch.begin();
        // Draw buttons
        joystick_texture = new Texture("joystick.png");
        button_image = new TextureRegion(joystick_texture,0,64,64,64);
        batch.end();
    }
    private void createEnemy(){
        boolean isCollisied = false;
        int rndXPos = new Random().nextInt(Gdx.graphics.getWidth()+1);
        int rndYPos = new Random().nextInt(Gdx.graphics.getHeight()+1);;
        for(Enemy enemy : enemies) {
            if(((enemy.getxPos()<rndXPos+64) || (enemy.getxPos()>rndXPos+64))
                &&
            (enemy.getyPos()<rndYPos+64) || (enemy.getyPos()>rndYPos+64))
                isCollisied = false;
            else {
                isCollisied = true;
            }
        }
        if(!isCollisied)
            enemies.add(UnitsFactory.createTank(rndXPos,rndYPos));

    }
    private void loadPlayer() {
        player = UnitsFactory.createPlayer(10,10);
    }
}
