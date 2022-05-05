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
   public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans=new ArrayList<String>();
        if(m[0][0]==0 || m[n-1][n-1]==0){
           
            return ans;
        }
        
        dfs(m,n,0,0,"",ans);
        if(ans.size()==0){
           
            return ans;
        }
        return ans;
    }
    
    
    public static void dfs(int[][] m,int n,int x,int y, String path,ArrayList<String> ans){
        if(x<0 || x>=n || y<0 || y>=n || m[x][y]==0){
            return;
        }
        
        if(x==n-1 && y==n-1){
            ans.add(path);
            return;
        }
        m[x][y]=0;
        dfs(m,n,x+1,y,path+"D",ans);
        dfs(m,n,x,y-1,path+"L",ans);
        dfs(m,n,x,y+1,path+"R",ans);
        dfs(m,n,x-1,y,path+"U",ans);
        
        m[x][y]=1;
    }
}