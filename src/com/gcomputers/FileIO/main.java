/*
 * Copyright (C) 2020 Dard
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
package com.gcomputers.FileIO;

/**
 *
 * @author Dard
 */
public class main {
    public static final String FILE_PATH = System.getProperty("user.home");
    public static final String PATH_TO_DESKTOP = System.getProperty("user.home") + "\\Desktop";
    public static final String FILE_NAME = "DeleteMe.txt";
    public static final String FILE_CONTENTS = "This is a test of the file write system.";
    public static final String FILE_CONTENTS_2 = "This is a test of the file append system.";
    public static final boolean WRITE_TO_NEW_LINE = true;
    
    public static void main (String[] args){
        fileHandler.createFile(PATH_TO_DESKTOP, FILE_NAME);
        fileHandler.writeToFile(PATH_TO_DESKTOP, FILE_NAME, FILE_CONTENTS);
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, FILE_CONTENTS_2, WRITE_TO_NEW_LINE);
        fileHandler.readFile(PATH_TO_DESKTOP, FILE_NAME);
    }
}
