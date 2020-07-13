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
package com.gcomputers.pattern.creational.prototype;

import java.util.Hashtable;

/**
 *
 * @author Dard
 */
public class VehicleCache {
    private static Hashtable<String, Vehicle> vehicleMap = new Hashtable<String, Vehicle>();
    
    public static Vehicle getVehicle(String vehicleId){
        Vehicle cachedVehicle = vehicleMap.get(vehicleId);
        
        return (Vehicle) cachedVehicle.clone();
    }
    
    public static void loadCache(){
        Car car = new Car();
        car.setId("1");
        vehicleMap.put(car.getId(), car);
        
        Truck truck = new Truck();
        truck.setId("2");
        vehicleMap.put(truck.getId(), truck);
        
        Van van = new Van();
        van.setId("3");
        vehicleMap.put(van.getId(), van);
    }
}
