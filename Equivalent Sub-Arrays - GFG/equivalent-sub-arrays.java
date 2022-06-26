// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


 
class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
 Map<Integer,Integer> map = new HashMap<>();
        for(int i: arr) map.put(i,1);
        int len = map.size();
        int l=0,r=0,ans=0;
        while(r<n){
            while(r<n && len>0){
                int curr = arr[r++];
                map.put(curr,map.get(curr)+1);
                if(map.get(curr)==2) len--;
            }
            while(l<r && len==0){
                ans++;
                ans += n-r;
                int curr = arr[l++];
                map.put(curr,map.get(curr)-1);
                if(map.get(curr)==1) len++;
            }
        }
        return ans;
    }
}


// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}
  // } Driver Code Ends