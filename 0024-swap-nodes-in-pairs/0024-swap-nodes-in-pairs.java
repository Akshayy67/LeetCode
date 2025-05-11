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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy= new ListNode(0);
        ListNode temp=dummy;
        while(head!=null){
            if(head.next!=null){
                ListNode t=head.next;
                head.next=head.next.next;
                temp.next=t;
                temp=temp.next;
            }
            temp.next=head;
            temp=temp.next;
            head=head.next;
        }
        temp.next=null;
        return dummy.next;
    }
}