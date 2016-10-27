package com.andersonescott.bill.objects;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Player extends Entity{

    protected int xp, money;
    protected ArrayList<Item> inventory;

    public Player(Vector2 position){
        super(position);
        xp = 0;
        money = 0; //for now
        inventory = new ArrayList<Item>();
        image = new Texture("bill.png");
    }

}
