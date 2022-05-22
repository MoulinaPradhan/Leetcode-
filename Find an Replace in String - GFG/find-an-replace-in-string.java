// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            int Q = Integer.parseInt(read.readLine());
            
            int[] index = new int[Q];
            String[] sources = new String[Q];
            String[] targets = new String[Q];
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            String S3[] = read.readLine().split(" ");
            
            for(int i=0 ; i<Q ; i++) {
                index[i] = Integer.parseInt(S1[i]);
                sources[i] = S2[i];
                targets[i] = S3[i];
            }

            Solution ob = new Solution();
            System.out.println(ob.findAndReplace(S,Q,index,sources,targets));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static String findAndReplace(String S, int Q, int[] index, String[] sources, String[] targets) {
          int n = S.length();
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder("");
        Arrays.fill(arr,-1);
        for(int i = 0;i<index.length;i++){
            if(S.substring(index[i],index[i]+sources[i].length()).equals(sources[i])){
                arr[index[i]] = i;
            }
        }
        int idx = 0;
        while(idx<n){
            if(arr[idx]>=0){
                sb.append(targets[arr[idx]]);
                idx+=sources[arr[idx]].length();
            }
            else{
                sb.append(S.charAt(idx++));
            }
        }
        return sb.toString();
    }
};