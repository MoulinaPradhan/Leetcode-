// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int V = scan.nextInt();
            int C = scan.nextInt();
            int E = scan.nextInt();

            List<Integer>[] G = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                G[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                G[u].add(v);
                G[v].add(u);
            }
            int[] color = new int[V];

            System.out.println(new solve().graphColoring(G, color, 0, C) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve 
{
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) 
    {
          if(i == G.length) return true;
       
       for(int c=1; c<=m; c++){
           if(isSafe(G, color, i, c)){
               color[i] = c;
               if(graphColoring(G, color, i+1, m)) return true;
               color[i] = 0;
           }
       }
       
       return false;
   }
   
   public static boolean isSafe(List<Integer>[] G, int[] color, int i, int c){
       for(int adj : G[i]){
           if(color[adj] == c) return false;
       }
       return true;
    }
}