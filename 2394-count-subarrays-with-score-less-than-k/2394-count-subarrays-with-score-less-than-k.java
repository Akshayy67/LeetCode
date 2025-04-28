class Solution {
    public long countSubarrays(int[] nums, long k) {
        long result=0;long sum=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum*(i-j+1)>=k){
                sum-=nums[j++];
            }
            result+=(i-j+1);
        }
        return result;
    }
}