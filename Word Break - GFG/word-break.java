// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        if(B.contains(A)) return 1;
        if(rec(A, B,0)) return 1;
      return 0;
    }
 
        public static boolean rec(String A, ArrayList<String> B, int index) {
            if (index == A.length())
                return false;
            
            String prefix = A.substring(0, index);
            String suffix = A.substring(index, A.length());
            if (B.contains(prefix) && B.contains(suffix))
                return true;
            else if (B.contains(prefix) && !B.contains(suffix))
                return rec(suffix, B, 1) || rec(A, B, index+1);
            else
                return rec(A, B, index+1);
        }
    }


