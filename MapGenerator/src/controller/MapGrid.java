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
    public boolean generateMap(Cell[][][] Cells){
        Cell[][] cellList = new Cell[this.sizeDimension.height][this.sizeDimension.width];
        if(this.getCellDataList() == null) {   //check if Cells haven't been generated
        for(int i = 0; this.getAmountX() > i; i++){
                for(int j = 0; this.getAmountY() > j; j++) {
                   //cell.setLocation(this.yCellPosition*i-(this.yCellPosition*i/2), -this.xCellPosition*j-(this.xCellPosition*j/2));
                   Cells[i][j][0].setVisible(true);
                   Cells[i][j][0].setPreferredSize(this.sizeDimension);
                   //cell.setBackground(Color.white);
                   Cells[i][j][0].isCreated(true);
                   //onClick Action Event
                   Cell cell = Cells[i][j][0];
                   Cells[i][j][0].addActionListener(new ActionListener(){
                       @Override
                       public void actionPerformed(ActionEvent e){
                           JFrame msg = new JFrame();
                           msg.setSize(100, 100);
                           msg.setVisible(true);
                           msg.add(new JLabel(cell.cellToString()));

                       }
                   });
                   cellList[i][j] = Cells[i][j][0];
                }
            }
            this.setCellDataList(cellList);
            return true;
        }
        
        return false;
    }
    
    /**
     * Converts Cell Objects to POI Objects
     * @param cellList a cellList object with 3th Dimensional Layer
     * @return an POI List Object with POI Elements in it
     */
    public POI[][] createPOIObjects(Cell[][][] cellList){
        POI[][] poiList = new POI[this.sizeDimension.height][this.sizeDimension.width];
        for(int i = 0 ; cellList.length > i; i++){
            for(int j = 0; cellList[i].length > j; j++){
               POI poi = new POI(cellList[i][j][1].getTileInformation(), 
                       cellList[i][j][1].getX(), cellList[i][j][1].getY());
               poiList[i][j] = poi;
            }
        }
        return poiList;
    }
    
    /**
     * Inserting new GeoType into the tileInformations of Cells
     * @param grid the new tilePlaced Grid with GeoTypes
     */
    public boolean insertGeoType(Cell[][] grid){
        for(int i = 0 ; this.getCellDataList().length > i; i++){
            for(int j = 0; this.getCellDataList()[i].length > j; j++){
                if((grid[i][j].getTileInformation().isEmpty())){
                    this.getCellDataList()[i][j].setTileInformation("Special_Feature");
                }
            }
        }
        return true;
    }
    
    /**
     * Function to set the Images of all the Cells to their corresponding geoTile
     */
    public void SetTileImages(){
        for(Cell[] row : this.getCellDataList()){
            for(Cell cell: row){
                cell.SetTileImages(cell.getSize().width, cell.getSize().height);
            }
        }
    }
    
    /**
     * Update the Tile Images when the Frame gets resized
     * @param frameSizeDimension the Dimension of the Frame
     */
    public void UpdateTileImages(Dimension frameSizeDimension){
        for(Cell[] row : this.getCellDataList()){
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
        for(POI[] poiList : this.getPOIList()){
            for(POI poi : poiList){
                poi.setPOIImage(frameSizeDimension);
            }
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
