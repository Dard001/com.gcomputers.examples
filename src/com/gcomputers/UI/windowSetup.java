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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Dard
 */
public class windowSetup {
    private final ImageIcon windowIcon = new ImageIcon(getClass().getResource("src/ecoIcon.png"));
    private final ImageIcon homeButton = new ImageIcon(getClass().getResource("src/homeIcon.png"));
    private final ImageIcon homeButtonPressed = new ImageIcon(getClass().getResource("src/homeIconPressed.png"));
    private final ImageIcon settingsButton = new ImageIcon(getClass().getResource("src/settingsIcon.png"));
    private final ImageIcon settingsButtonPressed = new ImageIcon(getClass().getResource("src/settingsIconPressed.png"));
    private final ImageIcon exitButton = new ImageIcon(getClass().getResource("src/powerIcon.png"));
    private final ImageIcon exitButtonPressed = new ImageIcon(getClass().getResource("src/powerIconPressed.png"));
    
    private ImageIcon getScaledImage(ImageIcon icon, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(icon.getImage(), 0,0,w,h,null);
        g2.dispose();
        
        ImageIcon newIcon = new ImageIcon(resizedImg);
        
        return newIcon;
    }
    
    private JButton applyButtonSettings(JButton b, ImageIcon icon, ImageIcon pressedIcon, int w, int h, int x, int y){
        b.setIcon(getScaledImage(icon, w, h));
        b.setPressedIcon(getScaledImage(pressedIcon, w, h));
        b.setBorderPainted(false);
        b.setMargin(new Insets(0,0,0,0));
        b.setBorder(null);
        b.setContentAreaFilled(false);
        b.setSize(w, h);
        b.setLocation(x,y);
        
        return b;
    }
    
    public windowSetup(int w, int h){
        JFrame f = new JFrame();
        f.setSize(w, h);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Test Window");
        f.setLocationRelativeTo(null);
        f.setIconImage(windowIcon.getImage()); //materials.io

        JPanel p = new JPanel();
        p.setLayout(null);
        
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        this.applyButtonSettings(b1, homeButton, homeButtonPressed, 50, 50, 0, 0);
        this.applyButtonSettings(b2, settingsButton, settingsButtonPressed, 50, 50, 50, 0);
        this.applyButtonSettings(b3, exitButton, exitButtonPressed, 50, 50, 100, 0);

        p.add(b1);
        p.add(b2);
        p.add(b3);
        
        f.getContentPane().add(p);
        f.setVisible(true);
    }
}
