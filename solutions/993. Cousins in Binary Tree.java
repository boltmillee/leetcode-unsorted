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
    int left = Integer.MAX_VALUE;
    int right = Integer.MIN_VALUE;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        helper(root, x, y, 0);
        
        if(left == right)
            return true;
        else
            return false;
        
    }
    
    void helper(TreeNode root, int x, int y, int depth){
        
        if(root == null)
            return;
        
        if(root.left != null && root.right != null){
            if((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val==x))
                return;
        }
        
        if(root.val == x)
            left = depth;
        
        if(root.val == y)
            right = depth;
        
        if(left == right)
            return;
        
        helper(root.left, x, y, depth+1);
        helper(root.right, x, y, depth+1);
        
    }
}
