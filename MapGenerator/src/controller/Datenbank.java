/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.lang.management.PlatformLoggingMXBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.chrono.ThaiBuddhistEra;
import model.NPC;
import java.util.List;
import java.util.ArrayList;
        

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
     *
     */
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(dbURL, "SA", "");
    }
    

    public void insertNPC(NPC npc) {
        String sql = "INSERT INTO NPC (realm, name, age, race, sub_type,"
               + " career, stage_of_career, goal, mob_number, mobType, title, "
               + "x_Pos, y_Pos, personality, ruler) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        pstmt.setString(1, npc.getRealm());
        pstmt.setString(2, npc.getName());
        pstmt.setInt(3, npc.getAge());
        pstmt.setString(4, npc.getRace());
        pstmt.setString(5, npc.getSubType());
        pstmt.setString(6, npc.getCareer());
        pstmt.setString(7, npc.getStageOfCareer());
        pstmt.setString(8, npc.getGoal());
        pstmt.setInt(9, npc.getMobNumber());
        pstmt.setString(10, npc.getMobType());
        pstmt.setString(11, npc.getTitle());
        pstmt.setInt(12, npc.getxPos());
        pstmt.setInt(13, npc.getyPos());
        pstmt.setString(14, npc.getPersonality());
        pstmt.setString(15, npc.getRuler());

        int affectedRows = pstmt.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating NPC failed, no rows affected.");
        }

        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                npc.setID(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating NPC failed, no ID obtained.");
            }
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}

        
        
            public List<NPC> getAllNPCs() {
        List<NPC> npcList = new ArrayList<>();
        String sql = "SELECT * FROM NPC";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            int i = 0;
            while (rs.next()) {
                
                NPC npc = new NPC();
                npc.setRealm(rs.getString("realm"));
                npc.setName(rs.getString("name"));
                npc.setAge(rs.getInt("age"));
                npc.setRace(rs.getString("race"));
                npc.setSubType(rs.getString("subType"));
                npc.setCareer(rs.getString("career"));
                npc.setStageOfCareer(rs.getString("stageOfCareer"));
                npc.setGoal(rs.getString("goal"));
                npc.setMobNumber(rs.getInt("mobNumber"));
                npc.setMobType(rs.getString("mobtype"));
                npc.setTitle(rs.getString("title"));
                npc.setxPos(rs.getInt("xPos"));
                npc.setyPos(rs.getInt("yPos"));
                npc.setPersonality(rs.getString("personalty"));
                npc.setRuler(rs.getString("ruler"));
                npcList.add(npc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return npcList;
    }

    
    // 2. Abrufen 
    public ResultSet getNPC() throws SQLException {
        
        return conn.createStatement().executeQuery("SELECT * FROM NPC");
    }

    // 3. Aktualisieren 
    public void updateNPC(int ID, String realm, String name, int age, String race, String subType, String career, String stageOfCareer, String goal, int MobNumber, String mobType, String title, int xPos, int yPos, String personality, String ruler) throws SQLException {
        
        String sql = "UPDATE NPC SET realm = '" + realm + "', name = '" + name + " WHERE ID = " + ID;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    // 4. Löschen 
    public void deleteNPC(int ID) throws SQLException {
        
        String sql = "DELETE FROM NPC WHERE ID = " + ID;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

////////////////////////////////////////////
        
    // 1. Einfügen
    public void insertPlace(int id, int riverId, int npcId, int xPos, int yPos, String type, int tileId, String symbol, String specialFeatures, String ageHistory, String difficulty) throws SQLException {
        PlaceOperations placeo = new PlaceOperations();
        try {
             String sql = placeo.insertPlace(id, riverId, npcId, xPos, yPos, type, tileId, symbol, specialFeatures, ageHistory, difficulty);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
      } catch (Exception ex) {
            System.out.println(ex);
        }
    }
        // Für die Tabelle "Place":
        static class PlaceOperations {
    // 1. Einfügen 
        public String insertPlace(int id, int riverId, int npcId, int xPos, int yPos, String type, int tileId, String symbol, String specialFeatures, String ageHistory, String difficulty) throws SQLException {
        String sql = "INSERT INTO Place (ID, riverId, npcId, xPos, yPos, type, tileId, symbol, specialFeatures, ageHistory, difficulty) VALUES (" + id + ", " + riverId + ", " + npcId + ", " + xPos + ", " + yPos + ", '" + type + "', " + tileId + ", '" + symbol + "', '" + specialFeatures + "', '" + ageHistory + "', '" + difficulty + "')";
        return sql;
    }
        }
    

    // 2. Abfragen
    public ResultSet getPlace() throws SQLException {
        return conn.createStatement().executeQuery("SELECT * FROM Place");
    }

    // 3. Aktualisieren
    public void updatePlace(int ID, String type, int tileId, String symbol, String specialFeatures, String ageHistory, String difficulty) throws SQLException {
        String sql = "UPDATE Place SET type = '" + type + "', tileId = " + tileId + ", symbol = '" + symbol + "', specialFeatures = '" + specialFeatures + "', ageHistory = '" + ageHistory + "', difficulty = '" + difficulty + "' WHERE ID = " + ID;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    // 4. Löschen
    public void deletePlace(int ID) throws SQLException {
        String sql = "DELETE FROM Place WHERE ID = " + ID;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

        
        
           

}



