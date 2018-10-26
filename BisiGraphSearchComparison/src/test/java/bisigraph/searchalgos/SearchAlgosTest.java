/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.searchalgos;

import bisigraph.domain.Node;
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
public class SearchAlgosTest {
    
    private SearchAlgos sg;
    
    public SearchAlgosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sg = new SearchAlgos();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of DFS method, of class SearchAlgos.
     */
    @Test
    public void testDFS() {
        System.out.println("DFS");
        assertEquals(sg.DFS(new Node(0,0), new Node(1,1)),-1);
        
    }

    /**
     * Test of BFS method, of class SearchAlgos.
     */
    @Test
    public void testBFS() {
        System.out.println("BFS");
        assertEquals(sg.BFS(new Node(0,0), new Node(1,1)),-1);
        
    }

    /**
     * Test of astar method, of class SearchAlgos.
     */
    @Test
    public void testAstar() {
        System.out.println("astar");
        assertEquals(sg.astar(new Node(0,0), new Node(1,1)),-1);
        
    }
    
}
