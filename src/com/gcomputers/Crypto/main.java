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
package com.gcomputers.Crypto;

import com.gcomputers.FileIO.fileHandler;

/**
 *
 * @author Dard
 */
public class main {
    
    private static final String PLAINTEXT = "This is a test of AES encryption. You can put whatever you want in here and it will become encrypted.";
    private static final String ENCRYPTION_KEY = "1234567890";
    private static final String DECRYPTION_KEY = "1234567890";
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String TEXT_ENCODING = "UTF-8";
    public static final String PATH_TO_DESKTOP = System.getProperty("user.home") + "\\Desktop";
    public static final String FILE_NAME = "DeleteMe.txt";
    
    public static void main(String[] args){ 
        byte[] iv = AES.getInitializationVector();
        byte[] encryptHash = hashes.getSHA512(ENCRYPTION_KEY, 32);
        byte[] decryptHash = hashes.getSHA512(DECRYPTION_KEY, 32);
        
        byte[] cipherText = AES.getEncryptedString(PLAINTEXT, encryptHash, CIPHER_ALGORITHM, iv, TEXT_ENCODING);
        String decryptedText = AES.getDecryptedString(cipherText, decryptHash, CIPHER_ALGORITHM, iv, TEXT_ENCODING);

        System.out.println("EncryptDigest=" + new String(encryptHash) + ", Length="+ encryptHash.length);
        System.out.println("DecryptDigest=" + new String(decryptHash) + ", Length=" + decryptHash.length);
        System.out.println("Original Text=" + PLAINTEXT + ", Length=" + PLAINTEXT.length());
        System.out.println(new String("Cipher Text=") + new String(cipherText) + ", Length=" + cipherText.length);
        System.out.println("Decrypted Text=" + decryptedText + ", Length=" + decryptedText.length());
        
        fileHandler.createFile(PATH_TO_DESKTOP, FILE_NAME);
        fileHandler.writeToFile(PATH_TO_DESKTOP, FILE_NAME, "Plain Text:");
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, PLAINTEXT, true);
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, "", true);
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, "Hash:", true);
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, new String(encryptHash), true);
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, "", true);
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, "IV:", true);
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, new String(iv), true);
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, "", true);
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, "Encrypted Text:", true);
        fileHandler.appendToFile(PATH_TO_DESKTOP, FILE_NAME, new String(cipherText), true);
    }
}
