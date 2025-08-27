class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        return Math.max(helper(nums,0,n-2),helper(nums,1,n-1));
    }
    public int helper(int[] nums, int start,int end){
        int prev1=0,prev2=0;
        for(int i=start;i<=end;i++){
            int take=nums[i]+prev2;
            int leave=prev1;
            int cur=Math.max(take,leave);
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}