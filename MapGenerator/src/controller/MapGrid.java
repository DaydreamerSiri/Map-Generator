/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import model.MapGridModel;
import javax.swing.*;
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
        if(this.getCellDataList() == null) {   //check if Cells haven't been generated
        for(int i = 0; this.getSizeX() > i; i++){
                cellMap.add(new ArrayList());
                for(int j = 0; this.getSizeY() > j; j++) {
                   Cell cell = new Cell();
                   //cell.setLocation(this.yCellPosition*i-(this.yCellPosition*i/2), -this.xCellPosition*j-(this.xCellPosition*j/2));
                   cell.setVisible(true);
                   cell.setPreferredSize(this.sizeDimension);
                   //cell.setBackground(Color.white);
                   cell.isCreated(true);
                   cellMap.get(i).add(cell);
                   //onClick Action Event
                   cell.addActionListener(new ActionListener(){
                       @Override
                       public void actionPerformed(ActionEvent e){
                           JFrame msg = new JFrame();
                           msg.setSize(100, 100);
                           msg.setVisible(true);
                           msg.add(new JLabel(cell.cellToString()));

                       }
                   });

                }
            }
            this.setCellDataList(cellMap);
            return true;
        }
        
        return false;
    }
    
    /**
     * Inserting new GeoType into the tileInformations of Cells
     * @param grid the new tilePlaced Grid with GeoTypes
     */
    public void insertGeoType(Object[][] grid){
        ArrayList<Object> tileInfo = new ArrayList<>();
        for(int i = 0 ; this.getCellDataList().size() > i; i++){
            for(int j = 0; this.getCellDataList().get(i).size() > j; j++){
                if(Objects.isNull(grid[i][j])){
                    tileInfo.add("Special_Feature");
                }else{
                    tileInfo.add(grid[i][j].toString());
                }
                this.getCellDataList().get(i).get(j).setTileInformation(tileInfo.toArray());
            }
        }
    }
    
    /**
     * Function to set the Images of all the Cells to their corresponding geoTile
     */
    public void SetTileImages(){
        for(List<Cell> row : this.getCellDataList()){
            for(Cell cell: row){
                cell.SetTileImages(cell.getSize().width, cell.getSize().height);
                System.out.println();
                System.out.println(this.xCellSize);
            }
        }
    }
    
    /**
     * Update the Tile Images when the Frame gets resized
     * @param frameSizeDimension the Dimension of the Frame
     */
    public void UpdateTileImages(Dimension frameSizeDimension){
        for(List<Cell> row : this.getCellDataList()){
            for(Cell cell: row){
                cell.SetTileImages(frameSizeDimension);
            }
        }
    }
    /**
     * Update the POI Images when the Frame gets resized
     * @param frameSizeDimension the Dimension of the Frame
     */
    public void UpdatePOIImages(Dimension frameSizeDimension){
        for(POI poi : this.getPOIList()){
            poi.setPOIImage(frameSizeDimension);
        }
    }
    
    
    /**
     * Getter Function to get the Size Dimension (X;Y) of the created MapGrid
     * @return Dimension of the Map Grid
     */
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
