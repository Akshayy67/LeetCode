class Solution {
    public boolean check(int[] nums) {
        int dis=0;
        // if(nums[0]>nums[nums.length-1]) dis=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length]) dis++;
        }
        return dis<=1;
    }
}