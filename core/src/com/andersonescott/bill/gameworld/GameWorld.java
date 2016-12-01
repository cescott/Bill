package com.andersonescott.bill.gameworld;


import com.andersonescott.bill.objects.entities.Entity;
import com.andersonescott.bill.objects.entities.Player;

import java.util.ArrayList;

public class GameWorld {

    protected ArrayList<Entity> entities;
    protected Player player;
    protected GameState gameState;

    public enum GameState {
        READY, PAUSED, RUNNING, COMBAT  //add more as needed
    }

    public GameWorld(){
        entities = new ArrayList<Entity>();
        gameState = GameState.READY;
    }

    public boolean isReady(){
        return gameState == GameState.READY;
    }

    public boolean isPaused(){
        return gameState == GameState.PAUSED;
    }

    public boolean isRunning(){
        return gameState == GameState.RUNNING;
    }

    public boolean isCombat(){
        return gameState == GameState.COMBAT;
    }

    public void update(float delta){
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update(delta);
            if (!entities.get(i).isAlive()) {
                entities.remove(i);
            }
        }
    }
}
