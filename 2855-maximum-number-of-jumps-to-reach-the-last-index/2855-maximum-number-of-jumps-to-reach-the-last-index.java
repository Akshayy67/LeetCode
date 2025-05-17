class Solution {
    int[][] dp;
    public int maximumJumps(int[] nums, int target) {
        dp= new int[nums.length][nums.length];
        int result=helper(nums,0,target,0);
        return result==Integer.MIN_VALUE?-1:result;
    }
    public int helper(int[] nums,int i,int target,int count){
        if(i==nums.length-1){
            return count;
        } 
        if(dp[i][count]!=0) return dp[i][count];
        int min=Integer.MIN_VALUE;
        for(int j=i+1;j<nums.length;j++){
            int dif=Math.abs(nums[i]-nums[j]);
            if( dif<=target){
                int temp =helper(nums,j,target,count+1);
                min=Math.max(min,temp);
            }
        }
        return dp[i][count]=min;
    }
}