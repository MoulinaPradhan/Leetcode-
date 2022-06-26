class Solution {
    public boolean validPath(int n, int[][] edges, int s, int dest) {
        boolean vis[] = new boolean [n];
       ArrayList< ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int g[] : edges){
            adj.get(g[0]).add(g[1]);
            adj.get(g[1]).add(g[0]);
        }
    Queue<Integer>q = new LinkedList<>();
        vis[s] =true;
        q.add(s);
        while(!q.isEmpty()){
            Integer node = q.poll();
            for(Integer it : adj.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
       return vis[dest]; 
    }
}