/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.lang.management.PlatformLoggingMXBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.chrono.ThaiBuddhistEra;
import model.NPC;

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
    private void connect(){
        try{
            conn = DriverManager.getConnection(dbURL, "SA", "");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    

    /**
     * Die private Methode close schließt die Verbindung
     * zur Datenbank.
     * 
     * @throws SQLException 
     */
    private void close() throws SQLException {
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
     * 
     */
    public void insertTestData(){
        try {

            if (conn == null || conn.isClosed()) {
                connect();
            }

            Statement stmt = conn.createStatement();

            stmt.executeUpdate("DELETE FROM RELATIONSHIPS");
            stmt.executeUpdate("INSERT INTO RELATIONSHIPS (id, type, duration) VALUES (0, 'test_type1', 'test_duration1')");
            stmt.executeUpdate("INSERT INTO RELATIONSHIPS (id, type, duration) VALUES (1, 'test_type2', 'test_duration2')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertNPC(NPC npc){
        try {
            connect();
            String sql = "INSERT INTO NPC (realm, name, age, race, sub_type,"
                    + " career, stage_of_career, goal, mob_number, mobtype, title, "
                    + "x_Pos, y_Pos, personality, ruler) VALUES ('" 
                    + npc.getRealm() + "', '" + npc.getName() + "', " + npc.getAge() + ", '" + npc.getRace() + "', '" 
                    + npc.getSubType()+ "', '" + npc.getCareer() + "', '" + npc.getStageOfCareer() + "', '" 
                    + npc.getGoal()+ "', " + npc.getMobNumber() + ", '" + npc.getMobType() + "', '" + npc.getTitle() + "', " 
                    + npc.getxPos() + ", " + npc.getyPos() + ", '" + npc.getPersonality() + "', '" + npc.getRuler() + "')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rst = stmt.getGeneratedKeys();
            if(rst.next()){
                npc.setID(rst.getInt(1));
            }
            close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
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


        
    // 1. Einfügen
    public void insertPlace(Place place){
        try{
            connect();
            String sql = "INSERT INTO PLACE (id, riverId, npcId,"
                   + "xPos, yPos, type, tileId, symbol, specialFeatures,"
                    + "ageHistory, difficulty) VALUES ('" 
                    + place.getId() + "', '" + place.getRiverId() + "', '" + place.getNpcId() + "', " + place.getXPos() + ", '" + place.getYPos() + "', '" 
                    + place.getType()+ "', '" + place.getTileId() + "', '" + place.getSymbol() + "', '" 
                    + place.getSpecialFeatures()+ "', " + place.getAgeHistory() + ", '" + place.getDifficulty() + "')";
            Statment stmt = conn.createStatement();
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rst = stmt.getGeneratedKeys();
            if(rst.next()){
                place.setID(rst.getInt(1));
            }
            close();
    } catch (Exception ex) {
        System.out.println(ex);
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

        
        
           
        public void insertGroup(Group group){
            try {
                connect();
                String sql = "INSERT INTO GROUP (relationship_ID, relationship_type, relationship_duration) VALUES ('" 
                    + group.getRelationship_ID() + "', '" + group.getRelationshipType() + "', " + group.getRelationshipDuration() + "')";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet rst = stmt.getGeneratedKeys();
                if(rst.next()){
                    group.setID(rst.getInt(1));
                }
                close();
            } catch (Exception ex);
                System.out.println(ex);
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

        
        
            
        
    
    // 1. Einfügen
        public void insertRelationship(Relationship relationship){
            try {
                connect();
                String sql = "INSERT INTO RELATIONSHIPS (relationship_ID, relationship_type, relationship_duration) VALUES ('" 
                + relationship.getRelationshipId() + "', '" + relationship.getRelationshipType() + "', '" + relationship.getRelationshipDuration() + "')";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet rst = stmt.getGeneratedKeys();
                if(rst.next()){
                    relationship.setID(rst.getInt(1));
                }
                close();
            } catch (Exception ex) {
                System.out.println(ex);


}

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



