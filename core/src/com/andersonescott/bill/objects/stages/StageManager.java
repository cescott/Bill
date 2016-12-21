package com.andersonescott.bill.objects.stages;


import com.andersonescott.bill.objects.Move;
import com.andersonescott.bill.objects.entities.Enemy;
import com.andersonescott.bill.objects.items.Weapon;
import com.andersonescott.bill.objects.items.WeaponFactory;
import com.andersonescott.bill.objects.stages.terrain.Terrain;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class StageManager {
    private static Stage[] stages;//zero indexed
    public static Stage currentStage;

    public static void loadStages(){
        stages = new Stage[] {
                new Stage(
                        new Terrain[]{ //array of terrain
                                new Terrain(new Vector2(0, 0), 0, 0),//terrain vars
                                new Terrain(new Vector2(0, 0), 0, 0),//etc
                        },
                        new Enemy[]{ //enemy array
                                new Enemy(//enemy constructor variant 1
                                        new Vector2(0,0), 0, "type"
                                ),
                                new Enemy(//enemy constructor variant 2 (for bosses and special enemies)
                                        new Vector2(0, 0), new Rectangle(0, 0, 0, 0),"type", 0, 0, 0, 0, 0,
                                        new Move[] {
                                                new Move (0, 0, 0)
                                        }, WeaponFactory.makeWeapon(0, "Sword")
                                )
                        },"biome", 0, 0, 0 //other stage variables
                ),
                new Stage(
                        new Terrain[]{
                                new Terrain(new Vector2(0, 0), 0, 0),
                                new Terrain(new Vector2(0, 0), 0, 0),//etc
                        },
                        new Enemy[]{
                                new Enemy(
                                        new Vector2(0,0), 0, "type"
                                ),
                                new Enemy(
                                        new Vector2(0, 0), new Rectangle(0, 0, 0, 0), "type", 0, 0, 0, 0, 0,
                                        new Move[] {
                                                new Move (0, 0, 0)
                                        }, WeaponFactory.makeWeapon(0, "Sword")
                                )
                        },"biome", 0, 0, 0 //other stage variables
                ),//etc
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
