package cwk1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class disIsland {

    public static void main (String [] args){

        int[][] grid = {{0,1,1,0},{0,1,1,0},{0,0,0,0}};
        Solution solution = new Solution();

        int res = solution.minDays(grid);

        System.out.println(res);


    }

}


class Solution {

    public int DFS(int[][] grid2, int i, int j) {
        int m = grid2.length;
        int n = grid2[0].length;
        int res = 0;
        int[][] grid = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                grid[x][y] = grid2[x][y];
            }
        }
        List<List<Integer>> heap = new ArrayList<>();
        heap.add(Arrays.asList(i, j));
        grid[i][j] = 0;
        while (heap.size() != 0) {
            i = heap.get(heap.size()-1).get(0);
            j = heap.get(heap.size()-1).get(1);
            heap.remove(heap.size() - 1);
            res++;
            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                grid[i - 1][j] = 0;
                heap.add(Arrays.asList(i - 1, j));
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                grid[i][j - 1] = 0;
                heap.add(Arrays.asList(i, j - 1));
            }
            if (i + 1 < m && grid[i + 1][j] == 1) {
                grid[i + 1][j] = 0;
                heap.add(Arrays.asList(i + 1, j));
            }
            if (j + 1 < n && grid[i][j + 1] == 1) {
                grid[i][j + 1] = 0;
                heap.add(Arrays.asList(i, j + 1));
            }
        }
        return res;
    }


    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int DFSNum = 0;
        List<List<Integer>> islands = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                   islands.add(Arrays.asList(i, j));
                }
            }
        }
        if (islands.size() == 0) {
            return 0;
        } else if (islands.size() == 1) {
            return 1;
        } else {
            DFSNum = DFS(grid, islands.get(0).get(0), islands.get(0).get(1));
            if (DFSNum != islands.size()) {
                return 0;
            } else {
                if (islands.size() == 2){
                    return 2;
                }
                for (int i=0; i<islands.size(); i++){
                    grid[islands.get(i).get(0)][islands.get(i).get(1)] = 0;
                    DFSNum = DFS(grid, islands.get(Math.abs(i-1)).get(0), islands.get(Math.abs(i-1)).get(1));
                    if (DFSNum != islands.size()-1) {
                        return 1;
                    } else {
                        grid[islands.get(i).get(0)][islands.get(i).get(1)] = 1;
                    }
                }
                return 2;
            }
        }
    }
}
