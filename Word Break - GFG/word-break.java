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
    public static int wordBreak(String s, ArrayList<String> b )
    {
        int[] dp=new int[s.length()];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                String word=s.substring(j,i+1);
                if(b.contains(word))
                {
                    dp[i]+=1;
                }
            }
        }
        return dp[s.length()-1]>0?1:0;
        }
    }


