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
package com.gcomputers.utilities.json;

/**
 *
 * @author Dard
 */
public abstract class Main {
    
    private static final String FILE_PATH = "src\\com\\gcomputers\\utilities\\json\\TestJSON.json";
    
    //TODO This is not dynamic at all and needs to be updated
    public static void main(String[] args){
        JsonParserUtils.parse(FILE_PATH);
    }
}
