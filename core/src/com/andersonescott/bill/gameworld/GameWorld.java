package com.andersonescott.bill.gameworld;


import com.andersonescott.bill.objects.entities.Enemy;
import com.andersonescott.bill.objects.entities.Player;
import com.andersonescott.bill.objects.stages.StageManager;
import com.andersonescott.bill.objects.stages.terrain.Terrain;
import com.badlogic.gdx.math.Intersector;
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
                    collision(player, terrain[i]);
                }
            }
        }
    }

    public void collision(Player player, Terrain terrain){
        if (player.getPosition().x > terrain.getPosition().x
                || player.getPosition().x < terrain.getPosition().x+ terrain.getWidth()){
            if (Intersector.overlaps(player.getHitbox(), terrain.getBody())
                    || Intersector.overlaps(player.getHitbox(), terrain.getSurface())){
                if ((player.getPosition().x + player.width> terrain.getPosition().x)
                        &&(player.yIsBetween(terrain.getPosition().y, terrain.getPosition().y + terrain.getHeight()))){//if player hits from the right
                    player.setPosition(terrain.getPosition().x, player.getPosition().y);
                    player.setVelocity(0, player.getVelocity().y);
                }
                else if ((player.getPosition().x < terrain.getPosition().x + terrain.getWidth())
                        &&(player.yIsBetween(terrain.getPosition().y, terrain.getPosition().y + terrain.getHeight()))){//if player hits from the left
                    player.setPosition(terrain.getPosition().x + terrain.getWidth(), player.getPosition().y);
                    player.setVelocity(0, player.getVelocity().y);
                }
                else if ((player.getPosition().y > terrain.getPosition().y + terrain.getWidth())
                        &&(player.xIsBetween(terrain.getPosition().x, terrain.getPosition().x + terrain.getWidth()))){//if player hits from top
                    player.setPosition(player.getPosition().x, terrain.getPosition().y + terrain.getHeight());
                    player.setVelocity(player.getVelocity().x, 0);
                }
                else {//if player hits from bottom
                    player.setPosition(player.getPosition().x, terrain.getPosition().y);
                    player.setVelocity(player.getVelocity().x, 0);
                }
                if (terrain.eventOnCollision(player)){
                    startCombat(StageManager.currentStage.getEnemey());
                }
            }
        }
    }


    public void startCombat(Enemy enemy){
        this.enemy = enemy;
        gameState = GameState.COMBAT;
    }
}
