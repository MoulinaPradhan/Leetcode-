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
    public TreeNode sortedArrayToBST(int[] nums) {
 
        TreeNode ans = helper(0,nums.length-1,nums);
        return ans;
    }
    public TreeNode helper (int start,int end,int[]nums){
        if(start>end){
           return null;
        }
        int mid = (start+end)/2;
        int data = nums[mid];
        TreeNode leftChild = helper(start,mid-1,nums);
        TreeNode rightChild = helper(mid+1,end,nums);
        TreeNode curr = new TreeNode(data,leftChild,rightChild);
        return curr;
    }
}