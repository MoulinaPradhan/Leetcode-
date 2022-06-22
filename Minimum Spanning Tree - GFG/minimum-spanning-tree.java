// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java
class Node{
    int u;
    int v ;
    int w;
    Node(int _u, int _v, int _w){
        u=_u;
        v=_v;
        w=_w;
    }
    int getU(){
        return u;
    }
    int getV(){
        return v;
    }
    int getW(){
        return w;
    }
}
class SortComparator implements Comparator<Node>{
    @Override
    public int compare (Node n1, Node n2){
        if(n1.w< n2.w) return -1;
        else if(n1.w> n2.w) return 1;
        return 0;
    }
}
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int findPar(int node, int parent[]){
        if(parent[node] == node) return node;
        return parent[node] = findPar(parent[node],parent);
    }
    static void union(int u, int v, int parent[], int rank[]){
        u=findPar(u,parent);
        v = findPar(v,parent);
        if(rank[u]< rank[v]){
            parent[u]=v;
        }else if(rank[v] < rank[u]){
            parent[v]=u;
        }else{
            parent[v] =u;
            rank[v]++;
        }
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> a) 
    {
        List<Node> adj = new ArrayList<>();
        for(int i=0;i<a.size();i++){
            for(int j=0;j<a.get(i).size();j++){
                adj.add(new Node(i,a.get(i).get(j).get(0),a.get(i).get(j).get(1)));
            }
        }
        Collections.sort(adj,new SortComparator());
        int parent[] = new int[V];
        int rank[] = new int[V];
        // take min
        for(int i=0;i<V;i++){
            parent[i] =i;
        }
        int minCost =0;
        for(Node it: adj){
            if(findPar(it.getU(),parent) != findPar(it.getV(),parent)){
                minCost+=it.getW();
                union(it.getU(), it.getV(),parent,rank);
            }
            
        }
        return minCost;
    }
}
