/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MMA
 */
public class DiceTest {
    
    public DiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of roll method, of class Dice.
     */
    @Test
    public void testRoll() {
        System.out.println("roll");
        Dice instance = new Dice();
        instance.roll();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generateRandom method, of class Dice.
     */
    @Test
    public void testGenerateRandom() {
        System.out.println("generateRandom");
        int minInclusive = 0;
        int maxInclusive = 0;
        int expResult = 0;
        int result = Dice.generateRandom(minInclusive, maxInclusive);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
