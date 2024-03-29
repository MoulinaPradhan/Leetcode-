// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        int n = str.length();
        boolean[][] palinIndices = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                palinIndices[i][j] = isPalin(str, i, j);
            }
        }
        
        int dp[] = new int[n];
        
        for(int i=0; i<n; i++) {
            if(palinIndices[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for(int j=i; j>0; j--) {
                    if (palinIndices[j][i]) {
                        dp[i] = Math.min(dp[i],  dp[j-1]);
                    }
                }
                dp[i]++;
            }
      
        }
        
        return dp[n-1];
    }
    
    static boolean isPalin(String s, int start, int end) {
     while(start<=end){
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;end--;
        }
        return true;
    }
}