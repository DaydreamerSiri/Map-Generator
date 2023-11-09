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
        this.setBorderPainted(false);
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
    
    
    public void setDescription(String desc){
        Description = desc;
    }
    
    public void setClickEvent(){
        addActionListener((ActionEvent e) -> {
            JFrame msg = new JFrame();
            msg.setSize(100, 100);
            msg.setVisible(true);
            msg.add(new JLabel(this.POIDescription()));
        });
    }
    
    public String POIDescription(){
        return this.Description;
    }
    
}
