class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0,max=nums[0],min=nums[0],curmax=0,curmin=0;
        for(int num:nums){
            curmax=Math.max(curmax+num,num);
            max=Math.max(curmax,max);
            curmin=Math.min(curmin+num,num);
            min=Math.min(min,curmin);
            sum+=num;
        }
        return max>0?Math.max(sum-min,max):max;
    }
}