/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
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
    
    public void setNeighbors() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j].getType() != 3) {
                    if (i > 0 && !graph[i - 1][j].visited() && graph[i - 1][j].getType() != 3) {
                        graph[i][j].setNeighbor(graph[i - 1][j]);
                    }
                    if (i < graph.length - 1 && !graph[i + 1][j].visited() && graph[i + 1][j].getType() != 3) {
                        graph[i][j].setNeighbor(graph[i + 1][j]);
                    }
                    if (j > 0 && !graph[i][j - 1].visited() && graph[i][j - 1].getType() != 3) {
                        graph[i][j].setNeighbor(graph[i][j - 1]);
                    }
                    if (j < graph[0].length - 1 && !graph[i][j + 1].visited() && graph[i][j + 1].getType() != 3) {
                        graph[i][j].setNeighbor(graph[i][j + 1]);
                    }
                }

            }
        }
    }
    
    // 
    
    public void testSet(int x1, int y1, int x2, int y2){
        goal[0] = x1;
        goal[1] = y1;
        start[0] = x2;
        start[1] = y2;
    }
    
    public Node getStart(){
        return graph[start[0]][start[1]];
    }
    public Node getGoal(){
        return graph[goal[0]][goal[1]];
    }

    public Node[][] getGraph() {
        return graph;
    }
    
    
    public void setGoal(){
       myListener.setGoal();
    }
    
    public void setStart(){
        myListener.setStart();
    }
    
    public void setWall(){
        myListener.setWall();
    }
    
    public void setEmpty(){
        myListener.setEmpty();
    }


    public void labelPressedGoal(JLabel label) {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                if (label == myLabels[i][j]) {
                    myListener.setAllFalse();
                    myListener.setGoal();
                    if(goal[0] != -1){
                        graph[goal[0]][goal[1]].setEmpty();
                        myLabels[goal[0]][goal[1]].setBackground(graph[goal[0]][goal[1]].getColor());
                    }
                    graph[i][j].setGoal();
                    goal[0] = i;
                    goal[1] = j;
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                    myListener.setAllFalse();
                }
            }
        }
    }

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
                }
            }
        }
    }

    public void labelPressedWall(JLabel label) {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                if (label == myLabels[i][j]) {
                    myListener.setAllFalse();
                    myListener.setWall();
                    graph[i][j].setWall();
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                }
            }
        }
    }

    public void labelPressedEmpty(JLabel label) {
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[i].length; j++) {
                if (label == myLabels[i][j]) {
                    myListener.setAllFalse();
                    myListener.setEmpty();
                    graph[i][j].setEmpty();
                    myLabels[i][j].setBackground(graph[i][j].getColor());
                }
            }
        }
    }
    
    public void updateColor(){
        for(int i = 0; i<myLabels.length;i++){
            for(int j = 0; j<myLabels[0].length;j++){
                myLabels[i][j].setBackground(graph[i][j].getColor());
            }
        }
    }
    
    public void wallify() {
        
        for (int i = 0; i < myLabels.length; i++) {
            for (int j = 0; j < myLabels[0].length; j++) {
                graph[i][j].setWall();
                myLabels[i][j].setBackground(graph[i][j].getColor());
            }
        }

    }
    
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


    public Path DFS() {
        setNeighbors();
        Path path = new Path(graph[start[0]][start[1]], null);
        graph[start[0]][start[1]].visit();
        LinkedList<Path> que = new LinkedList<Path>();
        que.add(path);
        while (!que.isEmpty()) {
            Path p = que.pollLast();
            if (p.getNode().equals(graph[goal[0]][goal[1]])) {
                drawPath(p);
            }
            p.getNode().setVisited();
            int[] xy = p.getNode().getXY();
            myLabels[xy[0]][xy[1]].setBackground(p.getNode().getColor());
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {
                if (n != null && !n.visited()) {
                    n.setInLine();
                    Path pt = new Path(n, p);
                    que.add(pt);
                    xy = pt.getNode().getXY();
                    myLabels[xy[0]][xy[1]].setBackground(pt.getNode().getColor());
                    n.visit();
                }
            }
        }
        return null;
    }

    public Path BFS() {
        setNeighbors();
        Path path = new Path(graph[start[0]][start[1]], null);
        graph[start[0]][start[1]].visit();
        LinkedList<Path> que = new LinkedList<Path>();
        que.add(path);
        while (!que.isEmpty()) {
            Path p = que.pollFirst();
            if (p.getNode().equals(graph[goal[0]][goal[1]])) {
                drawPath(p);
            }
            p.getNode().setVisited();
            int[] xy = p.getNode().getXY();
            myLabels[xy[0]][xy[1]].setBackground(p.getNode().getColor());
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {
                if (n != null && !n.visited()) {
                    n.setInLine();
                    Path pt = new Path(n, p);
                    que.add(pt);
                    xy = pt.getNode().getXY();
                    myLabels[xy[0]][xy[1]].setBackground(pt.getNode().getColor());
                    n.visit();
                }
            }
        }
        return null;
    }

    public void drawPath(Path p) {
        updateColor();
        while (p.getPrevious() != null) {
            p = p.getPrevious();
            p.getNode().setPath();
            int[] xy = p.getNode().getXY();
            myLabels[xy[0]][xy[1]].setBackground(p.getNode().getColor());
            System.out.println(p.toString());
        }
    }
    


}
