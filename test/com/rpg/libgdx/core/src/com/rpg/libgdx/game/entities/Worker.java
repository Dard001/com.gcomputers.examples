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
import com.rpg.libgdx.game.maps.TiledGameMap;

/**
 *
 * @author Dard
 */
public class Worker extends Entity {
    private Texture image;
    private Vector2 pos;
    private static final int SPEED = 80;
    protected float velocityY = 0;
    protected float velocityX = 0;
    private TiledGameMap map;
      
    @Override
    public void update(float deltaTime){
        if (1 == 0){
            moveX(-SPEED * deltaTime);
        }
        if (1 == 0){
            moveX(SPEED * deltaTime);
        }
        if (1 == 0){
            moveY(-SPEED * deltaTime);
        }
        if (1 == 0){
            moveY(SPEED * deltaTime);
        }
    }
    
    public Worker(Texture image, int x, int y){
        super(image, x, y);
    }
}