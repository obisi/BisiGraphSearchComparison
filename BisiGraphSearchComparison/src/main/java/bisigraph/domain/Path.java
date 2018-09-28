/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;

/**
 *
 * @author bisi
 */
public class Path {
    private Path prev;
    private Node node;
    private int distance;

    /**
     * Path class, keeps track of Node, previous path and the travelled distance so far.
     * @param node Node
     * @param prev Previous path
     * @param dist Distance so far
     */
    public Path(Node node, Path prev, int dist) {
        this.node = node;
        this.prev = prev;
        distance = dist;
    }

    /**
     * Returns the previous path.
     * @return Path
     */
    public Path getPrevious() {
        return prev;
    }

    /**
     * Returns the node.
     * @return Node
     */
    public Node getNode() {
        return node;
    }
    
    /**
     * Returns the travelled distance
     * @return distance
     */
    public int getDistance() {
        return distance;
    }
    
    /**
     * Calculates the distance between this node and the given one.
     * @param n Node where we calculate distance to.
     * @return Distance between two nodes
     */
    public int distanceToNode(Node n) {
        int x = node.getXY()[0] - n.getXY()[0];
        int y = node.getXY()[1] - n.getXY()[1];
        return (int) Math.sqrt((x*x*10) + (y*y*10));    
    }
    
    /**
     * Compares travelled distance or distance to given node with another Path object. Required for min heap. *DOES NOT WORK PROPERLY*
     * @param p Path to which this path is compared to
     * @param n Node where distance is calculated to
     * @return +, - or 0 whether goal is closer given travelled distance.
     */
    public int compare(Path p, Node n) {
        
        if((distanceToNode(n) + distance) == (p.distanceToNode(n) + p.distance)){
            return distance - p.getDistance();
        }
        return (distanceToNode(n) + distance) - (p.distanceToNode(n) + p.distance);

    }
    
    @Override
    public String toString(){
        int[] xy = node.getXY();
        String x = Integer.toString(xy[0]);
        String y = Integer.toString(xy[1]);
        return x + "," + y +": " + node.getType() + ", travelled dist: " + distance;
    }
}

