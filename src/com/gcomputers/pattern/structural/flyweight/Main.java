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

import java.util.Random;

/**
 *
 * @author Dard
 */
public abstract class Main {
    public static String[] vehicleType = {"Car","Truck"};
    public static String[] engine = {"4-cylinder","V6","V8"};
    
    public static String getRandVehicleType(){
        Random r = new Random();
        int randInt = r.nextInt(vehicleType.length);
        return vehicleType[randInt];
    }
    
    public static String getRandEngine(){
        Random r = new Random();
        int randInt = r.nextInt(engine.length);
        return engine[randInt];
    }
    
    public static void main(String[] arges){
        for (int i = 0; i < 10; i++){
            Vehicle vehicle = VehicleFactory.getVehicle(getRandVehicleType());
            vehicle.assignEngine(getRandEngine());
            
            vehicle.describeVehicle();
        }
    }
}
