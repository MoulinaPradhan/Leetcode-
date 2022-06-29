class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n,      List<List<Integer>> connect) {
        // if(n==1) return connect;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
         for(int i=0;i<connect.size();i++){
          adj.get(connect.get(i).get(0)).add(connect.get(i).get(1));
              adj.get(connect.get(i).get(1)).add(connect.get(i).get(0));
        }
        boolean vis[] = new boolean[adj.size()];
int tin[] = new int[adj.size()];
int low[] = new int[adj.size()];

int timmer =0;
for(int i=0;i<adj.size();i++){
if(!vis[i]) 
dfs(i,-1,vis,timmer,tin,low,adj);
}

        return ans;
    }
    public void dfs(int node,int parent, boolean vis[], int timmer,int []tin, int low[], List<List<Integer> > adj){
    vis[node] = true;
    tin[node] = low[node]= timmer++;
    for(Integer it: adj.get(node)){
        if(it==parent) continue;
if(!vis[it]){
dfs(it,node,vis,timmer,tin,low,adj);
low[node] = Math.min(low[it], low[node]);
if(low[it] > tin[node]){
    List<Integer> list = new ArrayList<>();
    list.add(it);
    list.add(node);
    ans.add(list);
    System.out.println(it+" "+node);
}
}else{
    low[node] = Math.min(low[node], tin[it]);
}
    }

} 


}