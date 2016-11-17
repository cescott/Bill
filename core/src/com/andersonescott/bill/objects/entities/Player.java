package com.andersonescott.bill.objects.entities;


import com.andersonescott.bill.objects.items.Item;
import com.badlogic.gdx.math.Vector2;


import java.util.ArrayList;

public class Player extends Entity {

    protected int xp, money;
    protected ArrayList<Item> inventory;

    public Player(Vector2 position){
        super(position);
        health = 50;
        mana = 100;
        healthRep = 0;
        manaRep = 10; //change these values after testing
        xp = 0;
        money = 0; //for now
        inventory = new ArrayList<Item>();
    }

}
