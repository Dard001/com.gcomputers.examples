/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcomputers.UI;

import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author Dard
 */
public class panelTemplate extends JPanel {
    public final ImageIcon getScaledImage(ImageIcon icon, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(icon.getImage(), 0,0,w,h,null);
        g2.dispose();
        
        ImageIcon newIcon = new ImageIcon(resizedImg);
        
        return newIcon;
    }
    
    public final JButton applyButtonSettings(JButton b, ImageIcon icon, ImageIcon pressedIcon, int w, int h, int x, int y){
        b.setIcon(getScaledImage(icon, w, h));
        b.setPressedIcon(getScaledImage(pressedIcon, w, h));
        b.setBorderPainted(false);
        b.setMargin(new Insets(0,0,0,0));
        b.setBorder(null);
        b.setContentAreaFilled(false);
        b.setSize(w, h);
        b.setHorizontalTextPosition(JButton.RIGHT);
        
        return b;
    }
}
