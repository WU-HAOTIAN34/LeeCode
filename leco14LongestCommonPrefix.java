package cwk1;
public class leco14 {
    
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        int right = res.length();
        int judg = 1;
        while(!res.equals("")){
            judg = 1;
            res = res.substring(0,right);
            for (int i=0; i<strs.length; i++){
                if (strs[i].length()<right || !strs[i].substring(0,right).equals(res)){
                    judg = 0;
                    break;
                }
            }
            if (judg == 1){
                break;
            }else{
                right--;
            }
        }
        return res;
    }
}