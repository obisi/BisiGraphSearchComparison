Tests were run by an automatic graph builder. It ran for 20 times for each graph size. A new graph was constructed for each test run.  Each new graph was filled with randomized walls, which cover roughly 1/3 of the area. Unsolvable maps were discarded using A*. An average run time for each search algorithm was calculated afterwards.


### First set of tests

| Graph Size  | BFS (ms) | DFS (ms) | A* (ms) | Test Time (s) |
| ------------- | ------------- | ------------ | ------------ | ------------ |
| 250 x 250  | 3  | 0 | 0 | 2 | 
| 500 x 500  | 10  | 2 | 1 | 5 | 
| 750 x 750  | 30 | 5 | 1 | 11 | 
| 1000 x 1000  | 54  | 5 | 2 | 25 | 
| 1250 x 1250  | 276 | 13 | 2 | 38 | 
| 1500 x 1500  | 157 | 15 | 3 | 75 | 
| 1750 x 1750  | 181 | 4 | 3 | 131 | 
| 2000 x 2000  | 301 | 42 | 4 | 158 | 
| 2250 x 2250  | 518 | 32 | 5 | 289 | 
| 2500 x 2500  | 1424 | 415 | 5 | 413 | 
| 2750 x 2750   | 1147 | 123 | 6 | 393 | 
| 3000 x 3000  | 3736 | 380 | 7 | 807 | 

### Second set of tests

| Graph Size  | BFS (ms) | DFS (ms) | A* (ms) | Test Time (s) |
| ------------- | ------------- | ------------ | ------------ | ------------ |
| 250 x 250  | 2  | 0 | 0 | 2 | 
| 500 x 500  | 10  | 2 | 0 | 6 | 
| 750 x 750  | 27  | 4 | 1 | 12 | 
| 1000 x 1000  | 51  | 6 | 2 | 27 | 
| 1250 x 1250  | 172 | 16 | 3 | 82 | 
| 1500 x 1500  | 194  | 21 | 3 | 54 | 
| 1750 x 1750  | 221 | 7 | 3 | 120 | 
| 2000 x 2000  | 308 | 19 | 4 | 213 | 
| 2250 x 2250  | 448 | 24 | 5 | 269 | 
| 2500 x 2500  | 1704  | 57 | 5 | 403 | 
| 2750 x 2750   | 739  | 96 | 6 | 422 | 
| 3000 x 3000  | 4419 | 427 | 7 | 780 | 


We can see that BFS starts to take longer and longer with larger inputs. DFS seems to be pretty close to A*, but starts to rise with larger inputs. There is more variation however, as DFS can be the fastest in certain cases. Certain cases it can look for the right path for a very long time. A* keeps its run times low even with large graphs. Very fast runtimes even with large graphs makes it ideal to discard unsolvable graphs during graph building.
