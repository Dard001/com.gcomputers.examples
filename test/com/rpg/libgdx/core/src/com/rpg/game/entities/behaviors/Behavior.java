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
package com.rpg.game.entities.behaviors;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

/**
 *
 * @author Dard
 */
public class Behavior {
    ArrayList<Vector2> destinations;
    
    public void addDestination(Vector2 destination){
        destinations.add(destination);
    }
    
    public Vector2 getDestination(){
        if (destinations.get(0) != null){
            return destinations.get(0);
        }
        return null;
    }
    
    public void setY(float posY){
        destinations.set(0, new Vector2(destinations.get(0).x, posY));
    }
    
    public void setX(float posX){
        System.out.println("Setting new X");
        destinations.set(0, new Vector2(posX, destinations.get(0).y));
    }
    
    public void removeCurrentDestination(){
        destinations.remove(0);
        System.out.println("Going to next destination " + destinations.get(0).x + " " + destinations.get(0).y);
    }
    
    public int getDestinationLength(){
        return destinations.size();
    }
    
    public Behavior(){
        destinations = new ArrayList();
    }
}
