package controller;

//@author jason

public class MonsterHazards extends Hazards {
    private String hazardClass;
    private String monsterType;
    private String monsterAttitude;

    public MonsterHazards(int number, String name, String hazardClass, String monsterType, String monsterAttitude) {
        super(number, name);
        this.hazardClass = hazardClass;
        this.monsterType = monsterType;
        this.monsterAttitude = monsterAttitude;
    }

    public static MonsterHazards monsterHazardGen(int number, String name) {
        String monsterType = monsterType();
        String monsterAttitude = monsterAttitude(monsterType);
        String hazardClass = "Monster";

        System.out.print("Hazard Number: " + number + ", Name: " + name + ", Class: " + hazardClass + ", Type: " + monsterType + ", Attitude: " + monsterAttitude + "\n");
        
        return new MonsterHazards(number, name, hazardClass, monsterType, monsterAttitude);
    }
    
    public static String monsterType(){
        String monType = "";
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(10);
        
        switch(roll){
            case 1, 2 -> monType = "Giant";
            case 3 -> monType = "Great Eagle";
            case 4 -> monType = "Griffon";
            case 5, 6 -> monType = "Hippogrif";
            case 7 -> monType = "Hydra";
            case 8 -> monType = "Jabberwock";
            case 9 -> monType = "Manticore";
            case 10 -> monType = "Wyvern";
        }       
        
        return monType;
    }
    
    public static String monsterAttitude(String monsterType){
        String attitude = "";
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(10);
        
        if(monsterType.equals("Giant")){
            switch(roll){
                case 1 -> attitude = "Guardian";
                case 2, 3, 4, 5, 6, 7, 8 -> attitude = "Raider";
                case 9, 10 -> attitude = "Reclusive";
            }
        } else if (monsterType.equals("Great Eagle")){
            switch(roll){
                case 1, 2 -> attitude = "Guardian";
                case 3, 4 -> attitude = "Raider";
                case 5, 6, 7, 8, 9-> attitude = "Reclusive";
                case 10 -> attitude = "Reclusive";
            }
        } else if (monsterType.equals("Griffon")){
            switch(roll){
                case 1, 2, 3, 4, 5, 6, 7 -> attitude = "Raider";
                case 8, 9, 10 -> attitude = "Reclusive";
            }
        } else if (monsterType.equals("Hippogriff")){
            switch(roll){
                case 1, 2, 3, 4, 5, 6, 7 -> attitude = "Raider";
                case 8, 9, 10 -> attitude = "Reclusive";
            }
        } else if (monsterType.equals("Hydra")){
            switch(roll){
                case 1 -> attitude = "Guardian";
                case 2, 3, 4, 5, 6 -> attitude = "Raider";
                case 7, 8, 9-> attitude = "Reclusive";
                case 10 -> attitude = "Reclusive";
            }
        } else if (monsterType.equals("Jabberwock")){
            switch(roll){
                case 1, 2, 3, 4, 5, 6, 7 -> attitude = "Raider";
                case 8, 9, 10 -> attitude = "Reclusive";
            }
        } else if (monsterType.equals("Manticore")){
            switch(roll){
                case 1 -> attitude = "Guardian";
                case 2, 3, 4, 5, 6, 7 -> attitude = "Raider";
                case 8, 9-> attitude = "Reclusive";
                case 10 -> attitude = "Reclusive";
            }
        } else if (monsterType.equals("Wyvern")){
            switch(roll){
                case 1 -> attitude = "Guardian";
                case 2, 3, 4, 5, 6, 7 -> attitude = "Raider";
                case 8, 9-> attitude = "Reclusive";
                case 10 -> attitude = "Reclusive";
            }
        }
        
        return attitude;
    }
}
