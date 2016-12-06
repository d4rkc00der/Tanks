package com.soho.evgeny.Factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.soho.evgeny.Model.Enemy;
import com.soho.evgeny.Model.Player;

/**
 * Created by shumakove on 06.12.16.
 */

public class UnitsFactory {
    public static Texture tanks_texture = new Texture("tanks_texture.png");


    public static Enemy createTank(int x, int y){
        Enemy enemy = new Enemy();
        enemy.setxPos(x);
        enemy.setyPos(y);
        return enemy;
    }

    public static Player createPlayer(int x, int y) {
        Player player = new Player();
        player.setxPos(x);
        player.setyPos(y);
        return player;
    }

}
