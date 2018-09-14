/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;

import java.util.LinkedList;

/**
 *
 * @author bisi
 */
public class SearchAlgos {

    public Path DFS(Node start, Node goal) {
        Path path = new Path(start, null);
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
                    Path pt = new Path(n, p);
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
        Path path = new Path(start, null);
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
                    Path pt = new Path(n, p);
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

    public Path Astar(Node start, Node goal) {
        return null;
    }

}
