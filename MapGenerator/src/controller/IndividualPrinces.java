package controller;

import java.util.ArrayList;

//@author jason
public class IndividualPrinces {

    //for testing in console
    /*public static void main(String[] args) {
        IndividualPrinces individualPrinces = new IndividualPrinces();
        Object[] prince = individualPrinces.princeGen(5);
    }*/

    public Object[] princeGen(int numPrinces) {
        Object[] prince = new Object[9];
        DiceRoll diceRoll = new DiceRoll();
        ArrayList<String> typeOfPrinceList = new ArrayList<>();
        ArrayList<String> princelyRaceList = new ArrayList<>();
        ArrayList<String> princelyGoalsList = new ArrayList<>();
        ArrayList<String> princelyPrinciplesList = new ArrayList<>();
        ArrayList<String> princelyStylesList = new ArrayList<>();
        ArrayList<String> princelySecretsList = new ArrayList<>();
        ArrayList<String> princelyQuirksList = new ArrayList<>();
        ArrayList<Integer> courtiersList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();

        int roll = 0;

        for (int i = 0; i < numPrinces; i++) {
            //new roll
            roll = diceRoll.roll(100);
            //table 2-1: Type Of Prince
            if (roll >= 1 && roll <= 30) {
                typeOfPrinceList.add("Bandit");
            } else if (roll >= 31 && roll <= 50) {
                typeOfPrinceList.add("Knight");
            } else if (roll >= 51 && roll <= 85) {
                typeOfPrinceList.add("Mercenary");
            } else if (roll >= 86 && roll <= 90) {
                typeOfPrinceList.add("Merchant");
            } else if (roll >= 91 && roll <= 94) {
                typeOfPrinceList.add("Politician");
            } else if (roll >= 95 && roll <= 98) {
                typeOfPrinceList.add("Priest");
            } else if (roll >= 99 && roll <= 100) {
                typeOfPrinceList.add("Wizard");
            }

            //new roll
            roll = diceRoll.roll(100);
            //table 2-2: Princely Races
            if (roll >= 1 && roll <= 8) {
                princelyRaceList.add("Dwarf");
            } else if (roll == 9) {
                princelyRaceList.add("Elf");
            } else if (roll == 10) {
                princelyRaceList.add("Halfling");
            } else if (roll >= 11 && roll <= 40) {
                princelyRaceList.add("Human—Border Princes");
            } else if (roll >= 41 && roll <= 55) {
                princelyRaceList.add("Human—Bretonnian");
            } else if (roll >= 56 && roll <= 70) {
                princelyRaceList.add("Human—Empire");
            } else if (roll >= 71 && roll <= 85) {
                princelyRaceList.add("Human—Tilean");
            } else if (roll >= 86 && roll <= 100) {
                princelyRaceList.add("Human—Other");
            }

            //new roll
            roll = diceRoll.roll(10);
            //table 2-5: Princely Goals
            switch (roll) {
                case 1 ->
                    princelyGoalsList.add("By My Command");
                case 2 ->
                    princelyGoalsList.add("Marvel At My Wondrousness");
                case 3, 4 ->
                    princelyGoalsList.add("It Must Be Mine!");
                case 5 ->
                    princelyGoalsList.add("For The Love Of The Children");
                case 6 ->
                    princelyGoalsList.add("I Am An Individual");
                case 7 ->
                    princelyGoalsList.add("Give Me Liberty, Or Give Me A Moment To Run Away");
                case 8, 9 ->
                    princelyGoalsList.add("This Power Is Mine");
                case 10 ->
                    princelyGoalsList.add("Money Can Too Buy Happiness");
            }

            //new roll
            roll = diceRoll.roll(10);
            //table 2-6: Princely Principles
            switch (roll) {
                case 1, 2 ->
                    princelyPrinciplesList.add("Death to Monsters!");
                case 3 ->
                    princelyPrinciplesList.add("True Nobility");
                case 4, 5 ->
                    princelyPrinciplesList.add("Kill the Mutant!");
                case 6 ->
                    princelyPrinciplesList.add("My Word is My Bond");
                case 7 ->
                    princelyPrinciplesList.add("Save the Children");
                case 8, 9, 10 ->
                    princelyPrinciplesList.add("What’s that?");
            }

            //new roll
            roll = diceRoll.roll(10);
            //table 2-7: princely Styles
            switch (roll) {
                case 1, 2 ->
                    princelyStylesList.add("Follow Your Instructions");
                case 3 ->
                    princelyStylesList.add("We’re All Friends Here");
                case 4, 5 ->
                    princelyStylesList.add("I Wouldn’t Expect You to Understand");
                case 6, 7 ->
                    princelyStylesList.add("Let’s Get to Business");
                case 8 ->
                    princelyStylesList.add("Honestly, You’d Embarrass a Retarded Snotling");
                case 9, 10 ->
                    princelyStylesList.add("You Have Our Permission to Rise");
            }

            //new roll
            roll = diceRoll.roll(9);
            //table 2-8: princely Secrets
            switch (roll) {
                case 1 ->
                    princelySecretsList.add("Act of Virtue");
                case 2 ->
                    princelySecretsList.add("Black Sheep");
                case 3 ->
                    princelySecretsList.add("Chaos Cultist");
                case 4 ->
                    princelySecretsList.add("Foul Murderer");
                case 5 ->
                    princelySecretsList.add("Open Book");
                case 6 ->
                    princelySecretsList.add("Secret Agent");
                case 7 ->
                    princelySecretsList.add("Strange Hobby");
                case 8 ->
                    princelySecretsList.add("Traitor");
                case 9 ->
                    princelySecretsList.add("Wanted Criminal");
            }

            //new roll
            roll = diceRoll.roll(9);
            //table 2-9: princely Quirks
            switch (roll) {
                case 1 ->
                    princelyQuirksList.add("Bizarre Temper");
                case 2 ->
                    princelyQuirksList.add("Catchphrase");
                case 3 ->
                    princelyQuirksList.add("Compulsion");
                case 4 ->
                    princelyQuirksList.add("Delusion");
                case 5 ->
                    princelyQuirksList.add("Irrational Hatred");
                case 6 ->
                    princelyQuirksList.add("Moral Rule");
                case 7 ->
                    princelyQuirksList.add("Phobia");
                case 8 ->
                    princelyQuirksList.add("Religious Fanatic");
                case 9 ->
                    princelyQuirksList.add("Uncontrollable Appetite");
            }

            //new roll
            roll = diceRoll.roll(10);
            //table 2-10: Courtiers
            switch (roll) {
                case 1, 2 ->
                    courtiersList.add(0);
                case 3 ->
                    courtiersList.add(1);
                case 4 ->
                    courtiersList.add(3);
                case 5 ->
                    courtiersList.add(4);
                case 6 ->
                    courtiersList.add(6);
                case 7 ->
                    courtiersList.add(8);
                case 8 ->
                    courtiersList.add(10);
                case 9 ->
                    courtiersList.add(12);
                case 10 ->
                    courtiersList.add(15);
            }

            
            //new roll
            roll = diceRoll.roll(100);
            //table 2-11: Titles
            if (roll >= 1 && roll <= 5) {
                titleList.add("Autocrat");
            } else if (roll >= 6 && roll <= 10) {
                titleList.add("Baron");
            } else if (roll >= 11 && roll <= 15) {
                titleList.add("Baronet");
            } else if (roll >= 16 && roll <= 20) {
                titleList.add("Captain");
            } else if (roll >= 21 && roll <= 25) {
                titleList.add("Duke/Duchess");
            } else if (roll >= 26 && roll <= 30) {
                titleList.add("Earl/Countess");
            } else if (roll >= 31 && roll <= 35) {
                titleList.add("Emperor/Empress");
            } else if (roll >= 36 && roll <= 40) {
                titleList.add("Exalted One");
            } else if (roll >= 41 && roll <= 45) {
                titleList.add("Gildemeister");
            } else if (roll >= 46 && roll <= 50) {
                titleList.add("Graf/Grafin");
            } else if (roll >= 51 && roll <= 55) {
                titleList.add("Holy Father/Mother");
            } else if (roll >= 56 && roll <= 60) {
                titleList.add("Imperator");
            } else if (roll >= 61 && roll <= 65) {
                titleList.add("King/Queen");
            } else if (roll >= 66 && roll <= 70) {
                titleList.add("Lord Protector");
            } else if (roll >= 71 && roll <= 75) {
                titleList.add("Margrave/Margravine");
            } else if (roll >= 76 && roll <= 80) {
                titleList.add("Prince");
            } else if (roll >= 81 && roll <= 85) {
                titleList.add("The Boss");
            } else if (roll >= 86 && roll <= 90) {
                titleList.add("Tzar/Tzarina");
            } else if (roll >= 91 && roll <= 95) {
                titleList.add("Viscount/Viscountess");
            } else if (roll >= 96 && roll <= 100) {
                titleList.add("Warlord");
            }

        }

        System.out.println("Type of Prince: " + typeOfPrinceList);
        prince[0] = typeOfPrinceList;
        System.out.println("Princely Race: " + princelyRaceList);
        prince[1] = princelyRaceList;
        System.out.println("Princely Goals: " + princelyGoalsList);
        prince[2] = princelyGoalsList;
        System.out.println("Princely Principles: " + princelyPrinciplesList);
        prince[3] = princelyPrinciplesList;
        System.out.println("Princely Styles: " + princelyStylesList);
        prince[4] = princelyStylesList;
        System.out.println("Princely Secrets: " + princelySecretsList);
        prince[5] = princelySecretsList;
        System.out.println("Princely Quirks: " + princelyQuirksList);
        prince[6] = princelyQuirksList;
        System.out.println("Courtiers: " + courtiersList);
        prince[7] = courtiersList;
        System.out.println("Title: " + titleList);
        prince[8] = titleList;

        return prince;
    }
}
