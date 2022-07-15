class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length ==0) return 0;
        int max =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    int area= dfs(i,j,grid,0);
                    max = Math.max(area,max);
                }
            }
        }
            return max;
            
    }
    public int dfs(int i, int j,int [][]grid ,int area){
        if(i<0|| i>=grid.length || j<0 ||j>= grid[i].length|| grid[i][j] ==0) return area;
      grid[i][j] =0;
        area++;
            area=dfs(i-1,j,grid,area);
            area=dfs(i+1,j,grid,area);
            area=dfs(i,j-1,grid,area);
            area=dfs(i,j+1,grid,area);
            return area;
    }
}