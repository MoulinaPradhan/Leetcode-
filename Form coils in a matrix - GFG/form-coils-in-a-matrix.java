// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            int[][] ptr = ob.formCoils(n);
            
            for(int i=0; i<2; i++)
            {
                for(int j=0; j<ptr[i].length; j++)
                {
                    System.out.print(ptr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
 private static int getDirx(int dir)
    {
        switch(dir)
        {
            case 0: return -1;
            case 1: return 0;
            case 2: return 1;
            default: return 0;
        }
        
        
    }
    
    private static int getDiry(int dir)
    {
        switch(dir)
        {
            case 0: return 0;
            case 1: return 1;
            case 2: return 0;
            default: return -1;
        }
    }
    
    private static int[][] createMatrix(int n)
    {
        int mat[][] = new int[n*4][n*4];
        
        int count = 1;
        
        for(int i=0; i<4*n; i++)
        {
            for(int j=0; j<4*n; j++)
            {
                mat[i][j] = count++;
            }
        }
        
        return mat;
    }
    
    private static void createCoils(int cx, int cy, int arr[][], int n, int dir, int ans[][])
    {
        int count = 0;
        
        ans[0][count] = arr[cx][cy];
        ans[1][count++] = arr[cy][cx];
        
        int x = cx, y = cy;
        
        
        for(int i=2; i<=n; i+=2)
        {
            for(int j=0; j<(i==n ? 1 : 2); j++)
            {
                for(int k=0; k<i; k++)
                {
                    
                    x += getDirx(dir);
                    y += getDiry(dir);
                    
                    if(x<0 || y<0 || x>=n || y>=n) return;
                    
                    ans[0][count] = arr[x][y];
                    ans[1][count++] = arr[n-x-1][n-y-1];
                }
                dir = (dir+1)%4;
            }
            
            
        }
        
    }
    
    static int[][] formCoils(int n) {
        
        int arr[][] = createMatrix(n);
        
        int ans[][] = new int[2][(n*n)*8];
        
        int cx1 = n*2;
        int cy1 = n*2-1;
        
        
        createCoils(cx1, cy1, arr, n*4, 0, ans);
        
        
        return ans;
        // code here
    }
}