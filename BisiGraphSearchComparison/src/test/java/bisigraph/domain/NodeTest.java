/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;

import java.awt.Color;
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
public class NodeTest {

    private Node node;
    private Node neighbor;

    public NodeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.node = new Node(0, 0);
        this.neighbor = new Node(1, 0);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getColor method, of class Node.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        assertEquals(node.getColor(), Color.lightGray);    
    }


    /**
     * Test of getType method, of class Node.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        assertEquals(node.getType(), "Empty");
    }

    /**
     * Test of toString method, of class Node.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals(node.toString(), Integer.toString(0)+"xy:0,0");
    }

    /**
     * Test of setWall method, of class Node.
     */
    @Test
    public void testSetWall() {
        System.out.println("setWall");
        node.setWall();
        assertEquals(node.getColor(), Color.BLACK);
        assertEquals(node.getType(), "Wall");
    }

    /**
     * Test of isWall method, of class Node.
     */
    @Test
    public void testIsWall() {
        System.out.println("isWall");
        node.setEmpty();
        assertEquals(node.isWall(), false);
        node.setWall();
        assertEquals(node.isWall(), true);
    }

    /**
     * Test of isEmpty method, of class Node.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        node.setEmpty();
        assertEquals(node.isEmpty(), true);
        node.setWall();
        assertEquals(node.isEmpty(), false);
    }

    /**
     * Test of setGoal method, of class Node.
     */
    @Test
    public void testSetGoal() {
        System.out.println("setGoal");
        node.setGoal();
        assertEquals(node.getColor(), Color.RED);
        assertEquals(node.getType(), "Goal");
    }

    /**
     * Test of setStart method, of class Node.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        node.setStart();
        assertEquals(node.getColor(), Color.WHITE);
        assertEquals(node.getType(), "Start");
    }

    /**
     * Test of setEmpty method, of class Node.
     */
    @Test
    public void testSetEmpty() {
        System.out.println("setEmpty");
        node.setEmpty();
        assertEquals(node.getColor(), Color.lightGray);
        assertEquals(node.getType(), "Empty");
    }

    /**
     * Test of setPath method, of class Node.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        node.setPath();
        assertEquals(node.getColor(), Color.CYAN);
        assertEquals(node.getType(), "Path");
    }

    /**
     * Test of setInLine method, of class Node.
     */
    @Test
    public void testSetInLine() {
        System.out.println("setInLine");
        node.setInLine();
        assertEquals(node.getColor(), Color.darkGray);
        assertEquals(node.getType(), "in Line");
    }

    /**
     * Test of setVisited method, of class Node.
     */
    @Test
    public void testSetVisited() {
        System.out.println("setVisited");
        node.setVisited();
        assertEquals(node.getColor(), Color.GRAY);
        assertEquals(node.getType(), "Visited");
    }

    /**
     * Test of getNeighbors method, of class Node.
     */
    @Test
    public void testGetNeighbors() {
        System.out.println("getNeighbors");
        assertEquals(node.getNeighbors().length, 4);
    }

    /**
     * Test of visit method, of class Node.
     */
    @Test
    public void testVisit() {
        System.out.println("visit");
        node.visit();
        assertEquals(node.visited(), true);
    }

    /**
     * Test of visited method, of class Node.
     */
    @Test
    public void testVisited() {
        System.out.println("visited");
        node.visit();
        assertEquals(node.visited(), true);
    }

    /**
     * Test of getXY method, of class Node.
     */
    @Test
    public void testGetXY() {
        System.out.println("getXY");
        assertEquals(node.getXY()[0], 0);
    }

    /**
     * Test of equals method, of class Node.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        assertEquals(node.equals(new Node(0,0)), true);
        assertEquals(node.equals(new Node(1,0)), false);
    }

    /**
     * Test of setNeighbor method, of class Node.
     */
    @Test
    public void testSetNeighbor() {
        System.out.println("setNeighbor");
        node.setNeighbor(neighbor);
        assertEquals(node.getNeighbors()[0], neighbor);
    }

}
