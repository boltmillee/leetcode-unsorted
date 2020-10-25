/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();
        
        if(root == null)
            return result;
        
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        s1.add(root);
        while(s1.size() > 0 || s2.size() > 0){
            List<Integer> list = new ArrayList();
            while(s1.size() >0){
                TreeNode t1 = s1.pop();
                list.add(t1.val);
                
                if(t1.left != null)
                    s2.add(t1.left);
                
                if(t1.right != null)
                    s2.add(t1.right);
            }
            
            if(list.size() > 0)
                result.add(list);
            List<Integer> list2 = new ArrayList();
            while(s2.size() >0){
                TreeNode t2 = s2.pop();
                list2.add(t2.val);
                
                if(t2.right != null)
                    s1.add(t2.right);
                
                if(t2.left != null)
                    s1.add(t2.left);
            }
            
            if(list2.size() > 0)
                result.add(list2);
        }
        
        return result;
    }
}
