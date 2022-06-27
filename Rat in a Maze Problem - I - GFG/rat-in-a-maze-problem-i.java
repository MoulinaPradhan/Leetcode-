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

       ArrayList<String> ans=new ArrayList<String>();
        if(m[0][0]==0 || m[n-1][n-1]==0){
           
            return ans;
        }
        
        dfs(0,0,m,"",ans);
        if(ans.size()==0){
           
            return ans;
        }
        return ans;
    }
    public static void dfs(int i, int j, int[][] m, String path,ArrayList<String>ans){
        if(i <0 || i>=m.length || j<0 || j>=m[i].length || m[i][j] ==0) return ;
        if(i==m.length-1 && j==m.length-1 ) {
            ans.add(path);
            return;
        }
        m[i][j] =0;
        dfs(i-1, j, m,path+'U',ans);
          dfs(i+1, j, m,path+'D',ans);
            dfs(i, j-1, m,path+'L',ans);
              dfs(i, j+1, m,path+'R',ans);
              m[i][j]=1;
    }
}