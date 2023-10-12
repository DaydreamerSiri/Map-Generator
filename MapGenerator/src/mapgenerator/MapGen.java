/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mapgenerator;
import view.*;
import javax.swing.JFrame;
import controller.Geography;


/**
 *
 * @author 3menk
 */
public class MapGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //incert, get map presets for UI
        int numTiles = 10;
        
        JFrame start = new MainMenu();
        start.setVisible(true);
        
        
        //1 - Geography Generator
        Geography geography = new Geography();
        geography.geographyGen(numTiles);
    }
    
}
