/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcomputers.UI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Dard
 */
public class panelButtons extends panelTemplate {
    private final ImageIcon homeButton = new ImageIcon(getClass().getResource("src/homeIcon.png"));
    private final ImageIcon homeButtonPressed = new ImageIcon(getClass().getResource("src/homeIconPressed.png"));
    private final ImageIcon settingsButton = new ImageIcon(getClass().getResource("src/settingsIcon.png"));
    private final ImageIcon settingsButtonPressed = new ImageIcon(getClass().getResource("src/settingsIconPressed.png"));
    private final ImageIcon exitButton = new ImageIcon(getClass().getResource("src/powerIcon.png"));
    private final ImageIcon exitButtonPressed = new ImageIcon(getClass().getResource("src/powerIconPressed.png"));

    public panelButtons(ActionListener evt1, ActionListener evt2, ActionListener evt3){
        this.setLayout(new GridLayout(1,3));
        this.setBackground(Color.BLACK);
        
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        b1.setFocusPainted(false);
        b2.setFocusPainted(false);
        b3.setFocusPainted(false);
        
        this.applyButtonSettings(b1, homeButton, homeButtonPressed, 50, 50, 435, 0);
        this.applyButtonSettings(b2, settingsButton, settingsButtonPressed, 50, 50, 485, 0);
        this.applyButtonSettings(b3, exitButton, exitButtonPressed, 50, 50, 535, 0);

        b1.addActionListener(evt1);
        b2.addActionListener(evt2);
        b3.addActionListener(evt3);
        this.add(b1);
        this.add(b2);
        this.add(b3);
    }
}
