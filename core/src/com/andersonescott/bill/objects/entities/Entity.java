package com.andersonescott.bill.objects.entities;

import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

    protected Vector2 position, velocity, acceleration;

    protected int health, mana, healthRep, manaRep;

    protected State state;

    public enum State{
        IDLING, MOVING, FIGHTING
    }

    public Entity(Vector2 position){
        this.position = new Vector2(position);
        velocity = new Vector2();
        acceleration = new Vector2();
    }

    public void update(float delta){
        velocity.add(acceleration.scl(delta));
        position.add(velocity);
        if (!(velocity.isZero())){
            state = State.MOVING;
        }
        if (velocity.isZero()){
            state = State.IDLING;
        }
        if (health <= 0){
            this.die();
        }
    }

    public void die(){

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

    public boolean isIdle(){
        return state == State.IDLING;
    }

    public boolean isMoving(){
        return state == State.MOVING;
    }

    public boolean isFighting(){
        return state == State.FIGHTING;
    }
}
