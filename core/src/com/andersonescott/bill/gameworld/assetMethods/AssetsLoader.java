package com.andersonescott.bill.gameworld.assetMethods;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetsLoader {
    protected static Texture player;
    protected static TextureRegion[] idle, moving, fighting;
    protected static int idleFrames, movingFrames, fightingFrames;
    protected static Animation idling, movement, combat;

    public static void load(){
        //player stuff
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

        idling = new Animation(0.06f, idle);
        movement = new Animation(0.06f, moving);
        combat = new Animation(0.06f, fighting);
    }
    public static void dispose(){
        player.dispose();
    }
}

