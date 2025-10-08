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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode middle=findMiddle(head);
        ListNode left=head,right=middle.next;
        middle.next=null;
        ListNode leftsort=mergeSort(left);
        ListNode rightsort=mergeSort(right);
        return merge(leftsort,rightsort);
    }
    public ListNode merge(ListNode left,ListNode right){
        ListNode dummy= new ListNode(-354323);
        ListNode cur=dummy;
        while(left!=null && right!=null){
            if(left.val<right.val){
                cur.next=left;
                left=left.next;
            }
            else{
                cur.next=right;
                right=right.next;
            }
            cur=cur.next;
        }
        if(left!=null) cur.next=left;
        else cur.next=right;
        return dummy.next;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow=head,fast=slow.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow; 
    }
}