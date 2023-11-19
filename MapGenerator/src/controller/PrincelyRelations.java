package controller;

import java.util.ArrayList;

//@author jason
public class PrincelyRelations {

    //for testing in console
    public static void main(String[] args) {
        PrincelyRelations princelyRelations = new PrincelyRelations();
        Object[] prince = princelyRelations.relationsGen(5);
    }

    public Object[][] relationsGen(int numPrinces) {
        Object[][] relations = new Object[numPrinces + 1][numPrinces + 1];
        DiceRoll diceRoll = new DiceRoll();

        ArrayList<String> relationsList = new ArrayList<>();

        int roll = 0;

        for (int x = 0; x < numPrinces; x++) {

            for (int y = (x + 1); y < numPrinces; y++) {
                //new roll
                roll = diceRoll.roll(10);
                //table 2-12: Diplomatic Relations
                switch (roll) {
                    case 1 -> relationsList.add("Alliance - " + originAlliance());
                    case 2 -> relationsList.add("Bitterness - " + springsOfBitterness());
                    case 3 -> relationsList.add("Contempt - " + groundsOfContempt());
                    case 4 -> relationsList.add("Envy - " + seedsOfEnvy());
                    case 5 -> relationsList.add("Fear - " + sourcesOfFear());
                    case 6 -> relationsList.add("Hatred - " + reasonsForHatred());
                    case 7 -> relationsList.add("Respect - " + groundsForRespect());
                    case 8 -> relationsList.add("Rivalry");
                    case 9 -> relationsList.add("Vengeance - " + thingsToAvenge());
                    case 10 -> relationsList.add("War");
                }

                //new roll
                roll = diceRoll.roll(100);
                //table 2-13: Length of Relations
                if (roll >= 1 && roll <= 10) {
                    relationsList.add("6 months");
                } else if (roll >= 11 && roll <= 30) {
                    relationsList.add("1 year");
                } else if (roll >= 31 && roll <= 60) {
                    relationsList.add("2 years");
                } else if (roll >= 61 && roll <= 75) {
                    relationsList.add("5 years");
                } else if (roll >= 76 && roll <= 85) {
                    relationsList.add("10 years");
                } else if (roll >= 86 && roll <= 90) {
                    relationsList.add("15 years");
                } else if (roll >= 91 && roll <= 94) {
                    relationsList.add("20 years");
                } else if (roll >= 95 && roll <= 97) {
                    relationsList.add("25 years");
                } else if (roll == 98) {
                    relationsList.add("30 years");
                } else if (roll == 99) {
                    relationsList.add("40 years");
                } else if (roll == 100) {
                    relationsList.add("50 years");
                }               
                                
                relations[x][y] = relationsList;
                System.out.println("Type of Prince: " + relations[x][y]);
                relationsList = new ArrayList<>();
            }
        }

        
        return relations;
    }
    
    public String originAlliance(){
        DiceRoll diceRoll = new DiceRoll();
        String originAlliance = "";
        //new roll
        int roll = diceRoll.roll(10);
        //table 2-14: Origins of Alliance
        switch (roll) {
            case 1 -> originAlliance = "Common Enemy";
            case 2 -> originAlliance = "Diplomacy";
            case 3 -> originAlliance = "Enlightened Self-Interest";
            case 4 -> originAlliance = "Former Comrades";
            case 5 -> originAlliance = "Fought to Stalemate";
            case 6 -> originAlliance = "Lovers";
            case 7 -> originAlliance = "Met in Battle";
            case 8 -> originAlliance = "Prophecy";
            case 9 -> originAlliance = "Relatives";
            case 10 -> originAlliance = "Unexpected Aid";
        }
        
        return originAlliance;
    }
    
    public String springsOfBitterness(){
        DiceRoll diceRoll = new DiceRoll();
        String springOfBitterness = "";
        //new roll
        int roll = diceRoll.roll(10);
        //table 2-15: Springs Of Bitterness
        switch (roll) {
            case 1, 2 -> springOfBitterness = "Deal Turned Sour";
            case 3, 4 -> springOfBitterness = "Spurned Lover";
            case 5, 6 -> springOfBitterness = "Stolen Inheritance";
            case 7, 8 -> springOfBitterness = "Treachery";
            case 9, 10 -> springOfBitterness = "Disfavoured Son";
        }
        
        return springOfBitterness;
    }
    
