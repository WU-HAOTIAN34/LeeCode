package cwk1;
public class leco9 {
    public static void main(String[] args) {
        Solution9 s = new Solution9();
        boolean a = s.isPalindrome(10);
        System.out.println(a);
    }

}

class Solution9 {
    public boolean isPalindrome(int x) {
        if (x<0 || (x%10==0 && x!= 0)){
            return false;
        }else{
            int temp = x;
            int res = 0;
            while(temp!=0){
                res *= 10;
                res += temp%10;
                temp /=10;
                if (res >=temp){
                    return res == temp || res/10 == temp;
                }
            }
            return res ==x;
        }

    }
}
