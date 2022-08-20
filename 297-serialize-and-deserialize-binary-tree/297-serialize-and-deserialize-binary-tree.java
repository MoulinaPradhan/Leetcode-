/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String spitter =",";
    public String NN="X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
        
    }
    public void buildString(TreeNode root , StringBuilder sb){
        if(root == null)
            sb.append(NN).append(spitter);
        else{
            sb.append(root.val).append(spitter);
            buildString(root.left,sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(spitter)));
        return buildTree(q);
    }
    public TreeNode buildTree(Deque<String> q){
        String val = q.remove();
        if(val.equals(NN) ) return null;
        else{
            TreeNode node = new TreeNode (Integer.valueOf(val));
            node.left =buildTree(q);
          node.right = buildTree(q);
                        
return node;
        }
      
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));