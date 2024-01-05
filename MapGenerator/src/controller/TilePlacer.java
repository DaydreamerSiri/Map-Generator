package controller;

import java.util.*;
import model.Cell;

/**
 * The TilePlacer class is responsible for placing tiles on a grid.
 * It uses a spiral pattern to fill the grid with different types of tiles.
 * The grid represents a map, and the tiles are placed randomly based on certain conditions.
 *
 * @author Autmn
 */
public class TilePlacer {

    // Geography class is assumed to provide tile types and bonuses.
    private Geography geography = new Geography();
    // DiceRoll class is assumed to handle random dice rolls.
    private DiceRoll diceRoll = new DiceRoll();

    // Main method for testing in the console.
    public static void main(String[] args) {
        TilePlacer tilePlacer = new TilePlacer();
        Object[][] grid = new Object[10][10];
        int x = 10;
        int y = 10;
        // Calls the placeTileSet method to place tiles on the grid.
        grid = tilePlacer.placeTileSet(x, y);
    }

    /**
     * Places a set of tiles on the grid.
     *
     * @param x The width of the grid.
     * @param y The height of the grid.
     * @return A 2D array representing the grid with placed tiles.
     */
    public Cell[][] placeTileSet(int x, int y) {
        // Prints a message for debugging purposes.
        System.out.println("Initialize placeTileSet method...");
        // Initialize variables for tracking running bonuses, maximum tiles, the grid, and a tile set.
        int runningBonus = 0;
        int maxTiles = x * y;
        Cell[][] grid = new Cell[x][y];
        Object[] tileSet = new Object[3];

        // Set random starting position.
        int xPos = diceRoll.roll(x - 1);
        int yPos = diceRoll.roll(y - 1);

        System.out.println("MaxTiles: " + maxTiles);

        // While there is still space in the grid.
        while (maxTiles > 0) {
            // Get a new TileSet from the geography.
            tileSet = geography.geographyGen(runningBonus);
            int[] newCoordinates = new int[(int) tileSet[2] * 2];

            // Check if the remaining tiles to place exceed the available space.
            if ((int) tileSet[2] > maxTiles) {
                // Handle special case where there is not enough space for all tiles of the type.
                System.out.println("MaxTiles: " + maxTiles);
                System.out.println("tiles to place: " + (int) tileSet[2]);
                System.out.println("tile type: " + (String) tileSet[1]);
                int counter = 0;

                // Set coordinates to (0, 0).
                xPos = 0;
                yPos = 0;

                // Run through all cells in the grid.
                while (yPos < y) {
                    while (xPos < x) {
                        // If the cell is empty, insert the tile type.
                        if (grid[xPos][yPos] == null && !tileSet[1].equals("River")) {
                            grid[xPos][yPos] = new Cell();
                            grid[xPos][yPos].setTileInformation((String) tileSet[1]);
                            counter++;
                        }
                        if (xPos <= x) {
                            xPos++;
                        }
                    }
                    // Reset the x position.
                    xPos = 0;
                    if (yPos <= y) {
                        yPos++;
                    }
                }

                System.out.println("counter: " + counter);
                System.out.println("Tada");
                return grid;
            }

            // Get new running Bonus.
            runningBonus = (int) tileSet[0];

            int tilesToPlaceNum = (int) tileSet[2];
            int upCounter = 0;

            // While the current position is not empty, choose a random position.
            while (grid[xPos][yPos] != null) {
                xPos = diceRoll.roll(x - 1);
                yPos = diceRoll.roll(y - 1);
            }

            // Place the initial tile at the chosen position.
            if (!tileSet[1].equals("River")) {
                grid[xPos][yPos] = new Cell();
                grid[xPos][yPos].setTileInformation((String) tileSet[1]);
                upCounter++;
            } else if (tileSet[1].equals("River")) {
                upCounter = tilesToPlaceNum;
            }

            int newXPos = 0;
            int newYPos = 0;
            int nextCoPosition = 0;
            System.out.println("tilesToPlaceNum: " + tilesToPlaceNum);

            // Continue placing tiles in a spiral pattern around the initial tile.
            while (upCounter < tilesToPlaceNum && nextCoPosition < newCoordinates.length / 2) {
                newXPos = (int) newCoordinates[nextCoPosition];
                newYPos = (int) newCoordinates[nextCoPosition + 1];

                // Check if the new position is within the grid bounds.
                if (newXPos > 0 && newYPos > 0 && newXPos < x && newYPos < y) {
                    xPos = newXPos;
                    yPos = newYPos;

                    // If the cell is null, insert the tile type.
                    if (grid[xPos][yPos] == null && !tileSet[1].equals("River")) {
                        grid[xPos][yPos] = new Cell();
                        grid[xPos][yPos].setTileInformation((String) tileSet[1]);
                        upCounter++;
                    }
                }

                // Move to the next coordinates position in newCoordinates.
                nextCoPosition += 2;
            }

            // Reduce maxTiles by the number of tiles placed.
            maxTiles = maxTiles - upCounter;
        }

        // Return the filled grid.
        System.out.println("Tada");
        return grid;
    }

    /**
     * Generates coordinates for a spiral pattern around a starting point.
     *
     * @param gridXMax The maximum width of the grid.
     * @param gridYMax The maximum height of the grid.
     * @param startX   The starting X coordinate.
     * @param startY   The starting Y coordinate.
     * @param tileNum  The number of tiles to be placed.
     * @return An array of coordinates representing the spiral pattern.
     */
    public int[] goAround(int gridXMax, int gridYMax, int startX, int startY, int tileNum) {
        int[] result = new int[tileNum * 2];
        int x = startX;
        int y = startY;
        int step = 0;
        int[] co = new int[2];

        // Store initial position.
        result[0] = x;
        result[++step] = y;

        for (int i = 2; i < result.length; i = i + step) {
            for (int layer = 0; layer < Math.min(gridXMax, gridYMax); layer += 2) {
                co = moveLeft(x, y);
                if (step < result.length - 1) {
                    result[++step] = co[0];
                }
                if (step < result.length - 1) {
                    result[++step] = co[1];
                }

                for (int ii = layer; ii >= 0; ii -= 2) {
                    co = moveUp(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                    }
                    if (ii >= 2) {
                        co = moveUp(x, y);
                        if (step < result.length - 1) {
                            result[++step] = co[0];
                        }
                        if (step < result.length - 1) {
                            result[++step] = co[1];
                        }
                    }
                }
                for (int ii = layer; ii >= 0; ii -= 2) {
                    co = moveRight(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                    }
                    co = moveRight(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                    }
                }
                for (int ii = layer; ii >= 0; ii -= 2) {
                    co = moveDown(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                    }
                    co = moveDown(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                    }
                }
                for (int ii = layer; ii >= 0; ii -= 2) {
                    co = moveLeft(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                    }
                    co = moveLeft(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                    }
                }
            }
        }

        return result;
    }

    // Helper methods for moving in different directions.
    public int[] moveLeft(int x, int y) {
        int[] co = new int[2];
        co[0] = --x;
        co[1] = y;
        return co;
    }

    public int[] moveRight(int x, int y) {
        int[] co = new int[2];
        co[0] = ++x;
        co[1] = y;
        return co;
    }

    public int[] moveUp(int x, int y) {
        int[] co = new int[2];
        co[0] = x;
        co[1] = --y;
        return co;
    }

    public int[] moveDown(int x, int y) {
        int[] co = new int[2];
        co[0] = x;
        co[1] = ++y;
        return co;
    }
}