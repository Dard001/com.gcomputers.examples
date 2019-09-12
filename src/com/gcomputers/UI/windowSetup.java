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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author NG @ G-Computers
 */
public class windowSetup {
    private final ActionListener evt1 = (ActionEvent) -> { jButtonActionPerformed(1);};
    private final ActionListener evt2 = (ActionEvent) -> { jButtonActionPerformed(2);};
    private final ActionListener evt3 = (ActionEvent) -> { jButtonActionPerformed(3);};
    private final Timer timer = new Timer(1000, (ActionEvent) -> { updateProgram();});
    private final mainFrame f;
    private final panelHome home;
    private final panelSettings settings;
    private final panelButtons buttons;
    private JPanel currentPanel;
    
    private void exitProgram(int code){
        timer.stop();
        f.dispose();
        System.exit(code);
    }
    
    private void updateProgram(){
        System.out.println("Program Updated");
    }
    
    private void jButtonActionPerformed(int action){
        switch(action){
            case 1: System.out.println("Home Button Pressed"); setActivePanel(f, home); break;
            case 2: System.out.println("Settings Button Pressed"); setActivePanel(f, settings); break;
            case 3: exitProgram(0); break;
            default: exitProgram(1);
        }
    }
    
    private void setActivePanel(JFrame f, JPanel p){
        f.remove(currentPanel);
        currentPanel.setVisible(false);
        f.add(p).setVisible(true);
        f.revalidate();
        currentPanel = p;
    }
    
    public windowSetup(int w, int h){
        f = new mainFrame(w, h);
        f.setLayout(new GridLayout (2,1));
        buttons = new panelButtons(evt1, evt2, evt3);
        home = new panelHome();
        settings = new panelSettings();
        f.add(buttons);
        f.add(home);
        currentPanel = home;
        f.pack();
        f.setVisible(true);
        
        timer.start(); 
    }
}
