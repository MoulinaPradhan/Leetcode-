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
            String str[] = read.readLine().split(" ");
            String S= str[0];
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            Solution ob = new Solution();
            System.out.println(ob.stringPartition(S,a,b));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static String stringPartition(String S, int a, int b){
     if(S.length()<2 || S.equals(""))return "-1";
     for(int i=1;i<S.length();i++){
         int first = Integer.parseInt(S.substring(0,i));
         int second = Integer.parseInt(S.substring(i));
         if(first%a ==0 && second%b ==0) 
         return S.substring(0,i)+" "+S.substring(i);
         
     }
     return "-1";
    }
}