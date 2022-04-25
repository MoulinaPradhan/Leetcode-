// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
      Map<Integer,Integer> xm = new HashMap<>();
       Map<Integer,Integer> ym = new HashMap<>();
        Map<String,Integer> xym = new HashMap<>();
        int ans =0;
    for(int i=0;i<N;i++){
        int x = X[i];
        int y = Y[i];
        
        String xy = ""+x+"*"+y;
        int xf = xm.getOrDefault(x,0);
         int yf = ym.getOrDefault(y,0);
          int xyf = xym.getOrDefault(xy,0);
         ans += xf+yf-2*xyf;
         xm.put(x,xf+1);
          ym.put(y,yf+1);
           xym.put(xy,xyf+1);
        
    }
     return ans; 
    }
};