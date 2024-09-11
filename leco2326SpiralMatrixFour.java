package cwk1;
public class leco2326SpiralMatrixFour {
    public static void main(String[] args) {
        Solution2326 s = new Solution2326();
        int[][] res = s.spiralMatrix(10, 1);
        long re = Long.MAX_VALUE;
    }

}


class Solution2326 {
    public int[][] spiralMatrix(int m, int n) {
        int[][] res = new int[m][n];
        int[] t = {0,0,0,0};
        int x = 0;
        int y = 0;
        int dir = 0;
        int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (int i=0; i<m*n; i++){
            res[x][y] = -1;
            if (dir==0 && y+1>=Math.min(n,n-t[1])){
                dir = 1;
                t[0]++;
            }else if (dir==1 && x+1>=Math.min(m,m-t[2])){
                dir = 2;
                t[1]++;
            }else if (dir==2 && y-1<Math.max(0, t[3])){
                dir = 3;
                t[2]++;
            }else if (dir==3 && x-1<Math.max(0, t[0])){
                dir = 0;
                t[3]++;
            }
            x += pos[dir][0];
            y += pos[dir][1];
        }
        return res;
    }
}