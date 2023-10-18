package controller;
import controller.Geography;
import java.util.*;

public class TilePlace {
    private Geography geography = new Geography();

    public void placeTile() {
        // use tableGeography
        Object[] tile = geography.tableGeography(1);

        // save both num and type
        String type = (String) tile[0];
        int count = (int) tile[1];

        // show on console
        System.out.println("Tile type: " + type);
        System.out.println("Tile count: " + count);
    }
}