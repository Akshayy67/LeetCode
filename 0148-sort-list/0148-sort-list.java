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
        ListNode leftHead=head,rightHead=middle.next;
        middle.next=null;
        ListNode Left_sort=mergeSort(head);
        ListNode Right_sort=mergeSort(rightHead);
        return merge(Left_sort,Right_sort);
    }
    public ListNode merge(ListNode left,ListNode right){
        ListNode dummy= new ListNode(0);
        ListNode temp=dummy;
        while(left!=null && right!=null){
            if(left.val<right.val) {
                temp.next=new ListNode(left.val);
                left=left.next;
            }
            else{
                temp.next=new ListNode(right.val);
                right=right.next;
            }
                temp=temp.next;
        }
        if(right!=null) temp.next=right;
        if(left!=null) temp.next=left;
        return dummy.next;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}