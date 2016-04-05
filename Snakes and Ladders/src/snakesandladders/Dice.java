package snakesandladders;


import java.util.Random;

/**
 * Created by MMA on 4/5/2016.
 */
public class Dice {

    public int number;

    public Dice(){this.number = -1;
        System.out.println("Dice initialized");}

    public void roll(){

//        Random rn = new Random();
//        int range = 6 - 1 + 1;
        this.number =  generateRandom(1,6);

        //this.number = 1 + (int)(Math.random() * ((6 - 1) + 1));
    }

    public static int generateRandom (int minInclusive, int maxInclusive){

        Random rn = new Random();
        int range = maxInclusive - minInclusive + 1;
        int randomNum =  rn.nextInt(range) + minInclusive;
        return randomNum;
    }

}
