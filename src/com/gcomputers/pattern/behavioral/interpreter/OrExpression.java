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
package com.gcomputers.pattern.behavioral.interpreter;

/**
 *
 * @author Dard
 */
public class OrExpression implements Expression {
    Expression ex1;
    Expression ex2;
    
    @Override
    public boolean interpret(String context){
        return ex1.interpret(context) || ex2.interpret(context);
    }
    
    public OrExpression(Expression ex1, Expression ex2){
        this.ex1 = ex1;
        this.ex2 = ex2;
    }
}
