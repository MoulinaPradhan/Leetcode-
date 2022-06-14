// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
          int low = 0;
            int high = n * 5;
            int ans = high;
            while(low <= high){
                int mid = low + (high - low)/2;
                int x = 5;
                int total = 0;
                while(x <= mid){
                    total += mid/x;
                    x *= 5;
                }

                if(total < n){
                    low = mid + 1;
                }
                else if(total > n){
                    high = mid - 1;
                    ans = Math.min(ans, mid);
                }
                else{
                    ans = mid;
                    break;
                }
            }
            ans -= ans % 5;
            return ans;
    }
}