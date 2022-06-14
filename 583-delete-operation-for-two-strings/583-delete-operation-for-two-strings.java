class Solution {
    public int minDistance(String word1, String word2) {
         int m=word1.length(),n=word2.length(),i,j;
        int [][] dp = new int[m+1][n+1];
        for(i=0;i<=m;++i){
            for(j=0;j<=n;++j){
                if(i==0 || j==0) dp[i][j]=0;
                else if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return m+n-2*dp[m][n];
    }
}