package com.andersonescott.bill.objects.terrain;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Terrain {
    protected Vector2 position, scrollSpeed;//position is bottom left corner
    protected int height, width; //MUST BE a whole number of tiles
    protected Rectangle surface, body;
    //surface is grass, sand, the top most layer. body is anything showing under it.
    //there might need to be other textures as well in order to add detail
    public Terrain(Vector2 position, int height, int width){
        this.position = position;
        this.height = height;
        this.width = width;
        body = new Rectangle(position.x, position.y, width, height);
        surface = new Rectangle(position.x, position.y - height + 10, width, 10); //10 pixel thick surface layer
        scrollSpeed.set(0,0);
    }

    public void update(float delta){
        position.add(scrollSpeed.scl(delta));
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Vector2 getScrollSpeed() {
        return scrollSpeed;
    }

    public Rectangle getBody() {
        return body;
    }

    public Rectangle getSurface() {
        return surface;
    }
}