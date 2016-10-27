package com.andersonescott.bill.objects;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.Animation;

import java.util.ArrayList;

public class Player extends Entity{

    protected int xp, money;
    protected ArrayList<Item> inventory;
    protected TextureRegion[] idle, moving, fighting;
    protected int idleFrames, movingFrames, fightingFrames;
    protected Animation idling, movement, combat;

    public Player(Vector2 position){
        super(position);
        xp = 0;
        money = 0; //for now
        inventory = new ArrayList<Item>();

        texture = new Texture("bill.png");

        idle = new TextureRegion[idleFrames];
        moving = new TextureRegion[movingFrames];
        fighting = new TextureRegion[fightingFrames];

        for (int i=0; i<idleFrames; i++){
            idle[i] = new TextureRegion(texture, 0, 0, 0, 0); //TODO make this move through the texture
        }

        for(int i=0; i<movingFrames; i++){
            moving[i] = new TextureRegion(texture, 0, 0, 0, 0); //TODO make this move through the texture
        }

        for (int i=0; i<fightingFrames; i++){
            fighting[i] = new TextureRegion(texture, 0, 0, 0, 0); //TODO make this move through the texture
        }

        idling = new Animation(0.06f, idle);
        movement = new Animation(0.06f, moving);
        combat = new Animation(0.06f, fighting);
    }

}
