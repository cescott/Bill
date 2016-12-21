package com.andersonescott.bill.objects.stages;


import com.andersonescott.bill.objects.entities.Enemy;
import com.andersonescott.bill.objects.stages.terrain.Terrain;


public class Stage {
    protected Terrain[] terrain;
    protected Enemy[] possibleEnemies;
    protected String biome;
    protected int index;//its relative position to other stages (etc, stage 2 is "next to" stage 1 and 3)
    protected int height, length;

    public Stage(Terrain[] terrain, Enemy[] possibleEnemies, String biome, int index, int height, int length){
        this.terrain = terrain;
        this.possibleEnemies = possibleEnemies;
        this.biome = biome;
        this.index = index;
        this.height = height;
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getIndex() {
        return index;
    }

    public String getBiome() {
        return biome;
    }

    public Enemy getEnemey(){
        //TODO add random drop table
        return possibleEnemies[(int)(Math.random()*possibleEnemies.length)];
    }

    public Terrain[] getTerrain() {
        return terrain;
    }
}
