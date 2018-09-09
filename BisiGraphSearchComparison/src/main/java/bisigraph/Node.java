/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph;

import java.util.Objects;

/**
 *
 * @author bisi
 */
public class Node {

    // 0=empty, 1=goal, 2=start, 3=wall
    private int type;

    private int x;
    private int y;
    private boolean visited;
    
    // muuttuja värille, jotta voi pitää yllä piirrosta.

    private Node[] neighbors;

    public Node(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.neighbors = new Node[4];
        visited = false;
    }

    public int getType() {
        return type;
    }
    
    public void setWall() {
        type = 3;
    }
    
    public void setGoal() {
        type = 1;
    }
    
    public void setStart() {
        type = 2;
    }

    public Node[] getNeighbors() {
        return this.neighbors;
    }
    
    public void visit(){
        visited = true;
    }
    
    public boolean visited(){
        return visited;
    }


    @Override
    public int hashCode() {
        
         // paska hash, pitää keksiä parempi
         
         
        int hash = 7;
        hash = 97 * hash + this.type;
        hash = 97 * hash + this.x;
        hash = 97 * hash + this.y;
        return hash;
    }
    
    public boolean equals(Node n) {
        if (this.x != n.x) {
            return false;
        }
        if (this.y != n.y) {
            return false;
        }
        return true;
    }


    public void setNeighbor(Node n) {
        for(int i = 0; i<4; i++){
            if(neighbors[i] == null){
                neighbors[i] = n;
                break;
            }
        }
    }
    
    
    
}
