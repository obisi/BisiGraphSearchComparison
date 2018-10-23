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

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i<stack.length; i++){
            if(stack[i] == null){
                s+="NULL\n";
            } else {
                s+= stack[i].toString()+"\n";
            } 
        }
        
        return "BisiStack:\n"+ s;
    }
    
        
    Path[] stack;
    int size;
    
    /** Self made stack last in, first out data structure
     *
     */
    public BisiStack(){
        stack = new Path[8];
        size = -1;
    }
    
    /**
     * Adds Path to stack
     * @param Path
     */
    public void add(Path p){
        size++;
        stack[size] = p;
        if(size == stack.length-1){
            Path[] temp = new Path[stack.length * 2];
            for(int i = 0; i<size; i++){
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
        if(size == -1){
            return null;
        }
        Path p = stack[size];
        size--;
        if(stack.length > 8 && size <= stack.length / 4){
            int length = stack.length / 2;
            Path[] temp = new Path[length];
            for(int i = 0; i<temp.length; i++){
                if(stack[i] == null){
                    break;
                }
                temp[i] = stack[i];
            }
            stack = temp;
        }
        return p;
    }
    
    /**
     * Returns whether stack is empty or not
     * @return boolean
     */
    public boolean isEmpty(){
        if(size == -1){
            return true;
        }
        return false;
    }
    
    
    
    
}
