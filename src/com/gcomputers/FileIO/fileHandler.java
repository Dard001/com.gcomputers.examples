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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dard
 */
public class fileHandler {
    
    public static void makeDirectory(String path){
        File myDir = new File(path);
        
        if (!myDir.exists()){
            myDir.mkdirs();
            System.out.println("Directory created: " + path);
        } else {
            System.out.println("Directory already exists");
        }
    }
    
    public static void makeDirectory(String path, String name){
        File myDir = new File(path + "\\" + name);
        
        if (!myDir.exists()){
            myDir.mkdir();
            System.out.println("Directory created: " + path + "\\" + name);
        } else {
            System.out.println("Directory already exists");
        }
    }
    
    public static void createFile(String path, String name){
        File myFile = new File(path + "\\" + name);
        
        try {
            if (myFile.createNewFile()){
                System.out.println("File created: " + path + "\\" + name);
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException ex) {
            Logger.getLogger(fileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeToFile(String path, String name, String contents){
        
        try {
            FileWriter myWriter = new FileWriter(path + "\\" + name);
            myWriter.write(contents);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ex) {
            Logger.getLogger(fileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //TODO Finish this
    public static String[] readFile(String path, String name){
        String[] lines = null;
        int x = 0;
        try {
            
            File myFile = new File(path + "\\" + name);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[x] = data;
                System.out.println(lines[x]);
                x++;
            }
            myReader.close();
            return lines;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(fileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }
    
    public static void appendToFile(String path, String name, String contents, Boolean newLine){
        try {
            FileWriter myWriter = new FileWriter(path + "\\" + name, true);
            if(newLine){
                myWriter.write("\n" + contents);
            } else {
                myWriter.write(contents);
            }
            myWriter.close();
            System.out.println("Successfully appended to the file.");
        } catch (IOException ex) {
            Logger.getLogger(fileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private fileHandler(){
        System.exit(-1);
    }
}
