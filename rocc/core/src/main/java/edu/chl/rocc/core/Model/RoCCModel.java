package edu.chl.rocc.core.model;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import org.jbox2d.collision.shapes.ChainShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;


/**
 * A class handeling the game model.
 *
 * Created by Yen on 2015-04-22.
 */
public class RoCCModel {

    private Level level;
    private Player player;

    public RoCCModel(){
        level = new Level();
        player = new Player(level.getWorld());
    }

    public void aim(int x, int y){

    }

    // Creates a logical box2d map mimicing the tiled-map
    public void constructWorld(TiledMap tMap){
        // Get the layer with information about the solid ground
        TiledMapTileLayer tileLayer = (TiledMapTileLayer)tMap.getLayers().get("ground");

        // Create a tile for each block on the map
        for (int row = 0; row < tileLayer.getHeight(); row++){
            for (int col = 0; col < tileLayer.getWidth(); col++){
                TiledMapTileLayer.Cell cell = tileLayer.getCell(col, row);

                // If there is a tile at the position
                if (cell != null && cell.getTile() != null){

                    // Create a body definiion
                    BodyDef bDef = new BodyDef();
                    bDef.type = BodyType.STATIC;
                    bDef.position.set(32 * (col + 0.5f), 32 * (row + 0.5f));

                    // And a fixture definition
                    ChainShape cs = new ChainShape();
                    Vec2[] v = new Vec2[4];
                    v[0] = new Vec2( -32f, -32f);
                    v[1] = new Vec2( -32f,  32f);
                    v[2] = new Vec2(  32f,  32f);
                    v[3] = new Vec2(  32f, -32f);
                    cs.createChain(v, 4);

                    FixtureDef fDef = new FixtureDef();
                    fDef.friction = 0;
                    fDef.shape = cs;

                    // Then let the level create the block in the world
                    level.addBlock(bDef, fDef);
                }
            }
        }
    }

    public void moveSideways(Direction dir){
        player.move(dir);
    }

    public int getCharacterXPos(){
        return player.getCharacterXPos();
    }

    public int getCharacterYPos(){
        return player.getCharacterYPos();
    }

    public Level getLevel(){
        return level;
    }

    public void updateWorld(float dt){
        level.updateWorld(dt);
    }


}