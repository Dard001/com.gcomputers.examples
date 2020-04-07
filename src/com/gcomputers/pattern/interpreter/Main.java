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
package com.gcomputers.pattern.interpreter;

/**
 *
 * @author Dard
 */
public abstract class Main {
    
    public static void main(String[] args){
        Expression vehicle1 = new TerminalExpression("Ford Mustang");
        Expression vehicle2 = new TerminalExpression("Chevy Camaro");
        Expression isFast = new OrExpression(vehicle1, vehicle2);
        
        Expression lamborgini = new TerminalExpression("Lamborgini");
        Expression expensive = new TerminalExpression("Expensive");
        Expression isExpensive = new AndExpression(lamborgini, expensive);
        
        System.out.println(isFast.interpret("Ford Mustang"));
        System.out.println(isFast.interpret("Chevy Camaro"));
        System.out.println(isFast.interpret("Ford Mustang, Chevy Camaro"));
        System.out.println(isFast.interpret("Chevy Camaro, Ford Mustang"));
        System.out.println(isFast.interpret("Volkswagen Bug"));
        System.out.println(isFast.interpret("Ford Mustang, Volkswagen Bug")); //Watch the boolean logic here
        System.out.println("----------------------------------");
        System.out.println(isExpensive.interpret("Lamborgini"));
        System.out.println(isExpensive.interpret("Expensive"));
        System.out.println(isExpensive.interpret("Lamborgini, Expensive"));
        System.out.println(isExpensive.interpret("Expensive, Lamborgini"));
        System.out.println(isExpensive.interpret("Cheap"));
        System.out.println(isExpensive.interpret("Lamborgini, Cheap"));
        System.out.println(isExpensive.interpret("Cheap, Lamborgini"));
    }
}
