/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph;

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
}

