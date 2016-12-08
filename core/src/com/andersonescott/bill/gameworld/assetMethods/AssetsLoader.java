package com.andersonescott.bill.gameworld.assetMethods;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetsLoader {

    //player assets
    private static Texture player;
    private static TextureRegion[] idle, moving, fighting;
    private static int idleFrames, movingFrames, fightingFrames;
    public static Animation playerIdling, playerMoving, playerFighting;

    //item assets
    public static Texture basicSword;

    public static void load(){
        //---------------PLAYER---------------//
        player = new Texture("bill.png");
        idle = new TextureRegion[idleFrames];
        moving = new TextureRegion[movingFrames];
        fighting = new TextureRegion[fightingFrames];

        for (int i=0; i<idleFrames; i++){
            idle[i] = new TextureRegion(player, 0, 0, 0, 0); //TODO make this move through the texture
        }

        for(int i=0; i<movingFrames; i++){
            moving[i] = new TextureRegion(player, 0, 0, 0, 0); //TODO make this move through the texture
        }

        for (int i=0; i<fightingFrames; i++){
            fighting[i] = new TextureRegion(player, 0, 0, 0, 0); //TODO make this move through the texture
        }

        playerIdling = new Animation(0.06f, idle);
        playerMoving = new Animation(0.06f, moving);
        playerFighting = new Animation(0.06f, fighting);

        //---------------ITEMS---------------//
        basicSword = new Texture("basicSword.png");
        //---------------BACKGROUNDS---------------//

        //---------------HUD---------------//

        //---------------ENEMIES----------------//
    }
    public static void dispose(){
        player.dispose();
    }
}

