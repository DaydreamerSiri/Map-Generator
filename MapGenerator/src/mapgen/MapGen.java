package controller;
import view.*;
import model.*;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author Sehri Singh
 * @author Jason Aragorn Charles
 * @author Florian Herbst
 * @author Noral Deen Dyab
 */
public class MapGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //incert, get map presets for UI
        int numTiles = 10;
        JFrame start = new MainMenu(new Datenbank());
        start.setVisible(true);
        
        
        //1 - Geography Generator
        Geography geography = new Geography();
        geography.geographyGen(numTiles);
    }
}