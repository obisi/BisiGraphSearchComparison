/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisigraph.searchalgos;

/**
 *
 * @author bisi
 */
public class TestCaller {

    int gW;
    int gH;

    public TestCaller(int gW, int gH) {
        this.gW = gW;
        this.gH = gH;
    }

    public String runTest(int amount) {
        long bfs = 0;
        long dfs = 0;
        long astar = 0;

        int fails = 0;

        for (int i = 0; i < amount; i++) {
            SearchTester st = new SearchTester(gW, gH);

            if (st.testAstar() != 0) {
                bfs += st.testBFS();
                dfs += st.testDFS();
                astar += st.testAstar();
            } else {
                fails++;
            }

        }

        bfs = bfs / amount;
        dfs = dfs / amount;
        astar = astar / amount;

        String r = "Tested DFS, BFS, Astar for " + amount + "times. Number of failures: "+ fails+"\n"
                + "Average time for BFS: " + bfs+"\n"
                + "Average time for DFS: " + dfs+"\n"
                + "Average time for Astar: " + astar+"\n";
        
        return r;
    }
}
