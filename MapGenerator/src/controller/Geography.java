package controller;

//@author jason

public class Geography {     
    public Object[] geographyGen(int runningBonus){
        DiceRoll diceRoll = new DiceRoll();
        
        int roll = diceRoll.roll(100);
        int num = roll + runningBonus;
            
        //System.out.println("Rolled: " + roll);
        //System.out.println("Bonus: " + runningBonus);
        //System.out.println("Number: " + num);
            
        //check and balance of running bonus
        if(num >= 101){
            runningBonus = 0;
        } else {
            runningBonus +=10;
        }
        
        
        return tableGeography(num, runningBonus);
    }
    
    public Object[] tableGeography(int num, int runningBonus){
        Object[] tileInfo = new Object[4];
        DiceRoll diceRoll = new DiceRoll();
        String tileGeoType = "Blank";
        int roll = 0;
        int maxRoll = 100;
        
        switch (num) {
            case 1, 11, 21, 31, 41, 51, 61 -> {tileGeoType = "Barren_Plains"; roll = diceRoll.roll(maxRoll);}
            case 2, 12, 22, 32, 42, 52, 62, 72 -> {tileGeoType = "Scrubland_Plains"; roll = diceRoll.roll(maxRoll);}
            case 3, 23, 43, 63 -> {tileGeoType = "Forested_Plains"; roll = diceRoll.roll(maxRoll);}
            case 4, 14, 24, 34, 44, 54, 64, 74 -> {tileGeoType = "Barren_Hills"; roll = diceRoll.roll(maxRoll);}
            case 5, 15, 25, 35, 45, 55, 65, 75 -> {tileGeoType = "Scrubland_Hills"; roll = diceRoll.roll(maxRoll);}
            case 6, 26, 46, 66 -> {tileGeoType = "Grassy_Hills"; roll = diceRoll.roll(maxRoll);}
            case 7, 37, 67 -> {tileGeoType = "Barren_Mountains"; roll = diceRoll.roll(maxRoll);}
            case 8, 38 -> {tileGeoType = "Barren_Swamps"; roll = diceRoll.roll(maxRoll);}
            case 9, 39, 69 -> {tileGeoType = "Barren_Badlands"; roll = diceRoll.roll(maxRoll);}
            case 13, 33, 53, 73 -> {tileGeoType = "Grassy_Plains"; roll = diceRoll.roll(maxRoll);}
            case 16, 36, 56, 76 -> {tileGeoType = "Forested_Hills"; roll = diceRoll.roll(maxRoll);}
            case 17, 47 -> {tileGeoType = "Scrubland_Mountains"; roll = diceRoll.roll(maxRoll);}
            case 18, 48 -> {tileGeoType = "Scrubland_Swamps"; roll = diceRoll.roll(maxRoll);}
            case 19, 49 -> {tileGeoType = "Scrubland_Badlands"; roll = diceRoll.roll(maxRoll);}
            case 27, 57 -> {tileGeoType = "Forested_Mountains"; roll = diceRoll.roll(maxRoll);}
            case 28, 58 -> {tileGeoType = "Grassy_Swamps"; roll = diceRoll.roll(maxRoll);}
            case 29, 59 -> {tileGeoType = "Grassy_Badlands"; roll = diceRoll.roll(maxRoll);}
            case 68 -> {tileGeoType = "Swamps"; roll = diceRoll.roll(maxRoll);}
            case 71 -> {tileGeoType = "Desert_Plains"; roll = diceRoll.roll(maxRoll);}
            case 77 -> {tileGeoType = "Grassy_Mountains"; roll = diceRoll.roll(maxRoll);}
            case 78 -> {tileGeoType = "Forested_Swamps"; roll = diceRoll.roll(maxRoll);}
            case 79 -> {tileGeoType = "Forested_Badlands"; roll = diceRoll.roll(maxRoll);}
            //large cases
            case 81 -> {tileGeoType = "Forested_Plains"; roll = diceRoll.roll(maxRoll*2);}
            case 82 -> {tileGeoType = "Scrubland_Plains"; roll = diceRoll.roll(maxRoll*2);}
            case 83 -> {tileGeoType = "Barren_Plains"; roll = diceRoll.roll(maxRoll*2);}
            case 84 -> {tileGeoType = "Grassy_Hills"; roll = diceRoll.roll(maxRoll*2);}
            case 85 -> {tileGeoType = "Scrubland_Hills"; roll = diceRoll.roll(maxRoll*2);}
            case 86 -> {tileGeoType = "Barren_Hills"; roll = diceRoll.roll(maxRoll*2);}
            case 87 -> {tileGeoType = "Scrubland_Mountains"; roll = diceRoll.roll(maxRoll*2);}
            case 88 -> {tileGeoType = "Scrubland_Swamps"; roll = diceRoll.roll(maxRoll*2);}
            case 89 -> {tileGeoType = "Scrubland_Badlands"; roll = diceRoll.roll(maxRoll*2);}
            case 91 -> {tileGeoType = "Grassy_Plains"; roll = diceRoll.roll(maxRoll*5);}
            case 92 -> {tileGeoType = "Scrubland_Plains"; roll = diceRoll.roll(maxRoll*5);}
            case 93 -> {tileGeoType = "Barren_Plains"; roll = diceRoll.roll(maxRoll*5);}
            case 94 -> {tileGeoType = "Forested_Hills"; roll = diceRoll.roll(maxRoll*5);}
            case 95 -> {tileGeoType = "Scrubland_Hills"; roll = diceRoll.roll(maxRoll*5);}
            case 96 -> {tileGeoType = "Barren_Hills"; roll = diceRoll.roll(maxRoll*5);}
            case 97 -> {tileGeoType = "Barren_Mountains"; roll = diceRoll.roll(maxRoll*5);}
            case 98 -> {tileGeoType = "Scrubland_Swamps"; roll = diceRoll.roll(maxRoll*5);}
            case 99 -> {tileGeoType = "Barren_Badlands"; roll = diceRoll.roll(maxRoll*5);}
            case 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 -> {tileGeoType = "River"; roll = diceRoll.roll(maxRoll/10);}
            default -> {tileGeoType = tableSpecialFeatures(); roll = 1;} // Default case
        }
        
        //System.out.println("Number of tiles: " + roll);
        
        tileInfo[0] = runningBonus;
        tileInfo[1] = tileGeoType;
        tileInfo[2] = roll;
        
        return tileInfo;
    }
    
    public String tableSpecialFeatures(){
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(10);
        String SpecialFeature = "";
        
        switch(roll){
            case 1 -> System.out.println("Caves");
            case 2 -> System.out.println("Cliff");
            case 3 -> System.out.println("Fertile Valley");
            case 4 -> System.out.println("Pool");
            case 5 -> System.out.println("Tor");
            case 6 -> System.out.println("Volcano");
            case 7 -> System.out.println("Waterfall");
            case 8 -> System.out.println("Whirlpool");
        }
        return SpecialFeature;
    }
}
