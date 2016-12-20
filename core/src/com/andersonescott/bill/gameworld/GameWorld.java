package com.andersonescott.bill.gameworld;


import com.andersonescott.bill.objects.entities.Enemy;
import com.andersonescott.bill.objects.entities.Player;
import com.andersonescott.bill.objects.stages.StageManager;
import com.andersonescott.bill.objects.stages.terrain.Terrain;
import com.badlogic.gdx.math.Vector2;

public class GameWorld {

    protected Terrain[] terrain;
    protected Player player;
    protected Enemy enemy;
    protected GameState gameState;
    protected boolean paused;

    public enum GameState {
        READY, RUNNING, COMBAT  //add more as needed
    }

    public GameWorld(){
        player = new Player(new Vector2(0, 0));//have these be the actual coords
        terrain = StageManager.currentStage.getTerrain();
        gameState = GameState.READY;
    }

    public boolean isReady(){
        return gameState == GameState.READY;
    }

    public boolean isPaused(){
        return paused;
    }

    public boolean isRunning(){
        return gameState == GameState.RUNNING;
    }

    public boolean isCombat(){
        return gameState == GameState.COMBAT;
    }

    public void update(float delta){
        if (!paused) {
            if (isRunning()){
                //update player
                player.update(delta);
                //update terrain
                for (int i = 0; i < terrain.length; i++) {
                    terrain[i].update(delta);
                }
            }
        }
    }

    public void startCombat(Enemy enemy){
        this.enemy = enemy;
        gameState = GameState.COMBAT;
    }
}
