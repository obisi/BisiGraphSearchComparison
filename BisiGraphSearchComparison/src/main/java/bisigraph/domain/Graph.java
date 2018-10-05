/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;

import bisigraph.datastructures.BisiHeap;
import bisigraph.datastructures.BisiQueue;
import bisigraph.datastructures.BisiStack;
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
     * Sets neightbours for the search graph
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
    
    public int getCellWidth(){
        return myLabels[0][0].getWidth();
    }
    
    public int getGraphWidth(){
        return myLabels.length;
    }
    
    public int getGraphHeight(){
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
     * Function for GUI, user can choose goal node after button is pressed
     *
     * @param label
     */
    public void labelPressedGoal(JLabel label) {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                if (label == myLabels[i][j]) {
                    myListener.setAllFalse();
                    myListener.setGoal();
                    if (goal[0] != -1) {
                        graph[goal[0]][goal[1]].setEmpty();
                        myLabels[goal[0]][goal[1]].setBackground(graph[goal[0]][goal[1]].getColor());
                    }
                    graph[i][j].setGoal();
                    goal[0] = i;
                    goal[1] = j;
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                    myListener.setAllFalse();
                    return;
                }
            }
        }
    }

    /**
     * Function for GUI, user can choose start node after button is pressed
     *
     * @param label
     */
    public void labelPressedStart(JLabel label) {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                if (label == myLabels[i][j]) {
                    myListener.setAllFalse();
                    myListener.setStart();
                    if (start[0] != -1) {
                        graph[start[0]][start[1]].setEmpty();
                        myLabels[start[0]][start[1]].setBackground(graph[start[0]][start[1]].getColor());
                    }
                    graph[i][j].setStart();
                    start[0] = i;
                    start[1] = j;
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                    myListener.setAllFalse();
                    return;
                }
            }
        }
    }

    /**
     * Function for GUI, user can choose wall nodes after button is pressed
     *
     * @param label
     */
    public void labelPressedWall(JLabel label) {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                if (label == myLabels[i][j]) {
                    myListener.setAllFalse();
                    myListener.setWall();
                    graph[i][j].setWall();
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                    return;
                }
            }
        }
    }

    /**
     * Function for GUI, user can choose empty nodes after button is pressed
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
                    myListener.setAllFalse();
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
        reset();
        
        int walls = (graph[0].length * graph.length) / 3;
        int i = 0;
        
        Random rnd = new Random();
        
        while(i < walls){
            int x = rnd.nextInt(graph.length);
            int y = rnd.nextInt(graph.length);
            if(graph[x][y].isEmpty()){
                graph[x][y].setWall();
                myLabels[x][y].setBackground(graph[x][y].getColor());
                i++;
            } 
        }

    }

    /**
     * Resets the graph to empty and light grey *DOES NOT WORK PROPERLY YET*
     */
    public void reset() {
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
     * DFS, returns a path to goal node from the start node
     *
     * @return Path
     */
    public Path DFS() {
        if (goal[0] == -1 || start[0] == -1) {
            return null;
        }
        long aikaAlussa = System.currentTimeMillis();
        setNeighbors();
        Path path = new Path(graph[start[0]][start[1]], null, 0);
        graph[start[0]][start[1]].visit();
        BisiStack stack = new BisiStack();
        stack.add(path);
        while (!stack.isEmpty()) {
            Path p = stack.poll();
            if (p.getNode().equals(graph[goal[0]][goal[1]])) {
                long aikaLopussa = System.currentTimeMillis();
                System.out.println("DFS found a path in: " + (aikaLopussa - aikaAlussa) + "ms.");
                drawPath(p);
                return p;
            }
            p.getNode().setVisited();
            int[] xy = p.getNode().getXY();
            myLabels[xy[0]][xy[1]].setBackground(p.getNode().getColor());
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {
                if (n != null && !n.visited()) {
                    n.setInLine();
                    Path pt = new Path(n, p, p.getDistance() + 1);
                    stack.add(pt);
                    xy = pt.getNode().getXY();
                    myLabels[xy[0]][xy[1]].setBackground(pt.getNode().getColor());
                    n.visit();
                }
            }
        }
        return null;
    }

    /**
     * BFS, returns the shortest path to goal node from the start node
     *
     * @return
     */
    public Path BFS() {
        if (goal[0] == -1 || start[0] == -1) {
            return null;
        }
        long aikaAlussa = System.currentTimeMillis();
        setNeighbors();
        Path path = new Path(graph[start[0]][start[1]], null, 0);
        graph[start[0]][start[1]].visit();
        BisiQueue que = new BisiQueue();
        que.add(path);
        while (!que.isEmpty()) {
            Path p = que.poll();
            if (p.getNode().equals(graph[goal[0]][goal[1]])) {
                long aikaLopussa = System.currentTimeMillis();
                System.out.println("BFS found the shortest path in: " + (aikaLopussa - aikaAlussa) + "ms.");
                drawPath(p);
                return p;
            }
            p.getNode().setVisited();
            int[] xy = p.getNode().getXY();
            myLabels[xy[0]][xy[1]].setBackground(p.getNode().getColor());
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {
                if (n != null && !n.visited()) {
                    n.setInLine();
                    Path pt = new Path(n, p, p.getDistance() + 1);
                    que.add(pt);
                    xy = pt.getNode().getXY();
                    myLabels[xy[0]][xy[1]].setBackground(pt.getNode().getColor());
                    n.visit();
                }
            }
        }
        return null;
    }

    public Path astar() {
        if (goal[0] == -1 || start[0] == -1) {
            return null;
        }
        long aikaAlussa = System.currentTimeMillis();
        setNeighbors();
        Path path = new Path(graph[start[0]][start[1]], null, 0);
        graph[start[0]][start[1]].visit();
        BisiHeap que = new BisiHeap(graph[goal[0]][goal[1]]);
        que.add(path);
        while (!que.isEmpty()) {
            Path p = que.poll();
            if (p.getNode().equals(graph[goal[0]][goal[1]])) {
                long aikaLopussa = System.currentTimeMillis();
                System.out.println("Astar found the shortest path in: " + (aikaLopussa - aikaAlussa) + "ms.");
                drawPath(p);
                return p;
            }
            p.getNode().setVisited();
            int[] xy = p.getNode().getXY();
            myLabels[xy[0]][xy[1]].setBackground(p.getNode().getColor());
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {
                if (n != null && !n.visited()) {
                    n.setInLine();
                    Path pt = new Path(n, p, p.getDistance() + 1);
                    que.add(pt);
                    xy = pt.getNode().getXY();
                    myLabels[xy[0]][xy[1]].setBackground(pt.getNode().getColor());
                    n.visit();
                }
            }
        }
        return null;
    }

    /**
     * Draws out the found path from start to goal.
     *
     * @param p
     */
    public void drawPath(Path p) {
        updateColor();
        while (p.getPrevious() != null) {
            p = p.getPrevious();
            p.getNode().setPath();
            int[] xy = p.getNode().getXY();
            myLabels[xy[0]][xy[1]].setBackground(p.getNode().getColor());
        }
    }

}
