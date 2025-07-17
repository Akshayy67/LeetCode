class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length][nums.length+1];
        return helper(nums,0,-1);
    }
    public int helper(int[] nums,int i,int prev){
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=null) return dp[i][prev+1];
        int leave=helper(nums,i+1,prev);
        int take=0;
        if(prev==-1 || nums[i]>nums[prev]){
            take=1+helper(nums,i+1,i);
        }
        return dp[i][prev+1]=Math.max(take,leave);
    }
}