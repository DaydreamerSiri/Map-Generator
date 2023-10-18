package controller;
import controller.Geography;
import java.util.*;

public class PlaceTile {
    private Geography geography = new Geography();
    private List<Object[]> tiles = new ArrayList<>();
    private List<Position> placedPositions = new ArrayList<>();
    private Set<Integer> blocked = new HashSet<>();

    public PlaceTile(int numTiles) {
        for (int i = 0; i < numTiles; i++) {
            tiles.add(geography.tableGeography());
        }
    }

    public void placeTiles() {
        Random random = new Random();

        // start at random position
        int x = random.nextInt(100) - 50; // random x from -49 to 50
        int y = random.nextInt(100) - 50; // random y from -49 to 50

        // if tiles left
        while (!tiles.isEmpty()) {
            // Würfeln Sie eine Zahl von 1-8
            int direction = getRandomDirection();

            // check if place is empty
            while (blocked.contains(direction)) {
                // if blocked roll again
                direction = getRandomDirection();
            }

            switch (direction) {
                case 1: x--; break; // Up
                case 2: x--; y++; break; // Up-right
                case 3: y++; break; // Right
                case 4: x++; y++; break; // Down-right
                case 5: x++; break; // Down
                case 6: x++; y--; break; // Down-left
                case 7: y--; break; // Left
                case 8: x--; y--; break; // Up-left
            }

            // check if new direction is blocked
            if (isPositionFree(x, y)) {
                // if not then place tile and reset block counter
                String tileType = (String) tiles.get(0)[0];
                int tileCount = (int) tiles.get(0)[1];
                placedPositions.add(new Position(x, y, tileType, tileCount));
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
        return new Random().nextInt(8) + 1;
    }

    public static void main(String[] args) {
        PlaceTile placeTile = new PlaceTile(10);
        placeTile.placeTiles();
    }
}

class Position {
    private int x;
    private int y;
    private String tileType;
    private int tileCount;

    public Position(int x, int y, String tileType, int tileCount) {
        this.x = x;
        this.y = y;
        this.tileType = tileType;
        this.tileCount = tileCount;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public String getTileType() { return tileType; }
    public int getTileCount() { return tileCount; }
}