/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mapgen;
import java.sql.Connection;
import view.*;
import javax.swing.JFrame;
import controller.Geography;
import controller.Datenbank;
import java.sql.SQLException;


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