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
            ResultSet result = conn.createStatement().executeQuery("SELECT * FROM RELATIONSHIPS");
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
     
    
    
    /**
     * Diese Methode fügt Testdaten in die Tabelle RELATIONSHIPS ein.
     * 
     * @throws SQLException 
     */
    public void insertTestData() throws SQLException {
        try {

            if (conn == null || conn.isClosed()) {
                connect();
            }

            Statement stmt = conn.createStatement();

            
            stmt.executeUpdate("INSERT INTO RELATIONSHIPS (type, duration) VALUES ('test_type1', 'test_duration1')");
            stmt.executeUpdate("INSERT INTO RELATIONSHIPS (type, duration) VALUES ('test_type2', 'test_duration2')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Für die Tabelle "NPC":
        public class NPCOperations {

    // 1. Einfügen 
        public void insertNPC(int id, String realm, String name, int age, String race, String subType, String career, String stageOfCareer, String goal, int mobHP, String mobType, String title, int xPos, int yPos, String personality, String ruler) throws SQLException {
        String sql = "INSERT INTO NPC (ID, realm, name, age, race, subType, career, stageOfCareer, goal, mobHP, mobType, title, xPos, yPos, personality, ruler) VALUES (" + id + ", '" + realm + "', '" + name + "', " + age + ", '" + race + "', '" + subType + "', '" + career + "', '" + stageOfCareer + "', '" + goal + "', " + mobHP + ", '" + mobType + "', '" + title + "', " + xPos + ", " + yPos + ", '" + personality + "', '" + ruler + "')";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    // 2. Abrufen 
    public ResultSet getNPC() throws SQLException {
        
        return conn.createStatement().executeQuery("SELECT * FROM NPC");
    }

    // 3. Aktualisieren 
    public void updateNPC(int ID, String realm, String name, int age, String race, String subType, String career, String stageOfCareer, String goal, int mobHP, String mobType, String title, int xPos, int yPos, String personality, String ruler) throws SQLException {
        
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
}
        
        public class PlaceOperations {
    // 1. Einfügen
    public void insertPlace(int id, int riverId, int npcId, int xPos, int yPos, String type, int tileId, String symbol, String specialFeatures, String ageHistory, String difficulty) throws SQLException {
        String sql = "INSERT INTO Place (ID, riverId, npcId, xPos, yPos, type, tileId, symbol, specialFeatures, ageHistory, difficulty) VALUES (" + id + ", " + riverId + ", " + npcId + ", " + xPos + ", " + yPos + ", '" + type + "', " + tileId + ", '" + symbol + "', '" + specialFeatures + "', '" + ageHistory + "', '" + difficulty + "')";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
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
        
        public class GroupOperations {
    // 1. Einfügen
    public void insertGroup(int relationshipId, String relationshipType, int relationshipDuration) throws SQLException {
        String sql = "INSERT INTO Groups (relationship_ID, relationship_type, relationship_duration) VALUES (" + relationshipId + ", '" + relationshipType + "', " + relationshipDuration + ")";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    // 2. Abfragen
    public ResultSet getGroup() throws SQLException {
        return conn.createStatement().executeQuery("SELECT * FROM Groups");
    }

    // 3. Aktualisieren
    public void updateGroup(int relationshipId, String relationshipType, int relationshipDuration) throws SQLException {
        String sql = "UPDATE Groups SET relationship_type = '" + relationshipType + "', relationship_duration = " + relationshipDuration + " WHERE relationship_ID = " + relationshipId;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    // 4. Löschen
    public void deleteGroup(int relationshipId) throws SQLException {
        String sql = "DELETE FROM Groups WHERE relationship_ID = " + relationshipId;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }
}
        
        public class RelationshipOperations {
    
    // 1. Einfügen
    public void insertRelationship(int relationshipId, String relationshipType, int relationshipDuration) throws SQLException {
        String sql = "INSERT INTO RELATIONSHIPS (relationship_ID, relationship_type, relationship_duration) VALUES (" + relationshipId + ", '" + relationshipType + "', " + relationshipDuration + ")";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    // 2. Abfragen
    public ResultSet getRelationship() throws SQLException {
        return conn.createStatement().executeQuery("SELECT * FROM RELATIONSHIPS");
    }

    // 3. Aktualisieren
    public void updateRelationship(int relationshipId, String relationshipType, int relationshipDuration) throws SQLException {
        String sql = "UPDATE RELATIONSHIPS SET relationship_type = '" + relationshipType + "', relationship_duration = " + relationshipDuration + " WHERE relationship_ID = " + relationshipId;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    // 4. Löschen
    public void deleteRelationship(int relationshipId) throws SQLException {
        String sql = "DELETE FROM RELATIONSHIPS WHERE relationship_ID = " + relationshipId;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }
}


}
