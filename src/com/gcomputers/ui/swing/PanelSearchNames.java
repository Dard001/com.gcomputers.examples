/*
 * Copyright (C) 2019 Dard
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

import com.gcomputers.utilities.searchtechniques.StringSearchUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author NG @ G-Computers
 */
public class PanelSearchNames extends PanelTemplate implements ActionListener{
    private final WindowHandler wh;
    private final JComboBox dropDown;
    private JLabel currentResultLinear;
    private JLabel currentResultBinary;
    private final String[] nameSelection = {"Adrian", "Benjamin", "Donald", "George"};   
    private final String[] sortedArray = StorageTextHelper.sortArray(StorageTextHelper.NAMES);
    
    private void applySettings(){
        dropDown.addActionListener(this);
    }
    
   @Override
    public void actionPerformed(ActionEvent e) {
        long timeStarted;
        long timeEnded;
        
        System.out.println("Search Performed");
        int foundAtLinear;
        timeStarted = System.nanoTime();
        foundAtLinear = StringSearchUtils.linearSearch(sortedArray, dropDown.getSelectedItem().toString());
        timeEnded = System.nanoTime();
        long timeTakenLinear = timeEnded- timeStarted;
        
        int foundAtBinary;
        timeStarted = System.nanoTime();
        foundAtBinary = StringSearchUtils.binarySearch(sortedArray, dropDown.getSelectedItem().toString());
        timeEnded = System.nanoTime();
        long timeTakenBinary = timeEnded - timeStarted;
        
        this.addSearchResults(foundAtLinear, timeTakenLinear, foundAtBinary, timeTakenBinary, this);
    }
    
    private void addSearchResults(int resultLinear, long timeLinear, int resultBinary, long timeBinary, JPanel panel){
        panel = (JPanel) panel.getComponent(2);
        currentResultLinear.setVisible(false);
        currentResultBinary.setVisible(false);
        
        panel.remove(currentResultLinear);
        panel.remove(currentResultBinary);
        
        currentResultLinear = new JLabel("Linear String: " + resultLinear + " in " + timeLinear + " nanoseconds.");
        currentResultBinary = new JLabel("Binary String: " + resultBinary + " in " + timeBinary + " nanoseconds.");
        
        currentResultLinear.setAlignmentX(JLabel.CENTER);
        currentResultBinary.setAlignmentX(JLabel.CENTER);
        
        this.applyTemplateSettings(currentResultLinear);
        this.applyTemplateSettings(currentResultBinary);
        
        panel.add(currentResultLinear);
        panel.add(currentResultBinary);
        
        currentResultLinear.setVisible(true);
        currentResultBinary.setVisible(true);
        
        wh.updateProgram();
    }
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public PanelSearchNames(WindowHandler wh){
        this.wh = wh;
        this.setLayout(new BorderLayout(0,0));
                
        JPanel borderStart = new JPanel();
        borderStart.setLayout(new GridLayout(2,1));
        JPanel borderCenter = new JPanel();
        borderCenter.setLayout(new GridLayout(1,1));
        JPanel borderEnd = new JPanel();
        borderEnd.setLayout(new GridLayout(10,1));
        
        this.applyTemplateSettings(borderStart);
        this.applyTemplateSettings(borderCenter);
        this.applyTemplateSettings(borderEnd);
        
        currentResultLinear = new JLabel("No Search Performed");
        currentResultBinary = new JLabel("No Search Performed");
        
        borderEnd.add(currentResultLinear);
        borderEnd.add(currentResultBinary);
        
        JLabel label = new JLabel("Search");
        this.applyTemplateSettings(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        
        dropDown = new JComboBox(nameSelection);
        
        borderStart.add(label);
        borderStart.add(dropDown);
        
        JTextArea windowContent;
        windowContent = new JTextArea("Searching for Strings and Integers.");
        windowContent.setLineWrap(true);
        windowContent.setEditable(false);
        windowContent.setForeground(Color.WHITE);
        windowContent.setBackground(Color.BLACK);
        borderCenter.add(windowContent);
        
        this.applySettings();

        this.add(borderStart, BorderLayout.PAGE_START);
        this.add(borderCenter, BorderLayout.CENTER);
        this.add(borderEnd, BorderLayout.PAGE_END);   
        this.validate(); 
    }


}
