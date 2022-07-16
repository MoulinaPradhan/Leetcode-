class Solution {
    int mod = 1000000007;
    Integer[][][] dp = null;
    public int findPaths(int m, int n, int N, int i, int j) {
        dp = new Integer[m][n][N+1];
        return helper(m, n, N, i, j, N);
    }
    private int helper(int m, int n, int N, int i, int j, int moves){
        if(i < 0 || j < 0 || i >= m || j >= n) return 1;        
        if(moves <= 0) return 0;
        if(dp[i][j][moves] != null) return dp[i][j][moves];
        int count = 0;
        count = count % mod + helper(m, n, N, i-1, j, moves-1) % mod;
        count = count % mod + helper(m, n, N, i+1, j, moves-1) % mod;
        count = count % mod + helper(m, n, N, i, j-1, moves-1) % mod;
        count = count % mod + helper(m, n, N, i, j+1, moves-1) % mod;
        dp[i][j][moves] = count % mod;
        return dp[i][j][moves];
    }
}