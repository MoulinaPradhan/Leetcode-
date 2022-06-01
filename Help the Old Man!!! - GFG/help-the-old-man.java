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
            int N = Integer.parseInt(a[0]);
            int n = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.shiftPile(N, n);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
   public static void callForHelp(List<Integer> list, int source, int auxiliary, int destination,
                                   int nOfDisk, int n, int[] move) {
        if (nOfDisk == 0) return;
        callForHelp(list, source, destination, auxiliary, (nOfDisk - 1), n, move);
        move[0]++;
        if (move[0] == n) {
            list.add(source);
            list.add(destination);
        }
        callForHelp(list, auxiliary, source, destination, (nOfDisk - 1), n, move);
    }
   
    static List<Integer> shiftPile(int N, int n){
        List<Integer> list = new ArrayList<>();
        int[] move = new int[]{0};
        callForHelp(list, 1, 2, 3, N, n, move);
        return list;
    }
}