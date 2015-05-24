package edu.chl.rocc.core.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * A class handling choosing and storing keysettings.
 * Get hold of the instance by getInstance(), no public constructor.
 *
 * Created by Joel on 2015-05-12.
 */
public class KeyOptions extends AbsInformationHandler{

    // The only instance
    private static final KeyOptions instance = new KeyOptions();

    /**
     * Getter for the shared instance
     * @return the instance
     */
    public static KeyOptions getInstance(){
        return instance;
    }

    private KeyOptions() {
        super("assets/options/keys.txt", new File("assets/options"));
    }

    /**
     * Call to write the current setting to file
     * @return successfully wrote to file
     */
    public boolean saveKeys(){
        return super.saveInfo();
    }


    public void setToDefault(){
        super.setInfo("Move Left", Integer.toString(Input.Keys.A));
        super.setInfo("Move Right", Integer.toString(Input.Keys.D));
        super.setInfo("Jump", Integer.toString(Input.Keys.SPACE));
        super.setInfo("Pause", Integer.toString(Input.Keys.ESCAPE));
        super.setInfo("Switch Character", Integer.toString(Input.Keys.TAB));
    }

    /**
     * Get the value for responding action
     * @param key action
     * @return set value for the action
     */
    public int getKey(String key){
        return Integer.parseInt(super.getInfo(key));
    }

    /**
     * Set a value to a action
     * @param key action to set
     * @param value value to give it
     */
    public void setKey(String key, int value) {
        super.setInfo(key, Integer.toString(value));
    }
}
