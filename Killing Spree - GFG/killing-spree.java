// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            long ans = ob.killinSpree(N);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    long killinSpree(long n)
    {
       
     long ans = fn(n,1,0);
       return ans;
    }
    long fn(long n, long i, long c){
         if(n ==(i*i)) return c+1;
       if(n<= (i*i)) return c;
      return fn(n-(i*i),i+1,c+1);
    }
}
