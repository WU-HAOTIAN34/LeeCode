package cwk1;
import java.util.ArrayList;
import java.util.List;



public class leco145 {
    public static void main(String[] args) {
        TreeNode145 t = new TreeNode145(1, null, new TreeNode145(2, new TreeNode145(3), null));
        Solution145 s = new Solution145();
        List<Integer> re = s.postorderTraversal(t);

        System.out.println(re);
    }



}


class TreeNode145 {
     int val;
     TreeNode145 left;
     TreeNode145 right;
     TreeNode145() {}
     TreeNode145(int val) { this.val = val; }
     TreeNode145(int val, TreeNode145 left, TreeNode145 right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution145 {
    public List<Integer> postorderTraversal(TreeNode145 root) {


        List<Integer> res = new ArrayList<>();
        addNode(root, res);

        return res;
    }

    public void addNode(TreeNode145 root, List<Integer> res){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            res.add(root.val);
        }else{
            if (root.left != null){
                addNode(root.left, res);
            }
            if (root.right != null){
                addNode(root.right, res);
            }
            res.add(root.val);
        }
    }
}