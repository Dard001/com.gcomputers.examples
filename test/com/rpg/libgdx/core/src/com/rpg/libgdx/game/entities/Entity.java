/*
 * Copyright (C) 2020 G-Computers
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rpg.libgdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.rpg.game.entities.behaviors.Behavior;
import com.rpg.libgdx.game.maps.TiledGameMap;

/**
 *
 * @author Dard
 */
public abstract class Entity {
    private Texture image;
    private Vector2 pos;
    private static final int SPEED = 80;
    protected float velocityY = 0;
    protected float velocityX = 0;
    private TiledGameMap map;
    private Behavior behavior;
    
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, 14, 32);
    }
    
    public void update(float deltaTime){
        /*
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            moveX(-SPEED * deltaTime);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            moveX(SPEED * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            moveY(-SPEED * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            moveY(SPEED * deltaTime);
        }
        */
        if (behavior.getDestinationLength() > 0){
            if(behavior.getDestination().x == pos.x && behavior.getDestination().y == pos.y){
                System.out.println("Reached Destination");
                behavior.removeCurrentDestination();
            } else {
                if (pos.x < behavior.getDestination().x){
                    if (!map.doesRectCollideWithMap(pos.x + (SPEED * deltaTime), pos.y, 14, 32)){
                            moveX(SPEED * deltaTime);
                    } else {
                        System.out.println("Reached X1");
                        behavior.setX(pos.x);
                    }
                }
                if (pos.x > behavior.getDestination().x){
                    if (!map.doesRectCollideWithMap(pos.x - (SPEED * deltaTime), pos.y, 14, 32)){
                            moveX(-SPEED * deltaTime);
                    } else {
                        System.out.println("Reached X2");
                        behavior.setX(pos.x);
                    }
                }
                if (pos.y < behavior.getDestination().y){
                    if (!map.doesRectCollideWithMap(pos.x, pos.y  + (SPEED * deltaTime), 14, 32)){
                        moveY(SPEED * deltaTime);
                    } else {
                        System.out.println("Reached Y1");
                        behavior.setY(pos.y);
                    }
                }
                if (pos.y > behavior.getDestination().y){
                    if (!map.doesRectCollideWithMap(pos.x, pos.y  - (SPEED * deltaTime), 14, 32)){
                        moveY(-SPEED * deltaTime);
                    } else {
                        System.out.println("Reached Y2");
                        behavior.setY(pos.y);
                    }
                }
            }
        }
    }
    
    protected void moveX (float amount) {
        float newX = pos.x + amount;
        
        if (!map.doesRectCollideWithMap(newX, pos.y, 14, 32))
            this.pos.x = newX;
    }
    
    protected void moveY (float amount) {
        float newY = pos.y + amount;
        
        if (!map.doesRectCollideWithMap(pos.x, newY, 14, 32))
        this.pos.y = newY;
    }
    
    public void setToMap(TiledGameMap map){
        this.map = map;
    }
        
    public Entity(Texture image, int x, int y){
        this.image = image;
        this.pos = new Vector2(x, y);
        this.behavior = new Behavior();
        behavior.addDestination(new Vector2(100, 100));
        behavior.addDestination(new Vector2(50, 800));
        behavior.addDestination(new Vector2(300, 500));
        behavior.addDestination(new Vector2(700, 900));
        behavior.addDestination(new Vector2(200, 50));
        behavior.addDestination(new Vector2(500, 150));
        
    }
}
