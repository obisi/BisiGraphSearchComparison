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

   public Node(int x, int y) {
      type = 0;
      this.color = Color.lightGray;
      this.x = x;
      this.y = y;
      this.neighbors = new Node[4];
      visited = false;
      
   }
    
   public Color getColor() {
      return color;
   }

   public int getType() {
      return type;
   }

   @Override
   public String toString() {
      return Integer.toString(type);
   }
   
    public void setWall() {
        type = 3;
        color = Color.BLACK;
    }

    public void setGoal() {
        type = 1;
        color = Color.RED;
    }

    public void setStart() {
        type = 2;
        color = Color.WHITE;
    }

    public void setEmpty() {
        type = 0;
        color = Color.lightGray;
    }
    
    public void setPath() {
        type = 5;
        color = Color.CYAN;
    }
    
    public void setInLine(){
        type = 4;
        color = Color.darkGray;
    }
    
    public void setVisited(){
        visited = true;
        type = 6;
        color = Color.GRAY;
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
    
    public int[] getXY(){
        int[] xy = {this.x, this.y};
        return xy;
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