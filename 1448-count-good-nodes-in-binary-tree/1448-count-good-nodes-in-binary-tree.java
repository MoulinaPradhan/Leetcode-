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
    public int goodNodes(TreeNode root) {
        
  
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
    
    int count = 0;
    private void dfs(TreeNode node, int currMax) {
        if (node.val >= currMax) count++;
        
        currMax = Math.max(currMax, node.val);
        if (node.left != null) dfs(node.left, currMax);
        if (node.right != null) dfs(node.right, currMax);

 
    }
}