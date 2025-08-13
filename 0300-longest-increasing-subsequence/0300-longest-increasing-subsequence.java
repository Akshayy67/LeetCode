class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    dp[j]=Math.max(dp[j],dp[i]+1);
                }
            }
        }
        int max=0;
        for(int num:dp) max=Math.max(num,max);
        return max+1;
    }
}