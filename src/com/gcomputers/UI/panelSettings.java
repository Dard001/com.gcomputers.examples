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
public class panelSettings extends panelTemplate {
    
    public panelSettings(){
        this.setLayout(new GridLayout(2,1));
        
        JLabel label = new JLabel("Settings");
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        
        this.setBackground(Color.BLACK);  
        this.add(label);

        this.validate();
    }
}
