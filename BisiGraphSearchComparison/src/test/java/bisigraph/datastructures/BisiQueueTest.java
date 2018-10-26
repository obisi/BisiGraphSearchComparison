/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.datastructures;

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

    /**
     * Test of toString method, of class BisiQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals(que.toString(), "BisiQue:[]");
    }

    /**
     * Test of add method, of class BisiQueue.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Path p = new Path(new Node(0,0), null, 0);
        que.add(p);
        assertEquals(que.poll(), p);
    }

    /**
     * Test of poll method, of class BisiQueue.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        assertEquals(que.poll(), null);
        Path p = new Path(new Node(0,0), null, 0);
        que.add(p);
        assertEquals(que.poll(), p);
        
    }

    /**
     * Test of isEmpty method, of class BisiQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertEquals(que.isEmpty(), true);
        Path p = new Path(new Node(0,0), null, 0);
        que.add(p);
        assertEquals(que.isEmpty(), false);
    }
    
    /**
     * Test of growth beyond 8, of class BisiQueue.
     */
    
    @Test
    public void testOverEight(){
        System.out.println("testOverEight");
        Path first = new Path(new Node(0,0), null, 0);
        Path second = new Path(new Node(0,0), null, 0);
        Path third = new Path(new Node(0,0), null, 0);
        Path fourth = new Path(new Node(0,0), null, 0);
        Path fifth = new Path(new Node(0,0), null, 0);
        Path sixth = new Path(new Node(0,0), null, 0);
        Path seventh = new Path(new Node(0,0), null, 0);
        Path eighth = new Path(new Node(0,0), null, 0);
        Path ninth = new Path(new Node(0,0), null, 0);
        que.add(first);
        que.add(second);
        que.add(third);
        que.add(fourth);
        que.add(fifth);
        que.add(sixth);
        que.add(seventh);
        que.add(eighth);
        que.add(ninth);
        assertEquals(que.poll(), first);
        assertEquals(que.poll(), second);
        assertEquals(que.poll(), third);
        assertEquals(que.poll(), fourth);
        assertEquals(que.poll(), fifth);
        assertEquals(que.poll(), sixth);
        assertEquals(que.poll(), seventh);
        assertEquals(que.poll(), eighth);
        assertEquals(que.poll(), ninth);
        assertEquals(que.poll(), null);
        assertEquals(que.isEmpty(), true); 
    }
    
}
