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
package com.gcomputers.CRYPTO;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dard
 */
public class hashes {
    public static byte[] getSHA1(String userText, int size){
        
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] hash = Arrays.copyOf(md.digest(userText.getBytes("UTF-8")), size);
            return hash;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(hashes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static byte[] getSHA224(String userText, int size){
        
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-224");
            byte[] hash = Arrays.copyOf(md.digest(userText.getBytes("UTF-8")), size);
            return hash;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(hashes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public static byte[] getSHA256(String userText, int size){
        
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = Arrays.copyOf(md.digest(userText.getBytes("UTF-8")), size);
            return hash;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(hashes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static byte[] getSHA384(String userText, int size){
        
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-384");
            byte[] hash = Arrays.copyOf(md.digest(userText.getBytes("UTF-8")), size);
            return hash;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(hashes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public static byte[] getSHA512(String userText, int size){
        
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
            byte[] hash = Arrays.copyOf(md.digest(userText.getBytes("UTF-8")), size);
            return hash;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(hashes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public static byte[] getMD5(String userText, int size){
        
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] hash = Arrays.copyOf(md.digest(userText.getBytes("UTF-8")), size);
            return hash;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(hashes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private hashes (){
        System.exit(-1);
    }
}
