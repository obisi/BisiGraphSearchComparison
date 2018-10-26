/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.searchalgos;

import bisigraph.domain.Node;
import java.util.Random;

/**
 *
 * @author bisi
 */
public class SearchTester {

    private Node[][] graph;
    private SearchAlgos algos;
    private int gH;
    private int gW;

    /**
     * Builds a new graph with given height and width. If the graph is unsolvable with astar, discard and build a new one.
     * @param width
     * @param height
     */
    public SearchTester(int gW, int gH) {
        this.gH = gH;
        this.gW = gW;
        algos = new SearchAlgos();
        
    }
    
    public boolean Start(){
        long i = -1;
        int j = 0;
        while(i == -1){
            buildGraph(gW, gH);
            i = testAstar();
            j++;
            if(j > 30){
                return false;
            }
        }
        System.out.println("Succeeded in building a solvable map on the " + j + ". try");
        return true;
    }

    
    
    /**
     * Builds a new graph
     * @param Width
     * @param Height
     */
    private void buildGraph(int gW, int gH) {
        
        this.graph = new Node[gW][gH];

        for (int i = 0; i < gW; i++) {
            for (int j = 0; j < gH; j++) {
                graph[i][j] = new Node(i, j);
                Random rnd = new Random();

                if (rnd.nextDouble() < 0.33) {
                    graph[i][j].setWall();
                }

            }
        }
        graph[0][0].setStart();
        graph[graph.length - 1][graph[0].length - 1].setGoal();
        setNeighbors();
    }

    /**
     * Sets neightbors for the nodes in graph
     */
    private void setNeighbors() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (!graph[i][j].isWall()) {
                    if (i > 0 && !graph[i - 1][j].visited() && !graph[i - 1][j].isWall()) {
                        graph[i][j].setNeighbor(graph[i - 1][j]);
                    }
                    if (i < graph.length - 1 && !graph[i + 1][j].visited() && !graph[i + 1][j].isWall()) {
                        graph[i][j].setNeighbor(graph[i + 1][j]);
                    }
                    if (j > 0 && !graph[i][j - 1].visited() && !graph[i][j - 1].isWall()) {
                        graph[i][j].setNeighbor(graph[i][j - 1]);
                    }
                    if (j < graph[0].length - 1 && !graph[i][j + 1].visited() && !graph[i][j + 1].isWall()) {
                        graph[i][j].setNeighbor(graph[i][j + 1]);
                    }
                }

            }
        }
    }
    
    // Builds a copy of the graph. Used, so that the search algos each can use their own graph. 
    // Reseting the original would have worked also.
    
    private Node[][] getGraph() {
        Node[][] cG = new Node[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                cG[i][j] = new Node(i, j);
                if (graph[i][j].isWall()) {
                    cG[i][j].setWall();
                } 
            }
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                Node[] neighbors = graph[i][j].getNeighbors();
                    for (Node n : neighbors) {
                        if(n != null){
                            cG[i][j].setNeighbor(cG[n.getXY()[0]][n.getXY()[1]]);
                        }
                    }
            }
        }
        
        cG[0][0].setStart();
        cG[cG.length - 1][cG[0].length - 1].setGoal();
        return cG;
    }

    /**
     * Runs astar on the copied graph. Returns -1 if graph is unsolvable, otherwise time taken in ms.
     * @return -1 for unsolvable or time taken.
     */
    public long testAstar() {
        Node[][] g = getGraph();
        return algos.astar(g[0][0], g[g.length-1][g[0].length-1]);

    }

    /**
     * Runs DFS on the copied graph. Returns -1 if graph is unsolvable, otherwise time taken in ms.
     * @return  -1 for unsolvable or time taken.
     */
    public long testDFS() {
        Node[][] g = getGraph();
        return algos.DFS(g[0][0], g[g.length-1][g[0].length-1]);

    }

    /**
     * Runs BFS on the copied graph. Returns -1 if graph is unsolvable, otherwise time taken in ms.
     * @return  -1 for unsolvable or time taken.
     */
    public long testBFS() {
        Node[][] g = getGraph();
        return algos.BFS(g[0][0], g[g.length-1][g[0].length-1]);
    }

}
