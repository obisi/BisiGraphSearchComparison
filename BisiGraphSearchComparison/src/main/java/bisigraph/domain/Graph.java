/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;

import bisigraph.datastructures.BisiHeap;
import bisigraph.datastructures.BisiQueue;
import bisigraph.datastructures.BisiStack;
import bisigraph.searchalgos.GUISearchAlgos;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author bisi
 */
public class Graph extends JPanel {

    private int[] goal = new int[2];
    private int[] start = new int[2];

    private Node[][] graph;
    private JLabel[][] myLabels;
    
    private GUISearchAlgos gsa = new GUISearchAlgos();

    private MyMouseListener myListener;

    /**
     * Builds two new graphs, one for GUI and one for searches. Parameters are
     * height and width of the graph, and the width of a cell of the gui graph.
     *
     * @param x width
     * @param y height
     * @param cellWidth width of the cell in gui
     */
    public Graph(int x, int y, int cellWidth) {
        goal[0] = -1;
        goal[1] = -1;
        start[0] = -1;
        start[1] = -1;

        graph = new Node[x][y];
        myLabels = new JLabel[x][y];

        myListener = new MyMouseListener(this);
        Dimension labelPrefSize = new Dimension(cellWidth, cellWidth);
        setLayout(new GridLayout(x, y));
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                JLabel myLabel = new JLabel();
                myLabel = new JLabel();
                myLabel.setOpaque(true);
                Node myColor = new Node(i, j);
                graph[i][j] = myColor;
                myLabel.setBackground(myColor.getColor());
                myLabel.addMouseListener(myListener);
                myLabel.setPreferredSize(labelPrefSize);
                add(myLabel);
                myLabels[i][j] = myLabel;
            }
        }
    }

    /**
     * Sets neightbours for the search graph Nodes
     */
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

    public int getGraphWidth() {
        return myLabels.length;
    }

    public int getGraphHeight() {
        return myLabels[0].length;
    }

    // 
    /**
     * function to set goal and start for testing purposes.
     *
     * @param x1 goal x
     * @param y1 goal y
     * @param x2 start x
     * @param y2 start y
     */
    public void testSet(int x1, int y1, int x2, int y2) {
        goal[0] = x1;
        goal[1] = y1;
        start[0] = x2;
        start[1] = y2;
    }

    /**
     * Returns the coordinates for the start node
     *
     * @return int[], [0] = x, [1] = y
     */
    public Node getStart() {
        return graph[start[0]][start[1]];
    }

    /**
     * Returns the coordinates for the goal node
     *
     * @return int[], [0] = x, [1] = y
     */
    public Node getGoal() {
        return graph[goal[0]][goal[1]];
    }

    /**
     * Returns the search graph
     *
     * @return Graph[][]
     */
    public Node[][] getGraph() {
        return graph;
    }

    /**
     * gui functionality for choosing goal node
     */
    public void setGoal() {
        myListener.setGoal();
    }

    /**
     * gui functionality for choosing start node
     */
    public void setStart() {
        myListener.setStart();
    }

    /**
     * gui functionality for choosing wall nodes
     */
    public void setWall() {
        myListener.setWall();
    }

    /**
     * gui functionality for choosing empty nodes
     */
    public void setEmpty() {
        myListener.setEmpty();
    }

    /**
     * Clicked node is turned into a goal node, if goal selection is on
     *
     * @param label
     */
    public void labelPressedGoal(JLabel label) {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                if (label == myLabels[i][j]) {
                    myListener.setGoal();
                    if (goal[0] != -1) {
                        graph[goal[0]][goal[1]].setEmpty();
                        myLabels[goal[0]][goal[1]].setBackground(graph[goal[0]][goal[1]].getColor());
                    }
                    graph[i][j].setGoal();
                    goal[0] = i;
                    goal[1] = j;
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                    return;
                }
            }
        }
    }

    /**
     * Clicked node is turned into a start node, if start selection is on
     *
     * @param label
     */
    public void labelPressedStart(JLabel label) {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                if (label == myLabels[i][j]) {
                    myListener.setStart();
                    if (start[0] != -1) {
                        graph[start[0]][start[1]].setEmpty();
                        myLabels[start[0]][start[1]].setBackground(graph[start[0]][start[1]].getColor());
                    }
                    graph[i][j].setStart();
                    start[0] = i;
                    start[1] = j;
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                    return;
                }
            }
        }
    }

    /**
     * Clicked node is turned into a wall node, if wall selection is on
     *
     * @param label
     */
    public void labelPressedWall(JLabel label) {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                if (label == myLabels[i][j]) {
                    myListener.setWall();
                    graph[i][j].setWall();
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                    return;
                }
            }
        }
    }

    /**
     * Clicked node is turned into an empty node, if empty selection is on
     *
     * @param label
     */
    public void labelPressedEmpty(JLabel label) {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                if (label == myLabels[i][j]) {
                    if (i == goal[0] && j == goal[1]) {
                        goal[0] = -1;
                        goal[1] = -1;
                    }
                    if (i == start[0] && j == start[1]) {
                        start[0] = -1;
                        start[1] = -1;
                    }
                    myListener.setEmpty();
                    graph[i][j].setEmpty();
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                    return;
                }
            }
        }
    }

    /**
     * Updates colors in the GUI graph
     */
    public void updateColor() {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[0].length; j++) {
                myLabels[i][j].setBackground(graph[i][j].getColor());
            }
        }
    }

    /**
     * Reset the graph, then randomly walls 1/3 of the area.
     */
    public void wallify() {
        clear();

        int walls = (graph[0].length * graph.length) / 3;
        int i = 0;

        Random rnd = new Random();

        while (i < walls) {
            int x = rnd.nextInt(graph.length);
            int y = rnd.nextInt(graph.length);
            if (graph[x][y].isEmpty()) {
                graph[x][y].setWall();
                myLabels[x][y].setBackground(graph[x][y].getColor());
                i++;
            }
        }

    }

    /**
     * Clears the graph to empty and light grey
     */
    public void clear() {
        goal[0] = -1;
        goal[1] = -1;
        start[0] = -1;
        start[1] = -1;

        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[0].length; j++) {
                graph[i][j].setEmpty();
                myLabels[i][j].setBackground(graph[i][j].getColor());
            }
        }
    }

    /**
     * Resets the graph to empty and light grey while keeping walls, start and goal
     */
    private void reset() {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[0].length; j++) {
                if (!graph[i][j].isWall()) {
                    graph[i][j].setEmpty();
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                }

            }
        }
        graph[start[0]][start[1]].setStart();
        myLabels[start[0]][start[1]].setBackground(graph[start[0]][start[1]].getColor());
        graph[goal[0]][goal[1]].setGoal();
        myLabels[goal[0]][goal[1]].setBackground(graph[goal[0]][goal[1]].getColor());
    }

    /**
     * DFS, returns a path to goal node from the start node
     *
     * @return Path
     */
    public void DFS() {
        if (goal[0] == -1 || start[0] == -1) {
            return;
        }
        reset();
        setNeighbors();
        drawPath(gsa.DFS(myLabels, graph, graph[start[0]][start[1]], graph[goal[0]][goal[1]]));
    }

    /**
     * BFS, returns the shortest path to goal node from the start node
     *
     * @return
     */
    public void BFS() {
        if (goal[0] == -1 || start[0] == -1) {
            return;
        }
        reset();
        setNeighbors();
        drawPath(gsa.BFS(myLabels, graph, graph[start[0]][start[1]], graph[goal[0]][goal[1]]));
    }

    public void astar() {
        if (goal[0] == -1 || start[0] == -1) {
            return;
        }
        reset();
        setNeighbors();
        drawPath(gsa.astar(myLabels, graph, graph[start[0]][start[1]], graph[goal[0]][goal[1]]));
    }

    /**
     * Draws out the found path from start to goal.
     *
     * @param p
     */
    public void drawPath(Path p) {
        if(p == null){
            return;
        }
        updateColor();
        while (p.getPrevious() != null) {
            p = p.getPrevious();
            p.getNode().setPath();
            int[] xy = p.getNode().getXY();
            if(xy[0] == start[0] && xy[1] == start[1]){
                break;
            }
            myLabels[xy[0]][xy[1]].setBackground(p.getNode().getColor());
        }
    }

}
