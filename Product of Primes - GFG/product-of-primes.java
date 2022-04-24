// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            long L = Long.parseLong(a[0]);
            long R = Long.parseLong(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.primeProduct(L, R));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int mod =1000000007;
    static long primeProduct(long L, long R){
       long ans =1;
    
       for(int i=(int)L;i<=(int)R;i++){
           if(isPrime(i)){
               ans*=i;
               ans%=mod;
           }
       }
       return ans;
    }
    static boolean isPrime(long n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i ==0) return false;
        }
        return true;
    }
}