Tests were run by an automatic graph builder. It ran for 20 times for each input, and constructed a new graph for each run. Then it calculated a average for the times each algorithm ran. Each new graph was filled with randomized walls, which cover roughly 1/3 of the area. Unsolvable maps were discarded using A*. 

We can see that BFS and DFS start to take longer and longer times with larger inputs, but A* keeps its run times low even with large graphs.


| Graph Size  | BFS (ms) | DFS (ms) | A* (ms) | Test Time (s) |
| ------------- | ------------- | ------------ | ------------ | ------------ |
| 10 x 10  | 0  | 0 | 0 | 0 | 
| 50 x 50  | 2  | 2 | 0 | 1 | 
| 100 x 100  | 3  | 3 | 0 | 2 | 
| 200 x 200  | 2  | 2 | 0 | 3 | 
| 350 x 350  | 13  | 10 | 1 | 8 | 
| 500 x 500  | 40  | 49 | 2 | 15 | 
| 600 x 600  | 42  | 28 | 2 | 14 | 
| 750 x 750  | 68  | 61 | 3 | 20 | 
| 900 x 900  | 111  | 168 | 3 | 42 | 
| 1200 x 1200   | 176  | 299 | 4 | 96 | 
| 1300 x 1300  | 251  | 268 | 4 | 108 | 
| 1400 x 1400  | 399  | 497 | 7 | 388 | 
