/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.domain;

import java.awt.Color;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getColorTest() {
        assertEquals(node.getColor(), Color.lightGray);
    }

    @Test
    public void getTypeTest() {
        assertEquals(node.getType(), "Empty");
    }

    @Test
    public void toStringTest() {
        assertEquals(node.toString(), Integer.toString(0));
    }

    @Test
    public void setWallTest() {
        node.setWall();
        assertEquals(node.getColor(), Color.BLACK);
        assertEquals(node.getType(), "Wall");
        

    }

    @Test
    public void setGoalTest() {
        node.setGoal();
        assertEquals(node.getColor(), Color.RED);
        assertEquals(node.getType(), "Goal");
    }

    @Test
    public void setStartTest() {
        node.setStart();
        assertEquals(node.getColor(), Color.WHITE);
        assertEquals(node.getType(), "Start");
    }

    @Test
    public void setEmptyTest() {
        node.setEmpty();
        assertEquals(node.getColor(), Color.lightGray);
        assertEquals(node.getType(), "Empty");
    }

    @Test
    public void setPathTest() {
        node.setPath();
        assertEquals(node.getColor(), Color.CYAN);
        assertEquals(node.getType(), "Path");
    }

    @Test
    public void setInLineTest() {
        node.setInLine();
        assertEquals(node.getColor(), Color.darkGray);
        assertEquals(node.getType(), "in Line");
    }

    @Test
    public void setVisitedTest() {
        node.setVisited();
        assertEquals(node.getColor(), Color.GRAY);
        assertEquals(node.getType(), "Visited");
    }

    @Test
    public void visitTest() {
        node.visit();
        assertEquals(node.visited(), true);
    }

    @Test
    public void visitedTest() {
        node.visit();
        assertEquals(node.visited(), true);
    }

    @Test
    public void setNeighborTest() {
        node.setNeighbor(neighbor);
        assertEquals(node.getNeighbors()[0], neighbor);
    }

    @Test
    public void getNeighborTest() {
        assertEquals(node.getNeighbors().length, 4);
    }

    @Test
    public void hashCodeTest() {
        node.setEmpty();
        assertEquals(node.hashCode(), (97 * 97 * 97 * 7));
    }

    @Test
    public void equalsTest() {
        assertEquals(node.equals(neighbor), false);
     }
}
