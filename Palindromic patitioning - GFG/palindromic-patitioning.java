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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        boolean[][]dp=new boolean[str.length()][str.length()];
       for(int g=0;g<str.length();g++){
           for(int i=0,j=g;j<str.length();i++,j++){
               if(g==0){
                 dp[i][j]=true;  
               } 
               else if(g==1){
                   if(str.charAt(i)==str.charAt(j)){
                       dp[i][j]=true;
                   }
                   else {
                       dp[i][j]=false;
                   }
               }
               else{
                   if(str.charAt(i)==str.charAt(j)&&dp[i+1][j-1]==true){
                       dp[i][j]=true;
                   }
                   else {
                       dp[i][j]=false;
                   }
               }
           }
       }
       
       int strj[]=new int[str.length()];
       strj[0]=0;
       for(int j=1;j<strj.length;j++){
           
           int min = Integer.MAX_VALUE;
           if(dp[0][j]) {
               strj[j]=0;
           }
           else{
           for(int i=j;i>=1;i--){
               if(dp[i][j]){
                   if(strj[i-1]<min) {
                       min=strj[i-1];
                   }
               }    
           }
           strj[j]=min+1;
       }
       }
       return strj[str.length()-1];
    }
}