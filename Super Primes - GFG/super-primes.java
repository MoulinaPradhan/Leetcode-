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
            System.out.println(ob.superPrimes(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int superPrimes(int n) {
          int N= n+2;
        boolean is_prime[] = new boolean [N];
        Arrays.fill(is_prime,true);
        is_prime[0] = is_prime[1] = false;
          for(int i=2;i<N;i++){
	    	if(is_prime[i]){
			for(int j=2*i;j<N;j+=i){
            is_prime[j]=false;
			}
	        	}
	     }
      int count =0;
      for(int i=2;i<=n;i++){
         if(is_prime[i] && is_prime[i-2])count++;
      }
      return count;
      
      
    }

}