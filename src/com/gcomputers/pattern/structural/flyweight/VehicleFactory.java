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

import java.util.HashMap;

/**
 *
 * @author Dard
 */
public abstract class VehicleFactory {
    private static HashMap <String, Vehicle> hashMap = new HashMap<String, Vehicle>(); 
    
    public static Vehicle getVehicle(String type){
        Vehicle vehicle = null;
        
        if (hashMap.containsKey(type)){
            vehicle = hashMap.get(type);
        } else {
            switch(type){
                case "Car":
                    System.out.println("Car created.");
                    vehicle = new Car();
                    break;
                case "Truck":
                    System.out.println("Truck created.");
                    vehicle = new Truck();
                    break;
                default:
                    System.exit(-1);
                    break;
            }
            hashMap.put(type, vehicle);
        }
        return vehicle;
    }
}
