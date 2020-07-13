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
package com.gcomputers.pattern.structural.composite;

/**
 *
 * @author Dard
 */
public class Truck implements Vehicle{
    private String make;
    private String model;
    private int id;
    
    public void showVehicleDetails(){
        System.out.println("Truck ID:" + this.id + " is a " + this.make + " " + this.model);
    }
    
    public Truck (int id, String make, String model){
        this.id = id;
        this.make = make;
        this.model = model;
    }
}
