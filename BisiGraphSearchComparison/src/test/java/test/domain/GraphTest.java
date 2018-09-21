/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.domain;

import bisigraph.domain.Graph;
import bisigraph.domain.Node;
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

    @Test
    public void getStartTest() {
        graph.testSet(0, 0, 0, 0);
        int[] xy = graph.getStart().getXY();
        assertEquals(xy[0], 0);
    }
    
    @Test
    public void getGoalTest(){
        graph.testSet(0, 0, 0, 0);
        int[] xy = graph.getGoal().getXY();
        assertEquals(xy[0], 0);
    }
    
    @Test
    public void getGraph() {
        assertEquals(graph.getGraph().length, 5);
        assertEquals(graph.getGraph()[0].length, 5);
    }
    
    @Test
    public void resetTest(){
        graph.reset();
        for (int i = 0; i < graph.getGraph().length; i++) {
            for (int j = 0; j < graph.getGraph()[0].length; j++) {
                assertEquals(graph.getGraph()[i][j].getType(), "Empty");
            }
        }
    }
}
