package com.andersonescott.bill.gameworld;


import com.badlogic.gdx.Screen;

public class GameScreen implements Screen{

    protected GameRenderer renderer;
    protected GameWorld world;

    public GameScreen(){
        world = new GameWorld();
        renderer = new GameRenderer(world);
    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
