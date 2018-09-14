/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.domain;

import bisigraph.domain.Node;
import bisigraph.domain.Path;
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
public class PathTest {
    
    private Path path;
    private Path prev;
    
    public PathTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        prev = new Path(new Node(0,0), null);
        path = new Path(new Node(0,1), prev);
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void getPreviousTest() {
        assertEquals(path.getPrevious(), prev);
    }
    
    @Test
    public void getNodeTest() {
        assertEquals(path.getNode().equals(new Node(0, 1)), true);
    }
    @Test
    public void toStringTest() {
        assertEquals(path.toString(), "0,1: 0");
    }
}
