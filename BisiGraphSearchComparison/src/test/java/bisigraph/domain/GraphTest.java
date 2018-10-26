/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;

import java.awt.Color;
import javax.swing.JLabel;
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
public class GraphTest {
    
    private Graph graph;
    
    public GraphTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        graph = new Graph(5,5,1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setNeighbors method, of class Graph.
     */
    @Test
    public void testSetNeighbors() {
        System.out.println("setNeighbors");
        graph.setNeighbors();
        assertEquals(graph.getGraph()[0][0].getNeighbors().length, 4);
    }


    /**
     * Test of getGraphWidth method, of class Graph.
     */
    @Test
    public void testGetGraphWidth() {
        System.out.println("getGraphWidth");
        assertEquals(graph.getGraphWidth(), 5);
    }

    /**
     * Test of getGraphHeight method, of class Graph.
     */
    @Test
    public void testGetGraphHeight() {
        System.out.println("getGraphHeight");
        assertEquals(graph.getGraphHeight(), 5);
    }

    /**
     * Test of testSet method, of class Graph.
     */
    @Test
    public void testTestSet() {
        graph.testSet(0, 0, 0, 0);
        int[] xy = graph.getStart().getXY();
        assertEquals(xy[0], 0);
        xy = graph.getGoal().getXY();
        assertEquals(xy[0], 0);
    }

    /**
     * Test of getStart method, of class Graph.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        graph.testSet(0, 0, 0, 0);
        int[] xy = graph.getStart().getXY();
        assertEquals(xy[0], 0);
    }

    /**
     * Test of getGoal method, of class Graph.
     */
    @Test
    public void testGetGoal() {
        System.out.println("getGoal");
        graph.testSet(0, 0, 0, 0);
        int[] xy = graph.getGoal().getXY();
        assertEquals(xy[0], 0);
    }

    /**
     * Test of getGraph method, of class Graph.
     */
    @Test
    public void testGetGraph() {
        System.out.println("getGraph");
        graph.getGraph();
        assertEquals(graph.getGraph()[0].length, 5);
        assertEquals(graph.getGraph().length, 5);
    }


    /**
     * Test of updateColor method, of class Graph.
     */
    @Test
    public void testUpdateColor() {
        System.out.println("updateColor");
        graph.clear();
        for (int i = 0; i < graph.getGraph().length; i++) {
            for (int j = 0; j < graph.getGraph()[0].length; j++) {
                assertEquals(graph.getGraph()[i][j].getColor(), Color.lightGray);
            }
        }
    }

    /**
     * Test of wallify method, of class Graph.
     */
    @Test
    public void testWallify() {
        System.out.println("wallify");
        graph.wallify();
        int walls = 0;
         for (int i = 0; i < graph.getGraph().length; i++) {
            for (int j = 0; j < graph.getGraph()[0].length; j++) {
                if(graph.getGraph()[i][j].isWall()){
                    walls++;
                }
            }
        }
        assertEquals(walls, 8);
    }

    /**
     * Test of clear method, of class Graph.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        graph.clear();
        for (int i = 0; i < graph.getGraph().length; i++) {
            for (int j = 0; j < graph.getGraph()[0].length; j++) {
                assertEquals(graph.getGraph()[i][j].getType(), "Empty");
            }
        }
    }
}
