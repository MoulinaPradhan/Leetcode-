// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
      int count =0;
      boolean vis[] = new boolean [V];
      Stack<Integer> st = new Stack<>();
      for(int i=0;i<V;i++){
          if(!vis[i]) dfs(i,vis,adj,st);
      }
      
      ArrayList<ArrayList<Integer>> transpose= new ArrayList<>();
      for(int i=0;i<V;i++){
         transpose.add(new ArrayList<>());
      }
      for(int i=0;i<V;i++){
          vis[i] = false;
          for(Integer it : adj.get(i)){
              transpose.get(it).add(i);
          }
      }
      while(!st.isEmpty()){
          int node = st.pop();
          if(!vis[node]){
              revDfs(node,vis,transpose);
              count++;
          }
      }
      return count;
    }
    public static void dfs(int node, boolean vis[],ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node]= true;
        for(Integer it : adj.get(node)){
            if(!vis[it])
            dfs(it, vis, adj,st);
        }
        st.push(node);
    }
    public static void revDfs(int node, boolean vis[],ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(Integer it : adj.get(node)){
            if(!vis[it]){
                revDfs(it,vis,adj);
            }
        }
    }
}
