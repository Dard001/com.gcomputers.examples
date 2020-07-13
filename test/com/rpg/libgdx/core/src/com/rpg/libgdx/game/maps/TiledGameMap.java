/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpg.libgdx.game.maps;

import com.rpg.libgdx.game.tiles.TileType;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.rpg.libgdx.game.entities.Entity;
import java.util.ArrayList;

public class TiledGameMap {
    private static TiledMap map;
//    private static TiledGameMap gameMap;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    protected ArrayList<Entity> entities;
    protected TextureRegion[][] tiles;

    public void render (OrthographicCamera camera, SpriteBatch batch) {
                tiledMapRenderer.setView(camera);
                tiledMapRenderer.render();
        	batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		for (int layer = 0; layer < getLayers(); layer++) {
			for (int row = 0; row < getHeight(); row++) {
				for (int col = 0; col < getWidth(); col++) {
					TileType type = this.getTileTypeByCoordinate(layer, col, row);
					if (type != null)
						batch.draw(tiles[0][type.getId() - 1], col * TileType.TILE_SIZE, row * TileType.TILE_SIZE);
				}
			}
		}
                for (Entity entity : entities) {
                        entity.render(batch);
                }

		batch.end();
    }

    public void update (float delta) {            
        for (Entity entity : entities) {
                entity.update(delta);
        }
    }

    public void dispose () {
            map.dispose();
    }

    public boolean doesRectCollideWithMap(float x, float y, int width, int height) {
        if (x < 0 || y < 0 || x + width > getPixelWidth() || y + height > getPixelHeight()){
                return true;
        }

        for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
                for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
                        for (int layer = 0; layer < getLayers(); layer++) {
                                TileType type = getTileTypeByCoordinate(layer, col, row);
                                if (type != null && type.isCollidable())
                                        return true;
                        }
                }
        }

        return false;
    }

    public TileType getTileTypeByLocation(int layer, float x, float y) {
        return this.getTileTypeByCoordinate(layer, (int) (x / TileType.TILE_SIZE), (int) (y / TileType.TILE_SIZE));
    }
    
    public TileType getTileTypeByCoordinate (int layer, int col, int row) {
            Cell cell = ((TiledMapTileLayer) map.getLayers().get(layer)).getCell(col, row);
            
            if (cell != null) {
                TiledMapTile tile = cell.getTile();

                if (tile != null) {
                        return TileType.getTileTypeById(tile.getId());
                }
            }
            return null;
    }

    public static int getWidth () {
            return ((TiledMapTileLayer) map.getLayers().get(0)).getWidth();
    }

    public static int getHeight () {
            return ((TiledMapTileLayer) map.getLayers().get(0)).getHeight();
    }

    public static int getLayers() {
            return map.getLayers().getCount();
    }

    public static int getPixelWidth() {
        return getWidth() * TileType.TILE_SIZE;
    }

    public static int getPixelHeight() {
        return getHeight() * TileType.TILE_SIZE;
    }

    public TiledGameMap (TextureRegion[][] tiles, TiledMap map, ArrayList<Entity> entities) {
        this.tiles = tiles;
        this.map = map;
        this.entities = entities;
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
    }
}