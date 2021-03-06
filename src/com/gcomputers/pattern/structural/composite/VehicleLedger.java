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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dard
 */
public class VehicleLedger implements Vehicle{
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();
    
    public void showVehicleDetails(){
        for(Vehicle vehicle:vehicleList){
            vehicle.showVehicleDetails();
        }
    }
    
    public void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
    }
    
    public void removeVehicle(Vehicle vehicle){
        vehicleList.remove(vehicle);
    }
}
