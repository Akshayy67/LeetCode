class Solution {
    Integer[][] dp;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp= new Integer[nums.size()][target+1];
        int result=helper(nums,0,target);
        return result<0?-1:result;
    }
    public int helper(List<Integer> nums,int i,int target){
        if(i==nums.size() || target<0){
            return target==0?0:Integer.MIN_VALUE;
        }
        if(dp[i][target]!=null) return dp[i][target];
        int leave=helper(nums,i+1,target);
        int take=1+helper(nums,i+1,target-nums.get(i));
        return dp[i][target]=Math.max(leave,take);
    }
}