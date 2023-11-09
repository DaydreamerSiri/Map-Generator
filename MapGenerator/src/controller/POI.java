/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.POIModel;

/**
 *
 * @author Sehri Singh
 */
public class POI extends POIModel{
    
    private Image POIImage;
    private String Description;
    
    public POI(String type, int xLoc, int yLoc) {
        super(type, xLoc, yLoc);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(true);
    }
    
    public void setPOIImage(int width, int height){
    String imagePath = String.format("images\\POIs\\%s.png", this.Type);
    this.setImageLocation(imagePath);
        try{
            
            this.POIImage = ImageIO.read(new File(imagePath).getAbsoluteFile()).getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            this.setIcon(new ImageIcon(POIImage));
        } catch (IOException e) {
            Logger.getLogger(MapGrid.class.getName()).log(Level.SEVERE, null, e);
            this.POIImage = null;
        }
        this.setSize(width, height);
    }
    
    public void setDescription(String desc){
        Description = desc;
    }
    
    public String POIDescprition(){
        return this.Description;
    }
    
}
