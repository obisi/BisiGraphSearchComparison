/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.datastructures;

import bisigraph.datastructures.BisiStack;
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
public class BisiStackTest {
    
    private BisiStack stack;
    
    public BisiStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stack = new BisiStack();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void addTest() {
         Path p = new Path(new Node(0,0), null, 0);
         stack.add(p);
         assertEquals(stack.poll(), p);
     }
     
     @Test
     public void pollTest() {
         assertEquals(stack.poll(), null);
     }
     
     @Test
     public void isEmptyTest() {
         assertEquals(stack.isEmpty(), true);
     }
}
