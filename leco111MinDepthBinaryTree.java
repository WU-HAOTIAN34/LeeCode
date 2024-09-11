package cwk1;
import javax.swing.tree.TreeNode;



public class leco111MinDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode111 t = new TreeNode111(1, null, new TreeNode111(1, null, new TreeNode111(1, null, new TreeNode111(1))));
        Solution111 s = new Solution111();
        int a = s.minDepth(t);
    }
}


class TreeNode111 {
     int val;
     TreeNode111 left;
     TreeNode111 right;
     TreeNode111() {}
     TreeNode111(int val) { this.val = val; }
     TreeNode111(int val, TreeNode111 left, TreeNode111 right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

class Solution111 {
    public int minDepth(TreeNode111 root) {
        if (root != null){
            return calMin(root);
        }else{
            return 0;
        }
    }
    public int calMin(TreeNode111 root){
        if (root==null){
            return 1000000;
        }else if (root.left==null && root.right==null){
            return 1;
        }else{
            return 1+Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
