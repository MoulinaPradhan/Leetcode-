// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] matrix = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.MaxGold(matrix);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MaxGold(int[][] matrix)
    {
 int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < m; i++){
            if(matrix[0][i] != -1){
                dp[0][i] = dfs(0, i, matrix, dp);
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++)
            res = Math.max(res, dp[0][i]);
        return res;
    }
    
    private int dfs(int i, int j, int[][] matrix, int[][] dp){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == -1)
            return 0;
        if(dp[i][j] != 0)
            return dp[i][j];
        return dp[i][j] = matrix[i][j] + Math.max(dfs(i+1, j-1, matrix, dp), Math.max(dfs(i+1, j, matrix, dp), dfs(i+1, j+1, matrix, dp)));
    }
}