    public String groundsOfContempt(){
        DiceRoll diceRoll = new DiceRoll();
        String groundOfContempt = "";
        //new roll
        int roll = diceRoll.roll(10);
        //table 2-16: Grounds Of Contempt
        switch (roll) {
            case 1, 2 -> groundOfContempt = "Decadence";
            case 3, 4 -> groundOfContempt = "Inexperience";
            case 5, 6 -> groundOfContempt = "Military Defeat";
            case 7, 8 -> groundOfContempt = "Virtue";
            case 9, 10 -> groundOfContempt = "Weakness";
        }
        
        return groundOfContempt;
    }
    
    public String seedsOfEnvy(){
        DiceRoll diceRoll = new DiceRoll();
        String seedOfEnvy = "";
        //new roll
        int roll = diceRoll.roll(10);
        //table 2-17: Seeds Of Envy
        switch (roll) {
            case 1, 2 -> seedOfEnvy = "Beautiful Consort";
            case 3, 4 -> seedOfEnvy = "Glorious Reputation";
            case 5, 6 -> seedOfEnvy = "Personal Power";
            case 7, 8 -> seedOfEnvy = "Strong Realm";
            case 9, 10 -> seedOfEnvy = "Vast Wealth";
        }
        
        return seedOfEnvy;
    }
    
    public String sourcesOfFear(){
        DiceRoll diceRoll = new DiceRoll();
        String sourceOfFear = "";
        //new roll
        int roll = diceRoll.roll(10);
        //table 2-18: Sources Of Fear
        switch (roll) {
            case 1, 2 -> sourceOfFear = "Aggression";
            case 3, 4 -> sourceOfFear = "Attrocity";
            case 5, 6 -> sourceOfFear = "Crushing Victory";
            case 7, 8 -> sourceOfFear = "Knowledge";
            case 9, 10 -> sourceOfFear = "Personal Power";
        }
        
        return sourceOfFear;
    }
    
    public String reasonsForHatred(){
        DiceRoll diceRoll = new DiceRoll();
        String reasonForHatred = "";
        //new roll
        int roll = diceRoll.roll(10);
        //table 2-19: Reasons For Hatred
        switch (roll) {
            case 1, 2 -> reasonForHatred = "Former Friends";
            case 3, 4 -> reasonForHatred = "Prejudice";
            case 5, 6 -> reasonForHatred = "Public Humiliation";
            case 7, 8 -> reasonForHatred = "Religion";
            case 9, 10 -> reasonForHatred = "Treachery";
        }
        
        return reasonForHatred;
    }
    
    public String groundsForRespect(){
        DiceRoll diceRoll = new DiceRoll();
        String groundForRespect = "";
        //new roll
        int roll = diceRoll.roll(10);
        //table 2-20: Grounds For Respect
        switch (roll) {
            case 1, 2 -> groundForRespect = "Cunning";
            case 3, 4 -> groundForRespect = "Lineage";
            case 5, 6 -> groundForRespect = "Power";
            case 7, 8 -> groundForRespect = "Survival";
            case 9, 10 -> groundForRespect = "Virtue";
        }
        
        return groundForRespect;
    }
    
    public String thingsToAvenge(){
        DiceRoll diceRoll = new DiceRoll();
        String thingToAvenge = "";
        //new roll
        int roll = diceRoll.roll(10);
        //table 2-21: Things To Avenge
        switch (roll) {
            case 1, 2 -> thingToAvenge = "Atrocity";
            case 3, 4 -> thingToAvenge = "Betrayal";
            case 5, 6 -> thingToAvenge = "Defeat";
            case 7, 8 -> thingToAvenge = "Humiliation";
            case 9, 10 -> thingToAvenge = "Insult";
        }
        
        return thingToAvenge;
    }
}
