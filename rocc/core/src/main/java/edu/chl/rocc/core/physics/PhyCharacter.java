package edu.chl.rocc.core.physics;

import edu.chl.rocc.core.controller.MyContactListener;
import edu.chl.rocc.core.m2phyInterfaces.ICharacter;
import edu.chl.rocc.core.model.*;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

/**
 * Created by Joel on 2015-05-03.
 */
public class PhyCharacter implements ICharacter {

    private final World world;
    private ICharacter character;
    private float width, height;
    private short BIT_Body;
    private short BIT_Ground;
    private Body body;

    public PhyCharacter(World world){
        this.world = world;
        this.width = 18;
        this.height = 35;
        this.BIT_Body = 4;
        this.BIT_Ground = 2;
        this.world.setContactListener(new MyContactListener()); //Ska flyttas

        //Defining & creating body
        BodyDef def = new BodyDef();
        def.position.set(160,120);
        def.type = BodyType.DYNAMIC;
        body = this.world.createBody(def);

        //Defining & creating fixture
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width,height);
        FixtureDef fDef = new FixtureDef();
        fDef.shape = shape;
        fDef.filter.categoryBits = BIT_Body;
        fDef.filter.maskBits = BIT_Ground;
        body.createFixture(fDef).setUserData("playerBody");

        //create foot sensor
        shape.setAsBox(width,height/4,new Vec2(0,-30),0);
        fDef.shape = shape;
        fDef.filter.categoryBits = BIT_Body;
        fDef.filter.maskBits = BIT_Ground;
        fDef.isSensor = true;
        body.createFixture(fDef).setUserData("footSensor");
    }

    @Override
    public int getHP() {
        return this.character.getHP();
    }

    @Override
    public void setHP(int value) {
        this.character.setHP(value);
    }

    @Override
    public void incHP(int value) {
        this.character.incHP(value);
    }

    @Override
    public void decHP(int value) {
        this.character.decHP(value);
    }

    @Override
    public void move(Direction dir) {

        if(dir.equals(Direction.LEFT)){
            body.applyForceToCenter(new Vec2(-1000, 0));
        } else if(dir.equals(Direction.RIGHT)){
            body.applyForceToCenter(new Vec2(1000, 0));
        } else if(dir.equals(Direction.UP)){

        } else if(dir.equals(Direction.DOWN)){

        } else if (dir.equals(Direction.NONE)){

        }
    }

    @Override
    public void jump() {
        body.applyForceToCenter(new Vec2(0, 1000));
    }

    @Override
    public float getX() {
        return body.getPosition().x-width;
    }

    @Override
    public float getY() {
        return body.getPosition().y-height;
    }
}