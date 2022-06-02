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
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int[][] ans = ob.ShortestDistance(matrix);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isSafe(int x,int y,int[][] matrix){
        return x<matrix.length&&y<matrix[0].length&&((x==matrix.length-1&&y==matrix[0].length-1)||matrix[x][y]!=0);
    }
    public boolean reachable(int x,int y,int[][] matrix,int[][] result){
        int m=matrix.length;
        int n=matrix[0].length;
        if(x==m-1&&y==n-1){result[x][y]=1;return true;}
        int k=matrix[x][y];

        for(int i=1;i<=k;i++){
            int x_=x+i;
            int y_=y+i;
            if(isSafe(x,y_,matrix)){
                result[x][y_]=1;
            if(reachable(x,y_,matrix,result))return true;
                result[x][y_]=0;
            }
            if(isSafe(x_,y,matrix)){
                result[x_][y]=1;
            if(reachable(x_,y,matrix,result))return true;
            result[x_][y]=0;
            }
        }
  
        return false;
    }
    public int[][] ShortestDistance(int[][] matrix)
    {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] result=new int[m][n];
        result[0][0]=1;
        
        boolean flag=reachable(0,0,matrix,result);
        if(!flag){
            return new int[][]{{-1}};
        }
        
        
        return result;
}
}