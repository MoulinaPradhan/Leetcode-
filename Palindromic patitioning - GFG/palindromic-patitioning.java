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
        int[][] dp = new int[n][n];
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; i < n && j < n; i++, j++){
                if(i == j){
                    dp[i][j] = 0;
                }
                else if(g == 1){
                    dp[i][j] = (str.charAt(i) == str.charAt(j))? 0:1;
                }
                else{
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == 0)
                        dp[i][j] = 0;
                    else{
                        int min = Integer.MAX_VALUE;
                        for(int tempi = i+1, tempj = j-g; tempi < n && tempj < j; tempi++, tempj++){
                            int num1 = dp[i][tempj];
                            int num2 = dp[tempi][j];
                            min = Math.min(min, num1+num2);
                        }
                        dp[i][j] = min+1;
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
}