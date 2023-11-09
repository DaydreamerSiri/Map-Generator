/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import controller.POI;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 * MapGridModel
 * @author Sehri
 */
public class MapGridModel implements MapGridInterface{
    private int sizeX; 
    private int sizeY;
    
    private List<List<Cell>> CellDataList;
    private List<POI> POIDataList;
    
    
    /**
     * Constructor method taking the size of map as arguments
     * @param sizeX x size of map
     * @param sizeY y size of map
     */
    public MapGridModel(int sizeX, int sizeY){
        if(sizeX != sizeY){
            throw new IllegalArgumentException("Please use correct Map Size");
        }
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    /**
     * Gets the SizeX
     * @return the X size of map 
     */
    public int getSizeX(){
        return this.sizeX;
    }
    /**
     * Gets the SizeY
     * @return the Y size of map 
     */
    public int getSizeY(){
        return this.sizeY;
    }
    
    /**
     * Gets all the Cells of a Map
     * @return List of a List with Cell Objects
     */
    public List<List<Cell>> getCellDataList(){
        return this.CellDataList;
    }
    
    /**
     * Sets all the Cells of a Map
     */
    public void setCellDataList(List<List<Cell>> cellData){
        this.CellDataList = cellData;
    }
    
    public void setPOIList(List<POI> poiList){
        this.POIDataList = poiList;
    }
    
    public List<POI> getPOIList(){
        return this.POIDataList;
    }
    
}
