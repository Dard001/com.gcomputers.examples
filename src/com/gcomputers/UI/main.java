/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcomputers.UI;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Dard
 */
public class main {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    public static void main(String[] args){
        System.out.println("Screen dimensions are: " + SCREEN_WIDTH + "x" + SCREEN_HEIGHT);
        windowSetup runningWindow = new windowSetup(WIDTH, HEIGHT);
    }
}
