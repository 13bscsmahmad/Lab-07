/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MMA
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of changeToNextPlayer method, of class Board.
     */
    @Test
    public void testChangeToNextPlayer() {
        System.out.println("changeToNextPlayer");
        Board instance = null;
        instance.changeToNextPlayer();
        // TODO review the generated test code and remove the default call to fail.
        //assertEquals(instance, this);
        
    }

    /**
     * Test of getScoreOfPlayer method, of class Board.
     */
    @Test
    public void testGetScoreOfPlayer() {
        System.out.println("getScoreOfPlayer");
        int playerNumber = 0;
        Board instance = null;
        int expResult = 0;
        int result = instance.getScoreOfPlayer(playerNumber);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printAllScores method, of class Board.
     */
    @Test
    public void testPrintAllScores() {
        System.out.println("printAllScores");
        Board instance = null;
        instance.printAllScores();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllScores method, of class Board.
     */
    @Test
    public void testGetAllScores() {
        System.out.println("getAllScores");
        Board instance = null;
        List<Integer> expResult = null;
        List<Integer> result = instance.getAllScores();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rollDice method, of class Board.
     */
    @Test
    public void testRollDice() {
        System.out.println("rollDice");
        Board instance = null;
        int expResult = 0;
        int result = instance.rollDice();
        
        Board board = new Board(2);
        
        int newNumber = board.rollDice();

        //assertTrue(newNumber, newNumber);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of anyoneWon method, of class Board.
     */
    @Test
    public void testAnyoneWon() {
        System.out.println("anyoneWon");
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.anyoneWon();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentPlayer method, of class Board.
     */
    @Test
    public void testGetCurrentPlayer() {
        System.out.println("getCurrentPlayer");
        Board instance = null;
        Player expResult = null;
        Player result = instance.getCurrentPlayer();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentPlayerScore method, of class Board.
     */
    @Test
    public void testGetCurrentPlayerScore() {
        System.out.println("getCurrentPlayerScore");
        Board instance = null;
        int expResult = 0;
        int result = instance.getCurrentPlayerScore();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentPlayerNumber method, of class Board.
     */
    @Test
    public void testGetCurrentPlayerNumber() {
        System.out.println("getCurrentPlayerNumber");
        Board instance = null;
        int expResult = 0;
        int result = instance.getCurrentPlayerNumber();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentPlayerStatus method, of class Board.
     */
    @Test
    public void testGetCurrentPlayerStatus() {
        System.out.println("getCurrentPlayerStatus");
        Board instance = new Board(2);
        boolean expResult = false;
        boolean result = instance.getCurrentPlayerStatus();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentPlayerScore method, of class Board.
     */
    @Test
    public void testSetCurrentPlayerScore() {
        System.out.println("setCurrentPlayerScore");
        int score = 0;
        Board instance = null;
        instance.setCurrentPlayerScore(score);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentPlayerStatus method, of class Board.
     */
    @Test
    public void testSetCurrentPlayerStatus() {
        System.out.println("setCurrentPlayerStatus");
        boolean status = false;
        Board instance = null;
        instance.setCurrentPlayerStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkSnakeMouth method, of class Board.
     */
    @Test
    public void testCheckSnakeMouth() {
        System.out.println("checkSnakeMouth");
        int value = 0;
        Board instance = null;
        int expResult = 0;
        int result = instance.checkSnakeMouth(value);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkLadderMouth method, of class Board.
     */
    @Test
    public void testCheckLadderMouth() {
        System.out.println("checkLadderMouth");
        int value = 0;
        Board instance = null;
        int expResult = 0;
        int result = instance.checkLadderMouth(value);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private void assertTrue(int expResult, int result) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
