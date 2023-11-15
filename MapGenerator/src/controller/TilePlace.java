package controller;
import java.util.*;
import model.Cell;

/**
 *
 * @author Autmn
 */

public class TilePlace {
    private Geography geography = new Geography();
    private DiceRoll diceRoll = new DiceRoll(); 
    //private Set<Position> placedPositions = new HashSet<>();
    private Set<Integer> blocked = new HashSet<>();
    private Position lastPlacedPosition = null;
  
    public Object[][] placeTile(int x,int y) {
        int runningBonus = 0;
        int maxTiles = x * y;
        Object[][] grid = new Object[x][y];
        Object[] tilePack = new Object[2];
        int xPos = diceRoll.roll(x), yPos = diceRoll.roll(y);
        
        while (maxTiles > 0){
            tilePack = geography.geographyGen(runningBonus);
            if( (int) tilePack[2] > maxTiles){
                tilePack[2] = maxTiles;
                xPos = 0;
                yPos = 0;
                while (xPos <= x){
                    while(yPos <= y){
                        if (grid[xPos][yPos] == null){grid[xPos][yPos] = (String) tilePack[1];}
                        yPos++;
                    }
                    xPos++;
                }
            }
            runningBonus = (int) tilePack[0];
            int downCounter = (int) tilePack[2];
            
            // If this is the first tile or a random condition is met, choose a random position
            if (grid[xPos][yPos] != null) {
                xPos = diceRoll.roll(grid.length);
                yPos = diceRoll.roll(grid[0].length);
            } else { // Otherwise, choose a position around the last placed tile
                grid[xPos][yPos] = (String) tilePack[1];
                downCounter--;
                while(downCounter > 0){
                    int direction = diceRoll.roll(8);
                    switch (direction) {
                        case 1: xPos = xPos - 1; break; // left
                        case 2: xPos = xPos - 1; yPos = yPos + 1; break; // left-up
                        case 3: yPos = yPos + 1; break; // up
                        case 4: xPos = xPos + 1; yPos = yPos + 1; break; // up-right
                        case 5: xPos = xPos + 1;  break; // right
                        case 6: xPos = xPos + 1; yPos = yPos - 1; break; // Down-right
                        case 7: yPos = yPos - 1; break; // down
                        default: xPos = xPos - 1; yPos = yPos - 1; break; // down-left
                    }
                    grid[xPos][yPos] = (String) tilePack[1];
                    downCounter--;
                }
                maxTiles = maxTiles - (int) tilePack[2];
            }
        }

        return grid;
    }  
}