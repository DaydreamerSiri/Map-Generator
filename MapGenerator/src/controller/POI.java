/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.POIModel;

/**
 * Class for POI Objects for second Layer
 * @author Sehri Singh
 */
public class POI extends POIModel{
    
    private Image POIImage;
    private String Description;
    /**
     * POI Constructor
     * @param type type of POI as String
     * @param xLoc x Position of POI
     * @param yLoc y Position of POI
     */
    public POI(String type, int xLoc, int yLoc) {
        super(type, xLoc, yLoc);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
    }
    
    /**
     * sets the Image of the POI Object
     * @param width width of Image as Int
     * @param height height of Image as Int
     */
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
    /**
     * sets the Image of the POI Object
     * @param frameDimension size of Image as Dimension Object
     */
    public void setPOIImage(Dimension frameDimension){
    String imagePath = String.format("images\\POIs\\%s.png", this.Type);
    this.setImageLocation(imagePath);
        try{
            
            this.POIImage = ImageIO.read(new File(imagePath).getAbsoluteFile()).getScaledInstance(frameDimension.width,frameDimension.height, java.awt.Image.SCALE_SMOOTH);
            this.setIcon(new ImageIcon(POIImage));
        } catch (IOException e) {
            Logger.getLogger(MapGrid.class.getName()).log(Level.SEVERE, null, e);
            this.POIImage = null;
        }
        this.setSize(frameDimension.width, frameDimension.height);
    }
    
    /**
     * sets the Description of POI Object
     * @param desc the description as String
     */
    public void setDescription(String desc){
        Description = desc;
    }
    
    /**
     * OnClick event for POI Object, which returns the POI description in a new Frame
     */
    public void setClickEvent(){
        addActionListener((ActionEvent e) -> {
            JFrame msg = new JFrame();
            msg.setSize(100, 100);
            msg.setVisible(true);
            msg.add(new JLabel(this.POIDescription()));
        });
    }
    
    /**
     * toString Custom Function
     * @return the POI Description as String
     */
    public String POIDescription(){
        return this.Description;
    }
    
}
