/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcomputers.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Dard
 */
public class windowSetup {
    private final ActionListener evt1 = (ActionEvent evt) -> { jButtonActionPerformed(evt, 1);};
    private final ActionListener evt2 = (ActionEvent evt) -> { jButtonActionPerformed(evt, 2);};
    private final ActionListener evt3 = (ActionEvent evt) -> { jButtonActionPerformed(evt, 3);};
    private mainFrame f;
    private panelHome home;
    private panelSettings settings;
    private JPanel currentPanel;
    private panelButtons buttons;
    
    private void jButtonActionPerformed(ActionEvent evt, int action){
        switch(action){
            case 1: System.out.println("Home Button Pressed"); setActivePanel(f, home); break;
            case 2: System.out.println("Settings Button Pressed"); setActivePanel(f, settings); break;
            case 3: System.exit(0); break;
            default: System.exit(1);
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
    }
}
