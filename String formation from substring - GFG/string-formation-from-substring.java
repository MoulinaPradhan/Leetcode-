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
            String input = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.isRepeat(input);
            
            System.out.println(result);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int isRepeat(String s) {
       int n = s.length();
      if(n==1){
          return 0;
      }
        if(n==2){
            if(s.charAt(0)==s.charAt(1)){
            return 1;
            }
        else{
            return 0;
            }
        }
        String t = s+s;
        String temp = t.substring(1,t.length()-1);
        if(temp.indexOf(s)!=-1){
            return 1;
        }
        return 0;
    }
}