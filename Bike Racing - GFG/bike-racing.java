// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            long M = Long.parseLong(a[1]);
            long L = Long.parseLong(a[2]);
            long H[] = new long[N];
            long A[] = new long[N];
            for(int i = 0; i < N; i++){
                String a1[] = in.readLine().trim().split("\\s+");
                H[i] = Long.parseLong(a1[0]);
                A[i] = Long.parseLong(a1[1]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.buzzTime(N, M, L, H, A));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static long buzzTime(int N, long M, long L, long H[], long A[]){
         long a=Math.max(L,M), sum=0, res=-1;
       while(sum<=a){
           long mid=sum+(a-sum)/2;
           if(possible(N,M,L,H,A,mid)){
               res=mid;
               a=mid-1;
           }else sum=mid+1;
       }
       return res;
   }
   
   static boolean possible(int N, long M, long L, long H[], long A[], long mid){
       long s=0;
       for(int i=0;i<N;i++){
            long a=H[i]+mid*A[i];
            if(a>=L) s+=a;
       }
       if(s>=M) return true;
       return false;
    }
}
