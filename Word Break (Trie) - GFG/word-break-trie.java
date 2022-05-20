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
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
   static class Trie{
        Trie children[]=new Trie[26];
        boolean end;
        public Trie(){
            end=false;
            for(int i=0;i<26;i++)
            children[i]=null;
        }
    }
    
    public static int wordBreak(String A, ArrayList<String> B)
    {
        Trie root=new Trie();
        for(String str:B)
        insert(str,root);
        return util(A,root)?1:0;
    }
    
    public static boolean util(String A, Trie root){
        int len=A.length();
        if(len==0)return true;
        for(int i=1;i<=len;i++)
            if(search(A.substring(0,i),root)&&util(A.substring(i,len),root))
            return true;
        return false;
    }
    
    public static boolean search(String str,Trie root){
        for(int i=0;i<str.length();i++){
            int val=(int)(str.charAt(i)-'a');
            if(root.children[val]==null)
            return false;
            root=root.children[val];
        }
        return root.end;
    }
    
    public static void insert(String str,Trie root){
        for(int i=0;i<str.length();i++){
            int val=(int)(str.charAt(i)-'a');
            if(root.children[val]==null)
            root.children[val]=new Trie();
            root=root.children[val];
        }
        root.end=true;
    }
}