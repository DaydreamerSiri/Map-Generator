package controller;
import java.util.*;
import model.Cell;

public class TilePlace {
    private Geography geography = new Geography();
    private DiceRoll diceRoll = new DiceRoll(); 
    private Set<Position> placedPositions = new HashSet<>();
    private Set<Integer> blocked = new HashSet<>();
    private Position lastPlacedPosition = null;

    public Object[] placeTile() {
        return geography.geographyGen();
        //String type = (String) tile[0];
        //int count = (int) tile[1];
    }
    
    public void placeTiles(MapGrid map, int xLimit, int yLimit) {
        Random random = new Random();

        for (List<Cell> row : map.getMapData().getCellDataList()) {
            for (Cell cell : row) {
                if (!cell.isPlaced()) {
                    int attempts = 0;
                    while (attempts < 100) {
                        int x, y;
                        // If this is the first tile or a random condition is met, choose a random position
                        if (lastPlacedPosition == null || random.nextInt(10) == 0) {
                            x = diceRoll.roll(xLimit);
                            y = diceRoll.roll(yLimit);
                        } else { // Otherwise, choose a position around the last placed tile
                            int direction = getRandomDirection();
                            switch (direction) {
                                case 1: x = lastPlacedPosition.getX() - 1; y = lastPlacedPosition.getY(); break; // left
                                case 2: x = lastPlacedPosition.getX() - 1; y = lastPlacedPosition.getY() + 1; break; // left-up
                                case 3: x = lastPlacedPosition.getX(); y = lastPlacedPosition.getY() + 1; break; // up
                                case 4: x = lastPlacedPosition.getX() + 1; y = lastPlacedPosition.getY() + 1; break; // up-right
                                case 5: x = lastPlacedPosition.getX() + 1; y = lastPlacedPosition.getY(); break; // right
                                case 6: x = lastPlacedPosition.getX() + 1; y = lastPlacedPosition.getY() - 1; break; // Down-right
                                case 7: x = lastPlacedPosition.getX(); y = lastPlacedPosition.getY() - 1; break; // down
                                default: x = lastPlacedPosition.getX() - 1; y = lastPlacedPosition.getY() - 1; break; // down-left
                            }
                        }

                        if (isPositionFree(x, y)) {
                            placedPositions.add(new Position(x, y));
                            cell.setTileInformation(this.placeTile());
                            cell.isPlaced(true);
                            lastPlacedPosition = new Position(x, y);
                            break;
                        }

                        attempts++;
                    }
                }
            }
        }
    }

    private boolean isPositionFree(int x, int y) {
        return placedPositions.stream().noneMatch(position -> position.getX() == x && position.getY() == y);
    }

    private int getRandomDirection() {
        return diceRoll.roll(8); 
    }
}