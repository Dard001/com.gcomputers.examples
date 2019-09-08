/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcomputers.UI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author Dard
 */
public class mainFrame extends JFrame{
    private final ImageIcon windowIcon = new ImageIcon(getClass().getResource("src/ecoIcon.png"));
    
    public mainFrame(int w, int h){
        this.setSize(w, h);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test Window");
        this.setLocationRelativeTo(null);
        this.setIconImage(windowIcon.getImage()); //materials.io
        this.setResizable(false);
    }
}
