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
  
        int maxpathsum;
    public int maxPathSum(TreeNode root) {
        maxpathsum = Integer.MIN_VALUE;
        path_sum(root);
        return maxpathsum;
    }
    int path_sum(TreeNode node){
        if(node==null){
            return 0;
        }
        
        int left=Math.max(0, path_sum(node.left));
        int right= Math.max(0,path_sum(node.right));
        maxpathsum = Math.max(maxpathsum,left+right+node.val);
        
        return Math.max(left,right)+node.val;
    }
}