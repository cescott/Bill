package com.andersonescott.bill.objects.items;


import com.badlogic.gdx.graphics.Texture;

public abstract class Item {

    protected int value, lvl;

    protected Texture image;

    protected Rarity rarity;

    public enum Rarity {
        COMMON, UNCOMMON, RARE, LEGENDARY
    }

    public Item(int value, int lvl, Rarity rarity, Texture image){
        this.value = value;
        this.lvl = lvl;
        this.rarity = rarity;
        this.image = image;
    }

    public Texture getImage() {
        return image;
    }

    public int getLvl() {
        return lvl;
    }

    public int getValue() {
        return value;
    }

    public boolean isCommon(){
        return rarity == Rarity.COMMON;
    }

    public boolean isUncommon(){
        return  rarity == Rarity.UNCOMMON;
    }

    public boolean isRare(){
        return rarity == Rarity.RARE;
    }

    public boolean isLegendary(){
        return rarity == Rarity.LEGENDARY;
    }
}
