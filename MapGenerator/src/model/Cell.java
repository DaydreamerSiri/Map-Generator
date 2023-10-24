/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.*;

/**
 *
 * @author Sehri Singh
 */
public class Cell extends JButton {
    
    String groundType;
    boolean isCreated = false;
    boolean isPlaced = false;
    
    public void Cell(){
        
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
    
}
