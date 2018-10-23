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

/**
 *
 * @author bisi
 */
// These functions are for later use, a base for a different kind of implemention.
public class SearchAlgos {

    public long DFS(Node start, Node goal) {
        long now = System.currentTimeMillis();
        Path path = new Path(start, null, 0);
        start.visit();
        BisiStack stack = new BisiStack();
        stack.add(path);
        while (!stack.isEmpty()) {
            Path p = stack.poll();
            if(p == null){
                continue;
            }
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {
                if (n != null && !n.visited()) {
                    if (n.equals(goal)) {
                        return System.currentTimeMillis() - now;
                    }
                    
                    Path pt = new Path(n, p, p.getDistance() + 1);
                    stack.add(pt);
                    n.visit();
                }
            }
        }
        return 0;
    }

    public long BFS(Node start, Node goal) {
        long now = System.currentTimeMillis();
        Path path = new Path(start, null, 0);
        start.visit();
        BisiQueue que = new BisiQueue();
        que.add(path);
        while (!que.isEmpty()) {
            Path p = que.poll();
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {
                if (n != null && !n.visited()) {
                    if(n.equals(goal)){
                        return System.currentTimeMillis() - now;
                    }
                    Path pt = new Path(n, p, p.getDistance() + 1);
                    que.add(pt);
                    n.visit();
                }
            }
        }
        return 0;
    }

    public long astar(Node start, Node goal) {
        long now = System.currentTimeMillis();
        BisiHeap que = new BisiHeap(goal);
        Path p = new Path(start, null, 0);
        que.add(p);
        while (!que.isEmpty()) {
            p = que.poll();
            Node[] neighbors = p.getNode().getNeighbors();
            for (Node n : neighbors) {

                if (n != null && !n.visited()) {
                    if (n.equals(goal)) {
                        return System.currentTimeMillis() - now;
                    }
                    Path pt = new Path(n, p, p.getDistance() + 1);
                    que.add(pt);
                    n.visit();
                }

            }
        }
        return 0;
    }

}
