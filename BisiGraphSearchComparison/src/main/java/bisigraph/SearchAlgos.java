/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph;

import java.util.LinkedList;

/**
 *
 * @author bisi
 */
public class SearchAlgos {

    public Path DFS(Node start, Node goal) {
        Path path = new Path(start, null);
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
                    que.add(pt);
                    n.visit();
                }
            }
        }
        return null;
    }

    public Path BFS(Node start, Node goal) {
        Path path = new Path(start, null);
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
