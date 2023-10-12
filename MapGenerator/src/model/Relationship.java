/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author noormo
 */

public class Relationship {
    private int ID;
    private String type;
    private String duration;

    public Relationship() {}

    public Relationship(int ID, String type, String duration) {
        this.ID = ID;
        this.type = type;
        this.duration = duration;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Relationship [ID=" + ID + ", type=" + type + ", duration=" + duration + "]";
    }
}
    


