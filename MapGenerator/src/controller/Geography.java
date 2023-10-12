/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mapgen;

/**
 *
 * @author jason
 */
public class Geography {     
    public void geographyGen(int numTiles){
        DiceRoll diceRoll = new DiceRoll();
        int runningBonus = 0;
        boolean mapFull = false;
        
        System.out.println("Number of Tiles: " + numTiles);
        System.out.println("Map Full? " + mapFull);
        
        while(mapFull == false){
            int roll = diceRoll.roll(100);
            int num = roll + runningBonus;
            
            System.out.println("Rolled: " + roll);
            System.out.println("Bonus: " + runningBonus);
            System.out.println("Number: " + num);
            
            tableGeography(num);
            numTiles--;
            if(numTiles == 0){
                mapFull = true;
                System.out.println("Map is full!");
            }
            
            //check and balance of running bonus
            if(num >= 101){
                runningBonus = 0;
            } else {
                runningBonus +=10;
            }
        }
    }
    
    public void tableGeography(int num){
        switch (num) {
            case 1, 11, 21, 31, 41, 51, 61 -> System.out.println("Barren Plains");
            case 2, 12, 22, 32, 42, 52, 62, 72 -> System.out.println("Scrubland Plains");
            case 3, 23, 43, 63 -> System.out.println("Forested Plains");
            case 4, 14, 24, 34, 44, 54, 64, 74 -> System.out.println("Barren Hills");
            case 5, 15, 25, 35, 45, 55, 65, 75 -> System.out.println("Scrubland Hills");
            case 6, 26, 46, 66 -> System.out.println("Grassy Hills");
            case 7, 37, 67 -> System.out.println("Barren Mountains");
            case 8, 38 -> System.out.println("Barren Swamps");
            case 9, 39, 69 -> System.out.println("Barren Badlands");
            case 13, 33, 53, 73 -> System.out.println("Grassy Plains");
            case 16, 36, 56, 76 -> System.out.println("Forested Hills");
            case 17, 47 -> System.out.println("Scrubland Mountains");
            case 18, 48 -> System.out.println("Scrubland Swamps");
            case 19, 49 -> System.out.println("Scrubland Badlands");
            case 27, 57 -> System.out.println("Forested Mountains");
            case 28, 58 -> System.out.println("Grassy Swamps");
            case 29, 59 -> System.out.println("Grassy Bandlands");
            case 68 -> System.out.println("Swamp");
            case 71 -> System.out.println("Desert Plains");
            case 77 -> System.out.println("Grassy Mountains");
            case 78 -> System.out.println("Forested Swamps");
            case 79 -> System.out.println("Forested Badlands");
            //large cases
            case 81 -> System.out.println("Forested Plains, 1d10×20 squares");
            case 82 -> System.out.println("Scrubland Plains, 1d10×20 squares");
            case 83 -> System.out.println("Barren Plains, 1d10×20 squares");
            case 84 -> System.out.println("Grassy Hills, 1d10×20 squares");
            case 85 -> System.out.println("Scrubland Hills, 1d10×20 squares");
            case 86 -> System.out.println("Barren Hills, 1d10×20 squares");
            case 87 -> System.out.println("Scrubland Mountains, 1d10×20 squares");
            case 88 -> System.out.println("Scrubland Swamps, 1d10×20 squares");
            case 89 -> System.out.println("Scrubland Badlands, 1d10×20 squares");
            case 91 -> System.out.println("Grassy Plains, 1d10×50 squares");
            case 92 -> System.out.println("Scrubland Plains, 1d10×50 squares");
            case 93 -> System.out.println("Barren Plains, 1d10×50 squares");
            case 94 -> System.out.println("Forested Hills, 1d10×50 squares");
            case 95 -> System.out.println("Scrubland Hills, 1d10×50 squares");
            case 96 -> System.out.println("Barren Hills, 1d10×50 squares");
            case 97 -> System.out.println("Barren Mountains, 1d10×50 squares");
            case 98 -> System.out.println("Scrubland Swamps, 1d10×50 squares");
            case 99 -> System.out.println("Barren Badlands, 1d10×50 squares");
            case 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 -> System.out.println("River");
            default -> {System.out.println("Special Feture"); tableSpecialFeatures();} // Default case
        }
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
