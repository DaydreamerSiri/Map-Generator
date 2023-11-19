package controller;

//@author jason

import java.util.Random;

public class DiceRoll {
    public int roll(int max){
        //create instance of Random class
        Random rand = new Random();
        
        //random Number between 1 and max (inclusive)
        int ranNum = rand.nextInt(max) + 1;
        
        return ranNum;
    }
}
