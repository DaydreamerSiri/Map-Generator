package controller;
import controller.Geography;
import java.util.*;

public class TilePlace {
    private Geography geography = new Geography();

    public void placeTile() {
        // use tableGeography
        Object[] tile = geography.geographyGen();

        // save both num and type
        String type = (String) tile[0];
        int count = (int) tile[1];

        // show on console
        System.out.println("Tile type: " + type);
        System.out.println("Tile count: " + count);
    }
    public void placeTiles() {
        Random random = new Random();

        // start random on the board
        int x = random.nextInt(100) - 50; // Zufällige X-Koordinate zwischen -50 und 49
        int y = random.nextInt(100) - 50; // Zufällige Y-Koordinate zwischen -50 und 49

        // Wenn noch Tiles übrig sind
        while (!tiles.isEmpty()) {
            // Würfeln Sie eine Zahl von 1-8
            int direction = getRandomDirection();

            // Überprüfen Sie, ob der Platz blockiert ist
            while (blocked.contains(direction)) {
                // Wenn blockiert, neue Zahl würfeln
                direction = getRandomDirection();
            }

            // Aktualisieren Sie x und y in die gewählte Richtung
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

            // Überprüfen Sie, ob die neue Richtung nicht belegt ist
            if (isPositionFree(x, y)) {
                // Wenn nicht, dann Tile setzen und Block-Counter zurücksetzen
                placedPositions.add(new Position(x, y));
                blocked.clear();
                tiles.remove(0); // Entfernen Sie das platzierte Tile aus der Liste
            } else {
                // Wenn blockiert, neu würfeln und Zahl blockieren
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
}