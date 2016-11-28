package com.andersonescott.bill.objects.entities;


import com.andersonescott.bill.objects.Move;
import com.andersonescott.bill.objects.items.Weapon;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Arrays;

public class Enemy extends Entity{

    protected String type;
    protected ArrayList<Move> moves;
    protected Weapon weapon;

    public Enemy(Vector2 position, String type, int health, int mana, int healthRep, int manaRep, Move[] moves, Weapon weapon){
        super(position);
        this.type = type;
        this.health = health;
        this.mana = mana;
        this.healthRep = healthRep;
        this.manaRep = manaRep;
        this.moves = new ArrayList<Move>(Arrays.asList(moves));
        this.weapon = weapon;
    }

    public Enemy(Vector2 position, String type){
        super (position);
        this.type = type;
        init(type);
    }

    private void init(String type){ //generates a random enemy based on its type
        if (type.equals("")){
            health = ;
            mana = ;
            healthRep = ;
            manaRep = ;
            moves = new ArrayList<Move>(Arrays.asList(new Move[] { }));
            weapon = ;//WeaponFactory.makeRandom(String type)
        }
        else if (type.equals("")){

        }
    }
}
