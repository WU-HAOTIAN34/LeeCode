package cwk1;
import java.util.ArrayList;
import java.util.List;



public class leco241DifferentWaysAddParentheses {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.diffWaysToCompute("2*3-4*5");
    }
}

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<String> op = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        for (int i=0; i<expression.length(); i++){
            String n = "";
            while (i<expression.length() && (int)expression.charAt(i)-(int)'0'>=0 && (int)expression.charAt(i)-(int)'9'<= 0){
                n += expression.charAt(i);
                i++;
            }
            num.add(Integer.parseInt(n));
            if (i<expression.length()){
                op.add(expression.charAt(i)+"");
            }
        }

        for (int i=0; i<num.size(); i++){
            dp.add(new ArrayList<>());
            for (int j=0; j<num.size(); j++){
                dp.get(i).add(new ArrayList<>());
            }
            dp.get(i).get(i).add(num.get(i));
        }

        for (int k=1; k<num.size(); k++){
            for (int i=0; i<num.size()-k; i++){
                for (int t=0; t<k; t++){
                    for (int x : dp.get(i).get(i+t)){
                        for (int y : dp.get(i+1+t).get(i+k)){
                            dp.get(i).get(i+k).add(computer(x, y, op.get(i+t)));
                        }
                    }
                }
            }
        }

        return dp.get(0).get(num.size()-1);


    }

    public int computer(int a, int b, String operation){
        if (operation.equals("+")){
            return a + b;
        }else if (operation.equals("-")){
            return a - b;
        }else if (operation.equals("*")){
            return a * b;
        }else{
            return a / b;
        }
    }
}
