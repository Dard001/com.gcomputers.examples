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

/**
 *
 * @author Dard
 */
public abstract class Vehicle implements Cloneable{
    private String id;
    protected String type;
    
    abstract void drive();
    
    public String getType(){
        return type;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    @Override
    public Vehicle clone() throws CloneNotSupportedException {
        Vehicle clone = null;
        
        try {
            clone = (Vehicle) super.clone();
        } catch (CloneNotSupportedException e){
            System.out.println(e);
            System.exit(-1);
        }
        return clone;
    }
}
