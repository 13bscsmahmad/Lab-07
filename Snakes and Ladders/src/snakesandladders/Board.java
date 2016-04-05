package snakesandladders;

import java.util.*;

/**
 * Created by MMA on 4/5/2016.
 */
public class Board {


    private Dice boardDice;

    private List<Player> playerDetails;

    private Player currentPlayer;

    private HashMap<Integer, Integer> snakes;
    private HashMap<Integer, Integer> ladders;

    public int rounds = 1;

    void changeToNextPlayer(){

        // update records

        for (int i = 0; i < playerDetails.size(); i++) {
            if (playerDetails.get(i).playerNumber == currentPlayer.playerNumber){

                playerDetails.set(i, currentPlayer);

            }

        }

        // Go to next player

        for (int i = 0; i < playerDetails.size(); i++){
            if (playerDetails.get(i).playerNumber == currentPlayer.playerNumber){

                try {

                    if (playerDetails.get(i+1) != null){
                        // go to next index
                        currentPlayer = playerDetails.get(i+1);
                        break;
                    } else {
                        currentPlayer = playerDetails.get(0);
                        System.out.println("Resetting...");

                        break;
                    }



                } catch (Exception ex){

                    currentPlayer = playerDetails.get(0);
                    System.out.println("Resetting...");
                    rounds++;
                    break;

                }


            }
        }

        System.out.println("Player " + currentPlayer.playerNumber + "'s turn.");

        // Change player to next until a player who is not blocked

//        do {
//
//            for (int i = 0; i < playerDetails.size(); i++) {
//                if (playerDetails.get(i).playerNumber == this.currentPlayer.playerNumber) {
//                    this.currentPlayer = playerDetails.get((playerDetails.size() % currentPlayer.playerNumber) + 1); // get next player
//                    break;
//                }
//            }
//        } while (this.currentPlayer.status == false);

    }


    Board(int numberOfPlayers){

        playerDetails = new ArrayList<Player>();
        boardDice = new Dice();
        snakes = new HashMap<Integer, Integer>();
        ladders = new HashMap<Integer, Integer>();


        for (int i = 0; i < numberOfPlayers; i++) {
            Player newPlayer = new Player();
            newPlayer.score = 0;
            newPlayer.playerNumber = i+1;
            playerDetails.add(newPlayer);
        }

        this.currentPlayer = playerDetails.get(0);
        //this.playerNameAndScore = new HashMap<Integer, Integer>();


        // TODO: Confirm snakes and ladder values

        snakes.put(99, 22);
        snakes.put(88,33);
        snakes.put(77,44);
        snakes.put(66, 55);
        snakes.put(25,15);
        snakes.put(35, 5);

        //////////////////////////

        ladders.put(3, 23);
        ladders.put(8, 17);
        ladders.put(12,43);
        ladders.put(20, 36);
        ladders.put(32, 49);
        ladders.put(48, 67);
        ladders.put(83, 97);

        ///////////////////////////




        System.out.println("Board initialized for " + numberOfPlayers + " players.");

//        for (int i = 0; i < numberOfPlayers; i++){ // initialize all players and scores to 0.
//            playerNameAndScore.put((i+1), 0);
//        }
    }

    int getScoreOfPlayer(int playerNumber){
//        return playerNameAndScore.get(playerNumber);

        for (int i = 0; i < playerDetails.size(); i++){
            if (playerDetails.get(i).playerNumber == playerNumber){
                return playerDetails.get(i).score;
            }
        }

        return -1;

    }

    void printAllScores(){ // Print all scores to standard output

        System.out.println("All scores: ");

//        for (Map.Entry<Integer,Integer> entry : playerNameAndScore.entrySet()) {
////            String key = entry.getKey();
////            String value = entry.getValue();
//
//            System.out.println("Player " + entry.getKey() + ": " + entry.getValue());
//        }

        for (int i = 0; i < playerDetails.size(); i++) {
            System.out.println("Player " + playerDetails.get(i).playerNumber + " Score: " + playerDetails.get(i).score);
        }

    }

    List<Integer> getAllScores(){ // return list of all scores
        List<Integer> allScores = new ArrayList<Integer>();

//        for (Map.Entry<Integer,Integer> entry : playerNameAndScore.entrySet()) {
//            //String key = entry.getKey();
//            allScores.add(entry.getValue());
//
////            System.out.println("Player " + entry.getKey() + ": " + entry.getValue());
//        }

        for (int i = 0; i < playerDetails.size(); i++){
            allScores.add(playerDetails.get(i).score);
        }

        return allScores;


    }

//    void updateScoreOfPlayer(int newScore){
//        //playerNameAndScore.put(playerNumber, newScore);
//
//        for (int i = 0; i < playerDetails.size(); i++){
//            if(playerDetails.get(i).playerNumber == currentPlayer.playerNumber){
//                playerDetails.get(i).score = newScore;
//                break;
//            }
//        }
//
//    }

    int rollDice(){
        boardDice.roll();
        System.out.println("Dice number: " + boardDice.number);
        return boardDice.number;
    }

    boolean anyoneWon(){

        boolean won = false;

        List<Integer> scores = getAllScores();

        for (int i = 0; i < scores.size(); i++) {
            if(scores.get(i) == 100){
                won = true;
            }
        }

        return won;

    }

    Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    int getCurrentPlayerScore(){
        return this.currentPlayer.score;
    }

    int getCurrentPlayerNumber(){
        return currentPlayer.playerNumber;
    }

    boolean getCurrentPlayerStatus(){
        return currentPlayer.status;
    }

    void setCurrentPlayerScore(int score){
        currentPlayer.score = score;
    }

    void setCurrentPlayerStatus(boolean status){
        currentPlayer.status = status;
    }

    int checkSnakeMouth(int value){ // returns -1 or snake tail

        // check if current value is at the mouth of snake

        int finalVal = -1;

//        if (snakes.containsKey(value) != null){
//            System.out.println("Encountered snake! Now, going to value: " + snakes.get());
//        }

        if(snakes.get(value) != null){

            finalVal = snakes.get(value);
            System.out.println("Snake mouth found at: " + value + ". Going to: " + finalVal);

        }

        return finalVal;

    }

    int checkLadderMouth(int value){

        int finalVal = -1;

        if(ladders.get(value) != null){

            finalVal = ladders.get(value);
            System.out.println("Ladder mouth found at: " + value + ". Going to: " + finalVal);

        }


        return finalVal;

    }




}
