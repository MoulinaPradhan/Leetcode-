// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
      boolean vis[] = new boolean[adj.size()];
for(int i=0;i<adj.size();i++){
    if(!vis[i]){
        if(checkforcycle(i,-1,vis,adj)) return true;
    }
   } return false;
    }  public static boolean checkforcycle(int node, int parent,boolean vis[],ArrayList<ArrayList<Integer>>adj){
vis[node] = true;
for(Integer it: adj.get(node)){
    if(!vis[it]){
        if(checkforcycle(it,node,vis,adj))return true;
    }else if (parent != it) return true;
}
return false;
    

    }
}