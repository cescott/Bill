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

    public GameRenderer(GameWorld world){
        this.world = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 0, 0); //TODO the zeros are temp positions
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        initAssets();
    }

    private void initAssets(){
        //initiate all the textures, sound files, etc. required for the game rendering
    }

    public void render(float runtime){
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        entities = world.getEntities();

        batch.begin();

        if (world.isRunning()){
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
