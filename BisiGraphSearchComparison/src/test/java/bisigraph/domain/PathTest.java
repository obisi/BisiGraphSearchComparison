/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;

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
        prev = new Path(new Node(0, 0), null, 0);
        path = new Path(new Node(0, 1), prev, 1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPrevious method, of class Path.
     */
    @Test
    public void testGetPrevious() {
        System.out.println("getPrevious");
        assertEquals(path.getPrevious(), prev);
    }

    /**
     * Test of getNode method, of class Path.
     */
    @Test
    public void testGetNode() {
        System.out.println("getNode");
        assertEquals(path.getNode().equals(new Node(0, 1)), true);
    }

    /**
     * Test of getDistance method, of class Path.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        assertEquals(path.getDistance(), 1);
    }

    /**
     * Test of distanceToNode method, of class Path.
     */
    @Test
    public void testDistanceToNode() {
        System.out.println("distanceToNode");
        assertEquals(prev.distanceToNode(path.getNode()), 3);
    }

    /**
     * Test of compare method, of class Path.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        assertEquals(path.compare(prev, path.getNode()), -2);
    }

    /**
     * Test of toString method, of class Path.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
         assertEquals(path.toString(), "0,1: Empty, travelled dist: 1");
    }

}
