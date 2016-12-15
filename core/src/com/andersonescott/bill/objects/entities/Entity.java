package com.andersonescott.bill.objects.entities;

import com.andersonescott.bill.objects.items.Weapon;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

    protected Vector2 position, velocity, acceleration;

    protected int health, mana, healthRep, manaRep, lvl;

    protected Weapon equipedWep;

    protected boolean alive;

    protected State state;

    protected String type;

    protected Texture texture;

    public enum State{
        IDLING, MOVING, FIGHTING
    }

    public Entity(Vector2 position){
        this.position = new Vector2(position);
        velocity = new Vector2();
        acceleration = new Vector2();
        alive = true;
    }

    public void update(float delta){
        velocity.add(acceleration.scl(delta));
        position.add(velocity.scl(delta));
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
        alive = false;
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

    public int getHealth() {
        return (int)(health * Math.pow(1.1, lvl -1) + equipedWep.getBonusHealth());
    }

    public int getHealthRep() {
        return (int)(healthRep * Math.pow(1.1, lvl -1) + equipedWep.getHealthRep());
    }

    public int getMana() {
        return (int)(mana * Math.pow(1.1, lvl -1) + equipedWep.getBonusMana());
    }

    public int getManaRep() {
        return (int)(manaRep * Math.pow(1.1, lvl -1) + equipedWep.getManaRep());
    }

    public int getLvl() {
        return lvl;
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

    public boolean isAlive(){
        return alive;
    }

    public String getType(){
        return type;
    }
}
