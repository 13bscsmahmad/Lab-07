/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorycrawlermt;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MMA
 */
public class WorkQueueTest {
    
    public WorkQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of add method, of class WorkQueue.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String s = "";
        WorkQueue instance = new WorkQueue();
        instance.add(s);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class WorkQueue.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        WorkQueue instance = new WorkQueue();
        String expResult = "";
        String result = instance.remove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of finish method, of class WorkQueue.
     */
    @Test
    public void testFinish() {
        System.out.println("finish");
        WorkQueue instance = new WorkQueue();
        instance.finish();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
