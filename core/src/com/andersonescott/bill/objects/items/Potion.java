package com.andersonescott.bill.objects.items;

import com.badlogic.gdx.graphics.Texture;

public class Potion extends Item {

    protected String type;

    protected int effect;

    protected double rarityScale, typeScale;

    public Potion(int lvl, Rarity rarity, Texture image, String type) {
        super(lvl, rarity, image);

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

        if (type.equals("Health") || type.equals("Mana")) {
            typeScale = 15*rarityScale*rarityScale;
        }
        if (type.equals("Power")) {
            typeScale = 20;
        }

        name = type + " Potion";
        effect = (int)(Math.pow(1.1, (lvl-1))*rarityScale*typeScale);
    }

}
