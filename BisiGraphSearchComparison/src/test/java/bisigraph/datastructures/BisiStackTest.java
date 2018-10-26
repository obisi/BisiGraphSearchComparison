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

    /**
     * Test of toString method, of class BisiStack.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals(stack.toString(), "BisiStack:[]");
    }

    /**
     * Test of add method, of class BisiStack.
     */
    @Test
    public void testAdd() {
        Path p = new Path(new Node(0, 0), null, 0);
        stack.add(p);
        assertEquals(stack.poll(), p);
    }

    /**
     * Test of poll method, of class BisiStack.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        Path p = new Path(new Node(0, 0), null, 0);
        stack.add(p);
        assertEquals(stack.poll(), p);
        assertEquals(stack.poll(), null);
    }

    /**
     * Test of isEmpty method, of class BisiStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertEquals(stack.isEmpty(), true);
        Path p = new Path(new Node(0, 0), null, 0);
        stack.add(p);
        assertEquals(stack.isEmpty(), false);
    }
    /**
     * Test of growth beyond 8, of class BisiStack.
     */
        
    @Test
    public void testOverEight() {
        System.out.println("testOverEight");
        Path first = new Path(new Node(0, 0), null, 0);
        Path second = new Path(new Node(0, 0), null, 0);
        Path third = new Path(new Node(0, 0), null, 0);
        Path fourth = new Path(new Node(0, 0), null, 0);
        Path fifth = new Path(new Node(0, 0), null, 0);
        Path sixth = new Path(new Node(0, 0), null, 0);
        Path seventh = new Path(new Node(0, 0), null, 0);
        Path eighth = new Path(new Node(0, 0), null, 0);
        Path ninth = new Path(new Node(0, 0), null, 0);
        stack.add(first);
        stack.add(second);
        stack.add(third);
        stack.add(fourth);
        stack.add(fifth);
        stack.add(sixth);
        stack.add(seventh);
        stack.add(eighth);
        stack.add(ninth);
        assertEquals(stack.poll(), ninth);
        assertEquals(stack.poll(), eighth);
        assertEquals(stack.poll(), seventh);
        assertEquals(stack.poll(), sixth);
        assertEquals(stack.poll(), fifth);
        assertEquals(stack.poll(), fourth);
        assertEquals(stack.poll(), third);
        assertEquals(stack.poll(), second);
        assertEquals(stack.poll(), first);
        assertEquals(stack.poll(), null);
        assertEquals(stack.isEmpty(), true);
    }

}
