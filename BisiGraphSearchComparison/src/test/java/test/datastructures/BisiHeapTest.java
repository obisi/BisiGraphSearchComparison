/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.datastructures;

import bisigraph.datastructures.BisiHeap;
import bisigraph.domain.Node;
import bisigraph.domain.Path;
import java.util.Arrays;
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
public class BisiHeapTest {
    
    BisiHeap heap;
    Node g;
    
    
    public BisiHeapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        g = new Node(8,8);
        heap = new BisiHeap(g);
    }
    
    @After
    public void tearDown() {
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    // 
     @Test
     public void insertTest() {
         Path p = new Path(new Node(0,0), null, 0);
         heap.add(p);
         assertEquals(heap.poll(), p);
     }
     
      @Test
     public void pollTest() {
         assertEquals(heap.poll(), null); 
     }
}
