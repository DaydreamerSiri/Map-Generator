/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jason
 */
public class Geography {     
    public Object[] geographyGen(){
        DiceRoll diceRoll = new DiceRoll();
        int runningBonus = 0;
        
        int roll = diceRoll.roll(100);
        int num = roll + runningBonus;
            
        System.out.println("Rolled: " + roll);
        System.out.println("Bonus: " + runningBonus);
        System.out.println("Number: " + num);
            
        //check and balance of running bonus
        if(num >= 101){
            runningBonus = 0;
        } else {
            runningBonus +=10;
        }
        
        
        return tableGeography(num);
    }
    
    public Object[] tableGeography(int num){
        Object[] typeAndNum = new Object[2];
        DiceRoll diceRoll = new DiceRoll();
        String tileGeoType = "Blank";
        int roll = 0;
        int maxRoll = 10;
        
        switch (num) {
            case 1, 11, 21, 31, 41, 51, 61 -> {System.out.println("Barren Plains"); tileGeoType = "Barren Plains"; roll = diceRoll.roll(maxRoll);}
            case 2, 12, 22, 32, 42, 52, 62, 72 -> {System.out.println("Scrubland Plains"); tileGeoType = "Scrubland Plains"; roll = diceRoll.roll(maxRoll);}
            case 3, 23, 43, 63 -> {System.out.println("Forested Plains"); tileGeoType = "Forested Plains"; roll = diceRoll.roll(maxRoll);}
            case 4, 14, 24, 34, 44, 54, 64, 74 -> {System.out.println("Barren Hills"); tileGeoType = "Barren Hills"; roll = diceRoll.roll(maxRoll);}
            case 5, 15, 25, 35, 45, 55, 65, 75 -> {System.out.println("Scrubland Hills"); tileGeoType = "Scrubland Hills"; roll = diceRoll.roll(maxRoll);}
            case 6, 26, 46, 66 -> {System.out.println("Grassy Hills"); tileGeoType = "Grassy Hills"; roll = diceRoll.roll(maxRoll);}
            case 7, 37, 67 -> {System.out.println("Barren Mountains"); tileGeoType = "Barren Mountains"; roll = diceRoll.roll(maxRoll);}
            case 8, 38 -> {System.out.println("Barren Swamps"); tileGeoType = "Barren Swamps"; roll = diceRoll.roll(maxRoll);}
            case 9, 39, 69 -> {System.out.println("Barren Badlands"); tileGeoType = "Barren Badlands"; roll = diceRoll.roll(maxRoll);}
            case 13, 33, 53, 73 -> {System.out.println("Grassy Plains"); tileGeoType = "Grassy Plains"; roll = diceRoll.roll(maxRoll);}
            case 16, 36, 56, 76 -> {System.out.println("Forested Hills"); tileGeoType = "Forested Hills"; roll = diceRoll.roll(maxRoll);}
            case 17, 47 -> {System.out.println("Scrubland Mountains"); tileGeoType = "Scrubland Mountains"; roll = diceRoll.roll(maxRoll);}
            case 18, 48 -> {System.out.println("Scrubland Swamps"); tileGeoType = "Scrubland Swamps"; roll = diceRoll.roll(maxRoll);}
            case 19, 49 -> {System.out.println("Scrubland Badlands"); tileGeoType = "Scrubland Badlands"; roll = diceRoll.roll(maxRoll);}
            case 27, 57 -> {System.out.println("Forested Mountains"); tileGeoType = "Forested Mountains"; roll = diceRoll.roll(maxRoll);}
            case 28, 58 -> {System.out.println("Grassy Swamps"); tileGeoType = "Grassy Swamps"; roll = diceRoll.roll(maxRoll);}
            case 29, 59 -> {System.out.println("Grassy Bandlands"); tileGeoType = "Grassy Bandlands"; roll = diceRoll.roll(maxRoll);}
            case 68 -> {System.out.println("Swamp"); tileGeoType = "Swamp"; roll = diceRoll.roll(maxRoll);}
            case 71 -> {System.out.println("Desert Plains"); tileGeoType = "Desert Plains"; roll = diceRoll.roll(maxRoll);}
            case 77 -> {System.out.println("Grassy Mountains"); tileGeoType = "Grassy Mountains"; roll = diceRoll.roll(maxRoll);}
            case 78 -> {System.out.println("Forested Swamps"); tileGeoType = "Forested Swamps"; roll = diceRoll.roll(maxRoll);}
            case 79 -> {System.out.println("Forested Badlands"); tileGeoType = "Forested Badlands"; roll = diceRoll.roll(maxRoll);}
            //large cases
            case 81 -> {System.out.println("Forested Plains"); tileGeoType = "Forested Plains"; roll = diceRoll.roll(maxRoll*2);}
            case 82 -> {System.out.println("Scrubland Plains"); tileGeoType = "Scrubland Plains"; roll = diceRoll.roll(maxRoll*2);}
            case 83 -> {System.out.println("Barren Plains"); tileGeoType = "Barren Plains"; roll = diceRoll.roll(maxRoll*2);}
            case 84 -> {System.out.println("Grassy Hills"); tileGeoType = "Grassy Hills"; roll = diceRoll.roll(maxRoll*2);}
            case 85 -> {System.out.println("Scrubland Hills"); tileGeoType = "Scrubland Hills"; roll = diceRoll.roll(maxRoll*2);}
            case 86 -> {System.out.println("Barren Hills"); tileGeoType = "Barren Hills"; roll = diceRoll.roll(maxRoll*2);}
            case 87 -> {System.out.println("Scrubland Mountains"); tileGeoType = "Scrubland Mountains"; roll = diceRoll.roll(maxRoll*2);}
            case 88 -> {System.out.println("Scrubland Swamps"); tileGeoType = "Scrubland Swamps"; roll = diceRoll.roll(maxRoll*2);}
            case 89 -> {System.out.println("Scrubland Badlands"); tileGeoType = "Scrubland Badlands"; roll = diceRoll.roll(maxRoll*2);}
            case 91 -> {System.out.println("Grassy Plains"); tileGeoType = "Grassy Plains"; roll = diceRoll.roll(maxRoll*5);}
            case 92 -> {System.out.println("Scrubland Plains"); tileGeoType = "Scrubland Plains"; roll = diceRoll.roll(maxRoll*5);}
            case 93 -> {System.out.println("Barren Plains"); tileGeoType = "Barren Plains"; roll = diceRoll.roll(maxRoll*5);}
            case 94 -> {System.out.println("Forested Hills"); tileGeoType = "Forested Hills"; roll = diceRoll.roll(maxRoll*5);}
            case 95 -> {System.out.println("Scrubland Hills"); tileGeoType = "Scrubland Hills"; roll = diceRoll.roll(maxRoll*5);}
            case 96 -> {System.out.println("Barren Hills"); tileGeoType = "Barren Hills"; roll = diceRoll.roll(maxRoll*5);}
            case 97 -> {System.out.println("Barren Mountains"); tileGeoType = "Barren Mountains"; roll = diceRoll.roll(maxRoll*5);}
            case 98 -> {System.out.println("Scrubland Swamps"); tileGeoType = "Scrubland Swamps"; roll = diceRoll.roll(maxRoll*5);}
            case 99 -> {System.out.println("Barren Badlands"); tileGeoType = "Barren Badlands"; roll = diceRoll.roll(maxRoll*5);}
            case 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 -> {System.out.println("River"); tileGeoType = "River"; diceRoll.roll(maxRoll);}
            default -> {System.out.println("Special Feture"); tableSpecialFeatures(); tileGeoType = "Special Feture"; roll = 1;} // Default case
        }
        
        typeAndNum[0] = tileGeoType;
        typeAndNum[1] = roll;
        
        return typeAndNum;
    }
    
    public void tableSpecialFeatures(){
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(10);
        
        switch(roll){
            case 1 -> System.out.println("Caves, d% squares");
            case 2 -> System.out.println("Cliff");
            case 3 -> System.out.println("Fertile Valley");
            case 4 -> System.out.println("Geyser");
            case 5 -> System.out.println("Isolated Mountain");
            case 6 -> System.out.println("Pool");
            case 7 -> System.out.println("Tor");
            case 8 -> System.out.println("Volcano");
            case 9 -> System.out.println("Waterfall");
            case 10 -> System.out.println("Whirlpool");
        }
    }
}
