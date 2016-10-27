package com.andersonescott.bill.objects;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

    protected Vector2 position, velocity, acceleration;
    protected Texture image, imageWep; //image would be for walking around in main map, imageWep would depend on weapon equipped

    public Entity(Vector2 position){
        this.position = new Vector2(position);
        velocity = new Vector2();
        acceleration = new Vector2();
    }

    public void update(float delta){
        velocity.add(acceleration.scl(delta));
        position.add(velocity);
    }

    public Texture getImage() {
        return image;
    }

    public Texture getImageWep() {
        return imageWep;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setPosition(Vector2 position){
        this.position = position;
    }

    public void setVelocity(Vector2 velocity){
        this.velocity = velocity;
    }

    public void setAcceleration(Vector2 acceleration){
        this.acceleration = acceleration;
    }
}
