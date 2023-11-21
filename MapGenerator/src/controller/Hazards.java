package controller;

//@author jason

public class Hazards {
    private int number;
    private String name;

    // Default constructor for using in test main method
    public Hazards() {
        this.number = 0;
        this.name = "Please enter name...";
    }
     
    //for testing in console
    public static void main(String[] args) {
        Hazards hazard = new Hazards();
        Hazards[] hazards = hazard.hazardsGen();
    }
    
    // Parameterized constructor
    public Hazards(int number, String name) {
        this.number = number;
        this.name = name;
    } 
    
    
    public Hazards[] hazardsGen(){
        DiceRoll diceRoll = new DiceRoll();
        int lairs = diceRoll.roll(22);
        
        System.out.println("Number of Lairs: " + lairs);
        
        Hazards[] hazard = new Hazards[lairs];
        
        for(int i = 0; i < lairs; i++){
            int hazardNum = i+1;
            String hazardName = this.name;

            hazard[i] = new Hazards(hazardNum, hazardName).hazardSubType(hazardNum, hazardName);
        }
        
        return hazard;
    }
    
    public Hazards hazardSubType(int num, String name){
        Hazards hazardSubTyp = null;
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(10);

        //table 4-2: Type of Monsters
        switch (roll) {
            case 1, 2 -> hazardSubTyp = ChaosHazards.chaosHazardGen(num, name);
            case 3, 4, 5, 6, 7 -> hazardSubTyp = GreenskinHazards.greenskinHazardGen(num, name);
            case 8 -> hazardSubTyp = MonsterHazards.monsterHazardGen(num, name);
            case 9, 10 -> hazardSubTyp = UndeadHazards.undeadHazardGen(num, name);
        }
        
        return hazardSubTyp;
    }
}