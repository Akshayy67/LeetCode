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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy=new ListNode(0);
        ListNode evenDummy=new ListNode(0);
        ListNode odd=oddDummy,even=evenDummy;
        int i=0;
        while(head!=null){
            if(i%2==1){
                odd.next=head;
                odd=odd.next;
            }
            else{
                even.next=head;
                even=even.next;
            }
            i++;
            head=head.next;
        }
        even.next=null;
        odd.next=null;
        even.next=oddDummy.next;
        return evenDummy.next;
    }
}