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
package com.gcomputers.factorypattern;

/**
 *
 * @author Dard
 */
public class VehicleFactory {
    public static Vehicle buildVehicle(VehicleType type){
        Vehicle vehicle = null;
        switch(type){
            case BOAT:
                vehicle = new Boat();
                break;
            case CAR:
                vehicle = new Car();
                break;
            case MOTORCYCLE:
                vehicle = new Motorcycle();
                break;
            case PLANE:
                vehicle = new Plane();
                break;
            case TRUCK:
                vehicle = new Truck();
                break;
            default:
                System.exit(-1);
                break;
        }
        return vehicle;
    }
}
