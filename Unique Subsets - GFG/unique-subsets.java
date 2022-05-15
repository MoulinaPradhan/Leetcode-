// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    System.out.print("()");
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}// } Driver Code Ends


class solve
{
    //Function to find all possible unique subsets.
 public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
   {
       // your code here
       Arrays.sort(arr);
       ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
       
       solve(0,arr,ans,n,new ArrayList<Integer>());
       ans.remove(ans.get(0));
       return ans;
   }
   static void  solve(int ind,int arr[],ArrayList<ArrayList<Integer>> ans,int n,
   ArrayList<Integer> ds){
      
       if(!ans.contains(ds))
       ans.add(new ArrayList<Integer>(ds));
      
       for(int i=ind;i<n;i++){
           ds.add(arr[i]);
           solve(i+1,arr,ans,n,ds);
           ds.remove(ds.size()-1);
           
       }
       return;
   }
}
 