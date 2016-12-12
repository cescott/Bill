package com.andersonescott.bill.objects.entities;


import com.andersonescott.bill.gameworld.assetMethods.AssetsLoader;
import com.andersonescott.bill.objects.Move;
import com.andersonescott.bill.objects.items.Weapon;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.Animation;

import java.util.ArrayList;
import java.util.Arrays;

public class Enemy extends Entity{

    protected ArrayList<Move> moves;

    public Enemy(Vector2 position, String type, int lvl, int health, int mana, int healthRep, int manaRep, Move[] moves, Weapon weapon){
        super(position);
        this.type = type;
        this.lvl = lvl;
        this.health = health;
        this.mana = mana;
        this.healthRep = healthRep;
        this.manaRep = manaRep;
        this.moves = new ArrayList<Move>(Arrays.asList(moves));
        this.equipedWep = weapon;
    }

    public Enemy(Vector2 position, int lvl, String type){
        super (position);
        this.type = type;
        this.lvl = lvl;
        init(type);
    }

    private void init(String type) { //generates a random enemy based on its type
        /*
        if (type.equals("")){
            health = ;
            mana = ;
            healthRep = ;
            manaRep = ;
            moves = new ArrayList<Move>(Arrays.asList(new Move[] { }));
            equipedWep = ;//WeaponFactory.makeRandom(String type)
            texture = AssetsLoader.texture;
        }
        else if (type.equals("")){

        }
        */
        TextureRegion[] tempIdle = new TextureRegion[AssetsLoader.idleFrames];
        TextureRegion[] tempCombat = new TextureRegion[AssetsLoader.fightingFrames];
        for (int i=0; i< AssetsLoader.idleFrames;i++){
            tempIdle[i] = new TextureRegion(texture, 0, 0, 0, 0);
        }
        for (int i=0; i< AssetsLoader.fightingFrames;i++){
            tempCombat[i] = new TextureRegion(texture, 0, 0, 0, 0);
        }
        idling = new Animation(0.06f, tempIdle);
        combat = new Animation(0.06f, tempCombat);
    }
    @Override
    public void die(){
        super.die();
        if (Math.random()>= .8){ //20% chance of dropping weapon
            //drop weapon
        }
        //drop gold based on a function dependent on lvl
    }

    public Texture getTexture(){
        return texture;
    }
}
