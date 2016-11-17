package com.andersonescott.bill.objects.items;

import com.badlogic.gdx.graphics.Texture;

public class Potion extends Item {

    protected String type;

    protected int effect;

    protected double rarityScale;

    public Potion(int value, int lvl, Rarity rarity, Texture image, String type) {
        super(value, lvl, rarity, image);

        if (rarity == Rarity.COMMON) {
            rarityScale = 1;
        }
        else if (rarity == Rarity.UNCOMMON) {
            rarityScale = 1.1;
        }
        else if (rarity == Rarity.RARE) {
            rarityScale = 1.25;
        }
        else if (rarity == Rarity.LEGENDARY) {
            rarityScale = 1.6;
        }

        if (type.equals("Health")) {
            
        name = type + " Potion";
        effect = (int)(Math.pow(1.1, (lvl-1))*rarityScale*50);
    }

}
