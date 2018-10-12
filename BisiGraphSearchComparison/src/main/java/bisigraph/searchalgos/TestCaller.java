/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.searchalgos;

import java.util.Scanner;

/**
 *
 * @author bisi
 */
public class TestCaller {

    int gW;
    int gH;

    
    public void test(){
        System.out.println("\n\nHello! Welcome to Graph tester!\n\n"
                + "Here you can try out large maps.\nThey will not be "
                + "drawn, so searches work faster and you can try BIG maps."
                + "\nBut first, give the width and height of the map.\n"
                + "5 minimum here too!");
        
        gW = getInt("Width: ");
        gH = getInt("Height: ");
        
        System.out.println("Excellent!\n Now, the number of test. \nBig maps take time, so choose "
                + "wisely! \nAlso, under 5 is not on option here either.");
        
        int tests = getInt("Number of tests: ");
        
        System.out.println("Let the testing commence!\n\n\n");
        
        String s = runTest(tests);
        
        System.out.println(s);
        
        System.out.println("\n\n\nContinue on the graph!\n\n\n");
    }

    private String runTest(int amount) {
        long bfs = 0;
        long dfs = 0;
        long astar = 0;
        long s = System.currentTimeMillis();

        for (int i = 0; i < amount; i++) {
            System.out.println((i + 1) + ". iteration of test:");
            SearchTester st = new SearchTester(gW, gH);
            bfs += st.testBFS();
            dfs += st.testDFS();
            astar += st.testAstar();
        }

        bfs = bfs / amount;
        dfs = dfs / amount;
        astar = astar / amount;
        long e = System.currentTimeMillis();
        long t = (e - s) / 1000;

        String r = "Tested DFS, BFS, Astar for " + amount + " times on a " + gW + "x" + gH + " map\n"
                + "Average time for BFS: " + bfs + " ms.\n"
                + "Average time for DFS: " + dfs + " ms.\n"
                + "Average time for Astar: " + astar + " ms.\n"
                + "Test took " + t + " seconds.";
        return r;
    }

    private static int getInt(String line) {
        Scanner sc = new Scanner(System.in);
        System.out.println(line);
        int i = -1;
        while (i < 5) {
            String input = sc.next();
            try {
                i = Integer.parseInt(input);
            } catch (NumberFormatException n) {
                System.out.println("Incorrect input.\n");
                continue;
            }
            if(i < 5){
                System.out.println("over 5!\n");
            }
        }
        return i;
    }
}
