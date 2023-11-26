package controller;

//@author jason

public class GreenskinHazards extends Hazards {
    private String hazardClass;
    private int numSnotlings;
    private int numGoblins;
    private int numTrolls;
    private int numCommonOrcs;
    private int numBlackOrcs;

    public GreenskinHazards(int number, String name, String hazardClass, int numSnotlings, int numGoblins, int numTrolls, int numCommonOrcs, int numBlackOrcs) {
        super(number, name);
        this.hazardClass = hazardClass;
        this.numSnotlings = numSnotlings;
        this.numGoblins = numGoblins;
        this.numTrolls = numTrolls;
        this.numCommonOrcs = numCommonOrcs;
        this.numBlackOrcs = numBlackOrcs;
    }

    public static GreenskinHazards greenskinHazardGen(int number, String name) {
        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll(10);
        String hazardClass = "Greenskin";
        int numSnotlings = 0;
        int numGoblins = 0;
        int numTrolls = 0;
        int numCommonOrcs = 0;
        int numBlackOrcs= 0;
        
        switch(roll){
            case 1, 2 -> {numSnotlings = 10; numGoblins = 5; numTrolls = 0; numCommonOrcs = 5; numBlackOrcs = 0;}
            case 3 -> {numSnotlings = 25; numGoblins = 10; numTrolls = 0; numCommonOrcs = 10; numBlackOrcs = 0;}
            case 4 -> {numSnotlings = 100; numGoblins = 25; numTrolls = 0; numCommonOrcs = 25; numBlackOrcs = 1;}
            case 5 -> {numSnotlings = 150; numGoblins = 50; numTrolls = 0; numCommonOrcs = 50; numBlackOrcs = 2;}
            case 6 -> {numSnotlings = 250; numGoblins = 100; numTrolls = 1; numCommonOrcs = 100; numBlackOrcs = 5;}
            case 7 -> {numSnotlings = 500; numGoblins = 250; numTrolls = 2; numCommonOrcs = 250; numBlackOrcs = 10;}
            case 8 -> {numSnotlings = 750; numGoblins = 500; numTrolls = 5; numCommonOrcs = 500; numBlackOrcs = 20;}
            case 9 -> {numSnotlings = 1000; numGoblins = 750; numTrolls = 10; numCommonOrcs = 750; numBlackOrcs = 30;}
            case 10 -> {numSnotlings = 1000; numGoblins = 1000; numTrolls = 20; numCommonOrcs = 1000; numBlackOrcs = 50;}
        }

        System.out.print("Hazard Number: " + number + ", Name: " + name + ", Class: " + hazardClass + ", Snotlings: " + numSnotlings + ", Goblins: " + numGoblins + ", Trolls: " + numTrolls + ", Common Orcs: " + numCommonOrcs + ", Black Orcs: " + numBlackOrcs + "\n");
        return new GreenskinHazards(number, name, hazardClass, numSnotlings, numGoblins, numTrolls, numCommonOrcs, numBlackOrcs);
    }
}
