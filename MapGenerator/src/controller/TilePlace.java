import java.util.*;

public class PlaceTile {
    private List<Tile> tiles; //Liste der Tiles die platziert werden sollen
    private List<Position> placedPositions = new ArrayList<>(); //Liste die die Positionen aller platzierten Tiles speichert
    private Set<Integer> blocked = new HashSet<>(); // Vorrübergehender Speicher für blockierte Richtungen (1 bis 8)

    public PlaceTile(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public void placeTiles() {
        // Start in Board Mitte ansonsten mathematisch Mittelpunkt bestimmten
        int x = 0;
        int y = 0;

        // Zufälliges Tile in Mitte setzen
        placedPositions.add(new Position(x, y));

        // Wenn noch Tiles übrig sind
        while (!tiles.isEmpty()) {
            // würfel Zahl von 1-8
            int direction = getRandomDirection();

            // Check ob platz blockiert
            while (blocked.contains(direction)) {
                // Wenn blockiert, neue Zahl würfeln
                direction = getRandomDirection();
            }

            // Update x und y auf gewählte Richtung
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

            // Check ob neue Richtung nicht belegt
            if (isPositionFree(x, y)) {
                // Wenn nicht, dann Tile setzen und block counter reset
                placedPositions.add(new Position(x, y));
                blocked.clear();
                tiles.remove(getRandomTile());
            } else {
                // wenn blockiert neu würfeln und Zahl blockieren
                blocked.add(direction);
            }
        }
    }

    private boolean isPositionFree(int x, int y) {
        return placedPositions.stream().noneMatch(position -> position.getX() == x && position.getY() == y); //Das hier hat ein Kumpel mir so gesagt, ich hatte noch nie mit stream zu tun.
    }

    private Tile getRandomTile() {
        return tiles.get(new Random().nextInt(tiles.size())); //wählt zufälliges Tile via würfeln aus
    }

    private int getRandomDirection() {
        return new Random().nextInt(8) + 1; // kein off by 1 for me bitch!
    }
}

class Position { //Klasse für Position auf dem Spielfeld. KI meinte ich soll die so unter meine andere Klasse tun da sonst kein Zugriff wäre.
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}