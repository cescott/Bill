package com.andersonescott.bill.objects.stages;


import com.andersonescott.bill.objects.stages.terrain.Terrain;


public class Stage {
    protected Terrain[] terrain;
    protected int index;//its relative position to other stages (etc, stage 2 is "next to" stage 1 and 3)
    protected int height, length;

    public Stage(Terrain[] terrain, int index, int height, int length){
        this.terrain = terrain;
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

    public Terrain[] getTerrain() {
        return terrain;
    }
}
