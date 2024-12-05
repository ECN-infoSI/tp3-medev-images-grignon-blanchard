/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fr.ecnantes.PGMApp;

import fr.ecnantes.PGMApp.PGMFileIO;
import fr.ecnantes.PGMApp.PGMImage;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author simon
 */
public class PGMFileIOTest {
    
    public PGMFileIOTest() {
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
     * Test of read method, of class PGMFileIO.
     */
    @Test
    public void testRead() throws Exception {       
        System.out.println("read absent file");
        Exception exception = assertThrows(FileNotFoundException.class, () -> PGMFileIO.read("absentFile.pgm"));
        
        System.out.println("read file");
        PGMImage image = PGMFileIO.read("src/test/resources/pictures/test.pgm");
        Integer[][] content = {{49, 50, 48, 49}, {48, 48, 49, 50}, {50, 50, 50, 49}};
        
        assertEquals("test.pgm", image.getName());
        assertEquals(3, image.getHeight());
        assertEquals(4, image.getWidth());
        assertArrayEquals(content, image.getContent());
    }

    /**
     * Test of write method, of class PGMFileIO.
     */
    @Test
    public void testWrite() throws Exception {

    }
}
