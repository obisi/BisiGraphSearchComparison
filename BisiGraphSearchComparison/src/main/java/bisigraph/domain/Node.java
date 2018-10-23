/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.domain;
import java.awt.Color;


/**
 *
 * @author bisi
 */
public class Node{

   private Color color;
   private int type;
   private int x;
   private int y;
   private boolean visited;
   private Node[] neighbors;

    /**
     * Node object, default type is unvisited and empty
     * @param x set x-coordinate
     * @param y set y-coordinate
     */
    public Node(int x, int y) {
      type = 0;
      this.color = Color.lightGray;
      this.x = x;
      this.y = y;
      this.neighbors = new Node[4];
      visited = false;
      
   }
    
    /**
     *
     * @return color of the Node
     */
    public Color getColor() {
      return color;
   }

    /**
     *
     * @return String value of the object type
     */
    public String getType() {
      if(type == 0){
          return "Empty";
      } else if(type == 1){
          return "Goal";
      } else if(type == 2){
          return "Start";
      } else if(type == 3){
          return "Wall";
      } else if(type == 4){
          return "in Line";
      } else if(type == 5){
          return "Path";
      } else{
          return "Visited";
      }
   }

   @Override
   public String toString() {
      return Integer.toString(type) + "xy:"+ Integer.toString(x) + "," + Integer.toString(y);
   }
   
    /**
     * Sets the Node to wall-type
     */
    public void setWall() {
        type = 3;
        color = Color.BLACK;
    }
    /**
     * Returns whether Node is wall-type
     */
    public boolean isWall() {
        return type == 3;
    }
    
    public boolean isEmpty() {
        return type == 0;
    }

    /**
     * Sets the Node to goal-type
     */
    public void setGoal() {
        type = 1;
        color = Color.RED;
    }

    /**
     * Sets the Node to start-type
     */
    public void setStart() {
        type = 2;
        color = Color.WHITE;
    }

    /**
     * Sets the Node to empty-type, reset visited and neightbor list
     */
    public void setEmpty() {
        neighbors = new Node[4];
        visited = false;
        type = 0;
        color = Color.lightGray;
    }
    
    /**
     * Sets the Node to path-type
     */
    public void setPath() {
        type = 5;
        color = Color.CYAN;
    }
    
    /**
     * Sets the Node to inLine-type
     */
    public void setInLine(){
        type = 4;
        color = Color.darkGray;
    }
    
    /**
     * Sets the Node to visited-type
     */
    public void setVisited(){
        visited = true;
        type = 6;
        color = Color.GRAY;
    }

    /**
     * Returns a size four array of neighbors.
     * @return Node[]
     */
    public Node[] getNeighbors() {
        return this.neighbors;
    }
    
    /**
     * set visited value to true
     */
    public void visit(){
        visited = true;
    }
    
    /**
     * Return whether node is visited.
     * @return boolean
     */
    public boolean visited(){
        return visited;
    }
    
    /**
     * Returns int[2] array of x and y coordinate
     * @return int[]
     */
    public int[] getXY(){
        int[] xy = {this.x, this.y};
        return xy;
    }


    /**
     * Check if the x,y coordinates are the same
     * @param Node to compare to
     * @return boolean
     */
    public boolean equals(Node n) {
        if (this.x != n.x) {
            return false;
        }
        if (this.y != n.y) {
            return false;
        }
        return true;
    }

    /**
     * Sets a new neighbor if the node is not wall type.
     * @param Node
     */
    public void setNeighbor(Node n) {
        if(n.type == 3){
            return;
        }
        for(int i = 0; i<4; i++){
            if(neighbors[i] == null){
                neighbors[i] = n;
                break;
            }
        }
    }

}