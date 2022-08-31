class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        
        int  n = heights.length, m = heights[0].length;
        
        
        boolean pacific[][] = new boolean [n][m];
         boolean atlantic[][] = new boolean [n][m];
        
        for(int i =0;i<n;i++){
            dfs(heights,pacific,Integer.MIN_VALUE,i,0);
             dfs(heights,atlantic,Integer.MIN_VALUE,i,m-1);
        }
        
        for(int i =0;i<m;i++){
            dfs(heights,pacific,Integer.MIN_VALUE,0,i);
             dfs(heights,atlantic,Integer.MIN_VALUE,n-1,i);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                List<Integer> sub = new ArrayList<>();
                if(pacific[i][j] && atlantic[i][j] ){
                  sub.add(i);
                    sub.add(j);
                    res.add(new ArrayList<>(sub));
                }
            }
        }
        return res;
    }
        int dirs[][]= { {0,1},{0,-1},{1,0},{-1,0}};
        
        
        public void dfs(int [][] heights, boolean [][] visited,int height, int x, int y){
             int  n = heights.length, m = heights[0].length;
            if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || heights[x][y] < height)
            return;
            visited[x][y] = true;
            for(int d[] : dirs){
                dfs(heights,visited, heights[x][y],x+d[0],y+d[1]);
            }
        }
        
    }
