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
  
    public Object[][] placeTile(int x,int y) {
        System.out.println("initialize place tile method.");
        int runningBonus = 0;
        int maxTiles = x * y;
        Object[][] grid = new Object[x][y];
        Object[] tilePack = new Object[4];
        int xPos = diceRoll.roll(x - 1), yPos = diceRoll.roll(y - 1);
        
        while (maxTiles > 0){
            System.out.println("Das ist ein RuningBonus" + runningBonus);
            tilePack = geography.geographyGen(runningBonus);
            if( (int) tilePack[2] > maxTiles){
                tilePack[2] = maxTiles;
                xPos = 0;
                yPos = 0;
                while (xPos < x){
                    System.out.println("xPos:" + xPos + "yPos:" + yPos);
                    while(yPos < y){
                        if (grid[xPos][yPos] == null){grid[xPos][yPos] = (String) tilePack[1];}
                        yPos++;
                    }
                    xPos++;
                }
                if(xPos == x){
                    xPos--;
                }
                if(yPos == y){
                    yPos--;
                }
            }
            runningBonus = (int) tilePack[0];
            int downCounter = (int) tilePack[2];
            
            // If this is the first tile or a random condition is met, choose a random position
            System.out.println("Grid printout:" + grid[xPos][yPos]);
            if (grid[xPos][yPos] != null) {
                xPos = diceRoll.roll(grid.length);
                yPos = diceRoll.roll(grid[0].length);
            } else { // Otherwise, choose a position around the last placed tile
                grid[xPos][yPos] = (String) tilePack[1];
                downCounter--;
                while(downCounter > 0){
                    int direction = diceRoll.roll(8);
                    int newXPos = xPos;
                    int newYPos = yPos;
                    switch (direction) {
                        case 1: newXPos = xPos - 1; break; // left
                        case 2: newXPos = xPos - 1; newYPos = yPos + 1; break; // left-up
                        case 3: newYPos = yPos + 1; break; // up
                        case 4: newXPos = xPos + 1; newYPos = yPos + 1; break; // up-right
                        case 5: newXPos = xPos + 1;  break; // right
                        case 6: newXPos = xPos + 1; newYPos = yPos - 1; break; // Down-right
                        case 7: newYPos = yPos - 1; break; // down
                        default: newXPos = xPos - 1; newYPos = yPos - 1; break; // down-left
                    }
                    if(newXPos >= 0 && newXPos < x && newYPos >= 0 && newYPos < y) {
                        xPos = newXPos;
                        yPos = newYPos;
                        grid[xPos][yPos] = (String) tilePack[1];
                        downCounter--;
                    }
                }
                maxTiles = maxTiles - (int) tilePack[2];
            }
        }

        return grid;
    }   
}