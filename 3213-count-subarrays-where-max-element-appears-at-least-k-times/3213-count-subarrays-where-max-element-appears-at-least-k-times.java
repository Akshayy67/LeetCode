class Solution {
    public long countSubarrays(int[] nums, int k) {
        long result=0;
        int count=0,j=0,n=nums.length,max=0;
        for(int num:nums) max=Math.max(max,num);
        for(int i=0;i<n;i++){
            count+=(nums[i]==max)?1:0;
            while(count==k){
                count-=(nums[j++]==max)?1:0;
            }
            result+=j;
        }
        return result;
    }
}