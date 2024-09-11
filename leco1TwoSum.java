package cwk1;
import java.util.HashMap;
import java.util.Map;



public class leco1TwoSum {

    public static void main(String [] args){

        int[] nums = {0, 4, 3, 0};

        int a = 0;

        int[] res = sol2(nums, a);



    }


    public static int[] sol1(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for (int j = i+1; j < nums.length; j++){

                if (nums[i] + nums[j] == target){
                    int[] res = {i, j};
                    return res;
                }
            }
        }
        return new int[] {};
    }

    public static int[] sol2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // Build the hash table
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        // Find the complement
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }

    public static int[] sol3(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i<nums.length; i++){
            int temp = target - nums[i];
            if (numMap.containsKey(temp)){
                return new int[] {i, numMap.get(temp)};
            }else{
                numMap.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}
