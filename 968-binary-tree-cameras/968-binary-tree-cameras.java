/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
     int res;
    public int helper(TreeNode t){
        if(t == null)
            return 1;
        int left = helper(t.left);
        int right = helper(t.right);
        if(left == 0 || right == 0){
            res++;
            return 2;
        }
        if(left == 1 && right == 1)
            return 0;
        return 1;
    }
    public int minCameraCover(TreeNode root) {
        res = 0;
        if(helper(root) == 0)
            return ++res;
        return res;    
    }
}