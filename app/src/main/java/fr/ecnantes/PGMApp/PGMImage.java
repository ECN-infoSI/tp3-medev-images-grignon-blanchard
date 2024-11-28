/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ecnantes.PGMApp;

/**
 *
 * @author grigm
 */
public class PGMImage {
    private String name; 
    private Integer height; 
    private Integer width; 
    private Integer[][] content; 
    
    
    /**
     * Constructor PGMImage
     * @grigm
     * @param name      image name
     * @param height    image height
     * @param width     image width
     * @param content   table width*height with integer represented gray level 
     **/
    public PGMImage(String name, int height, int width, Integer[][] content){
        this.name = name; 
        this.height=height; 
        this.width=width; 
        this.content = content; 
    }
    
    /**
     * Copy Constructor PGMImage
     * @grigm
     * @param image     image to copy
     *  
     **/
    public PGMImage(PGMImage image){
        this.name = image.name; 
        this.height=image.height; 
        this.width=image.width; 
        this.content = image.content; 
    }

    /*
    * GETTERS
    */
    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer[][] getContent() {
        return content;
    }
    
    /*
    * SETTERS
    */
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setContent(Integer[][] content) {
        this.content = content;
    }
    
    /**
     * Difference between 2 images px by px
     * @grigm
     * @param other     image to compare
     * @return          difference image 
     **/
    public PGMImage difference(PGMImage other){
        String namediff ="Diff-"+ this.getName() + "-"+ other.getName();  
        int heightdiff =  this.getHeight(); 
        int widthdiff = this.getWidth(); 
        Integer[][] contentdiff = new Integer[heightdiff][ widthdiff]; 
        
        Integer[][] othercontent= other.getContent(); 
        
        for (int i = 0; i< heightdiff; i++) {
         for (int j = 0;j < widthdiff;j++) {
            contentdiff[i][j] = Math.abs(this.content[i][j]-othercontent[i][j]);
            }
        }
        PGMImage res = new PGMImage(namediff, heightdiff, widthdiff, contentdiff); 
        return res; 
    }
    
}
