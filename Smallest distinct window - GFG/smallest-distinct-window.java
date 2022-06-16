// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
            HashSet<Character>hs = new HashSet<>();
        HashMap<Character , Integer> mp = new HashMap<>();
        for(int i =0 ; i<str.length(); i++)
        hs.add(str.charAt(i));
     
        int i = 0 , j = 0, count = 0 , f_count =Integer.MAX_VALUE;
       
        for( i = 0 ; i<str.length() ; i++)
        {
            if(mp.containsKey(str.charAt(i)))
            mp.put(str.charAt(i) , mp.get(str.charAt(i))+1);
            else
            mp.put(str.charAt(i) , 1);
            
            if(hs.size()== mp.size())
            {
                count = i-j+1 ;
               
                while(j<=i )
                {
                    if(mp.get(str.charAt(j)) == 1)
                   {  
                       
                       mp.remove(mp.get(str.charAt(j)));
                       f_count = Math.min(count ,f_count);
                       break;
                   }
                    else
                   {
                       mp.put(str.charAt(j) , mp.get(str.charAt(j))-1);
                       count = count-1;            
                       f_count = Math.min(count ,f_count);
                   }
                    j++;
                }
                
            }
            
        }
        return f_count;
    }
}