// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
   public static void helper(int[][] m,int n,String s,ArrayList<String>ans,int row,int col,boolean[][]visited)
   {
       //System.out.println(s);
       if(row==n-1&&col==n-1)
       {
           ans.add(s);
           return;
       }
       visited[row][col]=true;
       int[]x={0,0,1,-1};
       int[]y={1,-1,0,0};
       char[]dir={'R','L','D','U'};
       for(int i=0;i<4;i++)
       {
           int row1=row+x[i];
           int col1=col+y[i];
           boolean valid=row1>=0&&row1<n&&col1>=0&&col1<n&&!visited[row1][col1]&&m[row1][col1]!=0;
           if(valid)
           {
               helper(m,n,s+dir[i],ans,row1,col1,visited);
           }
       }
       visited[row][col]=false;
   }
   public static ArrayList<String> findPath(int[][] m, int n) {
       ArrayList<String>ans=new ArrayList<>();
       if(m[0][0]==0)
       {
           return ans;
       }
       boolean[][]visited=new boolean[n][n];
       String s="";
       helper(m,n,s,ans,0,0,visited);
       return ans;
   }
}