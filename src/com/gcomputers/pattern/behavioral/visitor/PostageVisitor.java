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
package com.gcomputers.pattern.behavioral.visitor;

/**
 *
 * @author Dard
 */
public class PostageVisitor implements Visitor{
    private double totalPostage;
    
    @Override
    public void visit(Book book) {
        if(book.getPrice() < 10.0){
            totalPostage += book.getWeight() * 2;
        }
    }

    @Override
    public void visit(CD cd) {
        if(cd.getPrice() < 10.0){
            totalPostage += cd.getWeight() * 2;
        }
    }

    @Override
    public void visit(DVD dvd) {
        if(dvd.getPrice() < 10.0){
            totalPostage += dvd.getWeight() * 2;
        }
    }
    public double getTotalPostage(){
        return totalPostage;
    }
}
