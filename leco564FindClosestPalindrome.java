package cwk1;
public class leco564 {
    public static void main(String[] args) {
        Solution564 s = new Solution564();
        String x = s.nearestPalindromic("1000");
        System.out.println(x);

    }
}

class Solution564 {

    public String nearestPalindromic(String n) {
        long x = stringToLong(n);
        long left = x-1;
        long right = x+1;
        long res = 0;
        while(x - left<10){
            if (isPalindrome(left)){
                res = left;
                return "" + res;
            }
            if (isPalindrome(right)){
                res = right;
                return "" + res;
            }
            left--;
            right++;
        }

        int l = n.length();
        String res1 = n.substring(0, l / 2);
        String res2 = n.substring(0, l / 2);
        String res3 = n.substring(0, l / 2);
        if (l%2==1){
            res1 += n.charAt(n.length()/2);
            res2 += n.charAt(n.length()/2);
            res3 += n.charAt(n.length()/2);
            res2 = (stringToLong(res2)-1)+"";
            res3 = (stringToLong(res3)+1)+"";
            for (int i=res1.length()-2; i>=0; i--){
                res1 += res1.charAt(i);
                res2 += res2.charAt(i);
                res3 += res3.charAt(i);
            }
        }else{
            res2 = (stringToLong(res2)-1)+"";
            res3 = (stringToLong(res3)+1)+"";
            for (int i=res1.length()-1; i>=0; i--){
                res1 += res1.charAt(i);
                res2 += res2.charAt(i);
                res3 += res3.charAt(i);
            }
        }

        long a = Math.abs(stringToLong(res2)- stringToLong(n));
        long b = Math.abs(stringToLong(res1)- stringToLong(n));
        long c = Math.abs(stringToLong(res3)- stringToLong(n));

        long res4;
        if (b != 0){
            res4 = Math.min(c, Math.min(a, b));
        }else{
            res4 = Math.min(c,a);
        }
        if (stringToLong(n)-res4==stringToLong(res3)||stringToLong(n)-res4==stringToLong(res1)||stringToLong(n)-res4==stringToLong(res2)){
            return (stringToLong(n)-res4)+"";
        }else{
            return (stringToLong(n)+res4)+"";
        }



    }

    public long stringToLong(String s){
        long res = 0;
        if (s.length()<=9){
            res = Integer.parseInt(s);
        }else{
            res += Integer.parseInt(s.substring(0,9));
            res *= Math.pow(10, s.length()-9);
            res += Integer.parseInt(s.substring(9));
        }
        return res;
    }


    public boolean isPalindrome(long x) {
        if (x<0 || (x%10==0 && x!= 0)){
            return false;
        }else{
            long temp = x;
            long res = 0;
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