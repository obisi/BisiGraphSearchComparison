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
public class BisiStack {
    
        
    Path[] stack;
    int index;
    int size;
    
    /** Self made stack last in, first out data structure
     *
     */
    public BisiStack(){
        stack = new Path[8];
        index = 0;
        size = 0;
    }
    
    /**
     * Adds Path to stack
     * @param Path
     */
    public void add(Path p){
        stack[size] = p;
        size++;
        if(size == stack.length){
            Path[] temp = new Path[stack.length * 2];
            for(int i = 0; i<stack.length; i++){
                temp[i] = stack[i];
            }
            stack = temp;
        }
    }
    
    /**
     * removes Path from stack
     * @return Last added Path
     */
    public Path poll(){
        if(size == 0){
            index = 0;
            return null;
        }
        Path p = stack[index];
        index++;
        if(index == size){
            int length = stack.length;
            if(stack.length > 8){
                length = stack.length / 2;
            }
            Path[] temp = new Path[length];
            for(int i = 0; i<temp.length; i++){
                if(stack[index+i] == null){
                    break;
                }
                temp[i] = stack[index + i];
            }
            size = 0;
            index = 0;
        }
        return p;
    }
    
    /**
     * Returns whether stack is empty or not
     * @return boolean
     */
    public boolean isEmpty(){
        if(size <= 0){
            return true;
        }
        return false;
    }
    
    
}
