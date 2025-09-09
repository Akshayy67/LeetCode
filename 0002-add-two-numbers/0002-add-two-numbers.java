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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy= new ListNode(0);
        ListNode cur= dummy;
        int carry=0,sum=0;
        while(l1!=null || l2!=null || carry==1){
            int v1=(l1==null)?0:l1.val;
            int v2=(l2==null)?0:l2.val;
            sum=(v1+v2+carry);
            ListNode nn= new ListNode(sum%10);
            cur.next=nn;
            cur=cur.next;
            carry=sum/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return dummy.next;
    }
}