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

    protected String[] effects = {
            "Power",
            "Mana",
            "Health",
            "HealthRep"
    };

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
        String type;
        String name;
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

        int dmgInt = (int)(Math.random()*80) + 20;
        int critInt = (int)(Math.random()*80) + 20;
        int manaRepInt = (int)(Math.random()*80) + 20;

        double dmgPercent = dmgInt/(dmgInt + critInt + manaRepInt);
        double critPercent = critInt/(dmgInt + critInt + manaRepInt);
        double manaRepPercent = manaRepInt/(dmgInt + critInt + manaRepInt);

        if (dmgPercent >= .5) {
            type = "Hammer";
            name = hammerNames.remove((int)(Math.random()*hammerNames.size())) + "hammer";
            if (hammerNames.size() == 0) {
                for (int i = 0; i < hammer.length; i++) {
                    hammerNames.add(hammer[i]);
                }
            }
        }
        else if (critPercent >= .5) {
            type = "Dagger";
            name = daggerNames.remove((int)(Math.random()*daggerNames.size())) + "dagger";
            if (daggerNames.size() == 0) {
                for (int i = 0; i < dagger.length; i++) {
                    daggerNames.add(dagger[i]);
                }
            }
        }
        else if (manaRepPercent >= .5) {
            type = "Staff";
            name = staffNames.remove((int)(Math.random()*staffNames.size())) + "staff";
            if (staffNames.size() == 0) {
                for (int i = 0; i < staff.length; i++) {
                    staffNames.add(staff[i]);
                }
            }
        }
        else {
            type = "Sword";
            name = swordNames.remove((int)(Math.random()*swordNames.size())) + "sword";
            if (swordNames.size() == 0) {
                for (int i = 0; i < sword.length; i++) {
                    swordNames.add(sword[i]);
                }
            }
        }

        String effect = effects[(int)(Math.random()*4)];

        if (effect.equals("Power")) {


        return new Weapon(level, rarity, image, );
    }
}
