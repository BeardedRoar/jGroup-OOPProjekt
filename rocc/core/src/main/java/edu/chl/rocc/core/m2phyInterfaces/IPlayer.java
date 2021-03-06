package edu.chl.rocc.core.m2phyInterfaces;

import edu.chl.rocc.core.observers.IDeathListener;
import edu.chl.rocc.core.utility.Direction;

import java.util.List;

/**
 * An interface describing a player.
 *
 * Created by Joel on 2015-05-03.
 */
public interface IPlayer {

    /**
     * Make the active character jump.
     */
    public void jump();

    /**
    * Move the front character in a given direction.
    */
    public void move(Direction dir);

    /**
    * Move the follower characters towards the front character.
    */
    public void moveFollowers(Direction dir);

    /**
    * @return x-coordinate of the lead character.
    */
    public float getCharacterXPos();

    /**
    * @return y-coordinate of the lead character.
    */
    public float getCharacterYPos();

    /**
    * Adds a character to the character list.
    */
    public void addCharacter(String name);

    /**
     * Adds a character to the character list.
     */
    public void addCharacter(String name, IDeathListener listener);

    /**
     * Remove a character from the character list.
     */
    public void removeCharacter(ICharacter character);

    /**
     * @return list of all characters.
     */
    public List<ICharacter> getCharacters();

    /**
     * Add/create a weapon to the weapon list.
     */
    public void addWeapon(String name);

    /**
     * Remove a weapon from the weapon list.
     */
    public void removeWeapon(String name);

    /**
     * @return the weapon at the given index in the weapon list.
     */
    public IWeapon getWeapon();

    /**
     * @return a list of all the players weapons.
     */
    public List<IWeapon> getWeapons();

    /**
     * Change the currently used weapon.
     */
    public void changeWeapon();

    /**
     * @return the x-coordinate of where the bullets spawn.
     */
    public int getBulletSpawnX();

    /**
     * @return the y-coordinate of where the bullets spawn.
     */
    public int getBulletSpawnY();

    /**
     * Make the active character shoot/fire a bullet.
     * @return the bullet that has been fired.
     */
    public IBullet shoot(float xDir, float yDir);

    /**
     * Method that makes it easier for Java's garbage collector to delete objects.
     */
    public void dispose();

    /**
     * Adds a value to the total score
     * @param value
     */
    public void addToScore(int value);

    /**
     * @return score
     */
    public int getScore();

    /**
     * Increase the player's score.
     */
    public void incScore(int inc);

    /**
     * Change which character the player is playing as.
     */
    public void setActiveCharacter(int i);

    /**
     * @return the active character.
     */
    public ICharacter getActiveCharacter();

    /**
     * Change which the active character is, cycles according to the character list.
     */
    public void cycleActiveCharacter();

    /**
     * @return the index of the front character in the character list.
     */
    public int getFrontCharacterIndex();
}
