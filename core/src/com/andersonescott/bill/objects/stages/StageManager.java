package com.andersonescott.bill.objects.stages;


import com.andersonescott.bill.objects.stages.terrain.Terrain;
import com.badlogic.gdx.math.Vector2;

public class StageManager {
    private static Stage[] stages;//zero indexed
    public static Stage currentStage;

    public static void loadStages(){
        stages = new Stage[] {
                new Stage(
                        new Terrain[]{
                                new Terrain(new Vector2(0, 0), 0, 0),
                                new Terrain(new Vector2(0, 0), 0, 0),//etc
                        }, 0, 0, 0 //other stage variables
                ),
                new Stage(
                        new Terrain[]{
                                //more terrain
                        }, 1, 0, 0//the stage variables
                )//etc
        };
        currentStage = stages[0];
    }

    public static void nextStage(){
        currentStage = stages[currentStage.getIndex()+1];
    }
    public static void previousStage(){
        currentStage = stages[currentStage.getIndex()-1];
    }
}
