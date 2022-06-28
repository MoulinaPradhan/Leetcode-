class Solution {
    public int makeConnected(int n, int[][] connections) {
         if(connections.length<n-1)
            return -1; 
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
              adj.get(connections[i][1]).add(connections[i][0]);
        }
        int count=0;
        boolean vis[] = new boolean [n];
        for(int i=0;i<adj.size();i++){
            if(!vis[i]) {
                count++;
                dfs(i,vis,adj);
                
            }
        }
        return count-1;
    }
    public void dfs(int node, boolean vis[], List<List<Integer>> adj){
        vis[node] = true;
        for(Integer it : adj.get(node)){
            if(!vis[it])
                dfs(it,vis,adj);
        }
    }
}