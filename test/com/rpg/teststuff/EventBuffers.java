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
package com.rpg.teststuff;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.gcomputers.utilities.fileio.FileUtils;

/**
 *
 * @author Dard
 */
public class EventBuffers {
    public ArrayList<String> fastBuffer;
    public ArrayList<String> moderateBuffer;
    public ArrayList<String> slowBuffer;
    public ArrayList<String> eventLog;
    public ArrayList<String> systemLog;
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final String SYSTEM_LOG_DIR = System.getProperty("user.home") + "\\Desktop\\GameLoop";
    private final String SYSTEM_LOG_NAME = "SystemLog.txt";
    private int LOG_LEVEL;
    
    public void addToLog(String string){
        Date date = new Date();
        systemLog.add(dateFormat.format(date) + ": " + string);
        FileUtils.appendToFile(SYSTEM_LOG_DIR, SYSTEM_LOG_NAME, dateFormat.format(date) + ": " + string, true);
    }
    
    public void addToBuffer(String string){
        if (fastBuffer.size() < 10){
            fastBuffer.add(string);
        } else if (moderateBuffer.size() < 100) {
            moderateBuffer.add(fastBuffer.get(0));
            fastBuffer.remove(0);
            fastBuffer.add(string);
        } else if (slowBuffer.size() < 1000){
            slowBuffer.add(moderateBuffer.get(0));
            moderateBuffer.remove(0);
            moderateBuffer.add(fastBuffer.get(0));
            fastBuffer.remove(0);
            fastBuffer.add(string);
        } else {
            eventLog.add(slowBuffer.get(0));
            slowBuffer.remove(0);
            slowBuffer.add(moderateBuffer.get(0));
            moderateBuffer.remove(0);
            moderateBuffer.add(fastBuffer.get(0));
            fastBuffer.remove(0);
            fastBuffer.add(string);
        }
    }

    public void clearFast(){
        eventLog.addAll(fastBuffer);
        fastBuffer.clear();
        if (LOG_LEVEL >= 1) this.addToLog("Fast Buffer Cleared");
    }
    
    public void clearModerate(){
        eventLog.addAll(moderateBuffer);
        moderateBuffer.clear();
        if (LOG_LEVEL >= 1) this.addToLog("Moderate Buffer Cleared");
    }
    
    public void clearSlow(){
        eventLog.addAll(slowBuffer);
        slowBuffer.clear();
        if (LOG_LEVEL >= 1) this.addToLog("Slow Buffer Cleared");
    }
    
    public boolean scanFast(String search){
        boolean found = false;

        if (fastBuffer.contains(search)){
            found = true;
            eventLog.add(search);
            fastBuffer.remove(search);
        }
        
        System.out.println("Scanned Fast");
        if (LOG_LEVEL >= 1) this.addToLog("Fast Buffer Scanned");
        if (LOG_LEVEL >= 2) this.addToLog("Fast Size: " + fastBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Moderate Size: " + moderateBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Slow Size: " + slowBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Event Size: " + eventLog.size());

        return found;
    }
    
    public boolean scanModerate(String search){
        boolean found = false;

        if (moderateBuffer.contains(search)){
            found = true;
            eventLog.add(search);
            moderateBuffer.remove(search);
        }
        System.out.println("Scanned Moderate");
        if (LOG_LEVEL >= 1) this.addToLog("Moderate Buffer Scanned");
        if (LOG_LEVEL >= 2) this.addToLog("Fast Size: " + fastBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Moderate Size: " + moderateBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Slow Size: " + slowBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Event Size: " + eventLog.size());
        return found;
    }
    
    public boolean scanSlow(String search){
        boolean found = false;

        if (slowBuffer.contains(search)){
            found = true;
            eventLog.add(search);
            slowBuffer.remove(search);
        }
        System.out.println("Scanned Slow");
        if (LOG_LEVEL >= 1) this.addToLog("Slow Buffer Scanned");
        if (LOG_LEVEL >= 2) this.addToLog("Fast Size: " + fastBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Moderate Size: " + moderateBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Slow Size: " + slowBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Event Size: " + eventLog.size());
        return found;
    }
    
    public boolean scanEvents(String search){
        boolean found = false;

        if (eventLog.contains(search)){
            found = true;
        }
        System.out.println("Scanned Events");
        if (LOG_LEVEL >= 1) this.addToLog("Event Log Scanned");
        if (LOG_LEVEL >= 2) this.addToLog("Fast Size: " + fastBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Moderate Size: " + moderateBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Slow Size: " + slowBuffer.size());
        if (LOG_LEVEL >= 2) this.addToLog("Event Size: " + eventLog.size());
        return found;
    }
    
    public void printBuffers(){
        System.out.println("Fast Size" + fastBuffer.size());
        System.out.println("Moderate Size" + moderateBuffer.size());
        System.out.println("Slow Size" + slowBuffer.size());
        System.out.println("Event Size" + eventLog.size());
    }
    
    public EventBuffers(int LOG_LEVEL){
        this.LOG_LEVEL = LOG_LEVEL;
        
        fastBuffer = new ArrayList<>();
        moderateBuffer = new ArrayList<>();
        slowBuffer = new ArrayList<>();
        eventLog = new ArrayList<>();
        systemLog = new ArrayList<>();
        
        FileUtils.makeDirectory(SYSTEM_LOG_DIR);
        FileUtils.createFile(SYSTEM_LOG_DIR, SYSTEM_LOG_NAME);
    }    
}
