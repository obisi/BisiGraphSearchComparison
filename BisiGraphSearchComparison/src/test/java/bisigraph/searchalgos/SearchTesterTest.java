/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.searchalgos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bisi
 */
public class SearchTesterTest {
    
    private SearchTester st;
    
    public SearchTesterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        st = new SearchTester(5,5);
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of testAstar method, of class SearchTester.
     */
    @Test
    public void testTestAstar() {
        System.out.println("testAstar");
        assertNotEquals(st.testAstar(), -1);
    }

    /**
     * Test of testDFS method, of class SearchTester.
     */
    @Test
    public void testTestDFS() {
        System.out.println("testDFS");
        assertNotEquals(st.testDFS(), -1);
    }

    /**
     * Test of testBFS method, of class SearchTester.
     */
    @Test
    public void testTestBFS() {
        System.out.println("testBFS");
        assertNotEquals(st.testBFS(), -1);
    }
    
}
