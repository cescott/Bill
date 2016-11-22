package com.andersonescott.bill.objects.items;

import java.util.ArrayList;

public class WeaponFactory {

    protected String[] sword = {
            "Swanky",
            "S-s-s-",
            "Slippy",
            "Serpent",
            "Silly",
            "Super",
            "Dord",
            "Sword",
            "Stabby",
            "Purple",
            "Sonofa",
    };
    protected String[] dagger = {

    };
    protected String[] staff = {

    };
    protected String[] hammer = {

    };
    protected static ArrayList<String> swordNames;
    protected static ArrayList<String> daggerNames;
    protected static ArrayList<String> staffNames;
    protected static ArrayList<String> hammerNames;

    public WeaponFactory() {
        for (int i = 0; i < sword.length; i++) {
            swordNames.add(sword[i]);
        }
        for (int i = 0; i < dagger.length; i++) {
            daggerNames.add(dagger[i]);
        }
        for (int i = 0; i < staff.length; i++) {
            staffNames.add(staff[i]);
        }
        for (int i = 0; i < hammer.length; i++) {
            hammerNames.add(hammer[i]);
        }
    }

    public Weapon makeWeapon(int playerLvl){
        int level;
        int rare = (int)(Math.random() * 100);
        Item.Rarity rarity;


        if (playerLvl > 2) {
            level = playerLvl + (int) (Math.random() * 4) - 2;
        }
        else {
            level = playerLvl;
        }

        if (rare >= 98) {
            rarity = Item.Rarity.LEGENDARY;
        }
        else if (rare >= 85) {
            rarity = Item.Rarity.RARE;
        }
        else if (rare >= 50) {
            rarity = Item.Rarity.UNCOMMON;
        }
        else {
            rarity = Item.Rarity.COMMON;
        }



        return new Weapon(level, rarity, image, );
    }
}
