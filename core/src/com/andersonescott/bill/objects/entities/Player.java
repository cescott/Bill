package com.andersonescott.bill.objects.entities;


import com.andersonescott.bill.gameworld.assetMethods.AssetsLoader;
import com.andersonescott.bill.objects.items.Item;
import com.andersonescott.bill.objects.items.Weapon;
import com.badlogic.gdx.math.Vector2;


import java.util.ArrayList;

public class Player extends Entity {

    protected int xp, money;
    protected ArrayList<Item> inventory;

    public Player(Vector2 position){
        super(position);
        lvl = 1;
        health = 50;
        mana = 100;
        healthRep = 0;
        manaRep = 0; // these values might change after play testing
        xp = 0;
        money = 0; //for now
        Weapon wep = new Weapon(1, Item.Rarity.COMMON, "Basic Sword", "Sword", AssetsLoader.basicSword, 10, 10, 10, 0, 0, 0);
        inventory = new ArrayList<Item>();
        inventory.add(wep);
        equipedWep = wep;
        type = "player";
    }

    @Override
    public void die(){
        super.die();
        money = (int)(money*.8);
    }

}
