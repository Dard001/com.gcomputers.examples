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
package com.gcomputers.SwingUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author NG @ G-Computers
 */
public class panelButtons extends panelTemplate implements ActionListener {
    private final ImageIcon homeButton = new ImageIcon(getClass().getResource("src/homeIcon.png"));
    private final ImageIcon homeButtonPressed = new ImageIcon(getClass().getResource("src/homeIconPressed.png"));
    private final ImageIcon settingsButton = new ImageIcon(getClass().getResource("src/settingsIcon.png"));
    private final ImageIcon settingsButtonPressed = new ImageIcon(getClass().getResource("src/settingsIconPressed.png"));
    private final ImageIcon exitButton = new ImageIcon(getClass().getResource("src/powerIcon.png"));
    private final ImageIcon exitButtonPressed = new ImageIcon(getClass().getResource("src/powerIconPressed.png"));
    private final ImageIcon searchButton = new ImageIcon(getClass().getResource("src/searchIcon.png"));
    private final ImageIcon searchButtonPressed = new ImageIcon(getClass().getResource("src/searchIconPressed.png"));
    private final ImageIcon searchButtonNumbers = new ImageIcon(getClass().getResource("src/searchIconNumbers.png"));
    private final ImageIcon searchButtonNumbersPressed = new ImageIcon(getClass().getResource("src/searchIconNumbersPressed.png"));
    private final JButton b1 = new JButton();
    private final JButton b2 = new JButton();
    private final JButton b3 = new JButton();
    private final JButton b4 = new JButton();
    private final JButton b5 = new JButton();
    private final windowHandler wh;

    private void setupButtons(){
        this.applyButtonSettings(b1, homeButton, homeButtonPressed, 50, 50);
        this.applyButtonSettings(b2, settingsButton, settingsButtonPressed, 50, 50);
        this.applyButtonSettings(b3, searchButton, searchButtonPressed, 50, 50);
        this.applyButtonSettings(b4, searchButtonNumbers, searchButtonNumbersPressed, 50, 50);
        this.applyButtonSettings(b5, exitButton, exitButtonPressed, 50, 50);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this); 
        
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (b1.isFocusOwner()){wh.windowActionPerformed(1);}
        else if (b2.isFocusOwner()){wh.windowActionPerformed(2);}
        else if (b3.isFocusOwner()){wh.windowActionPerformed(3);}
        else if (b4.isFocusOwner()){wh.windowActionPerformed(4);}
        else if (b5.isFocusOwner()){wh.windowActionPerformed(5);}
        else {wh.exitProgram(1);}
    }

    public panelButtons(windowHandler wh){
        this.setLayout(new GridLayout(1,5));
        this.applyTemplateSettings(this);
        this.wh = wh;
        
        this.setupButtons();
    }
}