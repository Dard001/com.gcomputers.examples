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
package com.gcomputers.pattern.builder;

/**
 *
 * @author Dard
 */
public class Car {
    private final String make;
    private final String model;
    private final int horsePower;
    private final String color;
    private final boolean frontWheelDrive;
    
    public String getMake(){
        return make;
    }
    
    public String getModel(){
        return model;
    }
    
    public int getHorsePower(){
        return horsePower;
    }
    
    public String getColor(){
        return color;
    }
    
    public boolean getFrontWheelDrive(){
        return frontWheelDrive;
    }
    
    public String toString(){
        return "Make:" + this.make + 
                " Model:" + this.model + 
                " Horsepower:" + this.horsePower + 
                " Color:" + this.color + 
                " Front Wheel Drive:" + this.frontWheelDrive;
    }
    
    private Car(CarBuilder builder){
        this.make = builder.make;
        this.model = builder.model;
        this.horsePower = builder.horsePower;
        this.color = builder.color;
        this.frontWheelDrive = builder.frontWheelDrive;
    }


    public static class CarBuilder {
        private final String make;
        private final String model;
        private int horsePower;
        private String color;
        private boolean frontWheelDrive;

        public CarBuilder(String make, String model){
            this.make = make;
            this.model = model;
        }

        public CarBuilder horsePower(int horsePower){
            this.horsePower = horsePower;
            return this;
        }
        
        public CarBuilder color(String color){
            this.color = color;
            return this;
        }
        
        public CarBuilder frontWheelDrive(boolean frontWheelDrive){
            this.frontWheelDrive = frontWheelDrive;
            return this;
        }

        public Car build(){
            Car car = new Car(this);
            validateCarObject(car);
            return car;
        }
        
        private void validateCarObject(Car car){
            System.out.println(car + ": Car validation checks.");
        }
    }
}
