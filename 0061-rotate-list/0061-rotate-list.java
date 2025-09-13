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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int size=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            size++;
        }
        k=k%size;
        if(k==0) return head;
        head=rotate(head);
        cur=head;
        for(int i=0;i<k-1;i++) cur=cur.next;
        ListNode nh=cur.next;
        cur.next=null;
        ListNode sh=rotate(nh);
        nh=rotate(head);
        head.next=sh;
        return nh;
    }
    public ListNode rotate(ListNode head)   {
        ListNode prev=null,next=null;
        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}