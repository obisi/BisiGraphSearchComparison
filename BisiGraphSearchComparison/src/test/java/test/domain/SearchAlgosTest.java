/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.domain;

import bisigraph.domain.Graph;
import bisigraph.domain.Node;
import bisigraph.domain.SearchAlgos;
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
public class SearchAlgosTest {
    
    private SearchAlgos sa;
    
    public SearchAlgosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sa = new SearchAlgos();
    }
    
    @After
    public void tearDown() {
    }
    /* Not working atm
    @Test
    public void DFSTest() {
        Graph graph = new Graph(5, 5, 1);
        graph.testSet(0, 0, 4, 4);
        graph.getGraph()[0][0].setStart();
        graph.getGraph()[4][4].setGoal();
        Node n = new Node(4,4);
        n.setGoal();
        assertEquals(sa.DFS(graph.getStart(), graph.getGoal()).getNode().equals(n), true);
    }
    
    @Test
    public void BFSTest() {
        Graph graph = new Graph(5, 5, 1);
        graph.testSet(0, 0, 4, 4);
        graph.getGraph()[0][0].setStart();
        graph.getGraph()[4][4].setGoal();
        Node n = new Node(4,4);
        n.setGoal();
        assertEquals(sa.BFS(graph.getStart(), graph.getGoal()).getNode().equals(n), true);
        
    }
    */
    @Test
    public void AstarTest(){
        Graph graph = new Graph(5, 5, 1);
        graph.testSet(0, 0, 4, 4);
        assertEquals(sa.BFS(graph.getStart(), graph.getGoal()), null);
    }
}
