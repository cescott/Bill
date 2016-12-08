package com.andersonescott.bill.gameworld;


import com.andersonescott.bill.gameworld.assetMethods.AssetsLoader;
import com.andersonescott.bill.objects.entities.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class GameRenderer {

    protected GameWorld world;
    protected ArrayList<Entity> entities;

    private OrthographicCamera cam;
    private SpriteBatch batch;
    private Vector2 tempPos;

    public GameRenderer(GameWorld world){
        batch = new SpriteBatch();
        this.world = world;
    }

    public void render(float runtime){
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        entities = world.getEntities();

        batch.begin();

        if (world.isRunning()){//if the game is in the over world or is paused in the over world
            overWorldRender(runtime);
        }

        if (world.isCombat()){
            combatRender(runtime);
        }

        if (world.isPaused()){
            pausedMenuRender(runtime);
        }

        if (world.isReady()){
            mainMenuRender(runtime);
        }
    }

    public void mainMenuRender(float runtime){

    }

    public void pausedMenuRender(float runtime){

    }

    public void overWorldRender(float runtime){
        //batch.draw(AssetsLoader.background)
        for (int i=0; i<entities.size();i++){
            tempPos = entities.get(i).getPosition();
            if (entities.get(i).getType().equals("player")){
                if (entities.get(i).isIdle()) {
                    batch.draw(AssetsLoader.playerIdling.getKeyFrame(runtime, true), tempPos.x, tempPos.y);
                }
                else if (entities.get(i).isMoving()) {
                    batch.draw(AssetsLoader.playerMoving.getKeyFrame(runtime, true), tempPos.x, tempPos.y);
                }
            }
            else if (entities.get(i).getType().equals("tallgrass")){
                //batch.draw(AssetsLoader.tallgrass, tempPos.x, tempPos.y);
            }
        }
    }

    public void combatRender(float runtime){
        //batch.draw(AssetsLoader.combatBackground)
        for (int i=0;i<entities.size();i++){
            tempPos = entities.get(i).getPosition();
            if (entities.get(i).getType().equals("player")){
                if (entities.get(i).isIdle()){
                    batch.draw(AssetsLoader.playerIdling.getKeyFrame(runtime, true), tempPos.x, tempPos.y);
                }
                else if (entities.get(i).isFighting()){
                    batch.draw(AssetsLoader.playerFighting.getKeyFrame(runtime, true), tempPos.x, tempPos.y);
                }
            }
        }
    }
}
