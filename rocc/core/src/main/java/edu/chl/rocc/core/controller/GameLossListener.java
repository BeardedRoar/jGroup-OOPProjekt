package edu.chl.rocc.core.controller;

import edu.chl.rocc.core.observers.IGameLossListener;

/**
 * Created by Joel on 2015-05-28.
 */
public class GameLossListener implements IGameLossListener {

    private final MainController controller;

    public GameLossListener(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void gameLost() {
        this.controller.setState("defeat");
    }
}
