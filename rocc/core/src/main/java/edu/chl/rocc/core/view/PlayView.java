package edu.chl.rocc.core.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import java.util.List;

import edu.chl.rocc.core.m2phyInterfaces.IEnemy;
import edu.chl.rocc.core.m2phyInterfaces.IFood;
import edu.chl.rocc.core.m2phyInterfaces.IRoCCModel;
import edu.chl.rocc.core.model.RoCCModel;
import edu.chl.rocc.core.view.observers.IViewObserver;

import java.util.ArrayList;

/**
 * This class is supposed to contain the
 * graphical data required for playing a level.
 * Created by Jacob on 2015-04-28.
 */
public class PlayView{

    private Texture characterTexture;
    private Texture followerTexture;
    private Texture foodTexture;
    private List<Texture> textures;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private ArrayList<IViewObserver> observerArrayList;

    //private Texture enemyTexture;

    private IRoCCModel model;


    public PlayView(){

       observerArrayList = new ArrayList<IViewObserver>();

        map = new TmxMapLoader().load("ground-food-map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        this.model.constructWorld(map);

        characterTexture = new Texture(Gdx.files.internal("characterSprite.png"));
        followerTexture  = new Texture(Gdx.files.internal("followerSprite.png"));
        foodTexture      = new Texture(Gdx.files.internal("shaitpizza.png"));
        //enemyTexture     = new Texture(Gdx.files.internal("enemy.png"));
        //b2dr = new Box2DDebugRenderer();
    }


    public void render(SpriteBatch batch, OrthographicCamera cam, OrthographicCamera hudCam) {
        //b2dr.render(model.getLevel().getWorld(),camera.combined);

       //Set camera to follow player
       cam.position.set(new Vector2(model.getCharacterXPos(0), model.getCharacterYPos(0)), 0);
       cam.update();

        renderer.setView(cam);
        renderer.render();

        batch.begin();
        batch.draw(characterTexture, model.getCharacterXPos(0), model.getCharacterYPos(0));
        batch.draw(followerTexture, model.getCharacterXPos(1), model.getCharacterYPos(1));

        for (IFood food : model.getFoods()){
            batch.draw(foodTexture, food.getX(), food.getY());
        }

        batch.end();
    }


    public void dispose() {

    }


    public void register(IViewObserver observer) {
        observerArrayList.add(observer);
    }


    public void unregister(IViewObserver observer) {
        observerArrayList.remove(observer);
    }

    
    public void notifyObserver() {
        /**
         * Figure out what parameters the viewUpdated will take.
         */
        for(IViewObserver observer : observerArrayList){
            observer.viewUpdated("");
        }
    }
}
