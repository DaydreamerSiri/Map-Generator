/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author noormo
 */
public class Datenbank {

    
    private static final String treibername = "org.hsqldb.jdbc.JDBCDriver";
    private static final String dbURL = "jdbc:hsqldb:file:data/mapgen;ifexists=true";
    private Connection conn;
    private static Datenbank instance;
    


  /**
     * Der private Standradkonstruktor verhindert, dass
     * Objekte der Datenbankschnittstelle außerhalb  dieser
     * Klasse erzeugt werden können.
     * 
     * Ferner macht der Konstruktor den Datenbanktreiber
     * der Laufzeitumgebung bekannt.
     */
    public Datenbank() {
        try {
            Class.forName(treibername);
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
            System.exit(-1);
        }
    }
    
    /**
     * Die Datenbankschnittstelle implementiert das Singleton-
     * Pattern, sodass es nur ein einziges Objekt davon
     * geben kann. Auf dieses kann mittels der Klassenmethode
     * getInstance von überall aus der Anwendung zugegriffen
     * werden. Wurde das Objekt noch nicht erzeugt, übernimmt
     * dies ebenfalls die getInstance-Methode.
     * 
     * @return das Datenbankschnittstelle-Objekt
     */
    public static Datenbank getInstance() {
        if (instance == null) {
            instance = new Datenbank();
        }
        return instance;
    }

    /**
     * Die private Methode connect stellt die Verbindung mit
     * der Datenbank her.
     * 
     * @throws SQLException 
     */
    public void connect() throws SQLException {
        conn = DriverManager.getConnection(dbURL, "SA", "");
    }
    
    public void getDate() throws SQLException {
        try {
            ResultSet result = conn.createStatement().executeQuery("SELECT * FROM 'RELATIONSHIPS'");
             while(result.next()){
                System.out.println(result.getInt("id")+" | "+
                result.getString("type")+" | "+
                result.getString("duration"));
         }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * Die private Methode close schließt die Verbindung
     * zur Datenbank.
     * 
     * @throws SQLException 
     */
    public void close() throws SQLException {
        if (conn != null) {
            if (!conn.isClosed()) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("SHUTDOWN");
                conn.close();
            }
        }
    }

 
  
    
}
