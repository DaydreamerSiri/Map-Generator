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
import model.Place;
import model.Relationship;
import model.Groups;
import java.util.List;
import java.util.ArrayList;
        

/**
 *
 * @author Noral Deen Dyab
 */
public class Datenbank {

    
    private static final String treibername = "org.hsqldb.jdbc.JDBCDriver";
    private static final String dbURL = "jdbc:hsqldb:file:data/mapgen;ifexists=true";
    private Connection conn;
    private static Datenbank instance;
    

    public Datenbank() {
        try {
            Class.forName(treibername);
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
            System.exit(-1);
        }
    }
    
    /**
     * 
     * @return das Datenbank-Objekt
     */
    public static Datenbank getInstance() {
        if (instance == null) {
            instance = new Datenbank();
        }
        return instance;
    }

    /**
     * Diese Methode stellt die Verbindung mit der Datenbank her.
     * @throws SQLException -
     */
    private Connection getConnection() throws SQLException {    
        return DriverManager.getConnection(dbURL, "SA", "");
    }
    
    
    // Für die Tabelle "NPC":
    
        // 1. Einfügen
    public void insertNPC(NPC npc) {
        String sql = "INSERT INTO NPC (realm, name, age, race, sub_type,"
               + " career, stage_of_career, goal, mob_number, mobType, title, "
               + "x_Pos, y_Pos, personality, ruler) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
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
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

        
            // 2. Abfragen
    public List<NPC> getAllNPCs() {
        List<NPC> npcList = new ArrayList<>();
        String sql = "SELECT * FROM NPC";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return npcList;
    }

    

    // 3. Aktualisieren 
    public void updateNPC (NPC npc) {
    String sql = "UPDATE NPC SET (realm = ?, name = ?, age = ?, race = ?, subType = ?, career = ?, stageOfCareer = ?, goal = ?, mobNumber = ?, mobType = ?, title = ?, xPos = ?, yPos = ?, personality = ?, ruler = ? WHERE ID = ?";
    try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, npc.getRealm());
        pstmt.setString(2, npc.getName());
        pstmt.setInt(3, npc.getAge());
        pstmt.setString(4, npc.getRace());
        pstmt.setString(5, npc.getSubType());
        pstmt.setString(6, npc.getCareer());
        pstmt.setString(7, npc.getStageOfCareer());
        pstmt.setString(8, npc.getGoal());
        pstmt.setInt( 9, npc.getMobNumber());
        pstmt.setString(10, npc.getMobType());
        pstmt.setString(11, npc.getTitle());
        pstmt.setInt(12, npc.getxPos());
        pstmt.setInt(13, npc.getyPos());
        pstmt.setString(14, npc.getPersonality());
        pstmt.setString(15, npc.getRuler());
        pstmt.setInt(16, npc.getID());
        pstmt.executeUpdate();
    } catch (SQLException e) {
            e.printStackTrace();
    }
}


    // 4. Löschen 
   public void deleteNPC(int npcID) {
    String sql = "DELETE FROM NPC WHERE ID = ?";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, npcID);
        pstmt.executeUpdate();
    } catch (SQLException e) {
            e.printStackTrace();
    }
}


    // Für die Tabelle "Place":
        
    // 1. Einfügen
    public void insertPlace(Place place) {
        String sql = "INSERT INTO Place ( int id, int riverId, int npcId, int xPos, int yPos, String type, int tileId, String symbol, String specialFeatures, String ageHistory, String difficulty) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, place.getID());
            pstmt.setInt(2, place.getRiverNumber());
            pstmt.setInt(3, place.getNpcID());
            pstmt.setInt(4, place.getXPos());
            pstmt.setInt(5, place.getYPos());
            pstmt.setString(6, place.getType());
            pstmt.setInt(7, place.getTileNumber());
            pstmt.setString(8, place.getSymbol());
            pstmt.setString( 9, place.getSpecialFeatures());
            pstmt.setString(10, place.getAgeHistory());
            pstmt.setString(11, place.getDifficulty());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
    

    // 2. Abfragen
    public List<Place> getAllPlaces() {
        List<Place> placeList = new ArrayList<>();
        String sql = "SELECT * FROM Place";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Place place = new Place();
                place.setID(rs.getInt("id"));
                place.setRiverNumber(rs.getInt("riverId"));
                place.setNpcID(rs.getInt("npcId"));
                place.setXPos(rs.getInt("xPos"));
                place.setYPos(rs.getInt("yPos"));
                place.setType(rs.getString("type"));
                place.setTileNumber(rs.getInt("tileId"));
                place.setSymbol(rs.getString("symbol"));
                place.setSpecialFeatures(rs.getNString("specialFeatures"));
                place.setAgeHistory(rs.getString("ageHistory"));
                place.setDifficulty(rs.getString("difficulty"));
                placeList.add(place);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeList;
    }

    // 3. Aktualisieren
    public void updatePlace(Place place) {
        String sql = "INSERT INTO Place ( int id, int riverId, int npcId, int xPos, int yPos, String type, int tileId, String symbol, String specialFeatures, String ageHistory, String difficulty) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, place.getID());
            pstmt.setInt(2, place.getRiverNumber());
            pstmt.setInt(3, place.getNpcID());
            pstmt.setInt(4, place.getXPos());
            pstmt.setInt(5, place.getYPos());
            pstmt.setString(6, place.getType());
            pstmt.setInt(7, place.getTileNumber());
            pstmt.setString(8, place.getSymbol());
            pstmt.setString( 9, place.getSpecialFeatures());
            pstmt.setString(10, place.getAgeHistory());
            pstmt.setString(11, place.getDifficulty());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 4. Löschen
    public void deletePlace(int placeId) {
        String sql = "DELETE FROM Place WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, placeId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Für die Tabelle "Relationship":

        // 1. Einfügen
    public void insertRelationship(Relationship relationship) {
        String sql = "INSERT INTO Relationships (ID, type, duration) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, relationship.getID());
            pstmt.setString(2, relationship.getType());
            pstmt.setString(3, relationship.getDuration());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        // 2. Aktualisieren
    public void updateRelationship(Relationship relationship) {
        String sql = "UPDATE Relationships SET type = ?, duration = ? WHERE ID = ?";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, relationship.getType());
            pstmt.setString(2, relationship.getDuration());
            pstmt.setInt(3, relationship.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
        // 3. Löschen
    public void deleteRelationship(int relationshipID) {
        String sql = "DELETE FROM Relationships WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, relationshipID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Für die Tabelle "Groups":

        // 1. Einfügen
    public void insertGroup(Groups group) {
        String sql = "INSERT INTO Groups (relationship_ID, relationship_type, relationship_duration) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, group.getRelationshipID());
            pstmt.setString(2, group.getRelationshipType());
            pstmt.setInt(3, group.getRelationshipDuration());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    

        // 2. Aktualisieren
    public void updateGroup(Groups group) {
        String sql = "UPDATE Groups SET relationship_type = ?, relationship_duration = ? WHERE relationship_ID = ?";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, group.getRelationshipType());
            pstmt.setInt(2, group.getRelationshipDuration());
            pstmt.setInt(3, group.getRelationshipID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        // 3. Löschen
    public void deleteGroup(int relationshipID) {
        String sql = "DELETE FROM Groups WHERE relationship_ID = ?";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, relationshipID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            }
    }

        
        
           

}



