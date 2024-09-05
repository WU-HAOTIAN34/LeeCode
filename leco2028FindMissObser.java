package cwk1;
public class leco2028FindMissObser {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum1 = mean*(m+n);
        for (int num : rolls){
            sum1-=num;
        }
        if (sum1>n*6 || sum1 < n){
            return new int[] {};
        }

        int res[] = new int[n];
        for (int i=0; i<n; i++){
            int temp = Math.min(6, sum1-(n-1-i));
            res[i] = temp;
            sum1 -= temp;
        }
        return res;


    }
}
