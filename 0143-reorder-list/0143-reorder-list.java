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
    public void reorderList(ListNode head) {
        ArrayList<ListNode> list= new ArrayList<>();
        while(head!=null){
            list.add(head);
            head=head.next;
        }
        int i=0,j=list.size()-1;
        while(i<j){
            list.get(i).next=list.get(j);
            list.get(j).next=list.get(i+1);
            i++;
            j--;
        }
        list.get(i).next=null;
    }
}