// { Driver Code Starts
//Initial Template for Java

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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
          long pre=2; long cur=3;
       if(N==1){ return 4; }
       if(N==2){ return 9; }
       for(int i=3; i<=N; i++){
           long val=cur;
           cur+=pre;
           cur%=1000000007;
           pre=val;
       }
       return (int)((cur*cur)%1000000007);
    }
}