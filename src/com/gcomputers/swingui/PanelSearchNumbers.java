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
package com.gcomputers.swingui;

import com.gcomputers.searchtechniques.NumberSearchUtils;
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
public class PanelSearchNumbers extends PanelTemplate implements ActionListener{
    private final JTextArea windowContent;
    private final WindowHandler wh;
    private final JComboBox dropDown;
    private JLabel currentResultLinear;
    private JLabel currentResultBinary;
    private JLabel currentResultJump;
    private JLabel currentResultInterpolation;
    private final String[] intSelection = {"2", "251", "601", "919"};     
    private final JPanel borderStart;
    private final JPanel borderEnd;
    private final JPanel borderCenter;
            
   @Override
    public void actionPerformed(ActionEvent e) {
        long timeStarted;
        long timeEnded;
        
        System.out.println("Search Performed");
        int foundAtLinear;
        timeStarted = System.nanoTime();
        foundAtLinear = NumberSearchUtils.linearSearch(StorageText.NUMBERS, Integer.parseInt(dropDown.getSelectedItem().toString()));
        timeEnded = System.nanoTime();
        long timeTakenLinear = timeEnded- timeStarted;
        
        int foundAtBinary;
        timeStarted = System.nanoTime();
        foundAtBinary = NumberSearchUtils.binarySearch(StorageText.NUMBERS, Integer.parseInt(dropDown.getSelectedItem().toString()));
        timeEnded = System.nanoTime();
        long timeTakenBinary = timeEnded - timeStarted;
        
        int foundAtJump;
        timeStarted = System.nanoTime();
        foundAtJump = NumberSearchUtils.jumpSearch(StorageText.NUMBERS, Integer.parseInt(dropDown.getSelectedItem().toString()));
        timeEnded = System.nanoTime();
        long timeTakenJump = timeEnded - timeStarted;
        
        int foundAtInterpolation;
        timeStarted = System.nanoTime();
        foundAtInterpolation = NumberSearchUtils.interpolationSearch(StorageText.NUMBERS, Integer.parseInt(dropDown.getSelectedItem().toString()));
        timeEnded = System.nanoTime();
        long timeTakenInterpolation = timeEnded - timeStarted;
        
        this.addSearchResults(foundAtLinear, timeTakenLinear, foundAtBinary, timeTakenBinary, foundAtJump, timeTakenJump, foundAtInterpolation, timeTakenInterpolation);
    }
    
    private void addSearchResults(int resultLinear, long timeLinear, int resultBinary, long timeBinary, int resultJump, long timeJump, int resultInterpolation, long timeInterpolation){
        
        currentResultLinear.setVisible(false);
        currentResultBinary.setVisible(false);
        currentResultJump.setVisible(false);
        currentResultInterpolation.setVisible(false);
        
        borderEnd.remove(currentResultLinear);
        borderEnd.remove(currentResultBinary);
        borderEnd.remove(currentResultJump);
        borderEnd.remove(currentResultInterpolation);
        
        currentResultLinear = new JLabel("Linear Integer: " + resultLinear + " in " + timeLinear + " nanoseconds.");
        currentResultBinary = new JLabel("Binary Integer: " + resultBinary + " in " + timeBinary + " nanoseconds.");
        currentResultJump = new JLabel("Jump Integer: " + resultJump + " in " + timeJump + " nanoseconds.");
        currentResultInterpolation = new JLabel("Interpolation Integer: " + resultInterpolation + " in " + timeInterpolation + " nanoseconds.");
        
        currentResultLinear.setAlignmentX(JLabel.CENTER);
        currentResultBinary.setAlignmentX(JLabel.CENTER);
        currentResultJump.setAlignmentX(JLabel.CENTER);
        currentResultInterpolation.setAlignmentX(JLabel.CENTER);
        
        this.applyTemplateSettings(currentResultLinear);
        this.applyTemplateSettings(currentResultBinary);
        this.applyTemplateSettings(currentResultJump);
        this.applyTemplateSettings(currentResultInterpolation);
        
        borderEnd.add(currentResultLinear);
        borderEnd.add(currentResultBinary);
        borderEnd.add(currentResultJump);
        borderEnd.add(currentResultInterpolation);
        
        currentResultLinear.setVisible(true);
        currentResultBinary.setVisible(true);
        currentResultJump.setVisible(true);
        currentResultInterpolation.setVisible(true);
        
        wh.updateProgram();
    }
    
    public PanelSearchNumbers(WindowHandler wh){
        this.wh = wh;
        this.setLayout(new BorderLayout(0,0));
        
        borderStart = new JPanel();
        borderStart.setLayout(new GridLayout(2,1));
        borderCenter = new JPanel();
        borderCenter.setLayout(new GridLayout(1,1));
        borderEnd = new JPanel();
        borderEnd.setLayout(new GridLayout(10,1));
        
        this.applyTemplateSettings(borderStart);
        this.applyTemplateSettings(borderCenter);
        this.applyTemplateSettings(borderEnd);
        
        currentResultLinear = new JLabel("No Search Performed");
        currentResultBinary = new JLabel("No Search Performed");
        currentResultJump = new JLabel("No Search Performed");
        currentResultInterpolation = new JLabel("No Search Performed");
        
        borderEnd.add(currentResultLinear);
        borderEnd.add(currentResultBinary);
        borderEnd.add(currentResultJump);
        borderEnd.add(currentResultInterpolation);
        
        JLabel label = new JLabel("Search");
        this.applyTemplateSettings(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        
        dropDown = new JComboBox(intSelection);
        dropDown.addActionListener(this);
        
        borderStart.add(label);
        borderStart.add(dropDown);
      
        windowContent = new JTextArea("Searching for Strings and Integers.");
        windowContent.setLineWrap(true);
        windowContent.setEditable(false);
        windowContent.setForeground(Color.WHITE);
        windowContent.setBackground(Color.BLACK);
        borderCenter.add(windowContent);
        
        this.applyTemplateSettings(this);

        this.add(borderStart, BorderLayout.PAGE_START);
        this.add(borderCenter, BorderLayout.CENTER);
        this.add(borderEnd, BorderLayout.PAGE_END);   
        this.validate();
    }


}
