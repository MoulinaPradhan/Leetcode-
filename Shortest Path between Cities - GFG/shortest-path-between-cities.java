// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
        	String input_line[] = read.readLine().trim().split("\\s+");
        	int x = Integer.parseInt(input_line[0]);
        	int y = Integer.parseInt(input_line[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestPath(x,y));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution { 
    int shortestPath( int x, int y){ 
  int ctr = 0;
       while(x != y && (x >= 1 && y >= 1)) {
           if(x > y) {
               x /= 2;
           }
           else if(y > x) {
               y /= 2;
           }
           ctr++;
       }
       return ctr;
    }
}