/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
         List<List<Integer>> levelList = new ArrayList<>();
        if(root == null) 
            return levelList;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodeList = new ArrayList<>();
            
            for(int i=0;i<size;i++) {
                Node node = queue.poll();
                
                if(node.children != null) {
                    for(Node child : node.children) {
                        queue.offer(child);
                    }
                }
                nodeList.add(node.val);
            }
            levelList.add(nodeList);
        }
        
        return levelList;
    }
}