package controller;

import java.util.*;
import model.Cell;
import java.math.BigDecimal;

/**
 *
 * @author Autmn
 */
public class TilePlacer {

    private Geography geography = new Geography();
    private DiceRoll diceRoll = new DiceRoll();

    //for testing in console
    public static void main(String[] args) {
        TilePlacer tilePlacer = new TilePlacer();
        Object[][] grid = new Object[10][10];
        int x = 10;
        int y = 10;
        grid = tilePlacer.placeTileSet(x, y);
    }

    public Cell[][][] placeTileSet(int x, int y) {
        System.out.println("Initialize placeTileSet method...");
        int runningBonus = 0;
        int maxTiles = x * y;
        Cell[][][] grid = new Cell[x][y][2];
        Object[] tileSet = new Object[3];

        //set random position
        int xPos = diceRoll.roll(x - 1);
        int yPos = diceRoll.roll(y - 1);

        System.out.println("MaxTiles: " + maxTiles);

        //while there is still space in the grid
        while (maxTiles > 0) {
            //get new TileSet
            tileSet = geography.geographyGen(runningBonus);

            //TODO: Auffang River
            if (tileSet[1].equals("River")) {
                int riverSetNum = (int) tileSet[2];
                int[] newCo = new int[2];
                int riverLayerPosX = diceRoll.roll(x - 1);
                int riverLayerPosY = diceRoll.roll(y - 1);
                int orientation = 0;
                int direction = 0;
                int directionOld = 0;
                int rollOrientation = 0;

                // while river tiles are still to place
                for (int i = 0; i < riverSetNum; i++) {
                    // what direction is to be blacked
                    int blockedDirection = diceRoll.roll(4);
                    direction = diceRoll.roll(4);

                    if (i == 0) {
                        while (direction == blockedDirection) {
                            direction = diceRoll.roll(4);
                        }

                        //check direction, to limit orientation
                        if (direction == 1 || direction == 2) {
                            rollOrientation = diceRoll.roll(2);
                            //determin left or right
                            if (rollOrientation == 1) {
                                orientation = 3;
                                grid[riverLayerPosX][riverLayerPosY][1].setTileInformation("river_left");
                            } else if (rollOrientation == 2) {
                                orientation = 4;
                                grid[riverLayerPosX][riverLayerPosY][1].setTileInformation("river-right");
                            }
                        } else if (direction == 3 || direction == 4) {
                            rollOrientation = diceRoll.roll(2);
                            //determin up or down
                            if (rollOrientation == 1) {
                                orientation = 1;
                                grid[riverLayerPosX][riverLayerPosY][1].setTileInformation("river _top");
                            } else if (rollOrientation == 2) {
                                orientation = 2;
                                grid[riverLayerPosX][riverLayerPosY][1].setTileInformation("river-bottom");
                            }
                        }

                        directionOld = direction;
                    } else {
                        //TODO rest of placment

                        //place next river tile on the secound layer
                        for (int ii = riverSetNum; ii < 0; ii++) {
                            newCo = riverPlacer(riverLayerPosX, riverLayerPosY);

                            //TODO what is the new direction from newCo
                            if (riverLayerPosX != newCo[0]) {
                                BigDecimal num1 = new BigDecimal(riverLayerPosX);
                                BigDecimal num2 = new BigDecimal(newCo[0]);
                                int result = num1.compareTo(num2);
                                if (result < 0) {
                                    direction = 3;
                                } else if (result > 0) {
                                    direction = 4;
                                }
                            } else if (riverLayerPosY != newCo[1]) {
                                BigDecimal num1 = new BigDecimal(riverLayerPosY);
                                BigDecimal num2 = new BigDecimal(newCo[1]);
                                int result = num1.compareTo(num2);
                                if (result < 0) {
                                    direction = 2;
                                } else if (result > 0) {
                                    direction = 1;
                                }
                            }

                            //TODO determin orientation from old and new direction
                            if (directionOld == 1) {
                                if (direction == 1) {
                                    directionOld = 1;
                                }
                                if (direction == 2) {
                                    directionOld = 1;
                                }
                                if (direction == 3) {
                                    orientation = 2;
                                    directionOld = 3;
                                }
                                if (direction == 4) {
                                    orientation = 2;
                                    directionOld = 4;
                                }
                                break;
                            } else if (directionOld == 2) {
                                if (direction == 1) {
                                    directionOld = 2;
                                }
                                if (direction == 2) {
                                    directionOld = 2;
                                }
                                if (direction == 3) {
                                    orientation = 1;
                                    directionOld = 3;
                                }
                                if (direction == 4) {
                                    orientation = 1;
                                    directionOld = 4;
                                }
                                break;
                            } else if (directionOld == 3) {
                                if (direction == 1) {
                                    orientation = 4;
                                    directionOld = 1;
                                }
                                if (direction == 2) {
                                    orientation = 4;
                                    directionOld = 2;
                                }
                                if (direction == 3) {
                                    directionOld = 3;
                                }
                                if (direction == 4) {
                                    directionOld = 3;
                                }
                                break;
                            } else if (directionOld == 4) {
                                if (direction == 1) {
                                    orientation = 3;
                                    directionOld = 1;
                                }
                                if (direction == 2) {
                                    orientation = 3;
                                    directionOld = 2;
                                }
                                if (direction == 3) {
                                    directionOld = 4;
                                }
                                if (direction == 4) {
                                    directionOld = 4;
                                }
                                break;
                            }

                            //TODO orientation oinsert and check if on grid
                            if (riverLayerPosX < (x - 1) && riverLayerPosY < (y - 1)) {
                                if (orientation == 1) {
                                    grid[riverLayerPosX][riverLayerPosY][1].setTileInformation("river_top");
                                } else if (orientation == 2) {
                                    grid[riverLayerPosX][riverLayerPosY][1].setTileInformation("river_bottom");
                                } else if (orientation == 3) {
                                    grid[riverLayerPosX][riverLayerPosY][1].setTileInformation("river_left");
                                } else if (orientation == 4) {
                                    grid[riverLayerPosX][riverLayerPosY][1].setTileInformation("river_right");
                                }
                            }
                        }
                    }
                }
            }

            //TODO: Neue Ebene erzeugen
            //TODO: River Logic
            int[] newCoordinates = new int[(int) tileSet[2] * 2];

            //at almost end check what is left, compare tileSet[2] "amount" with rest of maxTiles
            //----------------------------------------------- dose not enter ??? ----------------------------------------------------------------
            if ((int) tileSet[2] > maxTiles) {
                System.out.println("MaxTiles: " + maxTiles);
                System.out.println("tiles to place: " + (int) tileSet[2]);
                System.out.println("tile type: " + (String) tileSet[1]);
                int counter = 0;

                //set coordinates 0,0
                xPos = 0;
                yPos = 0;

                //run through all cells in grid
                while (yPos < y) {
                    //System.out.println("xPos:" + xPos + "yPos:" + yPos);
                    while (xPos < x) {
                        //System.out.println("xPos:" + xPos + "yPos:" + yPos);
                        //if empty, insert tile type
                        if (grid[xPos][yPos][0] == null && !tileSet[1].equals("River")) {
                            grid[xPos][yPos][0] = new Cell();
                            grid[xPos][yPos][0].setTileInformation((String) tileSet[1]);
                            counter++;
                        }
                        if (xPos <= x) {
                            xPos++;
                        }
                    }
                    //reset the x position
                    xPos = 0;
                    if (yPos <= y) {
                        yPos++;
                    }
                }

                //System.out.println("counter: " + counter);
                System.out.println("Tada");
                return grid;
            }

            runningBonus = (int) tileSet[0]; //get new running Boni

            int tilesToPlaceNum = (int) tileSet[2];
            int upCounter = 0;

            //while not empty, choose a random position
            while (grid[xPos][yPos][0] != null) {
                //System.out.println("no empty cell, reroll.");
                xPos = diceRoll.roll(x - 1);
                yPos = diceRoll.roll(y - 1);
            }

            //System.out.println("current Co:" + xPos + ", " + yPos);
            //get spiral coordinates
            newCoordinates = goAround(x, y, xPos, yPos, (tilesToPlaceNum - upCounter));

            // Otherwise, choose a position around the last placed tile 
            if (!tileSet[1].equals("River")) {
                grid[xPos][yPos][0] = new Cell();
                grid[xPos][yPos][0].setTileInformation((String) tileSet[1]); //insert tile type into cell
                upCounter++;
            } else if (tileSet[1].equals("River")) {
                upCounter = tilesToPlaceNum;
            }

            int newXPos = 0;
            int newYPos = 0;
            int nextCoPosition = 0;
            System.out.println("tilesToPlaceNum: " + tilesToPlaceNum);

            while (upCounter < tilesToPlaceNum && nextCoPosition < newCoordinates.length / 2) {
                //System.out.println("uPCounter: " + upCounter);
                //System.out.println("tilesToPlaceNum: " + tilesToPlaceNum);
                //System.out.println("readout next coordinates");
                //save new positions
                //System.out.println("nextCoPosition: " + nextCoPosition);
                newXPos = (int) newCoordinates[nextCoPosition];
                newYPos = (int) newCoordinates[nextCoPosition + 1];

                //System.out.println("newXPos: " + newXPos);
                //System.out.println("newYPos: " + newYPos);
                //check if is in grid bound
                if (newXPos > 0 && newYPos > 0 && newXPos < x && newYPos < y) {
                    //adapt to new position
                    xPos = newXPos;
                    yPos = newYPos;

                    //System.out.println("XPos: " + xPos);
                    //System.out.println("YPos: " + yPos);
                    //if cell null
                    if (grid[xPos][yPos][0] == null && !tileSet[1].equals("River")) {
                        grid[xPos][yPos][0] = new Cell();
                        grid[xPos][yPos][0].setTileInformation((String) tileSet[1]); //insert tile type into cell
                        upCounter++;
                    }
                }

                //go to next coordinates position in newCoordinets
                nextCoPosition += 2;
            }

            //reduce maxTile of amount in tileSet[2]
            maxTiles = maxTiles - upCounter;
            //System.out.println("MaxTiles: " + maxTiles);
        }
        //return filled grid
        System.out.println("Tada");
        return grid;
    }

