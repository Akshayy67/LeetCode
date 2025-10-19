class Solution {
    Integer[][] dp;
    public int maxSatisfaction(int[] satisfaction) {
        dp= new Integer[satisfaction.length+1][satisfaction.length+1];
        Arrays.sort(satisfaction);
        return helper(satisfaction,0,1);
    }
    public int helper(int[] nums, int i,int count){
        if(i>=nums.length) return 0;
        if(dp[i][count]!=null) return dp[i][count];
        int leave=helper(nums,i+1,count);
        int take=nums[i]*count+helper(nums,i+1,count+1);
        return dp[i][count]=Math.max(leave,take);
    }
}