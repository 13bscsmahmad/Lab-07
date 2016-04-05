package snakesandladders;

/**
 * Created by MMA on 4/5/2016.
 */

public class main {

    public static void main(String [] args){

        final int count = 100; // run 100 times

        int rounds = 0;
        int max_rounds = Integer.MIN_VALUE;
        int min_rounds = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++) {


            int numberOfPlayers = Dice.generateRandom(2, 4);
            //int numberOfPlayers = 4;
            Board board = new Board(numberOfPlayers);

            System.out.println("Initial score: ");

            board.getAllScores();

            while (!board.anyoneWon()) {
                // all game here

                System.out.println("Player " + board.getCurrentPlayerNumber() + " is now playing.");

                // roll dice for whatever current player is
                int score = 0;
                int diceNumber = board.rollDice();
                score += diceNumber;


                // check if current score + new score > 100. If so, do nothing, and change player.

                if (board.getCurrentPlayerScore() + score > 100) {
                    board.changeToNextPlayer();
                    continue;
                }

                // check snake mouth. if true, go back, and change current player. block current player until next 6.


                if (board.checkSnakeMouth(score) != -1) {

                    score = board.checkSnakeMouth(score);// get new score
                    board.setCurrentPlayerScore(score);
                    board.setCurrentPlayerStatus(false); // block player from next turn until 6 comes
                    board.changeToNextPlayer(); // change to next player. 'Continue' done here to avoid further processing

                    board.printAllScores();

                    continue;
                }


                // check ladder bottom. If true, go above, and another chance to roll dice.

                if (board.checkLadderMouth(score) != -1) {

                    score = board.checkLadderMouth(score);
                    board.setCurrentPlayerScore(score);

                    board.printAllScores();

                    continue; // give the same player another turn

                }


                // if 6, roll until no 6. ALSO CHECK IF CURRENT PLAYER WAS BLOCKED. IF SO, UNBLOCK


                boolean six = false;
                if (diceNumber == 6) {

                    six = true;

                    if (board.getCurrentPlayerStatus() == false) {
                        board.setCurrentPlayerStatus(true);
                    }

                    board.setCurrentPlayerScore(board.getCurrentPlayerScore() + score);
                    board.printAllScores();

                    //diceNumber = board.rollDice();

                    continue;

                }


//            while (diceNumber == 6){ // handle if multiple 6s
//                diceNumber = board.rollDice();
//                score += diceNumber;

//            }


                // add number to current score of current player
                board.setCurrentPlayerScore(board.getCurrentPlayerScore() + score);
                board.changeToNextPlayer();
                board.printAllScores();

                // check if dice was 6. If so, another turn. Else, turn of next player.


            }

            rounds += board.rounds;
            if (board.rounds < min_rounds){
                min_rounds = board.rounds;
            }

            if (board.rounds > max_rounds){
                max_rounds = board.rounds;
            }



        }

        System.out.println("Average number of rounds: " + rounds/100);
        System.out.println("Minimum number of rounds: " + min_rounds);
        System.out.println("Maximum number of rounds: " + max_rounds);

    }

}
