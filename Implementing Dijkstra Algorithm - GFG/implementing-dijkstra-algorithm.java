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
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
     static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
     PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node> (){
            public int compare(Node n1, Node n2){
                return n1.value-n2.value;
            }
        });
        
        boolean [] vis = new boolean [V];
        int [] dist = new int[V];
        for(int i = 0; i < V ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[S] = 0;
        pq.add(new Node(S,0));
        
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            vis[curr.id] = true;
            
            for(ArrayList<Integer> i : adj.get(curr.id)){
                int end = i.get(0);
                int w = i.get(1);
              
                if(vis[end]) continue;
                
                int tempDist = dist[curr.id]+ w;
                
                if(dist[end] > tempDist){
                    dist[end] = tempDist;
                    pq.add(new Node(end, dist[end]));
                }
            }
        }
		return dist;
    }
    
public static class Node{
    int id;
    int value;
    
    public Node(int id, int value){
        this.id = id;
        this.value = value;
    }
}
}
