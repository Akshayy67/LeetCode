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
    public int[] nextLargerNodes(ListNode head) {
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int[] result= new int[len];
        Stack<int[]> stk= new Stack<>();
        int i=0;
        for(temp=head;temp!=null;temp=temp.next){
            while(!stk.isEmpty() && stk.peek()[0]<temp.val){
                result[stk.pop()[1]]=temp.val;
            }
            stk.push(new int[] {temp.val,i});
            i++;
        }
        return result;
    }
}