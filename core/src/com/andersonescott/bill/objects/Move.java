package com.andersonescott.bill.objects;


public class Move {

    protected int damageMod, manaDrain;
    protected double lifesteal;
    protected String name, type;

    public Move(){ //creates random move
        int random = (int)(Math.random()*100);
        manaDrain = 0;
        type = "";
        if (random < 55) {
            damageMod = (int)(Math.random()*2);
            manaDrain += 33*(damageMod/2);
            if (damageMod >= 1){
                type += "Smack";
            }
            else {
                type += "Poke";
            }
        }
        if (random > 45) {
            lifesteal = Math.random();
            manaDrain += (int)(50*lifesteal);
            if (lifesteal >= .5){
                type += "Soul Crush";
            }
            else {
                type += "Life Steal";
            }
        }
    }

    public int getDamageMod() {
        return damageMod;
    }

    public double getLifesteal() {
        return lifesteal;
    }

    public int getManaDrain() {
        return manaDrain;
    }
}
