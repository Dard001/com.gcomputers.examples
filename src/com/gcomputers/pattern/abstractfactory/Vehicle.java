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
package com.gcomputers.pattern.abstractfactory;

/**
 *
 * @author Dard
 */
abstract class Vehicle {
    VehicleType type = null;
    Model model = null;
    Location location = null;
        
    abstract void construct();

    void setVehicleType(VehicleType type){
        this.type = type;
    }
    
    VehicleType getVehicleType(){
        return type;
    }
    
    Model getVehicleModel(){
        return model;
    }
    
    void setVehicleModel(Model model){
        this.model = model;
    }
    void setVehicleLocation(Location location){
        this.location = location;
    }
    
    Location getVehicleLocation(){
        return location;
    }

    public String toString(){
        return "Type:" + type + ", Model:" + model + " Location:" + location;
    }
    
    Vehicle(VehicleType type, Model model, Location location){
        this.type = type;
        this.model = model;
        this.location = location;
    }
}
