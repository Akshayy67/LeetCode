class Solution {
    public long subArrayRanges(int[] nums) {
        long result=0;
        for(int i=0;i<nums.length;i++){
            int mx=nums[i];
            int mn=nums[i];
            for(int j=i;j<nums.length;j++){
                mn=Math.min(nums[j],mn);
                mx=Math.max(nums[j],mx);
                result+=(mx-mn);
            }
        }
        return result;
    }
}