package cwk1;
public class leco264UglyNumberTwo {
    public static void main(String[] args) {
        int x = nthUglyNumber(10);
    }
    static int nthUglyNumber(int n) {
        int[] res = new int[n];
        int[] num = {2,3,5};
        int[] x = {2,3,5};
        int[] pos = {0,0,0};
        res[0] = 1;
        for (int j=1; j<n; j++){
            for (int i=0; i<3; i++){
                if (num[i]==Math.min(num[0], Math.min(num[1], num[2]))){
                    if (num[i] == res[j-1]){
                        pos[i]++;
                        num[i] = res[pos[i]] * x[i];
                        i = -1;
                    }else{
                        res[j] = num[i];
                        pos[i]++;
                        num[i] = res[pos[i]] * x[i];
                        break;
                    }
                }
            }
        }
        return res[n-1];
    }
}


