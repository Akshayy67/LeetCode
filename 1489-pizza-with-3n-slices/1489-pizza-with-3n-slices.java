class Solution {
    Integer[][] dp;
    public int maxSizeSlices(int[] slices) {
        dp= new Integer[slices.length][slices.length];
        int LeaveLast=helper(slices,0,slices.length-1,0);
        dp= new Integer[slices.length][slices.length];
        int LeaveFirst=helper(slices,1,slices.length,0);
        return Math.max(LeaveFirst,LeaveLast);
    }
    public int helper(int[] nums,int i,int len,int count){
        if(i>=len) return (count==nums.length/3)?0:Integer.MIN_VALUE;
        if(dp[i][count]!=null) return dp[i][count];
        int leave=helper(nums,i+1,len,count);
        int take=helper(nums,i+2,len,count+1)+nums[i];
        return dp[i][count] =Math.max(take,leave);
    }
}