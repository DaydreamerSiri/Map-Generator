package controller;

// @author jason

import java.util.Random;

public class RandomNum {
    public int roll(int min, int max){
        //create instance of Random class
        Random rand = new Random();
        
        //random Number between 1 and max (inclusive)
        int ranNum = rand.nextInt(max - min + 1) + min;
        
        return ranNum;
    }
}
