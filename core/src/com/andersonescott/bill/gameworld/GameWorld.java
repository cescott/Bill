package com.andersonescott.bill.gameworld;


import com.andersonescott.bill.objects.entities.Entity;
import com.andersonescott.bill.objects.entities.Player;

import java.util.ArrayList;

public class GameWorld {

    public ArrayList<Entity> entities;
    public Player player;

    public enum GameState{
        PAUSED, RUNNING  //add more as needed
    }

    public GameWorld(){
        entities = new ArrayList<Entity>();

    }

    public void update(float delta){
        for (int i=0; i<entities.size();i++){
            entities.get(i).update(delta);
        }
    }
}
