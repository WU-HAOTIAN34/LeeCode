package cwk1;
public class leco213HouseRobberTwo {
    public static void main(String[] args) {

        int[] a = {1,2,3};
        int res = sol(a);
        System.out.println(res);

    }

    static int sol(int[] nums){
        int[] dp = new int[nums.length+3];
        int[] dp2 = new int[nums.length+3];
        for (int i=nums.length-2; i>=0; i--){
            dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        }
        for (int i=nums.length-1; i>=1; i--){
            dp2[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        }
        return Math.max(dp2[1], dp[0]);
    }

}
