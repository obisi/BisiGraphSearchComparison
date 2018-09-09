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
public class Main {
    
    
    public static void main(String[] args) {
        
        SearchAlgos search = new SearchAlgos();
        Node[][] graph = new Node[20][20];
        for(int i = 0; i<graph.length; i++){
            for(int j = 0; j<graph[0].length; j++){
                graph[i][j] = new Node(0, i, j);
            }
        }
        graph[1][1].setStart();
        graph[18][18].setGoal();
        
        for(int i = 0; i<graph.length; i++){
            for(int j = 0; j<graph[0].length; j++){
                if (i > 0 && !graph[i-1][j].visited() && graph[i-1][j].getType() != 3) {
                    graph[i][j].setNeighbor(graph[i - 1][j]);
                }
                if (i < graph.length-1 && !graph[i+1][j].visited() && graph[i+1][j].getType() != 3) {
                    graph[i][j].setNeighbor(graph[i+1][j]);
                }
                if (j > 0 && !graph[i][j-1].visited() && graph[i][j-1].getType() != 3) {
                    graph[i][j].setNeighbor(graph[i][j-1]);
                }
                if (j < graph[0].length-1 && !graph[i][j+1].visited() && graph[i][j+1].getType() != 3) {
                    graph[i][j].setNeighbor(graph[i][j+1]);
                }
            }
        }
        
        // sama verkko, joten vain toista voi kokeilla kerrallaan.
        
        //if(search.BFS(graph[1][1], graph[18][18]) != null){
        //    System.out.println("BFS toimii!");
        //} else {
        //    System.out.println("BFS ei toimi!");
        //}
        if(search.DFS(graph[1][1], graph[18][18]) != null){
            System.out.println("DFS toimii!");
        } else {
            System.out.println("DFS ei toimi!");
        }
        
    }

}
