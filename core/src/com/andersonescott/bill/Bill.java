package com.andersonescott.bill;


import com.andersonescott.bill.gameworld.GameScreen;
import com.badlogic.gdx.Game;

public class Bill extends Game{

    @Override
    public void create(){
        setScreen(new GameScreen());
    }
}
