/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.directorycrawlerupdated;

import java.io.File;
import java.util.List;
import java.util.Vector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MMA
 */
public class DirectoryCrawlerTest {
    
    public DirectoryCrawlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of Crawler method, of class DirectoryCrawler.
     */
    @org.junit.Test
    public void testCrawler() {
        System.out.println("Crawler");
        File file = null;
        String path = "";
        DirectoryCrawler.Crawler(file, path);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeContentsToFile method, of class DirectoryCrawler.
     */
    @org.junit.Test
    public void testWriteContentsToFile() {
        System.out.println("writeContentsToFile");
        String filePathWithExtension = "";
        String stringToWrite = "";
        DirectoryCrawler.writeContentsToFile(filePathWithExtension, stringToWrite);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of readFile method, of class DirectoryCrawler.
     */
    @org.junit.Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        String fileName = "";
        String expResult = "";
        String result = DirectoryCrawler.readFile(fileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SearchFile method, of class DirectoryCrawler.
     */
    @org.junit.Test
    public void testSearchFile() {
        System.out.println("SearchFile");
        String keyword = "";
        Vector<String> expResult = null;
        Vector<String> result = DirectoryCrawler.SearchFile(keyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SearchContent method, of class DirectoryCrawler.
     */
    @org.junit.Test
    public void testSearchContent() {
        System.out.println("SearchContent");
        String keyword = "";
        List<String> expResult = null;
        List<String> result = DirectoryCrawler.SearchContent(keyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DirectoryCrawler.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DirectoryCrawler.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
