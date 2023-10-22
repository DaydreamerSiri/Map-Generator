/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author noormo
 */
public class Place {
    private int ID;
    private int riverNumber;
    private int npcID;
    private int XPos;
    private int YPos;
    private String type;
    private int tileNumber;
    private String symbol;
    private String specialFeatures;
    private String ageHistory;
    private String difficulty;
    
    
    public Place() {}

    public Place(int ID, int riverNumber, int npcID, int XPos, int YPos, String type, int tileNumber, String symbol, String specialFeatures, String ageHistory, String difficulty) {
        this.ID = ID;
        this.riverNumber = riverNumber;
        this.npcID = npcID;
        this.XPos = XPos;
        this.YPos = YPos;
        this.type = type;
        this.tileNumber = tileNumber;
        this.symbol = symbol;
        this.specialFeatures = specialFeatures;
        this.ageHistory = ageHistory;
        this.difficulty = difficulty;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRiverNumber() {
        return riverNumber;
    }

    public void setRiverNumber(int riverNumber) {
        this.riverNumber = riverNumber;
    }

    public int getNpcID() {
        return npcID;
    }

    public void setNpcID(int npcID) {
        this.npcID = npcID;
    }

    public int getXPos() {
        return XPos;
    }

    public void setXPos(int XPos) {
        this.XPos = XPos;
    }

    public int getYPos() {
        return YPos;
    }

    public void setYPos(int YPos) {
        this.YPos = YPos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTileNumber() {
        return tileNumber;
    }

    public void setTileNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getAgeHistory() {
        return ageHistory;
    }

    public void setAgeHistory(String ageHistory) {
        this.ageHistory = ageHistory;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Place{" + "ID=" + ID + ", riverNumber=" + riverNumber + ", npcID=" + npcID + ", XPos=" + XPos + ", YPos=" + YPos + ", type=" + type + ", tileNumber=" + tileNumber + ", symbol=" + symbol + ", specialFeatures=" + specialFeatures + ", ageHistory=" + ageHistory + ", difficulty=" + difficulty + '}';
    }
    
    
    
    
}
