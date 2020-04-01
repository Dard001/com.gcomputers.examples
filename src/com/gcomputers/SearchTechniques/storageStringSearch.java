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
package com.gcomputers.SearchTechniques;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NG @ G-Computers
 */
public class storageStringSearch {
    
    public static final int linearSearch(String[] arr, String elementToSearch){
        for (int index = 0; index < arr.length; index++) {
            if (arr[index].equals(elementToSearch))
                return index; 
        }
        return -1;
    }
    
    public static final int binarySearch(String[] arr, String elementToSearch){
        int start = 0; 
        int end = arr.length - 1;
        while (start <= end)
        {
          int mid = (start + end) / 2;
          int comp = elementToSearch.compareTo(arr[mid]);
          if (comp == 0)
          {
            return mid;
          }
          else if (comp < 0)
          {
            end = mid - 1;
          }
          else
          {
            start = mid + 1;
          }
        }
        return -1;
    }
    
    public static final int simpleSearch(String[] arr, String elementToSearch){
        return -1;
    }
    
    public static final int rabinKarpSearch(String[] arr, String elementToSearch){
        return -1;
    }
    
    public static final int knuthMorissPrattSearch(String[] arr, String elementToSearch){
        return -1;
    }
    
    public static final int simpleBoyerMooreSearch(String[] arr, String elementToSearch){
        return -1;
    }
    
    public static final int boyerMooreHorspoolSearch(String[] arr, String elementToSearch){
        return -1;
    }
        
    private storageStringSearch(){
        System.exit(1);
    }
}
