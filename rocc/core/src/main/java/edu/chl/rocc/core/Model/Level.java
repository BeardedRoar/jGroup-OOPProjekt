package edu.chl.rocc.core.Model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.google.gwt.i18n.client.HasDirection;

import java.util.ArrayList;

/**
 * Created by Yen on 2015-04-22.
 */
public class Level {
    private int time;
    private int score;
    private ArrayList <String> highscore;

    private Character character;

    public Level(){

        character = new Character();
    }

    public void move(Direction dir){
        character.move(dir);
    }


    public Sprite getCharacterSprite(){
        return character.getSprite();
    }
}
