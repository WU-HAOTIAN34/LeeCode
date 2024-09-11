package cwk1;
public class leco69Sqrt {
    public static void main(String[] args) {
        int a = mySqrt(2147395599);
    }

    static int mySqrt(int x) {
        long left = 0;
        long right = x;
        long middle = (left+right)/2;
        while(left<right){
            if (middle*middle > x){
                right = middle;
            }else if(middle*middle<x){
                left = middle+1;
            }else{
                return (int)middle;
            }
            middle = (left+right)/2;
        }
        return left*left>x ?  (int)left-1 : (int)left;
    }

}
