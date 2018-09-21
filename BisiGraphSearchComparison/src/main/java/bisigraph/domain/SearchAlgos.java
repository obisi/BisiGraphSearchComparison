/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author bisi
 */
public class SearchAlgos {

    public Path DFS(Node start, Node goal) {
        Path path = new Path(start, null, 0);
        start.visit();
        LinkedList<Path> que = new LinkedList<Path>();
        que.add(path);
        while (!que.isEmpty()) {
            Path p = que.pollLast();
            if (p.getNode().equals(goal)) {
                return p;
            }
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {
                if (n!=null &&!n.visited()) {
                    Path pt = new Path(n, p, p.getDistance()+1);
                    int[] xy = pt.getNode().getXY();
                    int[] xy2 = p.getNode().getXY();
                    System.out.println("Node " + xy[0] +","+ xy[1] + " type: " + pt.getNode().getType() + " prev: " + "Node " + xy2[0] +","+ xy2[1] + " type: " + p.getNode().getType());
                    que.add(pt);
                    n.visit();
                }
            }
        }
        return null;
    }

    public Path BFS(Node start, Node goal) {
        Path path = new Path(start, null, 0);
        start.visit();
        LinkedList<Path> que = new LinkedList<Path>();
        que.add(path);
        while (!que.isEmpty()) {
            Path p = que.pollFirst();
            if (p.getNode().equals(goal)) {
                return p;
            }
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {
                if (n != null && !n.visited()) {
                    Path pt = new Path(n, p, p.getDistance()+1);
                    int[] xy = pt.getNode().getXY();
                    int[] xy2 = p.getNode().getXY();
                    System.out.println("Node " + xy[0] +","+ xy[1] + " type: " + pt.getNode().getType() + " prev: " + "Node " + xy2[0] +","+ xy2[1] + " type: " + p.getNode().getType());
                    que.add(pt);
                    n.visit();
                }
            }
        }
        return null;
    }

    public Path astar(Node start, Node goal) {
        PriorityQueue<Path> prioQue = new PriorityQueue<>();
        Path p = new Path(start, null, 0);
        prioQue.add(p);
        while (!prioQue.isEmpty()) {
            p = prioQue.poll();
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {
                if (n == goal) {
                    return new Path(n, p, p.getDistance()+1);
                }
                Path pt = new Path(n, p, p.getDistance()+1);
                prioQue.add(pt);
            }
        }
        return null;
    }

}
