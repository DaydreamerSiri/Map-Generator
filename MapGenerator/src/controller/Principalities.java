package controller;

import java.util.ArrayList;

//@author jason
public class Principalities {

    private String principalityName = "Please enter name...";
    private int numOfSquares = 0;
    private boolean hasTown = false;
    private int numOfVillages = 0;
    private String feature = "";

    //for testing in console
    /*public static void main(String[] args) {
        Principalities principality = new Principalities();
        Principalities[] principalities = principality.principalityGen(5);
    }*/

    public Principalities[] principalityGen(int numPrinces) {
        Principalities[] principality = new Principalities[numPrinces];
        DiceRoll diceRoll = new DiceRoll();

        ArrayList<Principalities> principalitiesList = new ArrayList<>();

        int roll = 0;

        for (int i = 0; i < numPrinces; i++) {
            principality[i] = new Principalities();
            roll = diceRoll.roll(8);
            principality[i].numOfVillages = roll;
            principality[i].numOfSquares = roll * 20;

            if (principality[i].numOfSquares >= 100) {
                principality[i].hasTown = true;
            }

            principality[i].feature = features();

            principalitiesList.add(principality[i]);
            
            System.out.println(principality[i]);
        }
        
        return principality;
    }
    
    public String toString() {
        return "Name: " + principalityName + ", Villages: " + numOfVillages + ", Squares: " + numOfSquares + ", Has Town: " + hasTown + ", Feature: " + feature;
    }

    public String features() {
        String feature = "";
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(5);

        //table 3-2: community Features
        switch (roll) {
            case 1 -> feature = "Economic Resource: " + economicResources();
            case 2 -> feature = "Stronghold";
            case 3 -> feature = "Chokepoint";
            case 4 -> feature = "Cultists";
            case 5 -> feature = "Special: " + spacials();
        }
                                
        return feature;
    }
    
    public String economicResources(){
        String ecoRes = "";
        
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(9);

        //table 3-3: Economic Resources
        switch (roll) {
            case 1, 2, 3, 4 -> ecoRes = resources();
            case 5, 6, 7 -> ecoRes = crafts();
            case 8 -> ecoRes = oddities();
            case 9 -> ecoRes = "Market";
        }
        
        return ecoRes;
    }
    
    public String resources(){
        String resource = "";
        
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(100);

        //table 3-4: resources
        if (roll >= 1 && roll <= 10) {
                resource = "Furs";
            } else if (roll >= 11 && roll <= 20) {
                resource = "Medicinal Plants";
            } else if (roll >= 21 && roll <= 30) {
                resource = "Mine, coal";
            } else if (roll >= 31 && roll <= 36) {
                resource = "Mine, copper";
            } else if (roll >= 37 && roll <= 46) {
                resource = "Mine, iron";
            } else if (roll >= 47 && roll <= 53) {
                resource = "Mine, lead";
            } else if (roll >= 54 && roll <= 55) {
                resource = "Mine, gemstones";
            } else if (roll >= 56 && roll <= 57) {
                resource = "Mine, gold";
            } else if (roll >= 58 && roll <= 61) {
                resource = "Mine, silver";
            } else if (roll >= 62 && roll <= 72) {
                resource = "Mine, tin";
            } else if (roll >= 73 && roll <= 84) {
                resource = "Quarry, building stone";
            } else if (roll >= 85 && roll <= 95) {
                resource = " Quarry, clay";
            } else if (roll >= 96 && roll <= 100) {
                resource = "Quarry, marble";
            }
        
        return "Resource: " + resource;
    }
    
    public String crafts(){
        String craft = "";
        
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(100);

        //table 3-5: crafts
        if (roll >= 1 && roll <= 5) {
                craft = "Armourer";
            } else if (roll >= 6 && roll <= 10) {
                craft = "Bowyer";
            } else if (roll >= 11 && roll <= 18) {
                craft = "Brewer";
            } else if (roll >= 19 && roll <= 22) {
                craft = "Candlemaker";
            } else if (roll >= 23 && roll <= 30) {
                craft = "Carpenter";
            } else if (roll >= 31 && roll <= 36) {
                craft = "Cooper";
            } else if (roll == 37) {
                craft = "Gem Cutter";
            } else if (roll >= 38 && roll <= 39) {
                craft = "Goldsmith";
            } else if (roll == 40) {
                craft = "Gunsmith";
            } else if (roll >= 41 && roll <= 48) {
                craft = "Potter";
            } else if (roll >= 49 && roll <= 55) {
                craft = "Shoemaker";
            } else if (roll >= 56 && roll <= 64) {
                craft = "Smith";
            } else if (roll >= 65 && roll <= 74) {
                craft = "Tailor";
            } else if (roll >= 75 && roll <= 84) {
                craft = "Tanner";
            } else if (roll >= 85 && roll <= 95) {
                craft = "Vintner";
            } else if (roll >= 96 && roll <= 100) {
                craft = "Weaponsmith";
            }
        
        return "Craft: " + craft;
    }
    
    public String oddities() {
        String oddity = "";
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(5);

        //table 3-6: Oddities
        switch (roll) {
            case 1: oddity = "An absolutely honest trader in goods of dubious origin. He does not ask where sellers got things, buys for half his selling price, and always assesses as fairly as he can. He is even reputed to have searched out one seller to give him extra money when something sold for a very high price.";
            case 2: oddity = "Big pile of excrement that the locals seem to worship as a God. If asked why, no one knows. “It’s just the way it’s always been, guv’nuh.”";
            case 3: oddity = "Competent doctor, willing to work for much less than most medical professionals.";
            case 4: oddity = " Entrance to a set of catacombs reputed to contain vast treasure. Most businesses cater to adventurers on their way in. Very few cater to people on their way out.";
            case 5: oddity = " Home of the most beautiful women in the Borderlands. Also home of some of the most bad-tempered men in the Borderlands.";
            case 6: oddity = "Location of a weapon shop run by the local prince. The prices are 50% higher than normal, but the prince takes that 50%, so if he catches people with other weapons, he breaks their legs.";
            case 7: oddity = " Only reliable well for miles around.";
            case 8: oddity = "Pies made from a closely guarded recipe that taste absolutely wonderful. They travel very poorly, though, and are best eaten fresh from the oven.";
            case 9: oddity = "Site of an ancient battle between two wealthy armies, and gold coins still work their way to the surface from time to time.";
            case 10: oddity = " Tavern famous for having beds with mattresses in the guest rooms.";
        }
                                
        return "Oddity: " + oddity;
    }

    public String spacials(){
        String special = "";
        
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(8);

        //table 3-7: Special Features
        switch (roll) {
            case 1 -> special = "Cultists";
            case 2 -> special = "Hospital";
            case 3 -> special = "Magical Effect";
            case 4 -> special = "Monastery";
            case 5 -> special = "Monster";
            case 6 -> special = "Templars";
            case 7 -> special = "Witch";
            case 8 -> special = "Wizard";
        }
        
        return "Speacial Freature" + special;
    }
}
