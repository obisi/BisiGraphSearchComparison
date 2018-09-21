/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.datastructures;

import bisigraph.datastructures.BisiQueue;
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
public class BisiQueueTest {
    
    private BisiQueue que;
    
    public BisiQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        que = new BisiQueue();
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void addTest() {
         Path p = new Path(new Node(0,0), null, 0);
         que.add(p);
         assertEquals(que.poll(), p);
     }
     
     @Test
     public void pollTest() {
         assertEquals(que.poll(), null);
     }
     
     @Test
     public void isEmptyTest() {
         assertEquals(que.isEmpty(), true);
     }
}
