package com.andersonescott.bill.objects.items;


import com.andersonescott.bill.objects.Move;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Weapon extends Item{

    protected int dmg, manaRep, critChance, bonusHealth, healthRep, bonusMana;
    protected ArrayList<Move> moves;

    public Weapon(int lvl, Rarity rarity, Texture image, int dmg, int manaRep, int critChance, int bonusHealth, int healthRep, int bonusMana){ //add more as they come
        super(lvl, rarity, image);
        this.dmg = dmg;
        this.manaRep = manaRep;
        this.critChance = critChance;
        this.bonusHealth = bonusHealth;
        this.healthRep = healthRep;
        this.bonusMana = bonusMana;
        init(bonusHealth, healthRep, bonusMana);
    }

    public int getDmg() {
        return dmg;
    }

    public int getManaRep() {
        return manaRep;
    }

    public int getCritChance() {
        return critChance;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public int getHealthRep() {
        return healthRep;
    }

    public int getBonusMana() {
        return bonusMana;
    }

    private void init(int bonusHealth, int healthRep, int bonusMana){
        //TODO add name and move generator based on these stats and weapon type
    }
}
