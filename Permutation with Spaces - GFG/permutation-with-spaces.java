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
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    ArrayList<String> res = new ArrayList<>();
    ArrayList<String> permutation(String S){
      solve(S.charAt(0)+"",S.substring(1));
        return res;
    }
        void solve(String a,String b){
        if(b.length()==0){
            res.add(a);
            return;
        }
        solve(a+" "+b.charAt(0),b.substring(1));
        solve(a+b.charAt(0),b.substring(1));
        }
    
}