
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.datastructures;
import bisigraph.domain.Path;

/**
 *
 * @author bisi
 */
public class BisiQueue {
    
    Path[] que;
    int startIndex;
    int endIndex;
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "BisiQue:[]";
        }
        String s = "";
        for (int i = 0; i < que.length; i++) {
            if (que[i] == null) {
                s += "NULL\n";
            } else {
                s += que[i].toString() + "\n";
            }
        }
        return "BisiQue:\n" + s;
    }

    
    /**
     * Self made first in, first out data structure
     */
    public BisiQueue(){
        que = new Path[8];
        startIndex = 0;
        endIndex = 0;
    }
    
    /**
     * Adds new Path to queue
     * @param p
     */
    public void add(Path p){
        que[endIndex] = p;
        endIndex++;
        if(endIndex == que.length){
            Path[] temp = new Path[que.length * 2];
            for(int i = 0; i<que.length; i++){
                temp[i] = que[i];
            }
            que = temp;
        }
    }
    
    /**
     * removes and returns the first added Path from queue
     * @return Path
     */
    public Path poll(){
        Path p = que[startIndex];
        startIndex++;
        if(startIndex == endIndex + 1){
            startIndex = 0;
            endIndex = 0;
            if(que.length / 2 > 8){
                que = new Path[que.length / 2];
            }
        }
        return p;
    }

    /**
     * Returns whether the queue is empty or not.
     * @return boolean
     */
    public boolean isEmpty(){
        if(startIndex == endIndex){
            return true;
        }
        return false;
    }
    
}
