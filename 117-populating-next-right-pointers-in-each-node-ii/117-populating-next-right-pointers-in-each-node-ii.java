/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
      if(root==null)
            return null;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        //Level Order Traversal
        while(!q.isEmpty()){
            int size=q.size();
            Node prev=null;
            while(size-->0){
                Node cur=q.poll();
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
                if(prev!=null)
                    prev.next=cur;
                prev=cur;
            }
        }
        
        return root; 
    
    }
}