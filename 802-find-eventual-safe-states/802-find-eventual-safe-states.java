class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
       int vis[] = new int [graph.length];
        for(int i=0;i<graph.length;i++)
          if(dfs(graph,vis,i) ==1)
        list.add(i);
 
        
 return list;
    
    }
    public int dfs(int[][]adj, int vis[],int node){
     if(vis[node] !=0) return vis[node];
        vis[node] =-1; // curreently visting
        for(int it : adj[node]){
            if(dfs(adj,vis,it) ==-1) return -1; //unsafe;
            
        }
    return vis[node] =1;
    }
}