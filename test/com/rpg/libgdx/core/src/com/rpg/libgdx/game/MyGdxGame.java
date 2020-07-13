package com.rpg.libgdx.game;

import com.rpg.libgdx.game.maps.TiledGameMap;
import com.rpg.libgdx.game.tiles.TileType;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.rpg.libgdx.game.initializers.*;

public class MyGdxGame extends ApplicationAdapter {
	TiledGameMap map;  
        OrthographicCamera camera;
        int deltaX;
        int deltaY;
        SpriteBatch batch;
        
        FileInitializer fInit;
        TextureInitializer tInit;
        TileInitializer teInit;
        EntityInitializer eInit;
        SpriteInitializer sInit;
        MapInitializer mInit;
        
        String ASSET_PATH = "C:\\Users\\Dard\\Documents\\NetBeansProjects\\com.gcomputers.examples\\test\\com\\rpg\\libgdx\\core\\src\\com\\rpg\\libgdx\\game\\assets\\";
        
	@Override
	public void create () {
            fInit = new FileInitializer(ASSET_PATH);
            tInit = new TextureInitializer(ASSET_PATH);
            teInit = new TileInitializer(ASSET_PATH);
            mInit = new MapInitializer(ASSET_PATH);
            sInit = new SpriteInitializer(ASSET_PATH);
            eInit = new EntityInitializer(ASSET_PATH, sInit.getSprites());
            
            batch = new SpriteBatch();
            
            map = new TiledGameMap(tInit.getTextures(), mInit.getMap(), eInit.getEntities());

            for (int x = 0; x < eInit.getEntities().size(); x++){
                 eInit.getEntities().get(x).setToMap(map);
            }

            float w = Gdx.graphics.getWidth();
            float h = Gdx.graphics.getHeight();

            camera = new OrthographicCamera();
            camera.setToOrtho(false, w, h);
            camera.update();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
                Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                Vector3 pos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
                
                if (Gdx.input.isTouched()){
                    camera.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
                    deltaX -= Gdx.input.getDeltaX();
                    deltaY += Gdx.input.getDeltaY();
                    camera.update();
                }
                
                if (Gdx.input.justTouched()){
                    TileType type = map.getTileTypeByLocation(1, pos.x, pos.y);
                    
                    if (type != null){
                        System.out.println("Tile Clicked ID:" + type.getId() + " Name:" + type.getName() + " Collidable:" + type.isCollidable() + " Damage:" + type.getDamage());
                    }
                }

                camera.update();
                map.update(Gdx.graphics.getDeltaTime());
                map.render(camera, batch);
	}
	
	@Override
	public void dispose () {
            batch.dispose();
            map.dispose();
	}
}
