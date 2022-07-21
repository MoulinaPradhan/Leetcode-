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

    public int widthOfBinaryTree(TreeNode root) {
    return dfs(root, 0, 1, new ArrayList<>());
}

private int dfs(TreeNode node, int level, int index, List<Integer> starts) {
    if (node == null) return 0;
    if (starts.size() == level) starts.add(index);

    int cur = index - starts.get(level) + 1;
    int leftResult = dfs(node.left, level + 1, index * 2 + 1, starts);
    int rightResult = dfs(node.right, level + 1, index * 2 + 2, starts);
    return Math.max(cur, Math.max(leftResult, rightResult));

    }
}