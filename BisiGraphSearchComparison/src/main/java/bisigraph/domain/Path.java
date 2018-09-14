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


    public Path(Node node, Path prev) {
        this.node = node;
        this.prev = prev;
    }

    public Path getPrevious() {
        return prev;
    }

    public Node getNode() {
        return node;
    }
    
    @Override
    public String toString(){
        int[] xy = node.getXY();
        String x = Integer.toString(xy[0]);
        String y = Integer.toString(xy[1]);
        return x + "," + y +": " +Integer.toString(node.getType());
    }
}

