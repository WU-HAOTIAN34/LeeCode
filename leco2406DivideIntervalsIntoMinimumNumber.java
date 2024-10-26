package cwk1;
import java.util.HashSet;



public class leco2406DivideIntervalsIntoMinimumNumber {

    public static void main(String[] args) {
        Solution2406 s = new Solution2406();
        System.out.println(s.minGroups(new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}}));

    }
}

class ListNode {
    int val;
    int n;
    ListNode next;
    public ListNode (int val, int n){
        this.val = val;
        this.n = n;
    }
    public ListNode (int val, int n,ListNode next){
        this.val = val;
        this.n = n;
        this.next = next;
    }
}

class Solution2406 {

    public int minGroups(int[][] intervals) {
        int res = 0;
        ListNode time = new ListNode(0,0);
        for (int i=0; i<intervals.length; i++){
            ListNode now = time;
            int num = now.n;
            while (now.next != null && now.next.val<=intervals[i][0]){
                now = now.next;
                num = now.n;
            }
            if (!(now.next != null && now.next.val == intervals[i][0])){
                now.next = new ListNode(intervals[i][0], num, now.next);
                res = Math.max(res, num);
            }
            while (now.next!=null && now.next.val<intervals[i][1]+1){
                now = now.next;
                num = now.n;
                now.n++;
                res = Math.max(res, now.n);
            }
            if (!(now.next != null && now.next.val == intervals[i][1]+1)){
                now.next = new ListNode(intervals[i][1]+1, num, now.next);
            }
        }
        return res;
    }
}