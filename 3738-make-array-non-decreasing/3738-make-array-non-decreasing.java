class Solution {
    public int maximumPossibleSize(int[] nums) {
        int count=0;
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1] || nums[i]<max){
                 count++;
                 max=Math.max(max,nums[i-1]);
            }
        }
        return nums.length-count;
    }
}