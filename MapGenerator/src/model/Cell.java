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
    
    
    public Color getTileColor(String color){
        switch(color) {
            case "Green" -> {return Color.GREEN;}
            case "Yellow" -> {return Color.YELLOW;}
            case "Gray" -> {return Color.GRAY;}
        }
        return null;
    }
    
    public Object[] getTileInformation(){
        return this.tileInformation;
    }
    
    public void setTileInformation(Object[] tileInformation) {
        this.tileInformation = tileInformation;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isCreated(){
        return this.isCreated;
    }
    
    public boolean isPlaced() {
        return this.isPlaced;
    }
    
    public void isCreated(boolean isCreated){
        this.isCreated = isCreated;
    }
    
    public void isPlaced(boolean isPlaced){
        this.isPlaced = isPlaced;
    }
    
    public String cellToString(){
        return String.valueOf(this.tileInformation[0]);
    }
    
}
