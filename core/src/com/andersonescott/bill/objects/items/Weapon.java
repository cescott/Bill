package com.andersonescott.bill.objects.items;


import com.badlogic.gdx.graphics.Texture;

public class Weapon extends Item{

    protected int dmg, manaRep, critChance, bonusHealth, healthRep, bonusMana;

    public Weapon(int value, int lvl, Rarity rarity, Texture image, int dmg, int manaRep, int critChance, int bonusHealth, int healthRep, int bonusMana){ //add more as they come
        super(value, lvl, rarity, image);
        this.dmg = dmg;
        this.manaRep = manaRep;
        this.critChance = critChance;
        this.bonusHealth = bonusHealth;
        this.healthRep = healthRep;
        this.bonusMana = bonusMana;
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
}
