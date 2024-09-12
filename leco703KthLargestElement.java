package cwk1;
import java.util.Arrays;
import java.util.PriorityQueue;



public class leco703KthLargestElement {

    public static void main(String [] args){
        KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));


    }


}

class KthLargest {

    private final int k;
    private PriorityQueue<Integer> nums;


    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        this.k = k;
        this.nums = new PriorityQueue<>(k);
        for (int i=nums.length-1; i>nums.length-4;i--){
            this.nums.add(nums[i]);
        }

    }

    public int add(int val) {
        if (nums.size()<k){
            nums.add(val);
        }else if(val>nums.peek()){
            nums.poll();
            nums.add(val);
        }
        return nums.peek();
    }
}
