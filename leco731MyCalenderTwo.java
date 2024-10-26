package cwk1;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;



public class leco731MyCalenderTwo {
    public static void main(String[] args) {
        MyCalendarTw m = new MyCalendarTw();

        System.out.println(m.book(10,20));
        System.out.println(m.book(50,60));
        System.out.println(m.book(10,40));
        System.out.println(m.book(5,15));
        System.out.println(m.book(5,10));
        System.out.println(m.book(25,55));


//        System.out.println(m.book(33,44));
//        System.out.println(m.book(20,37));
//        System.out.println(m.book(42,61));
//        System.out.println(m.book(70,82));
//        System.out.println(m.book(5,17));
//        System.out.println(m.book(16,26));
//        System.out.println(m.book(44,55));
//        System.out.println(m.book(58,73));
//        System.out.println(m.book(60,70));


    }
}
class LinkNode {
    int time;
    int val;
    LinkNode next;
    public LinkNode () {};
    public LinkNode (int time, int val){
        this.time = time;
        this.val = val;
    }
    public LinkNode (int time, int val, LinkNode next){
        this.time = time;
        this.val = val;
        this.next = next;
    }
}

class MyCalendarTw {

    private LinkNode calender;

    public MyCalendarTw() {
        this.calender = new LinkNode();
    }

    public boolean book(int start, int end) {
        LinkNode left;
        int num = 0;
        int right = 0;
        LinkNode now = calender;
        while (now.next != null && now.next.time <= start){
            now = now.next;
        }
        left = now;
        right = now.val;
        while (now.next != null && now.next.time < end){
            if (now.val==2){
                return false;
            }
            now = now.next;
            right = now.val;
            num++;
        }
        if (now.val==2){
            return false;
        }
        left.next = new LinkNode(start, left.val+1, left.next);
        left = left.next;
        while (num>0){
            left = left.next;
            left.val++;
            num--;
        }
        left.next = new LinkNode(end, right, left.next);
        return true;
    }
}
class MyCalendarTwo_ {

    private LinkedList<int[]> calender;

    public MyCalendarTwo_() {
        this.calender = new LinkedList<>();
    }

    public boolean book(int start, int end) {
        int left = 0;
        int right = 0;
        int now = 0;
        while (now<this.calender.size() && calender.get(now)[0]<=start){
            now++;
        };
        left = now;
        while (now<this.calender.size() && calender.get(now)[0]<end){
            if (calender.get(now)[1]==2){
                return false;
            }
            now++;
        }
        right = now;
        int a = 0;
        int b = 0;
        if (left-1>=0){
            a = calender.get(left-1)[1];
            if (a==2){
                return false;
            }
        }
        if (right-1>=0){
            b = calender.get(right-1)[1];
        }
        calender.add(left, new int[]{start, a});
        calender.add(right+1, new int[]{end, b});
        for ( ; left<=right; left++){
            calender.get(left)[1]++;
        }
        return true;
    }
}


class MyCalendarTwo {

    int[][] calender;

    public MyCalendarTwo() {
        this.calender = new int[0][0];
    }

    public boolean book(int start, int end) {
        int[][] res = new int[this.calender.length+2][2];
        int time = 0;
        int pre = 0;
        int num = 0;
        int num2 = 0;
        for ( ; num < this.calender.length; num++){
            if (this.calender[num][0] > start){
                break;
            }
            time = this.calender[num][0];
            pre = this.calender[num][1];
            if (time == start){
                res[num2++] = new int[]{time, pre+1};
            }else{
                res[num2++] = new int[]{time, pre};
            }

        }
        if (pre == 2){
            return false;
        }
        res[num2++] = new int[]{start, pre+1};

        for ( ; num < this.calender.length; num++){
            if (this.calender[num][0] > end){
                break;
            }
            time = this.calender[num][0];
            pre = this.calender[num][1];
            if (time == end){
                res[num2++] = new int[]{time, pre};
            }else {
                if (pre == 2){
                    return false;
                }
                res[num2++] = new int[]{time, pre + 1};
            }
        }
        res[num2++] = new int[]{end, pre};
        for ( ; num < this.calender.length; num++) {
            res[num2++] = this.calender[num];
        }
        this.calender = res;
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
