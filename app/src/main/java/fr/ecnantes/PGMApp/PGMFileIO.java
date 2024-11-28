/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ecnantes.PGMApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Input/Ouput Manager for PGM Image
 * @author simon
 */
public abstract class PGMFileIO {
    /**
     * Read a PGM image from a file
     * @param dir   Directory   
     * @return      PGMImage
     * @throws java.io.IOException      
     */
    public static PGMImage read(String dir) throws IOException {
        int height;
        int width;
        Integer[][] content;
       
        try (BufferedReader reader = new BufferedReader(new FileReader(dir))) {
            // Skip Header
            reader.skip(6);
            
            // Read Metadata
            height = readNextInt(reader);
            reader.skip(1); // Separation by two non-numeric characters
            width = readNextInt(reader);
            int saturationMax = readNextInt(reader);
            
            // Read Content
            content = new Integer[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    content[i][j] = readNextInt(reader);
                    reader.skip(1); // Separation by two non-numeric characters
                }
            }
        }
        
        return new PGMImage(getNameFromDir(dir), height, width, content);
    }
    
    /**
     * Read numbers until a non-numeric character
     * @param reader    Reader
     * @return          Read numeric value
     * @throws IOException 
     */
    private static int readNextInt(BufferedReader reader) throws IOException {
        int value = 0;
        int ascii;
        boolean continueFlag = reader.ready();
        
        while (continueFlag) {
            ascii = reader.read();
            
            // Check if the character is a number
            if (ascii >= 48 && ascii < 58) {
                value = 10*value + (ascii - 48);
                continueFlag = reader.ready();
            }
            else {
                continueFlag = false;
            }
        }
        
        return value;
    }
    
    /**
     * Get file name form directory name
     * @param dir   Directory name
     * @return      File Name
     */
    private static String getNameFromDir(String dir) {
        int i = dir.length() - 1;
        
        while (i >= 0 && dir.charAt(i) != '/') {
            i -= 1;
        }
        
        return dir.substring(i + 1);
    }
}
