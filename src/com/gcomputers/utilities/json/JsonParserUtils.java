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
package com.gcomputers.utilities.json;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Dard
 */
public abstract class JsonParserUtils {

    public static void parse(String filePath) { 
        // parsing file "JSONExample.json" 
        JSONObject jo = null;
        Object obj; 
        try {
            obj = new JSONParser().parse(new FileReader(filePath));
            jo = (JSONObject) obj;
        } catch (IOException | ParseException ex) {
            Logger.getLogger(JsonParserUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        // getting firstName and lastName 
        String firstName = (String) jo.get("firstName"); 
        String lastName = (String) jo.get("lastName"); 

        System.out.println(firstName); 
        System.out.println(lastName); 

        // getting age 
        long age = (long) jo.get("age"); 
        System.out.println(age); 

        // getting address 
        Map address = ((Map)jo.get("address")); 

        // iterating address Map 
        Iterator<Map.Entry> itr1 = address.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
            System.out.println(pair.getKey() + " : " + pair.getValue()); 
        } 

        // getting phoneNumbers 
        JSONArray ja = (JSONArray) jo.get("phoneNumbers"); 

        // iterating phoneNumbers 
        Iterator itr2 = ja.iterator(); 

        while (itr2.hasNext())  
        { 
            itr1 = ((Map) itr2.next()).entrySet().iterator(); 
            while (itr1.hasNext()) { 
                Map.Entry pair = itr1.next(); 
                System.out.println(pair.getKey() + " : " + pair.getValue()); 
            } 
        } 
    }
}
