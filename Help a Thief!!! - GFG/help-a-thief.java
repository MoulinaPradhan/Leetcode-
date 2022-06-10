// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int T = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            int[] B = new int[N];
            
            for(int i=0; i<N; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCoins(A,B,T,N));
        }
    }
}// } Driver Code Ends


class Solution {
   static int maxCoins(int[] plates, int[] coins, int t, int n) {
        if(t==0) return 0;
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<n;i++){
            pq.add(new int []{plates[i],coins[i]});
        }
        int res=0;
        while(t>0&&!pq.isEmpty()){
            int []p=pq.poll();
            for(int i=0;i<p[0]&&t-->0;i++){
             res+=p[1];
           }
        }
        return res;
    }
}