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
      List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
      
        h(root);
return res;
            
    }
    public void h ( TreeNode root){
               if(root == null) return ;
      inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
    
    }
}