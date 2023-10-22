/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.MapGridModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Sehri Singh
 */
public class MapGrid extends MapGridModel{
    
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
        List<List<JButton>> cellMap = new ArrayList();
        if(this.getCellData() == null) {
        for(int i = 0; this.getSizeX() > i; i++){
                cellMap.add(new ArrayList());
                for(int j = 0; this.getSizeY() > j; j++) {
                   JButton cell = new JButton();
                   cell.setLocation(this.yCellPosition*i, -this.xCellPosition*j);
                   cell.setSize(10, 10);
                   cell.setVisible(true);
                   cell.setText("CELL" +i+" "+j);
                   cell.setBorder(LineBorder.createBlackLineBorder());
                   cellMap.get(i).add(cell);

                   cell.addActionListener(new ActionListener(){
                       @Override
                       public void actionPerformed(ActionEvent e){
                           JFrame msg = new JFrame();
                           msg.setSize(100, 100);
                           msg.setVisible(true);
                           msg.add(new JLabel("TEST"));

                       }
                   });

                }
            }
            this.setCellData(cellMap);
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Getter Function to retrieve all the Map Information
     * @return MapGridModel Object
     */
    public MapGridModel getMapData(){
        return this;
    }
    
}
