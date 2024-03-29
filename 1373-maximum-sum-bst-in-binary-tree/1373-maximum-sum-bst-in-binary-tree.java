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
class NodeValue{
    int max;
    int min;
    int sum;
    
    NodeValue(int min, int max, int sum){
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}
class Solution {
    int maxSum=0;
    public NodeValue helper(TreeNode root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        
        if( left.max<root.val && root.val<right.min){
            maxSum = Math.max(maxSum,left.sum+right.sum+root.val);
            return new NodeValue(Math.min(left.min, root.val), Math.max(right.max, root.val), left.sum+right.sum+root.val );
            
        }
        
        maxSum = Math.max(maxSum, Math.max(left.sum, right.sum));
        
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
    }
    
    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
}