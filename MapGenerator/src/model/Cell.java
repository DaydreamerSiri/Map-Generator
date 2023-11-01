/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.MapGrid;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Sehri Singh
 */
public class Cell extends JButton {
    
    private Object[] tileInformation;
    boolean isCreated = false;
    boolean isPlaced = false;
    
    public void Cell(){
        
    }
    
    
    /**
     * Set the Image of the Cell
     * @param width width of the Tile
     * @param height height of the Tile
     */
    public void SetTileImages(int width, int height){
        String imagePath = String.format("images\\tiles\\%s.png", this.tileInformation[0]);
        try{
            
            Image img = ImageIO.read(new File(imagePath).getAbsoluteFile()).getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            System.out.println(img);
            this.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            Logger.getLogger(MapGrid.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Function to set the Background Colour of the Cell
     * @deprecated 
     * @param color color name
     * @return Color Object
     */
    public Color getTileColor(String color){
        switch(color) {
            case "Green" -> {return Color.GREEN;}
            case "Yellow" -> {return Color.YELLOW;}
            case "Gray" -> {return Color.GRAY;}
        }
        return null;
    }
    
    
    /**
     * Getter Function to retrieve the geoTileInformations
     * @return 
     */
    public Object[] getTileInformation(){
        return this.tileInformation;
    }
    
    
    /**
     * Setter Function to set the geoTileInformations
     * @param tileInformation 
     */
    public void setTileInformation(Object[] tileInformation) {
        this.tileInformation = tileInformation;
    }
    
    /**
     * Creation Check Function
     * @return boolean if it's created
     */
    public boolean isCreated(){
        return this.isCreated;
    }
    /**
     * Placement Check Function
     * @return boolean if it's placed
     */
    public boolean isPlaced() {
        return this.isPlaced;
    }
    
    /**
     * Creation Check Function
     * @param isCreated boolean if it's created
     * @return boolean if it's created
     */
    public boolean isCreated(boolean isCreated){
        return this.isCreated = isCreated;
    }
    /**
     * Placement Check Function
     * @param isPlaced boolean if it's created
     * @return boolean if it's placed
     */
    public boolean isPlaced(boolean isPlaced){
        return this.isPlaced = isPlaced;
    }
    
    
    /**
     * return Custom toString Method
     * @return String Object Information
     */
    public String cellToString(){
        return String.valueOf(this.tileInformation[0]);
    }
    
}
