package controller;

import java.util.*;
import model.Cell;

/**
 *
 * @author Autmn
 */
public class TilePlacer {

    private Geography geography = new Geography();
    private DiceRoll diceRoll = new DiceRoll();
    //private Set<Position> placedPositions = new HashSet<>();
    private Set<Integer> blocked = new HashSet<>();

    public Object[][] placeTileSet(int x, int y) {
        System.out.println("Initialize placeTileSet method...");
        int runningBonus = 0;
        int maxTiles = x * y;
        Object[][] grid = new Object[x][y];
        Object[] tileSet = new Object[3];
        Object[] newCoordinates = new Object[2];

        //set random position
        int xPos = diceRoll.roll(x - 1);
        int yPos = diceRoll.roll(y - 1);

        //while there is still space in the grid
        while (maxTiles > 0) {
            System.out.println("RuningBonus: " + runningBonus);

            //get new TileSet
            tileSet = geography.geographyGen(runningBonus);

            //at almost end check what is left, compare tileSet[2] "amount" with rest of maxTiles
            //----------------------------------------------- dose not enter ??? ----------------------------------------------------------------
            if ((int) tileSet[2] > maxTiles) {
                tileSet[2] = maxTiles; //set amount to what is left

                //set coordinates 0,0
                xPos = 0;
                yPos = 0;

                //run through all cells in grid
                while (xPos < x) {
                    System.out.println("xPos:" + xPos + "yPos:" + yPos);
                    while (yPos < y) {
                        //if empty, insert tile type
                        if (grid[xPos][yPos] == null) {
                            grid[xPos][yPos] = (String) tileSet[1];
                        }
                        yPos++;
                    }
                    xPos++;
                }

                //rest to in bound for array
                if (xPos == x) {
                    xPos--;
                }
                if (yPos == y) {
                    yPos--;
                }
            }

            runningBonus = (int) tileSet[0]; //get new running Boni

            int downCounter = (int) tileSet[2]; //set for cound down

            System.out.println("xPos:" + xPos + "yPos:" + yPos);

            // if not empty, choose a random position
            if (grid[xPos][yPos] != null) {
                xPos = diceRoll.roll(grid.length);
                yPos = diceRoll.roll(grid[0].length);
                System.out.println("new xPos:" + xPos + "new yPos:" + yPos);
            }

            // Otherwise, choose a position around the last placed tile 
            grid[xPos][yPos] = (String) tileSet[1]; //insert tile type into cell

            downCounter--;

            while (downCounter > 0) {
                int direction = diceRoll.roll(8);
                int newXPos = 0;
                int newYPos = 0;

                newCoordinates = randomAround(xPos, yPos);
                
                newXPos = (int) newCoordinates[0];
                newYPos = (int) newCoordinates[1];
                
                //check if is in grid bound
                if (newXPos >= 0 && newXPos < x && newYPos >= 0 && newYPos < y) {
                    xPos = newXPos;
                    yPos = newYPos;
                    grid[xPos][yPos] = (String) tileSet[1]; //insert tile type into cell
                    downCounter--;
                } else {
            }

            //reduce maxTile of amount in tileSet[2]
            maxTiles = maxTiles - (int) tileSet[2];
        }

        //return filled grid
        return grid;
    }

    public Object[] randomAround(int oldX, int oldY) {
        Object[] coordinates = new Object[2];

        switch (direction) {
            case 1:
                newXPos = xPos - 1;
                break; // left
            case 2:
                newXPos = xPos - 1;
                newYPos = yPos + 1;
                break; // left-up
            case 3:
                newYPos = yPos + 1;
                break; // up
            case 4:
                newXPos = xPos + 1;
                newYPos = yPos + 1;
                break; // up-right
            case 5:
                newXPos = xPos + 1;
                break; // right
            case 6:
                newXPos = xPos + 1;
                newYPos = yPos - 1;
                break; // Down-right
            case 7:
                newYPos = yPos - 1;
                break; // down
            default:
                newXPos = xPos - 1;
                newYPos = yPos - 1;
                break; // down-left
        
                       }
        
        return coordinates;
    }
}
