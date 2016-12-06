package com.andersonescott.bill.gameworld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameRenderer {

    protected GameWorld world;

    private OrthographicCamera cam;
    private SpriteBatch batch;

    public GameRenderer(GameWorld world){
        batch = new SpriteBatch();
        this.world = world;
    }

    public void render(float runtime){
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        if (!world.isCombat()||!world.isReady()){//if the game is in the over world or is paused in the over world
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
        
    }

    public void combatRender(float runtime){

    }
}
