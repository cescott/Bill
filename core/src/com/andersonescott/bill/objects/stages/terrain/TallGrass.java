package com.andersonescott.bill.objects.stages.terrain;

import com.andersonescott.bill.objects.entities.Player;
import com.badlogic.gdx.math.Vector2;

public class TallGrass extends Terrain {
    protected boolean explored;

    public TallGrass(Vector2 position, int height, int width){
        super(position, height, width);
        explored = false;
    }

    @Override
    public boolean eventOnCollision(Player player){
        if (!explored){
            int r = (int)(Math.random()*100);
            explored = true;
            if (r <= player.getEncounterChance()){
                player.resetEncounterChance();
                return true;
            }
            else {
                player.increaseEncounterChance();
                return false;
            }
        }
        else {
            explored = true;
            return false;
        }
    }

    @Override
    public void eventOnPlayerExit(Player player){
        explored = false; //this means that a player can walk in and out
                          //of a single tall grass to increase encounter chance
    }
}
