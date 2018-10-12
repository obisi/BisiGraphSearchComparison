/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.searchalgos;


import bisigraph.datastructures.BisiHeap;
import bisigraph.datastructures.BisiQueue;
import bisigraph.datastructures.BisiStack;
import bisigraph.domain.Node;
import bisigraph.domain.Path;
import bisigraph.domain.Graph;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 *
 * @author bisi
 */
public class GUISearchAlgos {
    
    public Path DFS(JLabel[][] myLabels, Node[][] graph, Node start, Node goal) {
        long startTime = System.currentTimeMillis();
        Path path = new Path(start, null, 0);
        start.visit();
        BisiStack stack = new BisiStack();
        stack.add(path);
        while (!stack.isEmpty()) {
            Path p = stack.poll();
            if (p.getNode().equals(goal)) {
                long endTime = System.currentTimeMillis();
                System.out.println("DFS found a path in: " + (endTime - startTime) + "ms.");
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
    
    public Path BFS(JLabel[][] myLabels, Node[][] graph, Node start, Node goal) {
        long startTime = System.currentTimeMillis();
        Path path = new Path(start, null, 0);
        start.visit();
        BisiQueue que = new BisiQueue();
        que.add(path);
        while (!que.isEmpty()) {
            Path p = que.poll();
            if (p.getNode().equals(goal)) {
                long endTime = System.currentTimeMillis();
                System.out.println("BFS found the shortest path in: " + (endTime - startTime) + "ms.");
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
    
    public Path astar(JLabel[][] myLabels, Node[][] graph, Node start, Node goal) {
        long startTime = System.currentTimeMillis();
        Path path = new Path(start, null, 0);
        start.visit();
        BisiHeap que = new BisiHeap(goal);
        que.add(path);
        while (!que.isEmpty()) {
            Path p = que.poll();
            if (p.getNode().equals(goal)) {
                long endTime = System.currentTimeMillis();
                System.out.println("Astar found the shortest path in: " + (endTime - startTime) + "ms.");
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
    
    
}