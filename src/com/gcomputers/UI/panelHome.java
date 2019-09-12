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
package com.gcomputers.UI;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 *
 * @author NG @ G-Computers
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
