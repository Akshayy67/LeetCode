class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp= new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums);
    }
    public int helper(int i, int[] nums){
        if(i>=nums.length) return 0;
        int leave=helper(i+1,nums);
        int take=nums[i]+helper(i+2,nums);
        return Math.max(leave,take);
    }
}