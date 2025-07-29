class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] dp= new int[32];
        int[] result= new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            int max=i;
            int count=0;
            while(count<32){
                if(((nums[i]>>count)&1)==1) dp[count]=i;
                count++;
            }
            for(int bit=0;bit<32;bit++){
                max=Math.max(max,dp[bit]);
            }
            result[i]=max-i+1;
        }
        return result;
    }
}