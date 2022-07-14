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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
     HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.putIfAbsent(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, map);
    }

    public TreeNode buildTree(
            int[] preorder,
            int start,
            int end,
            int[] inorder,
            int startInorder,
            HashMap<Integer, Integer> map
    ) {
        if (start > end)
            return null;
        TreeNode n = new TreeNode(preorder[start]);
        if (start == end) {
            return n;
        }
        int index = map.get(preorder[start]);
        int numLeftNodes = index - startInorder;
        
        n.left = buildTree(preorder, start + 1, start + numLeftNodes, inorder, startInorder, map);
        n.right = buildTree(preorder, start + numLeftNodes + 1, end, inorder, index + 1, map);
        return n;
	}
}    