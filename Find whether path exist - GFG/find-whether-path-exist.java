// { Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends




class Solution
{
    public boolean is_Possible(int[][] grid)
    {
        int n=grid.length;
        int m= grid[0].length;
        boolean[][] v=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return isPath(grid,i,j,n,m,v);
                } 
            }
        }
        return false;
        
    }
    public boolean  isPath(int[][] grid, int x,int y,int n, int m,boolean[][] v){
       if(x>n-1 || y>m-1||x<0||y<0 || grid[x][y]==0||v[x][y]) return false;
        if(grid[x][y]==2 ) return true;
        v[x][y]=true;
        return (( isPath(grid,x+1,y,n,m,v))||
        (isPath(grid,x,y+1,n,m,v))||
        (isPath(grid,x-1,y,n,m,v))||
        (isPath(grid,x,y-1,n,m,v)));
    }
    public boolean isSafe(int x,int y,int[][] grid,int n, int m,boolean[][] v){
      
        return true;
    }
    
    
}