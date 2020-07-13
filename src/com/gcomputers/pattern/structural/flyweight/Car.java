/*
 * Copyright (C) 2020 Dard
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
package com.gcomputers.pattern.structural.flyweight;

/**
 *
 * @author Dard
 */
public class Car implements Vehicle{
    private final String type;
    private String engine;
    
    public void assignEngine(String engine){
        this.engine = engine;
    }
    
    public void describeVehicle(){
        System.out.println(type + " with a " + engine + " engine.");
    }
    
    public Car(){
        type = "I'm a Car";
    }
}
