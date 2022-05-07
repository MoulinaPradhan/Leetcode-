// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class MergeLists
{
    Node head;



  /* Function to print linked list */
   public static void printList(Node head)
    {
        
        while (head!= null)
        {
           System.out.print(head.data+" ");
           head = head.next;
        }  
        System.out.println();
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
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node head1 = new Node(sc.nextInt());
            Node tail1 = head1;
            for(int i=0; i<n1-1; i++)
            {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }
			Node head2 = new Node(sc.nextInt());
            Node tail2 = head2;
            for(int i=0; i<n2-1; i++)
            {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }
			
			LinkedList obj = new LinkedList();
			Node head = obj.sortedMerge(head1,head2);
			printList(head);
			
			t--;
			
         }
    }
}
// } Driver Code Ends


/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class LinkedList
{
    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
   Node prev=null;
        Node ans=prev;
        while(head1!=null || head2!=null){
            Node head;
            int data1,data2;
            if(head1==null){
                head=new Node(head2.data);
                head2=head2.next;
            }else if(head2==null){
                head=new Node(head1.data);
                head1=head1.next;
            }else{
                data1=head1.data;
                data2=head2.data;
                if(data1<=data2){
                    head=new Node(head1.data);
                    head1=head1.next;
                }else{
                    head=new Node(head2.data);
                    head2=head2.next;  
                }
            }
            if(prev==null){
                prev=head;
                ans=prev;
            }
            else{
                prev.next=head;
                prev=prev.next;
            }
        }
        return ans;
   } 
}
