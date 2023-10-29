/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.MapGridModel;
import javax.swing.*;
import javax.swing.border.*;
import model.Cell;
/**
 *
 * @author Sehri Singh
 */
public class MapGrid extends MapGridModel{
    
    protected Dimension sizeDimension = new Dimension(this.xCellSize, this.yCellSize);
    
    /**
     * Constructor of the Class MapGrid
     * @param sizeX the X Size of the Map
     * @param sizeY the Y Size of the Map
     */
    public MapGrid(int sizeX, int sizeY){
        super(sizeX, sizeY);
    }
    
    
    
    /**
     * function to generate map Cells and placing them in the UI
     * @return Boolean 
     */
    public boolean generateMap(){
        List<List<Cell>> cellMap = new ArrayList();
        if(this.getCellDataList() == null) {
        for(int i = 0; this.getSizeX() > i; i++){
                cellMap.add(new ArrayList());
                for(int j = 0; this.getSizeY() > j; j++) {
                   Icon icon = new ImageIcon("..\\..\\tiles\\area\\grass1.png");
                   File test = new File("..\\..\\ressources\\tiles\\area\\grass1.png");
                   System.out.println(test.exists());
                   Cell cell = new Cell();
                   cell.setLocation(this.yCellPosition*i-(this.yCellPosition*i/2), -this.xCellPosition*j-(this.xCellPosition*j/2));
                   cell.setVisible(true);
                   cell.setPreferredSize(this.sizeDimension);
                   cell.setText(this.toString());
                   //cell.setBorder(LineBorder.createBlackLineBorder());
                   cell.setBackground(Color.white);
                   cell.isCreated(true);
                   cellMap.get(i).add(cell);
                   cell.addActionListener(new ActionListener(){
                       @Override
                       public void actionPerformed(ActionEvent e){
                           JFrame msg = new JFrame();
                           msg.setSize(100, 100);
                           msg.setVisible(true);
                           msg.add(new JLabel(this.toString()));

                       }
                   });

                }
            }
            this.setCellDataList(cellMap);
            return true;
        }
        
        return false;
    }
    
    
    public Dimension getSizeDimension() {
        return this.sizeDimension;
    }
    
    /**
     * Getter Function to retrieve all the Map Information
     * @return MapGridModel Object
     */
    public MapGridModel getMapData(){
        return this;
    }
    
}
