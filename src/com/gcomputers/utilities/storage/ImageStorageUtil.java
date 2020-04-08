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
package com.gcomputers.utilities.storage;

import com.gcomputers.utilities.crypto.AesUtils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Dard
 */
public abstract class ImageStorageUtil {

    public static BufferedImage getBufferedImage(HashMap<String, BufferedImage> hashMap, String sourceFile, int width, int height, int transparency){
        File imageFile = new File(sourceFile);
        BufferedImage image = null;

        if (hashMap.containsKey(sourceFile)){
            image = hashMap.get(sourceFile);
        } else {
            image = new BufferedImage(width, height, transparency);
            try {
            image = ImageIO.read(imageFile);
            } catch (IOException ex){
                Logger.getLogger(ImageStorageUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            hashMap.put(sourceFile, image);
            System.out.println("New BufferedImage Created.");
        }
        return image;
    }
    
    public static ImageIcon getImageIcon(HashMap<String, ImageIcon> hashMap, String sourceFile){
        ImageIcon image = null;

        if (hashMap.containsKey(sourceFile)){
            image = hashMap.get(sourceFile);
        } else {
            image = new ImageIcon(sourceFile);
            hashMap.put(sourceFile, image);
            System.out.println("New ImageIcon Created.");
        }
        return image;
    }
}
