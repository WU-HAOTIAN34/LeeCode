package cwk1;
import java.util.ArrayList;
import java.util.List;



public class Leco592 {

    public static void main(String[] args) {
        Solution592 s = new Solution592();
        String a = s.fractionAddition2("-1/2+1/2");
        System.out.println(a);

    }

}


class Solution592 {

    public String fractionAddition2(String expression) {
        if (expression.charAt(0) != '-'){
            expression = "+" + expression;
        }
        List<Integer> temp = new ArrayList<>();
        int left = 0;
        int num = 1;
        for (int i=1; i<expression.length(); i++){
            if (expression.charAt(i) == '/'){

                temp.add(Integer.parseInt(expression.substring(left, i)));
                left = i+1;
            }else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' ){
                int x = Integer.parseInt(expression.substring(left, i));
                num *= x;
                temp.add(x);
                left = i;
            } else if (i == expression.length()-1) {
                int x = Integer.parseInt(expression.substring(left));
                num *= x;
                temp.add(x);
            }
        }
        int res = 0;
        for (int i=0; i<temp.size();i++){
            if (i%2 == 0){
                res += temp.get(i) * (num / temp.get(i+1));
            }
        }

        if (res == 0){
            return "0/1";

        }else{
            int a = Math.max(res, num);
            int b = Math.abs(Math.max(-res, -num));

            while(a%b != 0 ){
                int num1 = a%b;
                a = b;
                b = num1;
            }

            return (res / b) + "/" + (num / b);
        }

    }




    public String fractionAddition(String expression) {

        if (expression.charAt(0) != '-'){
            expression = "+" + expression;
        }
        String res = calString(expression);

        String temp = res.substring(1);
        if (Integer.parseInt(temp.split("/")[0])==0){
            return "0/1";
        }else{
            int a = Math.max(Integer.parseInt(temp.split("/")[0]), Integer.parseInt(temp.split("/")[1]));
            int b = Math.abs(Math.max(-Integer.parseInt(temp.split("/")[0]), -Integer.parseInt(temp.split("/")[1])));

            while(a%b != 0 ){
                int num = a%b;
                a = b;
                b = num;
            }

            temp = (Integer.parseInt(temp.split("/")[0]) / b) + "/" + (Integer.parseInt(temp.split("/")[1]) / b);

            if (res.charAt(0) == '-'){
                return '-' + temp;
            }
            return temp;
        }




    }

    public String calString(String s){
        if (s.equals("")){
            return "+0/1";
        }else{
            for (int i=1; i<s.length(); i++){
                if (s.charAt(i) == '+' || s.charAt(i) == '-'){
                    String a = s.substring(0, i);
                    String b = calString(s.substring(i));
                    return calStringNum(a, b);
                }
            }
        }
        return s;
    }

    public String calStringNum(String aa, String bb){

        if (bb.equals("")){
            return aa;
        }
        String[] temp1 = aa.split("/");
        String[] temp2 = bb.split("/");

        int a = Integer.parseInt(temp1[0])*Integer.parseInt(temp2[1])+Integer.parseInt(temp2[0])*Integer.parseInt(temp1[1]);
        int b = Integer.parseInt(temp1[1])*Integer.parseInt(temp2[1]);

        if (a==0){
            return "+0/1";
        }else if(a<0){
            return a + "/" + b;
        }else{
            return "+" + a + "/" + b;
        }

    }
}