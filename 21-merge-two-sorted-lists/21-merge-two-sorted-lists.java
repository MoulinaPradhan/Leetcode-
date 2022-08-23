/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode li1, ListNode li2) {
       ListNode ans = new ListNode();
        ListNode temp = ans;
        while(li1 != null && li2!= null){
            if(li1.val < li2.val){
                ans.next=li1;
                li1=li1.next;
            }else{
                ans.next=li2;
                li2=li2.next; 
            }
            ans = ans.next;
        }
     if(li1 != null){
            ans.next = li1;
            // li1= li1.next;
        }
        if(li2 != null){
            ans.next = li2;
            // li2= li2.next;
        }
        return temp.next;
    }
}