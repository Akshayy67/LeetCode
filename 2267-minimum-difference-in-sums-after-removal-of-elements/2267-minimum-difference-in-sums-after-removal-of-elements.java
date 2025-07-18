class Solution {
    public long minimumDifference(int[] nums) {
        long ans=Long.MAX_VALUE;
        long[] lsum=new long[nums.length];
        long[] rsum=new long[nums.length];
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        for(int i=0;i<nums.length*2/3;i++){
            sum+=nums[i];
            pq.add(nums[i]);
            if(pq.size()>nums.length/3){
                sum-=pq.poll();
            }
            lsum[i]=sum;
        }
        pq= new PriorityQueue<>();
        sum=0;
        for(int i=nums.length-1;i>=nums.length/3;i--){
            sum+=nums[i];
            pq.add(nums[i]);
            if(pq.size()>nums.length/3){
                sum-=pq.poll();
            }
            rsum[i]=sum;
        }
        for(int i=nums.length/3-1;i<nums.length*2/3;i++){
            ans=Math.min(ans,lsum[i]-rsum[i+1]);
        }
        return ans;
    }
}