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
   int max, s; // max to store maximum depth, s to store sum of nodes with depth = max
    void solve(TreeNode root, int d) // d-> depth of root
    {
        if(root!=null)
        {
            if(d>max)  // If deeper node found
            {
                s = root.val;
                max = d;
            }
            else if(d==max) // sum of deepest nodes
            {
                s += root.val;
            }
            solve(root.left, d+1); // depth(child) = depth(node) + 1
            solve(root.right, d+1);
        }
    }
    public int deepestLeavesSum(TreeNode root)
    {
        max = 0;
        s = 0;
        solve(root, 0); // Initial depth = 0
        return s;
        
    }
}