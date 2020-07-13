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
package com.gcomputers.pattern.creational.factorymethod;

/**
 *
 * @author Dard
 */
public abstract class Main {
    
    public static void main(String[] args){
        System.out.println(VehicleFactoryHelper.buildVehicle(VehicleType.BOAT));
        System.out.println(VehicleFactoryHelper.buildVehicle(VehicleType.CAR));
        System.out.println(VehicleFactoryHelper.buildVehicle(VehicleType.MOTORCYCLE));
        System.out.println(VehicleFactoryHelper.buildVehicle(VehicleType.PLANE));
        System.out.println(VehicleFactoryHelper.buildVehicle(VehicleType.TRUCK));
    }
}
