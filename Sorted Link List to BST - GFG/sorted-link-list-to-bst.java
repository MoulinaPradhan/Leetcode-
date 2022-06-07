// { Driver Code Starts
import java.util.*;

class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}


class ListToBST
{
    
  /* Function to print linked list */
   public static void preOrder(TNode root)
    {
        
        if(root==null)
            return;
            
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			LNode head = new LNode(sc.nextInt());
            LNode tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new LNode(sc.nextInt());
                tail = tail.next;
            }
		
			Solution obj = new Solution();
			TNode root = obj.sortedListToBST(head);
			preOrder(root);
			
			System.out.println();
			
			t--;
			
         }
    }
}
// } Driver Code Ends


//User function Template for Java

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}*/

class Solution
{
    public TNode ConstTree( ArrayList<Integer> al , int lo ,int hi ){
       if(lo > hi){
           return null;
       }
       int mid = (int)Math.ceil((float)(lo + hi) / 2) ;
       int data = al.get(mid) ;
       TNode node = new TNode(data) ;
       node.left = ConstTree(al , lo ,mid - 1 ) ;
       node.right = ConstTree(al , mid + 1,hi ) ;
        
       return node ;
   }
   public TNode sortedListToBST( LNode head )
   { 
       LNode curr = head ;
       ArrayList<Integer>al = new ArrayList<>() ;
       while( curr != null ){
           al.add( curr.data ) ;
           curr = curr.next ; 
       }
       TNode t = ConstTree( al , 0 , al.size()-1) ;
       return t;
   } 
}