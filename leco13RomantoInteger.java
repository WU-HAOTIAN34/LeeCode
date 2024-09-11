package cwk1;
import java.util.HashMap;
import java.util.Map;



public class leco13 {
}

class Solution13 {
    public int romanToInt(String s) {
        Map<String, Integer> num = new HashMap<>();
        num.put("I", 1);
        num.put("V", 5);
        num.put("X", 10);
        num.put("L", 50);
        num.put("C", 100);
        num.put("D", 500);
        num.put("M", 1000);

        int res = 0;
        for (int i=0; i<s.length(); i++){
            if (i!=s.length()-1 && num.get(s.charAt(i)+"") < num.get(s.charAt(i+1)+"")){
                res += num.get(s.charAt(i+1)+"") - num.get(s.charAt(i)+"");
                i++;
            }else{
                res += num.get(s.charAt(i)+"");
            }
        }

        return res;

    }

    public int romanToInt2(String s){
        int res = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == 'M'){
                res += 1000;
            } else if (s.charAt(i) == 'D') {
                res += 500;
            }else if (s.charAt(i) == 'C'){
                if (i!=s.length()-1 && s.charAt(i+1) == 'M'){
                    res += 900;
                    i++;
                }else if(i!=s.length()-1 && s.charAt(i+1) == 'D'){
                    res += 400;
                    i++;
                }else{
                    res += 100;
                }
            }else if (s.charAt(i) == 'L') {
                res += 50;
            }else if (s.charAt(i) == 'X'){
                if (i!=s.length()-1 && s.charAt(i+1) == 'C'){
                    res += 90;
                    i++;
                }else if(i!=s.length()-1 && s.charAt(i+1) == 'L'){
                    res += 40;
                    i++;
                }else{
                    res += 10;
                }
            }else if (s.charAt(i) == 'V') {
                res += 5;
            }else if (s.charAt(i) == 'I'){
                if (i!=s.length()-1 && s.charAt(i+1) == 'X'){
                    res += 9;
                    i++;
                }else if(i!=s.length()-1 && s.charAt(i+1) == 'V'){
                    res += 4;
                    i++;
                }else{
                    res += 1;
                }
            }
        }
        return res;
    }
}