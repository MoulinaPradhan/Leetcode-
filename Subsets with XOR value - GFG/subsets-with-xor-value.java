// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

 // } Driver Code Ends
//User function Template for Java

class Solution{
    static int count=0;
    static HashSet<ArrayList<Integer>> hs = new HashSet<>();
    public static void countXor(int arr[],int i,int n,int k,int xor,ArrayList<Integer> li){
        if(xor==k){
            hs.add(li);

        }
        if(i==n){
            return;
        }
        countXor(arr,i+1,n,k,xor,li);
        xor=(xor^arr[i]);
        li.add(arr[i]);
        countXor(arr,i+1,n,k,xor,li);
        return;
    }
    static int subsetXOR(int arr[], int n, int k) {

        int max_ele=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>max_ele){
                max_ele=arr[i];
            }
        }
        int m = (1 << (int)(Math.log(max_ele)/Math.log(2) + 1) ) - 1;
        if(k>m){
            return 0;
        }
        int dp[][]=new int[n+1][m+1];
        dp[0][0]=1;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j]=dp[i-1][j]+dp[i-1][j^arr[i-1]];
            }
        }
        return dp[n][k];
    }
}

// { Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int N = s.nextInt();
            int K = s.nextInt();
            int arr[] = new int[N];
            for(int i =0;i<N;i++)
            {
                arr[i] =s.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.subsetXOR(arr,N,K));
        }
    }
}  // } Driver Code Ends