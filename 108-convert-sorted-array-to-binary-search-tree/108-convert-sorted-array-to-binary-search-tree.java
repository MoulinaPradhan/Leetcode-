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
        if(nums.length ==0) return null;
        return help(0,nums.length-1, nums);
        
    }
    public TreeNode help(int start,int end , int [] nums){
        if(start > end)return  null;
        int mid = (start+end)/2;
        int data = nums[mid];
        TreeNode left = help(start,mid-1,nums);
        TreeNode right = help( mid+1,end, nums);
        TreeNode curr = new TreeNode ( data, left, right);
        return curr;
    }
}