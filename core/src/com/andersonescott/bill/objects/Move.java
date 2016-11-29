package com.andersonescott.bill.objects;


import com.andersonescott.bill.objects.entities.Entity;

public class Move {

    protected int damageMod, manaDrain;
    protected double lifesteal;
    protected String name, type;

    public Move(Entity entity){ //creates random move with mana drain scaled to the entity's mana
        int random = (int)(Math.random()*100);
        manaDrain = 0;
        type = "";
        if (random < 55) {
            damageMod = (int)(Math.random()+1);
            manaDrain += entity.getMana()*(damageMod/2);
        }
        if (random > 45) {
            lifesteal = Math.random() * 0.2;
            manaDrain += (int)(entity.getMana() * lifesteal);
        }
        genType();
    }

    public Move(int damageMod, int manaDrain, double lifesteal){//creates a move with specified stats. does not scale mana drain to player lvl
        this.damageMod = damageMod;
        this.manaDrain = manaDrain;
        this.lifesteal = lifesteal;
        genType();
    }

    private void genType(){
        if (damageMod >= 1.5){
            type += "Smack";
        }
        else {
            type += "Poke";
        }
        if (lifesteal >= .5){
            type += "Soul Crush";
        }
        else {
            type += "Life Steal";
        }
        if ((type.contains("Smack")||type.contains("Poke"))&&(type.contains("Soul Crush")||type.contains("Life Steal"))){ //reformat type
            if (type.contains("Smack")){
                type = type.substring(5) + "ing Smack";
            }
            else {
                type = type.substring(4) + "ing Poke";
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
