package cwk1;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;



public class leco719FindKthSmallestPairDistance {

    public static void main(String [] args){

        //int a = smallestDistancePair3(new int[]{95,29,47,58,80,65,26,7,69,0,1,53,61,46,66,30,78,25,1,62,5,1,78,60,81,100,52,33,9,52,7,74,94,93,47,68,80,81,50,31,9,96,8,8,64,4,40,22,50,93}, 1142);
        int a = smallestDistancePair3(new int[]{1,1,6}, 3);
        System.out.println(a);
    }
    static int smallestDistancePair2(int[] nums, int k){
        int m = nums.length;
        int total = ((m+1)*m) / 2;
        int[] dis = new int[total];
        int temp=0;
        for(int i = 0; i<m-1; i++){
            for(int j=i+1; j<m; j++){
                dis[temp] = -Math.abs(nums[i] - nums[j]);
                temp++;
            }
        }
        Arrays.sort(dis);

        return dis[total-k+1];

    }


    static int smallestDistancePair(int[] nums, int k) {
        int m = nums.length;
        int total = ((m-1)*m) / 2;
        int con = 0;
        if (k > total/2){
            con = 1;
        }
        PriorityQueue<Integer> dis;
        if (con == 0){
            dis = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    return o2 - o1;
                }
            });
        }else{
            k = total - k + 1;
            dis = new PriorityQueue<Integer>(k);
        }

        Arrays.sort(nums);
//        for (int i = 0; i<m-1; i++){
//            int temp = Math.abs(nums[i]-nums[i+1]);
//            if (dis.size() < k){
//                dis.add(temp);
//            }else{
//                if (con==0){
//                    if (dis.peek() > temp){
//                        dis.poll();
//                        dis.add(temp);
//                    }
//                }else{
//                    if (dis.peek() < temp){
//                        dis.poll();
//                        dis.add(temp);
//                    }
//                }
//            }
//        }
        if (con==0){
            for (int i = 0; i<m-1; i++){
                for (int j=i+1; j<m; j++){
                    int temp = Math.abs(nums[i]-nums[j]);
                    if (dis.size() < k){
                        dis.add(temp);
                    }else{
                        if (dis.peek() > temp){
                            dis.poll();
                            dis.add(temp);
                        }else{
                            break;
                        }
                    }
                }
            }
        }else{
            for (int i = 0; i<m-1; i++){
                for (int j=m-1; j>i; j--){
                    int temp = Math.abs(nums[i]-nums[j]);
                    if (dis.size() < k){
                        dis.add(temp);
                    }else{
                        if (dis.peek() < temp){
                            dis.poll();
                            dis.add(temp);
                        }else{
                            break;
                        }
                    }
                }
            }
        }

        return dis.peek();
    }

    static int smallestDistancePair3(int[] nums, int k) {
        int m = nums.length;
        int total = ((m-1)*m)/2;
        int minDis = 0;
        int maxDis = nums[m-1] - nums[0];
        int midDis = (maxDis-minDis) * (k/total) + minDis;
        int left, right, num;

        while (minDis<maxDis){
            left = 0;
            num = 0;
            for (right=1; right<m; right++){
                while (nums[right] - nums[left] > midDis){
                    left++;
                }
                num += (right-left);
            }

            if (num >= k){
                maxDis = midDis;
            }else{
                minDis = midDis + 1;
            }
            midDis = (minDis + maxDis) /2;
        }
        return minDis;


    }

}

