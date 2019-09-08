/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcomputers.UI;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 *
 * @author Dard
 */
public class panelHome extends panelTemplate {
          
    public panelHome (){
        this.setLayout(new GridLayout(2,1));
        
        JLabel label = new JLabel("Home");
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        
        JLabel text = new JLabel(storageText.DESCRIPTION);
        text.setForeground(Color.WHITE);
        text.setHorizontalAlignment(JLabel.LEFT);
        text.setVerticalAlignment(JLabel.CENTER);
        
        this.setBackground(Color.BLACK);
        this.add(label);
        this.add(text);
        this.validate();
    }
}
