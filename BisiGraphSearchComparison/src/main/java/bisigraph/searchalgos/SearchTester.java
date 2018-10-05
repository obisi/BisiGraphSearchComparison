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
    private int[][] walls;
    private SearchAlgos algos;

    public SearchTester(int gW, int gH) {

        algos = new SearchAlgos();

        this.graph = new Node[gW][gH];
        this.walls = new int[gW][gH];

        int walls = (gW * gH) / 3;

        for (int i = 0; i < gW; i++) {
            for (int j = 0; j < gH; j++) {
                graph[i][j] = new Node(i, j);
                Random rnd = new Random();

                if (walls > 0 && rnd.nextDouble() > 0.34) {
                    graph[i][j].setWall();
                }

            }
        }
        graph[0][0].setStart();
        graph[graph.length - 1][graph[0].length - 1].setGoal();

    }

    public void setNeighbors() {
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

    private Node[][] getGraph() {
        Node[][] cG = new Node[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                cG[i][j] = new Node(i, j);
                if (graph[i][j].isWall()) {
                    cG[i][j].setWall();
                } else {
                    Node[] neighbors = graph[i][j].getNeighbors();
                    for (Node n : neighbors) {
                        if(n != null){
                            cG[i][j].setNeighbor(new Node(n.getXY()[0], n.getXY()[1]));
                        }
                    }
                }
            }
        }
        cG[0][0].setStart();
        cG[cG.length - 1][cG[0].length - 1].setGoal();
        return cG;
    }

    public long testAstar() {
        Node[][] g = getGraph();
        return algos.astar(g[0][0], g[g.length-1][g[0].length-1]);

    }

    public long testDFS() {
        Node[][] g = getGraph();
        return algos.astar(g[0][0], g[g.length][g[0].length]);

    }

    public long testBFS() {
        Node[][] g = getGraph();
        return algos.astar(g[0][0], g[g.length][g[0].length]);
    }

}
