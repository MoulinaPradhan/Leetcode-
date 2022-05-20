// { Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S1 = read.readLine();
            String S2 = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.findTime(S1,S2));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTime(String s1 , String s2) {
        int time =0,total=0;
        for(int i=0;i<s2.length();i++){
            int idx = s1.indexOf(s2.charAt(i));
            // System.out.println(idx);
            time =Math.abs(time - idx);
            total+=time;
            time=idx;
        }
        return total;
    }
};