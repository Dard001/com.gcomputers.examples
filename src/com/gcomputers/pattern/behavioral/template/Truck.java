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
package com.gcomputers.pattern.behavioral.template;

/**
 *
 * @author Dard
 */
public class Truck extends VehicleBuilder{
        @Override
    public void addEngine() {
        System.out.println("Add a Truck engine of your choice.");
    }

    @Override
    public void tuneEngine() {
        System.out.println("Tune the Truck engine.");
    }

    @Override
    public void addTires() {
        System.out.println("Add Truck tires of your choice.");
    }
}
