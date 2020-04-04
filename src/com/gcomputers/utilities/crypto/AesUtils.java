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
package com.gcomputers.utilities.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author Dard
 */
public final class AesUtils {
  
    public static byte[] getInitializationVector(){
        byte[] iv = new byte[128/8]; //Get blank byte array
        
        SecureRandom srd = new SecureRandom();
        srd.nextBytes(iv); //Randomize byte array
        
        return iv;
    }
    
    public static byte[] getEncryptedString(String plainText, byte[] hash, String cipherAlgorithm, byte[] iv, String textEncoding){        
        try {      
                SecretKey skey = new SecretKeySpec(hash, "AES"); //Create Secret Key
                Cipher ci = Cipher.getInstance(cipherAlgorithm); //Get Cipher instance
                ci.init(Cipher.ENCRYPT_MODE, skey, new IvParameterSpec(iv)); //Setup Cipher

                return ci.doFinal(plainText.getBytes(textEncoding));
                
            } catch (NoSuchPaddingException | UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(AesUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        return new byte[0];
    }
    
    public static String getDecryptedString(byte[] cipherText, byte[] hash, String cipherAlgorithm, byte[] iv, String textEncoding){
        try {
            SecretKey skey = new SecretKeySpec(hash, "AES"); //Create Secret Key
            Cipher ci = Cipher.getInstance(cipherAlgorithm); //Get Cipher instance
            ci.init(Cipher.DECRYPT_MODE, skey, new IvParameterSpec(iv)); //Setup Cipher
            
            return new String(ci.doFinal(cipherText));
            
        } catch (NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(AesUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private AesUtils(){  
        System.exit(-1);
    }
}
