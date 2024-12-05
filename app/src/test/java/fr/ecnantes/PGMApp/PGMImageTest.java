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
    public void testReduction() {
        System.out.println("reduction");
        
        //first image odd width
        Integer[][] tableau = new Integer[4][7];
        for (int i = 0;i < tableau.length; i++) {
         for (int j = 0;j < tableau[i].length;j++) {
            tableau[i][j] = i + j;
            }
        }
        PGMImage image = new PGMImage("cc",4, 7, tableau);
        
        //reduction
        Integer[][] res = image.reduction(2).getContent(); 
        
        //expected 
        Integer[][] tableauexp = {{1,3,5,6},{3,5,7,8}}; 
        
        assertArrayEquals(tableauexp,res);
        
        
        //first image even width
        Integer[][] tableau2 = new Integer[4][6];
        for (int i = 0;i < tableau2.length; i++) {
         for (int j = 0;j < tableau2[i].length;j++) {
            tableau2[i][j] = i + j;
            }
        }
        PGMImage image2 = new PGMImage("cc",4, 6, tableau2);
        
        //reduction
        Integer[][] res2 = image2.reduction(2).getContent(); 
        
        //expected 
        Integer[][] tableauexp2 = {{1,3,5},{3,5,7}}; 
        
        assertArrayEquals(tableauexp2,res2);
    }

    /**
     * Test of histogram method, of class PGMImage.
     */
    @Test
    @Disabled 
    public void testHistogram() {
        System.out.println("histogram");
        
         //first image 
        Integer[][] tableau = {{124,124,1,1},{1,1,1,1}};
        PGMImage image = new PGMImage("cc", 2, 3, tableau);
        PGMImage res =image.histogram(); 
        
        //expected 
        Integer[][] tableauexp = new Integer[512][256]; 
        
        for (int i = 0;i < tableauexp.length/4;i++) {
            tableauexp[i][124] = 255 ;
        }
        
        for (int i = 0;i < tableauexp.length/4*3;i++) {
            tableauexp[i][1] = 255 ;
        }
        
        assertArrayEquals(tableauexp,res.getContent());
        
        
    }
    
}
