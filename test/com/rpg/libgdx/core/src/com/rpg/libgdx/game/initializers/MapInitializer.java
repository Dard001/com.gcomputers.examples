/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpg.libgdx.game.initializers;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 *
 * @author Dard
 */
public class MapInitializer {
    TiledMap map;
    int lvlTileWidth;
    int lvlTileHeight;
    int lvlPixelWidth;
    int lvlPixelHeight;
    int tilePixelWidth;
    int tilePixelHeight;
    
    public TiledMap getMap(){
        return map;
    }
    
    public MapInitializer(String path){
        map = new TmxMapLoader().load("C:\\Users\\Dard\\Documents\\NetBeansProjects\\com.gcomputers.examples\\test\\com\\rpg\\libgdx\\core\\src\\com\\rpg\\libgdx\\game\\assets\\map.tmx");

        MapProperties properties = map.getProperties();
        lvlTileWidth = properties.get("width", Integer.class);
        lvlTileHeight = properties.get("height", Integer.class);
        lvlPixelWidth = properties.get("tilewidth", Integer.class);
        lvlPixelHeight = properties.get("tileheight", Integer.class);
        tilePixelWidth = lvlTileWidth * tilePixelWidth;
        tilePixelHeight = lvlTileHeight * tilePixelHeight;
    }
}
