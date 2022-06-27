// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
         boolean vis[] = new boolean[adj.size()];
        int indg[]= new int [adj.size()];
        for(int i=0;i<adj.size();i++){
            for(Integer it : adj.get(i)) indg[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i< indg.length;i++){
            if(indg[i] ==0) q.offer(i);
        }
        int cnt=0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(Integer it : adj.get(node)){
                indg[it]--;
                if(indg[it] ==0)q.offer(it);
            }
        }
        if(cnt == adj.size()) return false;
        return true;
    }
}