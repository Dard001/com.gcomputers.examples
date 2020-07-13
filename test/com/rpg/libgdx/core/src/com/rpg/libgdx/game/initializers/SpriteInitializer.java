/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpg.libgdx.game.initializers;

import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;

/**
 *
 * @author Dard
 */
public class SpriteInitializer {
    private ArrayList<Texture> textures = new ArrayList();
    
    public ArrayList<Texture> getSprites(){
        return textures;
    }
    
    public SpriteInitializer(String path){      
        textures.add(new Texture(path + "player.png"));
    }
}
