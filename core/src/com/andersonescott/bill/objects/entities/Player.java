package com.andersonescott.bill.objects.entities;


import com.andersonescott.bill.objects.items.Item;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.Animation;

import java.util.ArrayList;

public class Player extends Entity {

    protected int xp, money;
    protected ArrayList<Item> inventory;

    public Player(Vector2 position){
        super(position);
        xp = 0;
        money = 0; //for now
        inventory = new ArrayList<Item>();
    }

}
