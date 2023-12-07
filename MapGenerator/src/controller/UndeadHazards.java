package controller;

//@author jason

public class UndeadHazards extends Hazards {
    private String hazardClass;
    private String undeadClass;
    private String undeadType;
    private int undeadNumber;

    public UndeadHazards(int number, String name, String hazardClass, String undeadClass, String undeadType, int undeadNumber) {
        super(number, name);
        this.hazardClass = hazardClass;
        this.undeadClass = undeadClass;
        this.undeadType = undeadType;
        this.undeadNumber = undeadNumber;
    }

    public static UndeadHazards undeadHazardGen(int number, String name) {
        String hazardClass = "Undead";
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(10);

        String undeadClass = "";
        String undeadType = "";
        int undeadNumber = 1;

        switch (roll) {
            case 1, 2 -> undeadClass = "Dead Lord";
            case 3, 4, 5 -> undeadClass = "Lone Menace";
            case 6, 7, 8 -> undeadClass = "Shambling Horde";
        }
        
        if(undeadClass.equals("Dead Lord")){
            roll = diceRoll.roll(10);
            switch(roll){
                case 1, 2, 3, 4 -> undeadType = "Mummy";
                case 5 -> undeadType = "Vampire (Blood Dragon)";
                case 6 -> undeadType = "Vampire  (von Carstein Exile)";
                case 7, 8 -> undeadType = "Vampire (Necrarch)";
                case 9, 10 -> undeadType = "Vampire (Strigoi)";
            }
        } else if(undeadClass.equals("Lone Menace")){
            roll = diceRoll.roll(10);
            switch(roll){
                case 1 -> undeadType = "Banshee";
                case 2, 3 -> undeadType = "Spectre";
                case 4, 5, 6, 7 -> undeadType = "Wight";
                case 8, 9, 10 -> undeadType = "Wraith";
            }
        } else if(undeadClass.equals("Shambling Horde")){
            roll = diceRoll.roll(10);
            RandomNum ranNum = new RandomNum();
            int num = 0;
            
            switch (roll) {
                case 1, 2:
                    undeadType = "Dire Wolves"; 
                    undeadNumber = ranNum.roll(2, 100);
                    break;
                case 3, 4, 5:
                    undeadType = "Skeletons";
                    undeadNumber = ranNum.roll(3, 120);
                    break;
                case 6, 7:
                    undeadType = "Vampire Bats"; 
                    undeadNumber = ranNum.roll(1, 75); 
                    break;
                case 8, 9, 10:
                    undeadType = "Zombies"; 
                    undeadNumber = ranNum.roll(4, 125);
                    break;
            }
        }

        System.out.print("Hazard Number: " + number + ", Name: " + name + ", Hazard Class: " + hazardClass + ", Undead Class: " + undeadClass + ", Undead Type: " + undeadType + ", Number of Undead: " + undeadNumber + "\n");
        return new UndeadHazards(number, name, hazardClass, undeadClass, undeadType, undeadNumber);
    }
}
