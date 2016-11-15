package com.andersonescott.bill;


import com.andersonescott.bill.gameworld.GameScreen;
import com.andersonescott.bill.gameworld.assetMethods.AssetsLoader;
import com.badlogic.gdx.Game;

public class Bill extends Game{

    @Override
    public void create(){
        AssetsLoader.load();
        setScreen(new GameScreen());
    }
    @Override
    public void dispose(){
        super.dispose();
        AssetsLoader.dispose();
    }
}
