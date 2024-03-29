class Node{
    Node links[]= new Node[2];
    boolean contain(int idx){
        return links[idx] !=null;
    }
   Node get(int idx){
       return links[idx];
   } 
    void put(int idx, Node node){
        links[idx] = node;
    }
    }
class Trie{
     public Node root ;
    Trie(){
        root = new Node();
    }
    public void insert(int num){
       Node node = root;
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1; 
            if(!node.contain(bit)) {
                node.put(bit, new Node()); 
            }
            node = node.get(bit); 
        }
    }
    public int getMax(int num){
      Node node = root; 
        int maxNum = 0; 
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1; 
            if(node.contain(1 - bit)) {
                maxNum = maxNum | (1<<i);
                node = node.get( 1 - bit); 
            }
            else {
                node = node.get(bit); 
            }
        }
        return maxNum; 
    }
}

class Solution {
  
    
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int i=0;i<nums.length;i++){
            trie.insert(nums[i]);
        }
          int maxi = 0; 
        for(int i = 0;i<nums.length;i++) {
            maxi = Math.max(maxi, trie.getMax(nums[i])); 
        }
        return maxi; 
        
    }
}