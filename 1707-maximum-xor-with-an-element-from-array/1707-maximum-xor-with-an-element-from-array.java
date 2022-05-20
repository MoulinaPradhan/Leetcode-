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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie obj = new Trie();
        int q[][] = new int[queries.length][3];
        int ans[]= new int[queries.length];
        for(int i=0;i<q.length;i++){
            q[i][0] =queries[i][0];
            q[i][1] =queries[i][1];
            q[i][2] =i;
        }
        Arrays.sort(nums);
        Arrays.sort(q,(a,b)->a[1]-b[1]);
       int idx=0;
         for(int i=0;i<q.length;++i){

            while(idx<nums.length && nums[idx]<=q[i][1]){
                obj.insert(nums[idx]);
                idx++;
            }
            if(nums[0]>q[i][1])
                ans[q[i][2]] = -1;
            else 
                ans[q[i][2]] = obj.getMax(q[i][0]);
        }

        return ans;

        
    }
}