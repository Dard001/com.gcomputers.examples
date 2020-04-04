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
package com.gcomputers.ui.swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author NG @ G-Computers
 */
public class MainFrame extends JFrame{
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public MainFrame(int w, int h){
        this.setSize(w, h);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Playground Program");
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("sourcefiles/ecoIcon.png")).getImage()); //materials.io
        this.setResizable(false);
    }
}
