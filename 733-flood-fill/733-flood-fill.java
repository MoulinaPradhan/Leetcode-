class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int base = grid[sr][sc];
        if(grid[sr][sc] == color) return grid;
        dfs(sr,sc,grid,base,color);
        return grid;
    }

    public void dfs(int i, int j, int[][] grid,int base,int color){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] !=base ) return ;
      
        if(grid[i][j] !=color){
              grid[i][j] =color;
            dfs(i-1,j,grid,base,color);
             dfs(i+1,j,grid,base,color);
             dfs(i,j-1,grid, base,color);
             dfs(i,j+1,grid,base,color);
        }
    }
}