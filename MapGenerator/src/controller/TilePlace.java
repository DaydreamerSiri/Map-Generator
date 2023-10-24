package controller;
import controller.Geography;
import controller.DiceRoll;
import java.util.*;

/**
*
*@author Florian
*/

public class TilePlace {
    private Geography geography = new Geography();
    private DiceRoll diceRoll = new DiceRoll(); 

    public void placeTile() {
        // use tableGeography
        Object[] tile = geography.geographyGen();

        // save both num and type
        String type = (String) tile[0];
        int count = (int) tile[1];
/*
        // show on console
        System.out.println("Tile type: " + type);
        System.out.println("Tile count: " + count); */
    }
    
    public void placeTiles() {
        Random random = new Random();

        // start random on the board
        int x = random.nextInt(100) - 50; // Zufällige X-Koordinate zwischen -50 und 49
        int y = random.nextInt(100) - 50; // Zufällige Y-Koordinate zwischen -50 und 49

        // if tiles left
        while (!tiles.isEmpty()) {
            // roll 1 to 8
            int direction = getRandomDirection();

            // check if blocked
            while (blocked.contains(direction)) {
                // if blocked, new roll
                direction = getRandomDirection();
            }

            switch (direction) {
                case 1: x--; break; // left
                case 2: x--; y++; break; // left-up
                case 3: y++; break; // up
                case 4: x++; y++; break; // up-right
                case 5: x++; break; // right
                case 6: x++; y--; break; // Down-right
                case 7: y--; break; // down
                case 8: x--; y--; break; // down-left
            }

            // check if direction is blocked
            if (isPositionFree(x, y)) {
                // if not place tile and reset block counter
                placedPositions.add(new Position(x, y));
                blocked.clear();
                tiles.remove(0); // removes placed tile from list
            } else {
                // if blocked roll again and block num
                blocked.add(direction);
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