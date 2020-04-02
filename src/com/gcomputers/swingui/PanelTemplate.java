/*
 * Copyright (C) 2019 NG @ g-computers
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
package com.gcomputers.swingui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author NG @ G-Computers
 */
public class PanelTemplate extends JPanel {
    public final ImageIcon getScaledImage(ImageIcon icon, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(icon.getImage(), 0,0,w,h,null);
        g2.dispose();
        
        return new ImageIcon(resizedImg);
    }
    
    public final JButton applyButtonSettings(JButton b, ImageIcon icon, ImageIcon pressedIcon, int w, int h){
        b.setIcon(getScaledImage(icon, w, h));
        b.setPressedIcon(getScaledImage(pressedIcon, w, h));
        b.setBorderPainted(false);
        b.setMargin(new Insets(0,0,0,0));
        b.setBorder(null);
        b.setContentAreaFilled(false);
        b.setSize(w, h);
        b.setFocusPainted(false);
        b.setHorizontalTextPosition(JButton.RIGHT);
        b.setVerticalAlignment(JButton.TOP);
        
        return b;
    }
    
    public final void applyTemplateSettings(JPanel panel){
        panel.setForeground(Color.WHITE);
        panel.setBackground(Color.BLACK);
    }
    
    public final void applyTemplateSettings(JLabel label){
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
    }
    
    public final JButton applyButtonSettings(JButton b, ImageIcon icon, ImageIcon pressedIcon, int w, int h, int x, int y){
        b.setIcon(getScaledImage(icon, w, h));
        b.setPressedIcon(getScaledImage(pressedIcon, w, h));
        b.setBorderPainted(false);
        b.setMargin(new Insets(0,0,0,0));
        b.setBorder(null);
        b.setContentAreaFilled(false);
        b.setSize(w, h);
        b.setFocusPainted(false);
        b.setLocation(x,y);
        
        return b;
    }
}
