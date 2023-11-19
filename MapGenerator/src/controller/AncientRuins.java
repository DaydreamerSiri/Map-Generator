package controller;
import java.util.ArrayList;

//@author jason
public class AncientRuins {

    //for testing in console
    /*public static void main(String[] args) {
        AncientRuins ancientRuins = new AncientRuins();
        Object[] ruins = ancientRuins.ruinsGen();
    }*/

    public Object[] ruinsGen() {
        Object[] ruins = new Object[6];
        DiceRoll diceRoll = new DiceRoll();
        RandomNum randNum = new RandomNum();

        int roll = diceRoll.roll(100);
        int numOfRuins = 0;
        ArrayList<String> ruinTypeList = new ArrayList<>();
        ArrayList<String> ancientMenaces = new ArrayList<>();
        ArrayList<Integer> ageOfRuinsList = new ArrayList<>();
        ArrayList<String> purposeList = new ArrayList<>();
        ArrayList<String> reasonForRuinsList = new ArrayList<>();

        //Table 1-3 Number of Ancient Ruins
        if (roll >= 1 && roll <= 10) {
            numOfRuins = 1;
        } else if (roll >= 11 && roll <= 22) {
            numOfRuins = 2;
        } else if (roll >= 23 && roll <= 34) {
            numOfRuins = 3;
        } else if (roll >= 35 && roll <= 47) {
            numOfRuins = 4;
        } else if (roll >= 48 && roll <= 60) {
            numOfRuins = 5;
        } else if (roll >= 61 && roll <= 72) {
            numOfRuins = 6;
        } else if (roll >= 73 && roll <= 83) {
            numOfRuins = 7;
        } else if (roll >= 84 && roll <= 92) {
            numOfRuins = 8;
        } else if (roll >= 93 && roll <= 98) {
            numOfRuins = 9;
        } else if (roll >= 99 && roll <= 100) {
            numOfRuins = 10;
        }

        System.out.println("Num of ruins: " + numOfRuins);
        ruins[0] = numOfRuins;

        for (int i = 0; i < numOfRuins; i++) {
            //new roll
            roll = diceRoll.roll(100);

            //table 1-4: Ruin Type
            if (roll >= 1 && roll <= 20) {
                ruinTypeList.add("Arabyan");
            } else if (roll >= 21 && roll <= 30) {
                ruinTypeList.add("Chaos Cluts");
            } else if (roll >= 31 && roll <= 45) {
                ruinTypeList.add("Dwarf");
            } else if (roll >= 46 && roll <= 65) {
                ruinTypeList.add("Khemri");
            } else if (roll >= 66 && roll <= 90) {
                ruinTypeList.add("Recent Human");
            } else if (roll >= 91 && roll <= 100) {
                ruinTypeList.add("Oddity");
            }

            //table 1-5: Ancient Menaces & table 1-6: Age of Ruins & table 1-7: Original Purpose of Ruins
            String ruinType = ruinTypeList.get(i);
            if ("Arabyan".equals(ruinType)) {
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 25) {
                    ancientMenaces.add("Deamon");
                } else if (roll >= 26 && roll <= 55) {
                    ancientMenaces.add("Degenerate Tribe");
                } else if (roll >= 56 && roll <= 75) {
                    ancientMenaces.add("Plague");
                } else if (roll >= 76 && roll <= 85) {
                    ancientMenaces.add("Swarm");
                } else if (roll >= 86 && roll <= 95) {
                    ancientMenaces.add("Undead");
                } else if (roll >= 96 && roll <= 100) {
                    ancientMenaces.add("None");
                }
                //Age of Ruins
                ageOfRuinsList.add(randNum.roll(100, 1500));
                //Purpose
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 30) {
                    purposeList.add("Fortress");
                } else if (roll >= 31 && roll <= 60) {
                    purposeList.add("Outpost");
                } else if (roll >= 61 && roll <= 70) {
                    purposeList.add("Settlement");
                } else if (roll >= 71 && roll <= 90) {
                    purposeList.add("Temple");
                } else if (roll >= 91 && roll <= 100) {
                    purposeList.add("Tomb");
                }
            } else if ("Chaos Cluts".equals(ruinType)) {
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 20) {
                    ancientMenaces.add("Deamon");
                } else if (roll >= 21 && roll <= 25) {
                    ancientMenaces.add("Degenerate Tribe");
                } else if (roll >= 26 && roll <= 35) {
                    ancientMenaces.add("Golem");
                } else if (roll >= 36 && roll <= 50) {
                    ancientMenaces.add("Plague");
                } else if (roll >= 51 && roll <= 65) {
                    ancientMenaces.add("Swarm");
                } else if (roll >= 66 && roll <= 85) {
                    ancientMenaces.add("Undead");
                } else if (roll >= 86 && roll <= 95) {
                    ancientMenaces.add("Weapon");
                } else if (roll >= 96 && roll <= 100) {
                    ancientMenaces.add("None");
                }
                //Age of Ruins
                ageOfRuinsList.add(randNum.roll(0, 3000));
                //Purpose
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 20) {
                    purposeList.add("Fortress");
                } else if (roll >= 21 && roll <= 25) {
                    purposeList.add("Outpost");
                } else if (roll >= 26 && roll <= 30) {
                    purposeList.add("Settlement");
                } else if (roll >= 31 && roll <= 80) {
                    purposeList.add("Temple");
                } else if (roll >= 81 && roll <= 100) {
                    purposeList.add("Tomb");
                }
            } else if ("Dwarf".equals(ruinType)) {
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 5) {
                    ancientMenaces.add("Deamon");
                } else if (roll >= 6 && roll <= 30) {
                    ancientMenaces.add("Golem");
                } else if (roll >= 31 && roll <= 55) {
                    ancientMenaces.add("Plague");
                } else if (roll >= 56 && roll <= 75) {
                    ancientMenaces.add("Swarm");
                } else if (roll >= 76 && roll <= 95) {
                    ancientMenaces.add("Weapon");
                } else if (roll >= 96 && roll <= 100) {
                    ancientMenaces.add("None");
                }
                //Age of Ruins
                ageOfRuinsList.add(randNum.roll(100, 5000));
                //Purpose
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 25) {
                    purposeList.add("Fortress");
                } else if (roll >= 26 && roll <= 60) {
                    purposeList.add("Outpost");
                } else if (roll >= 61 && roll <= 80) {
                    purposeList.add("Settlement");
                } else if (roll >= 81 && roll <= 90) {
                    purposeList.add("Temple");
                } else if (roll >= 91 && roll <= 100) {
                    purposeList.add("Tomb");
                }
            } else if ("Khemri".equals(ruinType)) {
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 15) {
                    ancientMenaces.add("Deamon");
                } else if (roll >= 16 && roll <= 40) {
                    ancientMenaces.add("Degenerate Tribe");
                } else if (roll >= 41 && roll <= 50) {
                    ancientMenaces.add("Plague");
                } else if (roll >= 51 && roll <= 60) {
                    ancientMenaces.add("Swarm");
                } else if (roll >= 61 && roll <= 85) {
                    ancientMenaces.add("Undead");
                } else if (roll >= 86 && roll <= 95) {
                    ancientMenaces.add("Weapon");
                } else if (roll >= 96 && roll <= 100) {
                    ancientMenaces.add("None");
                }
                //Age of Ruins
                ageOfRuinsList.add(randNum.roll(300, 3000));
                //Purpose
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 20) {
                    purposeList.add("Fortress");
                } else if (roll >= 21 && roll <= 50) {
                    purposeList.add("Outpost");
                } else if (roll >= 51 && roll <= 60) {
                    purposeList.add("Settlement");
                } else if (roll >= 61 && roll <= 70) {
                    purposeList.add("Temple");
                } else if (roll >= 71 && roll <= 100) {
                    purposeList.add("Tomb");
                }
            } else if ("Recent Human".equals(ruinType)) {
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 15) {
                    ancientMenaces.add("Deamon");
                } else if (roll >= 16 && roll <= 40) {
                    ancientMenaces.add("Degenerate Tribe");
                } else if (roll >= 41 && roll <= 60) {
                    ancientMenaces.add("Plague");
                } else if (roll >= 61 && roll <= 70) {
                    ancientMenaces.add("Swarm");
                } else if (roll >= 71 && roll <= 85) {
                    ancientMenaces.add("Undead");
                } else if (roll >= 86 && roll <= 95) {
                    ancientMenaces.add("Weapon");
                } else if (roll >= 96 && roll <= 100) {
                    ancientMenaces.add("None");
                }
                //Age of Ruins
                ageOfRuinsList.add(randNum.roll(0, 300));
                //Purpose
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 20) {
                    purposeList.add("Fortress");
                } else if (roll >= 21 && roll <= 50) {
                    purposeList.add("Outpost");
                } else if (roll >= 51 && roll <= 75) {
                    purposeList.add("Settlement");
                } else if (roll >= 76 && roll <= 90) {
                    purposeList.add("Temple");
                } else if (roll >= 91 && roll <= 100) {
                    purposeList.add("Tomb");
                }
            } else if ("Oddity".equals(ruinType)) {
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 15) {
                    ancientMenaces.add("Deamon");
                } else if (roll >= 16 && roll <= 30) {
                    ancientMenaces.add("Degenerate Tribe");
                } else if (roll >= 31 && roll <= 45) {
                    ancientMenaces.add("Golem");
                } else if (roll >= 46 && roll <= 60) {
                    ancientMenaces.add("Plague");
                } else if (roll >= 61 && roll <= 75) {
                    ancientMenaces.add("Swarm");
                } else if (roll >= 76 && roll <= 80) {
                    ancientMenaces.add("Undead");
                } else if (roll >= 81 && roll <= 95) {
                    ancientMenaces.add("Weapon");
                } else if (roll >= 96 && roll <= 100) {
                    ancientMenaces.add("None");
                }
                //Age of Ruins
                ageOfRuinsList.add(randNum.roll(0, 5000));
                //Purpose
                //new roll
                roll = diceRoll.roll(100);
                if (roll >= 1 && roll <= 15) {
                    ancientMenaces.add("Deamon");
                } else if (roll >= 16 && roll <= 30) {
                    ancientMenaces.add("Degenerate Tribe");
                } else if (roll >= 31 && roll <= 45) {
                    ancientMenaces.add("Golem");
                } else if (roll >= 46 && roll <= 60) {
                    ancientMenaces.add("Plague");
                } else if (roll >= 61 && roll <= 75) {
                    ancientMenaces.add("Swarm");
                } else if (roll >= 76 && roll <= 80) {
                    ancientMenaces.add("Undead");
                } else if (roll >= 81 && roll <= 95) {
                    ancientMenaces.add("Weapon");
                } else if (roll >= 96 && roll <= 100) {
                    ancientMenaces.add("None");
                }
            }

            //table 1-8: Reason for Ruins
            //new roll
            roll = diceRoll.roll(10);
            switch (roll) {
                case 1 -> reasonForRuinsList.add("Civil War");
                case 2 -> reasonForRuinsList.add("Enigma");
                case 3 -> reasonForRuinsList.add("Famine");
                case 4 -> reasonForRuinsList.add("Magic");
                case 5 -> reasonForRuinsList.add("Military Attack");
                case 6 -> reasonForRuinsList.add("Natural Decay");
                case 7 -> reasonForRuinsList.add("Natural Disaster");
                case 8 -> reasonForRuinsList.add("Plague");
                case 9 -> reasonForRuinsList.add("Policy");
                case 10 -> reasonForRuinsList.add("Resource Loss");
            }
        }
        System.out.println("Ruin type: " + ruinTypeList);
        ruins[1] = ruinTypeList;
        System.out.println("Ancient Menaces: " + ancientMenaces);
        ruins[2] = ancientMenaces;
        System.out.println("Age of Ruins: " + ageOfRuinsList);
        ruins[3] = ancientMenaces;
        System.out.println("Purpose: " + purposeList);
        ruins[4] = purposeList;
        System.out.println("Reason: " + reasonForRuinsList);
        ruins[5] = reasonForRuinsList;

        return ruins;
    }
}
