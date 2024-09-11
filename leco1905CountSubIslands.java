package cwk1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class leco1905 {
    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        Solution1905 s = new Solution1905();
        int res = s.countSubIslands(grid1, grid2);
    }
}
class Solution1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for (int i=0; i<grid2.length; i++){
            for (int j=0; j<grid2[0].length; j++){
                if (grid2[i][j] == 1){
                    List<List<Integer>> islandPos = new ArrayList<>();
                    List<List<Integer>> search = new ArrayList<>();
                    search.add(Arrays.asList(i, j));
                    grid2[i][j] = 0;
                    DFS(grid2, islandPos, search);
                    int num = islandPos.size();
                    int k;
                    for (k=0; k<num; k++){
                        if (grid1[islandPos.get(k).get(0)][islandPos.get(k).get(1)]==0){
                            break;
                        }
                    }
                    if (num==k){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public void DFS(int[][] grid, List<List<Integer>> res, List<List<Integer>> search){
        int[][] pos = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        if (search.size() == 0){
            return;
        }else{
            int i = search.get(search.size()-1).get(0);
            int j = search.get(search.size()-1).get(1);
            res.add(search.get(search.size()-1));
            search.remove(search.size()-1);
            for (int k=0; k<4; k++){
                if (i+pos[k][0]>=0 && i+pos[k][0]<grid.length && j+pos[k][1]>=0 && j+pos[k][1]< grid[0].length && grid[i+pos[k][0]][j+pos[k][1]]==1){
                    search.add(Arrays.asList(i+pos[k][0], j+pos[k][1]));
                    grid[i+pos[k][0]][j+pos[k][1]] = 0;
                }
            }
            DFS(grid, res, search);
        }

    }


}