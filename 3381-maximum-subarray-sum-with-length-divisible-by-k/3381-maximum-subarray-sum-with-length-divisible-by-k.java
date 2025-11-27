class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] pre= new long[nums.length+1];
        pre[1]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        long[] minPref= new long[k];
        Arrays.fill(minPref,Long.MAX_VALUE);
        long max=Long.MIN_VALUE;
        for(int i=0;i<=nums.length;i++){
            if(i-k>=0){
                int idx=(i-k)%k;
                minPref[idx]=Math.min(minPref[idx],pre[i-k]);
            }
            int rem=i%k;
            if(minPref[rem]!=Long.MAX_VALUE) max=Math.max(max,pre[i]-minPref[rem]);
        }
        return max;
    }
}