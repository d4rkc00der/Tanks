package com.soho.evgeny.Model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.soho.evgeny.Factory.UnitsFactory;

/**
 * Created by shumakove on 05.12.16.
 */

public class Enemy {

    private TextureRegion mImage;


    private int xPos;
    private int yPos;

    private int mHealth;
    public Enemy(){

    }

    public int getHealth() {
        return mHealth;
    }

    public void setHealth(int health) {
        this.mHealth = health;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int pos){
        xPos = pos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int pos){
        yPos = pos;
    }

    public void draw(Batch batch){

        mImage = new TextureRegion(UnitsFactory.tanks_texture,0,0,64,64);

        batch.begin();
        batch.draw(mImage, xPos, yPos,128,128);
        batch.end();
    }


}
