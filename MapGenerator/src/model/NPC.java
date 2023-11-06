/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author noormo
 */
public class NPC {
    private int ID;
    private String realm;
    private String name;
    private int age;
    private String race;
    private String subType;
    private String career;
    private String stageOfCareer;
    private String goal;
    private int mobNumber;
    private String mobType;
    private String title;
    private int xPos;
    private int yPos;
    private String personality;
    private String ruler;
    private int relationshipID; 
    
    
    

    public NPC() {}

    

    
   public NPC(String realm, String name, int age, String race, String subType, 
               String career, String stageOfCareer, String goal, int mobNumber, 
               String mobType, String title, int xPos, int yPos, String personality, 
               String ruler, int relationshipID) {
        this.realm = realm;
        this.name = name;
        this.age = age;
        this.race = race;
        this.subType = subType;
        this.career = career;
        this.stageOfCareer = stageOfCareer;
        this.goal = goal;
        this.mobNumber = mobNumber;
        this.mobType = mobType;
        this.title = title;
        this.xPos = xPos;
        this.yPos = yPos;
        this.personality = personality;
        this.ruler = ruler;
        this.relationshipID = relationshipID;
   }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getStageOfCareer() {
        return stageOfCareer;
    }

    public void setStageOfCareer(String stageOfCareer) {
        this.stageOfCareer = stageOfCareer;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(int mobNumber) {
        this.mobNumber = mobNumber;
    }

    public String getMobType() {
        return mobType;
    }

    public void setMobType(String mobType) {
        this.mobType = mobType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getRuler() {
        return ruler;
    }

    public void setRuler(String ruler) {
        this.ruler = ruler;
    }

    public int getRelationshipID() {
        return relationshipID;
    }

    public void setRelationshipID(int relationshipID) {
        this.relationshipID = relationshipID;
    }

    @Override
    public String toString() {
        return "NPC{" + "ID=" + ID + ", realm=" + realm + ", name=" + name + ", age=" + age + ", race=" + race + ", subType=" + subType + ", career=" + career + ", stageOfCareer=" + stageOfCareer + ", goal=" + goal + ", mobNumber=" + mobNumber + ", mobType=" + mobType + ", title=" + title + ", xPos=" + xPos + ", yPos=" + yPos + ", personality=" + personality + ", ruler=" + ruler + ", relationshipID=" + relationshipID + '}';
    }
    
    
   
}
    

