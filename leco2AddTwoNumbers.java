package cwk1;
public class leco2AddTwoNumbers {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode res = s.addTwoNumbers(l1, l2);
    }
}
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0){
            return l2;
        }else if (l2.val == 0){
            return l1;
        }else{
            return calculateRes(l1, l2, 0);
        }

    }

    public ListNode calculateRes(ListNode l1, ListNode l2, int n){
        if (l1 == null && l2.next ==null){
            return calculateNode(l2.val, n);
        }else if (l1 == null){
            if (l2.val+n>=10){
                ListNode temp = new ListNode(l2.val+n-10);
                temp.next = calculateRes(null, l2.next, 1);
                return temp;
            }else{
                ListNode temp = new ListNode(l2.val+n);
                temp.next = calculateRes(null, l2.next, 0);
                return temp;
            }
        }else if (l1.next == null && l2 == null){
            return calculateNode(l1.val, n);
        }else if (l2 == null){
            if (l1.val+n>=10){
                ListNode temp = new ListNode(l1.val+n-10);
                temp.next = calculateRes(l1.next, null, 1);
                return temp;
            }else{
                ListNode temp = new ListNode(l1.val+n);
                temp.next = calculateRes(l1.next, null, 0);
                return temp;
            }
        }else if (l1.next == null && l2.next == null){
            return calculateNode(l1.val, l2.val, n);
        }else{
            if (l1.val+l2.val+n>=10){
                ListNode temp = new ListNode(l1.val+l2.val+n-10);
                temp.next = calculateRes(l1.next, l2.next, 1);
                return temp;
            }else{
                ListNode temp = new ListNode(l1.val+l2.val+n);
                temp.next = calculateRes(l1.next, l2.next, 0);
                return temp;
            }
        }
    }

    public ListNode calculateNode(int a, int b,int c){
        if (a+b+c >=10){
            return new ListNode(a+b+c-10, new ListNode(1));
        }else{
            return new ListNode(a+b+c);
        }
    }

    public ListNode calculateNode(int a, int b){
        if (a+b >=10){
            return new ListNode(a+b-10, new ListNode(1));
        }else{
            return new ListNode(a+b);
        }
    }
}