    public int[] goAround(int gridXMax, int gridYMax, int startX, int startY, int tileNum) {
        int[] result = new int[tileNum * 2];
        int x = startX;
        int y = startY;
        int step = 0;
        int[] co = new int[2];

        //System.out.println("Start step: " + step);
        // Store initial position
        result[0] = x;
        //System.out.println("First X result: " + result[0]);
        result[++step] = y;
        //System.out.println("First Y result: " + result[1]);

        //System.out.println("First step: " + step);
        //System.out.println("how many tiles?: " + tileNum);
        for (int i = 2; i < result.length; i = i + step) {
            //System.out.println("next step");
            for (int layer = 0; layer < Math.min(gridXMax, gridYMax); layer += 2) {
                //System.out.println("generate spiral");
                co = moveLeft(x, y);
                if (step < result.length - 1) {
                    //System.out.println("first x in : " + x);
                    result[++step] = co[0];
                    x = co[0];
                    //System.out.println("x: " + x);
                    //System.out.println("result: " + result[step]);
                    if (step == result.length - 1) {
                        return result;
                    }
                }
                if (step < result.length - 1) {
                    result[++step] = co[1];
                    y = co[1];
                    //System.out.println("result: " + result[step]);
                    if (step == result.length - 1) {
                        return result;
                    }
                }

                for (int ii = layer; ii >= 0; ii -= 2) {
                    //System.out.println("move up");
                    co = moveUp(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                        x = co[0];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                        y = co[1];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    if (ii >= 2) {
                        //System.out.println("move up");
                        co = moveUp(x, y);
                        if (step < result.length - 1) {
                            result[++step] = co[0];
                            x = co[0];
                            //System.out.println("result: " + result[step]);
                            if (step == result.length - 1) {
                                return result;
                            }
                        }
                        if (step < result.length - 1) {
                            result[++step] = co[1];
                            y = co[1];
                            //System.out.println("result: " + result[step]);
                            if (step == result.length - 1) {
                                return result;
                            }
                        }
                    }
                }
                for (int ii = layer; ii >= 0; ii -= 2) {
                    //System.out.println("move right");
                    co = moveRight(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                        x = co[0];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                        y = co[1];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    //System.out.println("move right");
                    co = moveRight(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                        x = co[0];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                        y = co[1];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                }
                for (int ii = layer; ii >= 0; ii -= 2) {
                    //System.out.println("move down");
                    co = moveDown(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                        x = co[0];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                        y = co[1];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    //System.out.println("move down");
                    co = moveDown(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                        x = co[0];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                        y = co[1];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                }
                for (int ii = layer; ii >= 0; ii -= 2) {
                    //System.out.println("move left");
                    co = moveLeft(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                        x = co[0];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                        y = co[1];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    //System.out.println("move left");
                    co = moveLeft(x, y);
                    if (step < result.length - 1) {
                        result[++step] = co[0];
                        x = co[0];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                    if (step < result.length - 1) {
                        result[++step] = co[1];
                        y = co[1];
                        //System.out.println("result: " + result[step]);
                        if (step == result.length - 1) {
                            return result;
                        }
                    }
                }
            }
        }

        return result;
    }

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

    //TODO: riverPlacer() Methode
    public int[] riverPlacer(int x, int y) {
        int direction = diceRoll.roll(4);
        int[] riverCo = new int[2];
        switch (direction) {
            case 1:
                riverCo = moveLeft(x, y);
            case 2:
                riverCo = moveRight(x, y);
            case 3:
                riverCo = moveUp(x, y);
            case 4:
                riverCo = moveDown(x, y);
        }
        return riverCo;
    }
}
