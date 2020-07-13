/*
 * Copyright (C) 2020 G-Computers
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
package com.rpg.libgdx.game.initializers;

import com.rpg.libgdx.game.tiles.TileType;
import java.util.HashMap;

/**
 *
 * @author Dard
 */
public class TileInitializer {
    private static HashMap<Integer, TileType> tileMap;
    
    public TileInitializer(String path){
            tileMap = new HashMap<Integer, TileType>();
            for (TileType tileType : TileType.values()) {
                tileMap.put(tileType.getId(), tileType);
            }
    }
}
