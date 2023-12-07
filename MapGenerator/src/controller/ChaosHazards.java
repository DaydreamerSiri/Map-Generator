package controller;

//@author jason

public class ChaosHazards extends Hazards {
    private String hazardClass;
    private String leader;
    private int numFollowers;
    private String typeOfFollowers;

    public ChaosHazards(int number, String name, String hazardClass, String leader, int numFollowers, String typeOfFollowers) {
        super(number, name);
        this.hazardClass = hazardClass;
        this.leader = leader;
        this.numFollowers = numFollowers;
        this.typeOfFollowers = typeOfFollowers;
    }

    public static ChaosHazards chaosHazardGen(int number, String name) {
        DiceRoll diceroll = new DiceRoll();
        String hazardClass = "Chaos";
        int roll = diceroll.roll(10);
        int numFollowers = 0;
        int followerTypeBoni = 0;
        int leaderBoni = 0;
        
        
        switch(roll){
            case 1 -> {numFollowers = 1;}
            case 2 -> {numFollowers = 5; leaderBoni = 5;}
            case 3 -> {numFollowers = 10; leaderBoni = 10; followerTypeBoni = 1;}
            case 4 -> {numFollowers = 20; leaderBoni = 15; followerTypeBoni = 2;}
            case 5 -> {numFollowers = 30; leaderBoni = 20; followerTypeBoni = 3;}
            case 6 -> {numFollowers = 50; leaderBoni = 20; followerTypeBoni = 4;}
            case 7 -> {numFollowers = 75; leaderBoni = 20; followerTypeBoni = 4;}
            case 8 -> {numFollowers = 100; leaderBoni = 20; followerTypeBoni = 4;}
            case 9 -> {numFollowers = 150; leaderBoni = 20; followerTypeBoni = 4;}
            case 10 -> {numFollowers = 200; leaderBoni = 20; followerTypeBoni = 4;}
        }
        
        String leader = chaosCreature(leaderBoni);       
        String typeOfFollowers = chaosFollowers(followerTypeBoni, leader);

        System.out.print("Hazard Number: " + number + ", Name: " + name + ", Class: " + hazardClass + ", Leader: " + leader + ", Number of Followers: " + numFollowers + ", Type of Followers: " + typeOfFollowers + "\n");
        
        return new ChaosHazards(number, name, hazardClass, leader, numFollowers, typeOfFollowers);
    }
    
    public static String chaosCreature(int leaderBoni){
        String leader = "";
        DiceRoll diceroll = new DiceRoll();
        int roll = diceroll.roll(100) + leaderBoni;
        
        //table 3-4: resources
        if (roll >= 1 && roll <= 5) {
                leader = "Daemon";
            } else if (roll >= 6 && roll <= 10) {
                leader = "Chaos Warrior";
            } else if (roll == 11) {
                leader = "Minotaur";
            } else if (roll >= 12 && roll <= 35) {
                leader = "Mutant";
            } else if (roll >= 36 && roll <= 65) {
                leader = "Gor (Beastman)";
            } else if (roll >= 66 && roll <= 100) {
                leader = "Bestigor (Beastman)";
            } else if (roll >= 101 && roll <= 105) {
                leader = "Chaos Warrior";
            } else if (roll >= 106 && roll <= 110) {
                leader = "Minotaur";
            } else if (roll >= 111) {
                leader = "Daemon";
            }
        
        return leader;
    }
    
    public static String chaosFollowers(int followerTypeBoni, String leader){
        String followerType = "";
        
        DiceRoll diceroll = new DiceRoll();
        int roll = diceroll.roll(5) + followerTypeBoni;
        
        if(leader.contains("Beastman")){
            switch(roll){
                case 1 -> followerType = "Beastmen";
                case 2 -> followerType = "Beastmen";
                case 3 -> followerType = "Beastmen and Mutants";
                case 4 -> followerType = "Beastmen";
                case 5 -> followerType = "Beastmen and Mutants";
                default -> followerType = "Beastmen and Mutants";
            }
        } else if (leader.equals("Deamon")){
            switch(roll){
                case 1 -> followerType = "Daemons";
                case 2 -> followerType = "Daemons";
                case 3 -> followerType = "Mutants";
                case 4 -> followerType = "Mutants";
                case 5 -> followerType = "Beastmen and Mutants";
                default -> followerType = "Beastmen and Mutants";
            }
        } else if(leader.equals("Chaos Warrior")){
            switch(roll){
                case 1 -> followerType = "Chaos Warriors";
                case 2 -> followerType = "Chaos Warriors";
                case 3 -> followerType = "Chaos Warriors";
                case 4 -> followerType = "Beastmen";
                case 5 -> followerType = "Beastmen";
                default -> followerType = "Beastmen";
            }
        } else if(leader.equals("Minotaur")){
            switch(roll){
                case 1 -> followerType = "Minotaurs";
                case 2 -> followerType = "Minotaurs";
                case 3 -> followerType = "Beastmen";
                case 4 -> followerType = "Beastmen";
                case 5 -> followerType = "Beastmen";
                default -> followerType = "Beastmen";
            }
        } else if(leader.equals("Mutant")){
            switch(roll){
                case 1 -> followerType = "Mutants";
                case 2 -> followerType = "Mutants";
                case 3 -> followerType = "Mutants and Beastmen";
                case 4 -> followerType = "Mutants";
                case 5 -> followerType = "Mutants";
                default -> followerType = "Mutants";
            }
        }
        
        return followerType;
    }
}