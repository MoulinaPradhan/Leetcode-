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
            int level = Integer.parseInt(a[0]);
            int pos = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            if(ob.profession(level, pos) == 'd')
                System.out.println("Doctor");
            else
                System.out.println("Engineer");
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static char profession(int level, int pos){
        
        if(pos==1) return 'e';
       char par = profession(level-1,(pos+1)/2);
       if(pos%2!=0)
           return par;
       if(par=='e') return 'd';
       else return 'e';
    }
}