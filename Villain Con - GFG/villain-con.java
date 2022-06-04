// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int M = Integer.parseInt(a[1]);
            int mat[][] = new int[M][2];
            for(int i = 0;i < M;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                mat[i][0] = Integer.parseInt(a1[0]);
                mat[i][1] = Integer.parseInt(a1[1]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minColour(N, M, mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    private static int dfs(int node, boolean visited[], int nchild[], ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = true;
        
        int max_depth = 0;
        
        for(int nei : adj.get(node))
        {
            int depth = 0;
            if(visited[nei]==true)
            {
                depth = nchild[nei];
            }
            else
            {
                depth = dfs(nei, visited, nchild, adj);
            }
            
            max_depth = Math.max(max_depth, depth);
        }
        
        nchild[node] = max_depth + 1;
        
        
        return max_depth + 1;
    }
    static int minColour(int N, int M, int mat[][])
    {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int indeg[] = new int[N];
        
        for(int i=0; i<M; i++)
        {
            int x = mat[i][0] - 1;
            int y = mat[i][1] - 1;
            
            adj.get(x).add(y);
            
            indeg[y]++;
        }
        boolean visited[] = new boolean[N];
        
        int nchild[] = new int[N];
        
        int max_depth = 0;
        
        for(int node=0; node<N; node++)
        {
            if(indeg[node]==0)
            {
                max_depth = Math.max(max_depth, dfs(node, visited, nchild, adj));
            }
            
        }
        return max_depth;
    }
}