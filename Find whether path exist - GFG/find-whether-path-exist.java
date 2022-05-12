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
     public boolean path=false;
   public boolean is_Possible(int[][] grid)
   {
       // Code here
       int id=0,jd=0,is=0,js=0;
       
       for(int i=0;i<grid.length;i++)
       {
           for(int j=0;j<grid[i].length;j++)
           {
               if(grid[i][j]==1)
               {
                   is=i;
                   js=j;
               }
                if(grid[i][j]==2)
               {
                   id=i;
                   jd=j;
               }
               
           }
       }
       if(is==id && js==jd)
       return true;
       bfs(grid,is,js);
       return path;
       
   }
   public void bfs(int[][] grid, int is, int js)
   
   {
       
       if(is<0 || is>=grid.length || js<0 || js>=grid[is].length || grid[is][js]==0)
       {
           return;
       }
       if(grid[is][js]==2)
       path=true;
       grid[is][js]=0;
       bfs(grid,is+1,js);
       bfs(grid,is,js+1);
       bfs(grid,is-1,js);
       bfs(grid,is,js-1);
       
   }
 
}