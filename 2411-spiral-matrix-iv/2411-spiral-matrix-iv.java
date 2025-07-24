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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result= new int[m][n];
        for(int[] a:result) Arrays.fill(a,-1);
        int l=0,t=0,r=n-1,b=m-1;
        while(l<=n && t<=b && head!=null){
            for(int i=l;i<=r && head!=null;i++){
                result[t][i]=head.val;
                head=head.next;
            }
            t++;
            for(int i=t;i<=b && head!=null;i++){
                result[i][r]=head.val;
                head=head.next;
            }
            r--;
            for(int i=r;i>=l && head!=null;i--){
                result[b][i]=head.val;
                head=head.next;
            }
            b--;
            for(int i=b;i>=t && head!=null;i--){
                result[i][l]=head.val;
                head=head.next;
            }
            l++;
        } 
        return result;
    }
}