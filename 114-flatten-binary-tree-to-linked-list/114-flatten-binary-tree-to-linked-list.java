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
    public void flatten(TreeNode root) {
        
    if(root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
      
        for(int i = 0; i < list.size(); i++) {
            root.val = list.get(i);
            root.left = null;
            if(i < list.size() - 1) {
                root.right = new TreeNode();
                root = root.right;
            }
        }
    }
    
    private void preorder(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if(root.left != null) {
            preorder(root.left, list);
        }
        if(root.right != null) {
            preorder(root.right, list);
        }
    }
}