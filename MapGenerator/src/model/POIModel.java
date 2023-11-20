/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Class for POI Objects on the Map
 * @author Sehri Singh
 */
public class POIModel extends JButton {
    
    protected String Type;
    private int xLocation;
    private int yLocation;
    private String ImageLocation;
    boolean isCreated = false;
    boolean isPlaced = false;
    
    /**
     * Constructor for POI Model
     * @param type type of POI
     * @param xLoc x Location of POI
     * @param yLoc y Location of POI
     */
    public POIModel(String type, int xLoc, int yLoc) {
        Type = type;
        xLocation = xLoc;
        yLocation = yLoc;
    }
    
    public void setImageLocation(String path){
        this.ImageLocation = path;
    }
    
    public String getImageLocation(){
        return ImageLocation;
    }
    
}
