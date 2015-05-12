package edu.chl.rocc.core.m2phyInterfaces;

import edu.chl.rocc.core.model.Direction;

/**
 * Created by Joel on 2015-05-03.
 */
public interface ICharacter {

    /**
    * @return the character's health.
    */
    public int getHP();

    /**
    * Set character's health with a chosen value.
    */
    public void setHP(int value);

    /**
    * Increase character's health with a given value.
    */
    public void incHP(int value);

    /**
    * Decrease character's health with a given value.
    */
    public void decHP(int value);

    /**
    * Move the character in a given direction.
    */
    public void move(Direction dir);

    /**
    * Move a follower in a given direction.
    */
    public void moveFollower(Direction dir);

    /**
    * Make the character jump by changing its y-coordinate.
    */
    public void jump();

    public void hitGround();

    public void leftGround();

    /**
     * @return x-coordinate of the character.
     */
    public float getX();

    /**
    * @return y-coordinate of the character.
    */
    public float getY();

    public String getName();

    public void dispose();
}
