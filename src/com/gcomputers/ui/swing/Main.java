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

import java.awt.Toolkit;

/**
 *
 * @author NG @ G-Computers
 */
public abstract class Main {
    private static final int PROGRAM_WIDTH = 300;
    private static final int PROGRAM_HEIGHT = 600;
    private static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args){     
        System.out.println("Screen dimensions are: " + SCREEN_WIDTH + "x" + SCREEN_HEIGHT);
        System.out.println("Program Window dimensions are: " + PROGRAM_WIDTH + "x" + PROGRAM_HEIGHT);
        new WindowHandler(PROGRAM_WIDTH, PROGRAM_HEIGHT);
    }
}
