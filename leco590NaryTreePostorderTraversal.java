package cwk1;
import java.util.ArrayList;
import java.util.List;



public class leco590NaryTreePostorderTraversal {


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            addNode(res, root);
            return res;
        }

        public void addNode(List<Integer> res, Node root){
            if (root == null){
                return;
            }
            if (root.children == null){
                res.add(root.val);
            }else{
                for (int i=0; i<root.children.size(); i++){
                    addNode(res, root.children.get(i));
                }
                res.add(root.val);
            }
        }
    }
    public static void main(String[] args) {

    }
}
