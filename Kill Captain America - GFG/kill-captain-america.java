// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            int V[][] = new int[M+1][2];
            for(int i=0;i<M;i++){
                String input_line1[] = read.readLine().trim().split("\\s+");
                V[i][0] = Integer.parseInt(input_line1[0]);
                V[i][1] = Integer.parseInt(input_line1[1]);
            }
            Solution ob = new Solution();
            int ans = ob.captainAmerica(N, M, V);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
  
     private void dfs(int node, ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,int[] vis){
         vis[node]=1;
         for(Integer it:adj.get(node)){
             if(vis[it]==0){
                  dfs(it,adj,st,vis);
             }
         }
         st.push(node);
     }
     
     private void dfs_(int node,  ArrayList<ArrayList<Integer>> transpose,int[] vis,int par,int[] parent,int[] no){
         vis[node]=1;
        
         parent[node]=par;
         no[par]++;
         for(Integer it:transpose.get(node)){
             if(vis[it]==0){
                  dfs_(it,transpose,vis,par,parent, no);
             }
         }
     }
   
    private void dfs__(int node,int[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> adjn,int[] parent){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            int par1=parent[node];
            int par2=parent[it];
            if(par1==par2){
                continue;
            }
            adjn.get(par1).add(par2);
            if(vis[it]==0){
                dfs__(it,vis,adj,adjn,parent);
            }
        }
    }
   
   int captainAmerica(int N, int M, int V[][]){
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<N;i++){
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<M;i++){
           adj.get(V[i][0]-1).add(V[i][1]-1);
       }
        int[] vis=new int[N];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                dfs(i,adj,st,vis);
            }
        }
        ArrayList<ArrayList<Integer>> transpose=new ArrayList<>();
       for(int i=0;i<N;i++){
           transpose.add(new ArrayList<>());
           vis[i]=0;
       }
       for(int i=0;i<M;i++){
           transpose.get(V[i][1]-1).add(V[i][0]-1);
       }
       int[] parent=new int[N];
       int par=0;
       int[] no=new int[N];
       while(!st.isEmpty()){
           int node=st.pop();
           if(vis[node]==0){
               dfs_(node,transpose,vis,par,parent,no);
               par++;
               }
       }
     
       
        ArrayList<ArrayList<Integer>> adjn=new ArrayList<>();
        for(int i=0;i<par;i++){
         adjn.add(new ArrayList<>());   
        }
        Arrays.fill(vis,0);
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                dfs__(i,vis,adj,adjn,parent);
            }
        }
        int outDegree=0;
        for(int i=0;i<par;i++){
            if(adjn.get(i).size()==0){
                outDegree++;
            }
        }
        if(outDegree>1 || outDegree==0){
            return 0;
        }
        else{
            for(int i=0;i<par;i++){
                 if(adjn.get(i).size()==0){
                  return no[i];
            }
            }
        }
        return -1;
        
   }
}

 