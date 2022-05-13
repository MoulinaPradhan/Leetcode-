// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr1 = new int[n], arr2 = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().maximizeArray(arr1, arr2, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
            HashSet<Integer> set = new HashSet<>();
     
       for(int i=0;i<n;i++){
           set.add(arr1[i]);
           set.add(arr2[i]);
       }
  
       ArrayList<Integer> al = new ArrayList<>();
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int i : set) pq.add(i);
       HashSet<Integer> set1 = new HashSet<>();
 
       while(!pq.isEmpty()&&set1.size()<n)set1.add(pq.poll());
  
       for(int i : arr2)
           if(set1.contains(i) && !al.contains(i))
               al.add(i);
       for(int i : arr1)
           if(set1.contains(i) && !al.contains(i))
               al.add(i);
       return al;
    }
}