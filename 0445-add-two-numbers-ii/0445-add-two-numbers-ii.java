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
        Stack<Integer> stk= new Stack<>();
        Stack<Integer> stk1= new Stack<>();
        Stack<Integer> stk2= new Stack<>();
        while(l1!=null){
            stk1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stk2.push(l2.val);
            l2=l2.next;
        }
        while(!stk1.isEmpty() || !stk2.isEmpty()){
            int num1=(stk1.size()>0)?stk1.pop():0;
            int num2=(stk2.size()>0)?stk2.pop():0;
            int sum=num1+num2;
            stk.push(sum%10);
            if(sum/10>0){
                if(stk1.isEmpty() && stk2.isEmpty()){
                    stk.push(sum/10);
                }
                else if(stk1.isEmpty()){
                    stk2.push(stk2.pop()+sum/10);
                }
                else{
                    stk1.push(stk1.pop()+sum/10);
                }
            }
        }
        ListNode result= new ListNode(0);
        ListNode cur=result;
        while(!stk.isEmpty()){
            cur.next= new ListNode(stk.pop());
            cur=cur.next;
        }
        return result.next;
    }
}