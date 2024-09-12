package cwk1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class leco15threeSum {

    public static void main(String [] args){

        int[] nums = {0, 4, 3, 0};
        int a = 0;

        List<Integer> temp = Arrays.asList(1, 1, 2);
        List<Integer> temp2 = Arrays.asList(1, 1, 2);

        System.out.println(temp.equals(temp2));

//        int[] res = sol(nums, a);



    }


    public List<List<Integer>> sol(int[] nums){

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        int j, k;
        for (int i=0; i<n-2; i++){
            j = i+1;
            k = n-1;

            if (i >0 && nums[i] == nums[i-1]){
                continue;
            }
            while (j != k){
                if (nums[i] + nums[j] + nums[k] > 0){
                    k--;

                }else if (nums[i] + nums[j] + nums[k] < 0){
                    j++;

                }else{

                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));


                    do{
                        j++;
                    }while (nums[j] == nums[j-1] && j < k);

                }
            }
        }


        return res;

    }

}
