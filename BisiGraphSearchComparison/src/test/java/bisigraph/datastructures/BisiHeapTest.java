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
        g = new Node(8, 8);
        heap = new BisiHeap(g);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class BisiHeap.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals(heap.toString(), "BisiHeap:[]");
    }

    /**
     * Test of poll method, of class BisiHeap.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        assertEquals(heap.poll(), null);
    }

    /**
     * Test of add method, of class BisiHeap.
     */
    @Test
    public void testAdd() {
        Path p = new Path(new Node(0, 0), null, 0);
        heap.add(p);
        assertEquals(heap.poll(), p);
    }

    /**
     * Test of getHeap method, of class BisiHeap.
     */
    @Test
    public void testGetHeap() {
        System.out.println("getHeap");
        assertEquals(heap.getHeap().length, 8);
    }

    /**
     * Test of isEmpty method, of class BisiHeap.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertEquals(heap.isEmpty(), true);
        Path p = new Path(new Node(0, 0), null, 0);
        heap.add(p);
        assertEquals(heap.isEmpty(), false);
    }
    
    /**
     * Test of growth over 8, of class BisiHeap.
     */

    @Test
    public void testOverEight() {
        System.out.println("testOverEight");
        Path first = new Path(new Node(0, 0), null, 0);
        Path second = new Path(new Node(0, 1), first, 0);
        Path third = new Path(new Node(1, 1), second, 0);
        Path fourth = new Path(new Node(1, 2), third, 0);
        Path fifth = new Path(new Node(2, 2), fourth, 0);
        Path sixth = new Path(new Node(2, 3), fifth, 0);
        Path seventh = new Path(new Node(3, 3), sixth, 0);
        Path eighth = new Path(new Node(3, 4), seventh, 0);
        Path ninth = new Path(new Node(4, 4), eighth, 0);
        heap.add(first);
        heap.add(second);
        heap.add(third);
        heap.add(fourth);
        heap.add(fifth);
        heap.add(sixth);
        heap.add(seventh);
        heap.add(eighth);
        heap.add(ninth);
        assertEquals(heap.poll(), ninth);
        assertEquals(heap.poll(), eighth);
        assertEquals(heap.poll(), seventh);
        assertEquals(heap.poll(), sixth);
        assertEquals(heap.poll(), fifth);
        assertEquals(heap.poll(), fourth);
        assertEquals(heap.poll(), third);
        assertEquals(heap.poll(), second);
        assertEquals(heap.poll(), first);
        assertEquals(heap.poll(), null);
        assertEquals(heap.isEmpty(), true);
    }

}
