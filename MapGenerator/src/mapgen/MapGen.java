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
import controller.TilePlace;


/**
 *
 * @author 3menk
 */
public class MapGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Datenbank db = new Datenbank();
        
        try {
            Connection conn = db.connect();
            System.out.println(conn.createStatement().execute("SELECT * FROM PUBLIC.RELATIONSHIPS"));
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        
        //incert, get map presets for UI
        int numTiles = 10;
        
        JFrame start = new MainMenu();
        start.setVisible(true);
        
        
        //1 - Geography Generator
        Geography geography = new Geography();
        geography.geographyGen(numTiles);
        
        TilePlace tileplace = new TilePlace();
        tileplace.placeTile();
    }
    
}
