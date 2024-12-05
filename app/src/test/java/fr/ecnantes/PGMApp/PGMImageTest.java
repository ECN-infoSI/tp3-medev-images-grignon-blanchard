/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fr.ecnantes.PGMApp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author grigm
 */
public class PGMImageTest {
    
    public PGMImageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    

    /**
     * Test of difference method, of class PGMImage.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        
        //first image
        Integer[][] tableau = new Integer[2][3];
        for (int i = 0;i < tableau.length; i++) {
         for (int j = 0;j < tableau[i].length;j++) {
            tableau[i][j] = i + j;
            }
        }
        PGMImage image = new PGMImage("cc", 2, 3, tableau); 
        
        //image diff from first one
        Integer[][] tableaudiff = new Integer[2][3];
        for (int i = 0;i < tableaudiff.length; i++) {
         for (int j = 0;j < tableaudiff[i].length;j++) {
            tableaudiff[i][j] = i + j;
         }
        }
        tableaudiff[0][0]=1;
        PGMImage imagediff = new PGMImage("cc2", 2, 3, tableaudiff); 
        
        //expected result Equal 
        Integer[][] tableauexpequal = new Integer[2][3];
        for (int i = 0;i < tableauexpequal.length; i++) {
         for (int j = 0;j < tableauexpequal[i].length;j++) {
            tableauexpequal[i][j] = 0;
         }
        }
        
        assertArrayEquals(tableauexpequal, image.difference(image).getContent());
        
        // exepected result Diff 
        Integer[][] tableauexpdiff = new Integer[2][3];
        for (int i = 0;i < tableauexpdiff .length; i++) {
         for (int j = 0;j < tableauexpdiff [i].length;j++) {
            tableauexpdiff [i][j] = 0;
         }
        }
        tableauexpdiff[0][0]=1;
        assertArrayEquals(tableauexpdiff, image.difference(imagediff).getContent());; 
       
    
    }

    /**
     * Test of thresholding method, of class PGMImage.
     */
    @Test
    
    public void testThresholding() {
        System.out.println("thresholding");
        
        //first image
        Integer[][] tableau = new Integer[2][3];
        for (int i = 0;i < tableau.length; i++) {
         for (int j = 0;j < tableau[i].length;j++) {
            tableau[i][j] = i + j;
            }
        }
        PGMImage image = new PGMImage("cc", 2, 3, tableau); 
        
        //thresholding
        int thres=2; 
        PGMImage res =image.thresholding(thres); 
        
        //expected 
        Integer[][] tableauexp = {{0, 0, 255},{0,255,255}}; 
        
        
        assertArrayEquals(tableauexp,res.getContent());
        
        
        
        
        
    }

    /**
     * Test of enlargement method, of class PGMImage.
     */
    @Test
    public void testEnlargement() {
        System.out.println("enlargement");
        
        
        //first image
        Integer[][] tableau = new Integer[2][3];
        for (int i = 0;i < tableau.length; i++) {
         for (int j = 0;j < tableau[i].length;j++) {
            tableau[i][j] = i + j;
            }
        }
        PGMImage image = new PGMImage("cc", 2, 3, tableau);
              
        //enlargement
        Integer[][] res = image.enlargement(2).getContent(); 
        
        //expected 
        Integer[][] tableauexp = {{0, 0, 1,1,2,2},{0, 0, 1,1,2,2},{1,1,2,2,3,3}, {1,1,2,2,3,3}}; 
        
        assertArrayEquals(tableauexp,res);
        
        
    }

    /**
     * Test of reduction method, of class PGMImage.
     */
    @Test
    @Disabled
    public void testReduction() {
        System.out.println("reduction");
        int ratio = 0;
        PGMImage instance = null;
        PGMImage expResult = null;
        PGMImage result = instance.reduction(ratio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of histogram method, of class PGMImage.
     */
    @Test
    @Disabled
    public void testHistogram() {
        System.out.println("histogram");
        PGMImage instance = null;
        PGMImage expResult = null;
        PGMImage result = instance.histogram();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
