class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] pre= new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        int result=Integer.MAX_VALUE;
        Deque<Integer> dq= new LinkedList<>();
        for(int i=0;i<pre.length;i++){
            while(!dq.isEmpty() && pre[dq.peekLast()]>pre[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            while(!dq.isEmpty() && pre[i]-pre[dq.peekFirst()]>=k) result=Math.min(result,i-dq.pollFirst());
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}