/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.datastructures;

import bisigraph.domain.Node;
import bisigraph.domain.Path;

/**
 *
 * @author bisi
 */
public class BisiHeap {
    
    private Path[] heap;
    private int heapsize;
    Node goal;
    
    /**
     *
     * @param g
     */
    public BisiHeap(Node g) {
        heap = new Path[8];
        heapsize = -1;
        goal = g;
        
    }
    
    private int parent(int i){
        return (int) Math.floor(i/2);
    }
    private int left(int i){
        return 2*i;
    }
    private int right(int i){
        return 2*i + 1;
    }
    
    private void heapify(int i){
        int l = left(i);
        int r = right(i);
        int smallest = -1;
        if(r <= heapsize){
            if(heap[l].compare(heap[r], goal) < 0) {
                smallest = l;
            } else {
                smallest = r;
            }
            if (heap[i].compare(heap[smallest], goal) < 0){
                Path temp = heap[i];
                heap[i] = heap[smallest];
                heap[smallest] = temp;
                heapify(smallest);
            }
        } else if( l == heapsize && heap[i].compare(heap[l], goal) < 0){
                Path temp = heap[i];
                heap[i] = heap[l];
                heap[l] = temp;
        }
        
    }
    
    /**
     *
     * @return
     */
    public Path poll(){
        if(heapsize == 0){
            if(heap.length > 8){
                heap = new Path[heap.length / 2];
            }
            return null;
        }
        Path min = heap[0];
        heap[0] = heap[heapsize];
        heapsize--;
        heapify(0);
        return min;
    }
    
    /**
     *
     * @param p
     */
    public void insert(Path p){
        heapsize++;
        if(heapsize == heap.length){
            Path[] temp = new Path[2*heapsize];
            for(int i = 0; i<heap.length; i++){
                temp[i] = heap[i];
            }
            heap = temp; 
        }
        int i = heapsize;
        if(heap[parent(i)] != null){
            System.out.println("compare: ");
           System.out.println(heap[parent(i)].compare(p, goal));
        }
        
        while(i > 0 && heap[parent(i)] != null && heap[parent(i)].compare(p, goal) < 0){
            System.out.println("i: " + i);
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = p;
    }
    
    /**
     *
     * @return
     */
    public Path[] getHeap(){
        return heap;
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty(){
        System.out.println("heapsize: " + heapsize);
        if (heapsize == -1 || heapsize == 0){
            return true;
        }
        return false;
    }

}
