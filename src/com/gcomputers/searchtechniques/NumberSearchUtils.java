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
package com.gcomputers.searchtechniques;

import java.util.Arrays;

/**
 *
 * @author NG @ G-Computers
 */
public final class NumberSearchUtils {
    
    public static int linearSearch(int[] arr, int elementToSearch){
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch) {
                return index;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int[] arr, int elementToSearch){
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // termination condition (element isn't present)
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // if the middle element is our goal element, return its index
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            // if the middle element is smaller
            // point our index to the middle+1, taking the first half out of consideration
            else if (arr[middleIndex] < elementToSearch){
                firstIndex = middleIndex + 1;
            }

            // if the middle element is bigger
            // point our index to the middle-1, taking the second half out of consideration
            else if (arr[middleIndex] > elementToSearch){
                lastIndex = middleIndex - 1;
            }

        }
        return -1;
    }
    
    public static int jumpSearch(int[] arr, int elementToSearch){
        int arrayLength = arr.length;
        int jumpStep = (int) Math.sqrt(arr.length);
        int previousStep = 0;

        while (arr[Math.min(jumpStep, arrayLength) - 1] < elementToSearch) {
            previousStep = jumpStep;
            jumpStep += (int)(Math.sqrt(arrayLength));
            if (previousStep >= arrayLength){
                return -1;
            }
        }
        while (arr[previousStep] < elementToSearch) {
            previousStep++;
            if (previousStep == Math.min(jumpStep, arrayLength)){
                return -1;
            }
        }

        if (arr[previousStep] == elementToSearch){
            return previousStep;
        }
        return -1;
    }
    
    public static int interpolationSearch(int[] arr, int elementToSearch){    
        int startIndex = 0;
        int lastIndex = arr.length - 1;

        while (startIndex <= lastIndex && elementToSearch >= arr[startIndex] &&
               elementToSearch <= arr[lastIndex]) {
            // using interpolation formulae to find the best probable position for this element to exist
            int pos = startIndex + (((lastIndex-startIndex) /
              (arr[lastIndex]-arr[startIndex]))*
                            (elementToSearch - arr[startIndex]));

            if (arr[pos] == elementToSearch){
                return pos;
            }

            if (arr[pos] < elementToSearch){
                startIndex = pos + 1;
            }

            else {
                lastIndex = pos - 1;
            }
        }
        return -1;
    }
    
    public static int exponentialSearch(int[] arr, int elementToSearch){
        if (arr[0] == elementToSearch){
            return 0;
        }
        if (arr[arr.length - 1] == elementToSearch){
            return arr.length;
        }

        int range = 1;

        while (range < arr.length && arr[range] <= elementToSearch) {
            range = range * 2;
        }

        return Arrays.binarySearch(arr, range / 2, Math.min(range, arr.length), elementToSearch);
    }
            
    public static int fibonacciSearch(int[] arr, int elementToSearch){
        int fibonacciMinus2 = 0;
        int fibonacciMinus1 = 1;
        int fibonacciNumber = fibonacciMinus2 + fibonacciMinus1;
        int arrayLength = arr.length;

        while (fibonacciNumber < arrayLength) {
            fibonacciMinus2 = fibonacciMinus1;
            fibonacciMinus1 = fibonacciNumber;
            fibonacciNumber = fibonacciMinus2 + fibonacciMinus1;
        }

        int offset = -1;

        while (fibonacciNumber > 1) {
            int i = Math.min(offset+fibonacciMinus2, arrayLength-1);

            if (arr[i] < elementToSearch) {
                fibonacciNumber = fibonacciMinus1;
                fibonacciMinus1 = fibonacciMinus2;
                fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
                offset = i;
            }

            else if (arr[i] > elementToSearch) {
                fibonacciNumber = fibonacciMinus2;
                fibonacciMinus1 = fibonacciMinus1 - fibonacciMinus2;
                fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
            }
            else {
                return i;
            }
        }

        if (fibonacciMinus1 == 1 && arr[offset+1] == elementToSearch){
            return offset+1;
        }

        return -1;
    }
    
    private NumberSearchUtils(){
        System.exit(1);
    }
}
