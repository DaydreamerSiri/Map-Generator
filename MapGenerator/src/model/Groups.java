/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author noormo
 */
public class Groups {
    private int relationshipID;
    private String relationshipType;
    private int relationshipDuration;
    
    
    public Groups() {}

    public Groups(int relationshipID, String relationshipType, int relationshipDuration, int npcID) {
        this.relationshipID = relationshipID;
        this.relationshipType = relationshipType;
        this.relationshipDuration = relationshipDuration;
        
    }

    public int getRelationshipID() {
        return relationshipID;
    }

    public void setRelationshipID(int relationshipID) {
        this.relationshipID = relationshipID;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public int getRelationshipDuration() {
        return relationshipDuration;
    }

    public void setRelationshipDuration(int relationshipDuration) {
        this.relationshipDuration = relationshipDuration;
    }



    @Override
    public String toString() {
        return "Groups{" + "relationshipID=" + relationshipID + ", relationshipType=" + relationshipType + ", relationshipDuration=" + relationshipDuration + '}';
    }
    
    
    
}
