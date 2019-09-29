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

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author NG @ G-Computers
 */
public class windowHandler {
    private final Timer timer = new Timer(10000, (ActionEvent) -> { updateProgram();});
    private final mainFrame f;
    private final panelHome home;
    private final panelSettings settings;
    private final panelSearch search;
    private final panelSearch searchNumbers;
    private final panelButtons buttons;
    private JPanel currentPanel;
        
    private void setActivePanel(JPanel p){
        f.remove(currentPanel);
        currentPanel.setVisible(false);
        f.add(p, BorderLayout.CENTER);
        p.setVisible(true);
        f.revalidate();
        currentPanel = p;
    }
    
    public void exitProgram(int code){
        timer.stop();
        f.dispose();
        if (code != 0){JOptionPane.showMessageDialog(null, "Program Error " + code + ": Closing Program.");}
        System.exit(code);
    }
    
    public void updateProgram(){
        f.revalidate();
        System.out.println("Program Updated");
    }
    
    public void windowActionPerformed(int action){
        switch(action){
            case 1: System.out.println("Home Button Pressed"); setActivePanel(home); break;
            case 2: System.out.println("Settings Button Pressed"); setActivePanel(settings); break;
            case 3: System.out.println("Search Button Pressed"); setActivePanel(search); break;
            case 4: System.out.println("Search Button Pressed"); setActivePanel(searchNumbers); break;
            case 5: exitProgram(0); break;
            default: exitProgram(1);
        }
    }
    
    public windowHandler(int w, int h){
        f = new mainFrame(w, h);
        f.setLayout(new BorderLayout(0,0));
        buttons = new panelButtons(this);
        home = new panelHome();
        settings = new panelSettings();
        search = new panelSearch(this);
        searchNumbers = new panelSearch(this);
        f.add(buttons, BorderLayout.PAGE_START);
        f.add(home, BorderLayout.CENTER);
        currentPanel = home;
    //    f.pack();
        f.setVisible(true);
        
        timer.start(); 
    }
}
