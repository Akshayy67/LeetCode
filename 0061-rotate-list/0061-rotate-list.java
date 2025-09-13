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
        if(head==null) return null;
        int size=1;
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
            size++;
        }
        cur.next=head;
        k=k%size;
        cur=head;
         for(int i=0;i<size-k-1;i++) cur=cur.next;
        head=cur.next;
        cur.next=null;
        // cur=head;
        // for(int i=0;i<size;i++){
        //     cur=cur.next;
        // }
        // cur.next=null;
        return head;
    }
}