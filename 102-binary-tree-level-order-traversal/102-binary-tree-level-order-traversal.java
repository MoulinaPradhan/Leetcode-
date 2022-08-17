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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>>res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null) return res;
        q.offer(root);
        while(!q.isEmpty()){
           List<Integer> path = new ArrayList<>();
            int sz = q.size();
            for(int i=0;i<sz;i++){
                  if(q.peek().left != null){
                q.offer(q.peek().left);
            }
             if(q.peek().right != null){
                q.offer(q.peek().right);
            }
            path.add(q.poll().val);
          
            }
        res.add(path);    
        }
    
    return res;
}}