/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpg.libgdx.game.initializers;
import com.badlogic.gdx.graphics.Texture;
import com.rpg.libgdx.game.entities.Entity;
import com.rpg.libgdx.game.entities.Person;
import com.rpg.libgdx.game.entities.Worker;
import java.util.ArrayList;
/**
 *
 * @author Dard
 */
public class EntityInitializer {
    private ArrayList<Entity> entities = new ArrayList();
    private ArrayList<Texture> sprites;
    
    public ArrayList<Entity> getEntities(){
        return entities;
    }
    
    public EntityInitializer(String assetPath, ArrayList<Texture> sprites){
        this.sprites = sprites;
        
        entities.add(new Person(sprites.get(0), 60, 500));
       // entities.add(new Worker(sprites.get(0), 160, 600));
    }
}
