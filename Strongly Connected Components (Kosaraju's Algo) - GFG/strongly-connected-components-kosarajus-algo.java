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
       boolean vis[] = new boolean[adj.size()];
Stack<Integer>st = new Stack<>();
for(int i=0;i<adj.size();i++){
	if(!vis[i]){
		dfs(i, st, adj, vis);
	}
}
ArrayList<ArrayList<Integer> > transpose = new ArrayList<>();
for(int i=0;i<adj.size();i++){
	transpose.add(new ArrayList<>());
}

for(int i=0;i<adj.size();i++){
	vis[i] = false;
	for(Integer it :adj.get(i)){
		transpose.get(it).add(i);
	}
}
int count=0;
while(!st.isEmpty()){
	int node = st.pop();
if(!vis[node]){
// 	System.out.print("SCC :");
revDfs(node,transpose,vis);
count++;
// System.out.println();
}

}
return count;
	}
	public static void dfs(int node, Stack<Integer> st,  ArrayList<ArrayList<Integer> > adj,boolean vis[] ){
vis[node] = true;
for(int it: adj.get(node)){
	if(!vis[it])
	dfs(it, st, adj, vis);
}
st.push(node);
	}

	public static void revDfs( int node, ArrayList<ArrayList<Integer> >transpose, boolean vis[]){
		vis[node] =true;
		//System.out.print(node+" ");
		for(Integer it :transpose.get(node)){
			if(!vis[it])
			revDfs(it, transpose, vis);
	
		}
	}
}