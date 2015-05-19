package edu.chl.rocc.core.physics;

import com.badlogic.gdx.math.Vector2;
import edu.chl.rocc.core.m2phyInterfaces.*;
import edu.chl.rocc.core.model.Level;
import org.jbox2d.common.Vec2;
import jdk.nashorn.internal.ir.Flags;
import org.jbox2d.dynamics.*;

import java.util.ArrayList;
import java.util.List;
import static edu.chl.rocc.core.GlobalConstants.PPM;

/**
 * Created by Joel on 2015-05-03.
 */
public class PhyLevel implements ILevel {

    private final ILevel level;
    private final World world;
    public static boolean isUpdating;
    private List<Body> bodiesNeedingToDispose;
    private List<IEnemy> enemies;

    private float aimX, aimY;

    public PhyLevel(World world) {
        this.world = world;
        this.level = new Level();
        this.bodiesNeedingToDispose = new ArrayList<Body>();
        this.enemies = new ArrayList<IEnemy>();
    }

    @Override
    public void addBlock(BodyDef bDef, FixtureDef fDef) {
        Body body = world.createBody(bDef);
        bodiesNeedingToDispose.add(body);
        body.createFixture(fDef);
    }

    @Override
    public void updateWorld(float dt) {
        world.step(dt, 6, 2);
        updateTime();
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public void addPickupable(IPickupable pickup) {
        level.addPickupable(pickup);
    }

    @Override
    public void removePickupable(IPickupable pickup) {
        level.removePickupable(pickup);
    }

    @Override
    public List<IPickupable> getPickupables() {
        return level.getPickupables();
    }

    @Override
    public void addJumpPoint(IJumpPoint jumpPoint){
        level.addJumpPoint(jumpPoint);
    }

    @Override
    public void createBullet(float x, float y, float xDir, float yDir){
        IBullet bullet = new PhyBullet(this.getWorld(), x, y, xDir, yDir, "");
        this.addBullet(bullet);
    }

    @Override
    public List<IBullet> getBullets(){
        return level.getBullets();
    }

    @Override
    public void addBullet(IBullet bullet){
        level.addBullet(bullet);
    }

    @Override
    public void removeBullet(IBullet bullet) {
        level.removeBullet(bullet);

    }
    @Override
    public List<IEnemy> getEnemies(){
        return enemies;
    }

    @Override
    public void addEnemy(IEnemy enemy) {
        enemies.add(enemy);
    }

    @Override
    public void removeEnemy(IEnemy enemy) {
        enemies.remove(enemy);
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        } else if (o == null){
            return false;
        } else if (this.getClass() != o.getClass()){
            return false;
        } else {
            return this.hashCode() == o.hashCode();
        }
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += world.hashCode();
        // hash += level.hashCode(); // For when level gets a hashCode
        return hash;
    }

    @Override
    public void setAim(float x, float y){
        this.aimX = x;
        this.aimY = y;
    }

    @Override
    public void addFinish(IFinishPoint finishPoint) {
        level.addFinish(finishPoint);
    }

    @Override
    public void dispose() {
        level.dispose();
        for (Body body : bodiesNeedingToDispose){
            world.destroyBody(body);
        }
    }

    public Vector2 getAim(){
        return new Vector2(this.getAimX(), this.getAimY());
    }

    public float getAimX(){
        return this.aimX;
    }

    public float getAimY(){
        return this.aimY;
    }

    public int getScore(){
        return level.getScore();
    }

    @Override
    public int getTime(){
        return level.getTime();
    }


    @Override
    public void updateTime(){
        level.updateTime();
    }
}
